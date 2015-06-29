package com.huayu.platform.util;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;

public class DocConverter {
	private static Logger LOG = LoggerFactory.getLogger(DocConverter.class.getCanonicalName());
	
	private static final int environment = 1;// 环境 1：windows 2:linux
	private String fileString;// (只涉及pdf2swf路径问题)
	private String outputPath = "";// 输入路径 ，如果不设置就输出在默认的位置
	private String fileName;
	private File pdfFile;
	private File swfFile;
	private File docFile;
	private boolean isPdf;

	public DocConverter (String fileString) {
		init(fileString);
	}

	/**
	 * 重新设置file
	 * @param fileString
	 */
	public void setFile(String fileString) {
		init(fileString);
	}

	/**
	 * 初始化
	 * 
	 * @param fileString
	 */
	private void init(String fileString) {
		this.fileString = fileString;
		fileName = fileString.substring(0, fileString.lastIndexOf("."));
		
		String extName = fileString.substring(fileString.lastIndexOf("."), fileString.length());
		if(extName.toLowerCase().equals("pdf")){
			this.isPdf = true;
			pdfFile = new File(fileString);
		}else{
			docFile = new File(fileString);
			pdfFile = new File(fileName + ".pdf");
		}
		
		swfFile = new File(fileName + ".swf");
	}
	
	public boolean pdfToImage(String fileName){
		return pdfToImage(new File(fileName));
	}
	
