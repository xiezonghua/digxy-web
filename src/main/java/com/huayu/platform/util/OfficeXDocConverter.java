package com.huayu.platform.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.core.FileURIResolver;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class OfficeXDocConverter {
	public static void main(String[] args) {
		// create();
		// createHtml();
//		doGenerateHTMLFile();
	}

	private static void create() {
		long startTime = System.currentTimeMillis();

		try {
			// 1) Load docx with POI XWPFDocument
			// XWPFDocument document = new XWPFDocument(
			// Data.class.getResourceAsStream( "DocxResume.docx" ) );

			XWPFDocument document = new XWPFDocument(new FileInputStream(
					new File("/home/xzh/User/DocxBig.docx")));

			// 2) Convert POI XWPFDocument 2 PDF with iText
			File outFile = new File("target/DocxResume.pdf");
			System.out.println(outFile.getAbsolutePath());
			outFile.getParentFile().mkdirs();

			OutputStream out = new FileOutputStream(outFile);
			PdfOptions options = null; // PdfOptions.create().fontEncoding(
										// "windows-1250" );
			PdfConverter.getInstance().convert(document, out, options);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.out.println("Generate DocxResume.pdf with "
				+ (System.currentTimeMillis() - startTime) + " ms.");
	}

	public static void createHtml() {
		try {
			// 1) Load docx with POI XWPFDocument
			XWPFDocument document = new XWPFDocument(new FileInputStream(
					new File("/home/xzh/User/DocxBig.docx")));
			File mediaFile = new File("word/media");
			System.out.println(mediaFile.getAbsolutePath());
			mediaFile.mkdirs();
			XHTMLOptions options = XHTMLOptions.create().URIResolver(
					new FileURIResolver(mediaFile));

			// 2) Convert POI XWPFDocument 2 PDF with iText
			File outFile = new File("target/DocxBig.html");
			outFile.getParentFile().mkdirs();

			OutputStream out = new FileOutputStream(outFile);
			XHTMLConverter.getInstance().convert(document, out, options);
			System.out.println("completed");
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	public static void doGenerateHTMLFile(String fileName , String htmlName) {
		try {
			String fileOutName = htmlName;

			long startTime = System.currentTimeMillis();

			XWPFDocument document = new XWPFDocument(new FileInputStream(
					new File(fileName)));

			XHTMLOptions options = XHTMLOptions.create();// .indent( 4 );
			// Extract image
			File imageFolder = new File("word/media");
			options.setExtractor(new FileImageExtractor(imageFolder));
			// URI resolver
			options.URIResolver(new FileURIResolver(imageFolder));

			OutputStream out = new FileOutputStream(new File(fileOutName));
			XHTMLConverter.getInstance().convert(document, out, options);

			System.out.println("Generate " + fileOutName + " with "
					+ (System.currentTimeMillis() - startTime) + " ms.");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
