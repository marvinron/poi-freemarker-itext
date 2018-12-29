package com.myitext;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

/**
 * @author houlei
 * @DESC:对Itext简单的测试
 * @create 2018-12-21 11:09
 */
public class MyFirstItext {

    private static final String DEST = "E:\\logs\\HelloWorld_CN.pdf";
    private static final String FONT = "simhei.ttf";

    public static void main(String[] args) throws Exception  {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(DEST));
        document.open();
        Font f1 = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        document.add(new Paragraph("hello world,我是大白",f1));
        document.close();
        writer.close();
    }
}