	private boolean pdfToImage(File pdfFile){
		RandomAccessFile raf = null;
		FileOutputStream out =  null;
        try {
			raf = new RandomAccessFile(pdfFile, "r");  
			FileChannel channel = raf.getChannel();  
			MappedByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());  
			PDFFile pdffile = new PDFFile(buf);  
			  
			for (int i = 1; i <= pdffile.getNumPages(); i++) {  
			    PDFPage page = pdffile.getPage(i);  
			    Rectangle rect = new Rectangle(0, 0, ((int) page.getBBox().getWidth()), ((int) page.getBBox().getHeight()));  
			    Image img = page.getImage(rect.width, rect.height, rect, null,true,true);  
			    BufferedImage tag = new BufferedImage(rect.width, rect.height, BufferedImage.TYPE_INT_RGB);  
			    tag.getGraphics().drawImage(img, 0, 0, rect.width, rect.height,null);  
			      
//			    out = new FileOutputStream("img" + File.separator + (i + 1) + ".jpg"); // 输出到文件流  
			    
			    File tmpImageFile=new File(pdfFile.getParentFile().getPath() +  "/tmp/" + i + ".png");
			    LOG.info("**** create image file in {} , image size width({}) and height({})" , tmpImageFile.getPath() , rect.width , rect.height);
			    tmpImageFile.getParentFile().mkdirs();
			    if (tmpImageFile.exists()) {
			      tmpImageFile.delete();
			    }
			    ImageIO.write(tag,"png",tmpImageFile);
			
			    
//			    JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
//			    JPEGEncodeParam param2 = encoder.getDefaultJPEGEncodeParam(tag);  
//			    param2.setQuality(1f, false);// 1f是提高生成的图片质量  
//			    encoder.setJPEGEncodeParam(param2);  
//			    encoder.encode(tag); // JPEG编码  
//			    out.close();  
			    
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(raf != null){
					raf.close();
				}
				
				if(out != null ){
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        return true;
	}

	/**
	 * 转为PDF
	 * 
	 * @param file
	 */
	private void doc2pdf() throws Exception {
		if (docFile.exists()) {
			if (!pdfFile.exists()) {
				OpenOfficeConnection connection = new SocketOpenOfficeConnection(8100);
				try {
					connection.connect();
					DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
					converter.convert(docFile, pdfFile);
					// close the connection
					connection.disconnect();
					LOG.info("Document({}) convert to PDF successful, store in  ", docFile.getName() , pdfFile.getPath());
					
				} catch (java.net.ConnectException e) {
					e.printStackTrace();
					LOG.info("Converter Exception , openoffice is not started.");
					throw e;
				} catch (com.artofsolving.jodconverter.openoffice.connection.OpenOfficeException e) {
					e.printStackTrace();
					LOG.info("Converter Exception , Fail to read the file");
					throw e;
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
			} else {
				LOG.info("The file({}) is PDF type", pdfFile.getName());
			}
		} else {
			LOG.info("Converter Exception , Fail to read the file");
		}
	}

	/**
	 * 转换成 swf
	 */
	@SuppressWarnings("unused")
	private void pdf2swf() throws Exception {
		Runtime r = Runtime.getRuntime();
		if (!swfFile.exists()) {
			if (pdfFile.exists()) {
				pdfToImage(pdfFile);
				if ( 1 == environment ) {// windows环境处理
					try {
						String cmd = "D:\\Program Files (x86)\\SWFTools\\pdf2swf.exe";
						Process p = r .exec(new String[]{cmd, pdfFile.getPath(), "-o" , swfFile.getPath() , "-T 9"});
						LOG.info(loadStream(p.getInputStream()));
						LOG.info(loadStream(p.getErrorStream()));
						LOG.info(loadStream(p.getInputStream()));
						LOG.info("**** SWF convert success，folder：" + swfFile.getPath() + "****");
						
					

					} catch (IOException e) {
						e.printStackTrace();
						throw e;
					}
				} else if (environment == 2) {// linux环境处理
					try {
						Process p = r.exec("pdf2swf " + pdfFile.getPath() + " -o " + swfFile.getPath() + " -T 9");
						LOG.info(loadStream(p.getInputStream()));
						LOG.info(loadStream(p.getErrorStream()));
						LOG.info("**** SWF convert success，folder：" + swfFile.getPath() + "****");
						
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					}
				}
				
				if(!isPdf && pdfFile.exists()) {
					pdfFile.delete();
				}
			} else {
				LOG.info("**** PDF file({}) does not exist, it can't convert ****" , pdfFile.getName());
			}
		} else {
			LOG.info("**** The swf file({}) exist ****" , swfFile.getName());
		}
	}

	static String loadStream(InputStream in) throws IOException {

		int ptr = 0;
		in = new BufferedInputStream(in);
		StringBuffer buffer = new StringBuffer();

		while ((ptr = in.read()) != -1) {
			buffer.append((char) ptr);
		}

		return buffer.toString();
	}

	/**
	 * 转换主方法
	 */
	@SuppressWarnings("unused")
	public boolean convert() {

		if (swfFile.exists()) {
			LOG.info("**** SWF is exist , conversion completed ****");
			return true;
		}

		if (environment == 1) {
			LOG.info("**** SWF converter is staring on windows ****");
		} else {
			LOG.info("**** SWF converter is staring on Linux ****");
		}
		try {
			if(!isPdf){
				doc2pdf();
			}
			
			pdf2swf();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		if (swfFile.exists()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 返回文件路径
	 * 
	 * @param s
	 */
	public String getswfPath() {
		if (swfFile.exists()) {
			String tempString = swfFile.getPath();
			tempString = tempString.replaceAll("\\\\", "/");
			return tempString;
		} else {
			return "";
		}

	}

	/**
	 * 设置输出路径
	 */
	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
		if (!outputPath.equals("")) {
			String realName = fileName.substring(fileName.lastIndexOf("/"),
					fileName.lastIndexOf("."));
			if (outputPath.charAt(outputPath.length()) == '/') {
				swfFile = new File(outputPath + realName + ".swf");
			} else {
				swfFile = new File(outputPath + realName + ".swf");
			}
		}
	}

	public String getFileString() {
		return fileString;
	}

	public void setFileString(String fileString) {
		this.fileString = fileString;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public boolean isPdf() {
		return isPdf;
	}

	public void setPdf(boolean isPdf) {
		this.isPdf = isPdf;
	}
	
	public static void main(String[] args){
		DocConverter convert = new DocConverter("D:/workdoc/wenti.docx");
		convert.convert();
	}
	
}
