package com.huayu.platform.util.doc;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;
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
	
	private final static String extPattern = ".*.[doc(x)|xls(x)|ppt(x)|txt|pdf]$";
	
	private File docFile ;
	private File pdfFile ;
	private File swfFile ;
	private String filename;
	private boolean isPdf = false;
	
	public DocConverter(String filename){
		init(filename);
	}
	
	public DocConverter(String filename , String extPattern){
		init(filename);
	}
	
	public boolean isSupport(String extension){
		Pattern pattern = Pattern.compile(extPattern);
		Matcher matcher = pattern.matcher(extension);
		if(matcher.matches()){
			return true;
		}
		return false;
	}	public void init(String filename){
		this.filename = FilenameUtils.getBaseName(filename);
		if(filename == null){
			LOG.error("Converter initalize failure, the file name is null");
			return ;
		}
		
		String extension = FilenameUtils.getExtension(filename).toLowerCase();
		if(!isSupport(extension)){
			LOG.error("Converter initalize failure, extension type don't support , please in {}" , extPattern);
			return ;
		}

		if(extension.equals("pdf")){
			this.isPdf = true;
			pdfFile = new File(filename);
		}else{
			docFile = new File(filename);
			pdfFile = new File(this.filename+ ".pdf");
		}
		
		swfFile = new File(this.filename + ".swf");
	}

	public boolean docToPdf(){
		boolean result = false;
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
					
					result = true;
				} catch (java.net.ConnectException e) {
					e.printStackTrace();
					LOG.info("Converter Exception , openoffice is not started.");
				} catch (com.artofsolving.jodconverter.openoffice.connection.OpenOfficeException e) {
					e.printStackTrace();
					LOG.info("Converter Exception , Fail to read the file");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				LOG.info("The file({}) is PDF type", pdfFile.getName());
			}
		} else {
			LOG.info("Converter Exception , Fail to read the file");
		}
		
		return result;
	}
	
	public boolean pdfToSWF(){
		Runtime r = Runtime.getRuntime();
		if (!swfFile.exists()) {
			if (pdfFile.exists()) {
				if(!swfFile.getParentFile().exists()){
					swfFile.getParentFile().mkdirs();
				}
				String cmd = "pdf2swf";
				
				try {
					Process p = r .exec(new String[]{cmd, pdfFile.getPath(), "-o" , swfFile.getPath() , "-T 9"});
					LOG.info(loadStream(p.getInputStream()));
					LOG.info(loadStream(p.getErrorStream()));
					LOG.info(loadStream(p.getInputStream()));
					LOG.info("**** SWF convert success，folder：" + swfFile.getPath() + "****");
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}	
				
				if(!isPdf && pdfFile.exists()) {
					if(pdfFile.delete()){
						LOG.info("**** PDF file({}) delete success." , pdfFile.getPath());
					}else{
						LOG.info("**** PDF file({}) delete failure." , pdfFile.getPath());
					}
				}
			} else {
				LOG.info("**** PDF file({}) does not exist, it can't convert ****" , pdfFile.getName());
			}
		} else {
			LOG.info("**** The swf file({}) exist ****" , swfFile.getName());
		}
		
		return true;
	}

	/**
	 * 设置输出路径
	 */
	public void setOutputPath(String outputPath) {
		if (!outputPath.equals("")) {
			if (outputPath.charAt(outputPath.length()) == '/') {
				swfFile = new File(outputPath + filename + ".swf");
			} else {
				swfFile = new File(outputPath + filename + ".swf");
			}
		}
	}
	
	public void setSwfFile(String file){
		swfFile = new File(file);
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
	
	public boolean pdfToImage(File pdfFile ,String storePath){
		RandomAccessFile raf = null;
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
			      
			    String directory = storePath; 
//			    if( null != pdfFile.getParentFile()){
//			    	directory = pdfFile.getParentFile().getPath() +"/images/";
//			    }
			    File tmpImageFile=new File(directory + ".png");
			    LOG.info("**** create image file in {} , image size width({}) and height({})" , tmpImageFile.getPath() , rect.width , rect.height);
			    tmpImageFile.getParentFile().mkdirs();
			    if (tmpImageFile.exists()) {
			      tmpImageFile.delete();
			    }
			    ImageIO.write(tag,"png",tmpImageFile);
			    
			    LOG.info("**** create image({}) success." , tmpImageFile.getPath());
			    return true;
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
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        return true;
	}
	

	public File getDocFile() {
		return docFile;
	}

	public void setDocFile(File docFile) {
		this.docFile = docFile;
	}
	
	public void setDocFile(String filename){
		String extension = FilenameUtils.getExtension(filename).toLowerCase();
		if(!isSupport(extension)){
			LOG.error("The file({}) is not word office type ", filename);
		}else{
			docFile = new File(filename);
		}
		
	}

	public File getPdfFile() {
		return pdfFile;
	}

	public void setPdfFile(File pdfFile) {
		this.pdfFile = pdfFile;
	}
	
	public void setPdfFile(String filename){
		String extension = FilenameUtils.getExtension(filename).toLowerCase();
		if(!DocType.PDF.getValue().equals(extension)){
			LOG.error("The file({}) is not pdf type", filename);
		}else{
			pdfFile = new File(filename);
		}
	}
	
	
	public static void main(String[] args) {
		DocConverter converter =  new DocConverter("D:/workspace/digxy-web/WebContent/upload/20151511/04677316-e0c6-4e49-a5dd-95ed1b81a9a7.doc");
		converter.setPdfFile("D:/workspace/digxy-web/WebContent/upload/20151511/04677316-e0c6-4e49-a5dd-95ed1b81a9a7.pdf");
		converter.docToPdf();
		converter.pdfToImage(converter.getPdfFile() , "D:/12");
		converter.setSwfFile("D:/workspace/digxy-web/WebContent/upload/20151511/swf/04677316-e0c6-4e49-a5dd-95ed1b81a9a7.swf");
		converter.pdfToSWF();
	}
	
}
