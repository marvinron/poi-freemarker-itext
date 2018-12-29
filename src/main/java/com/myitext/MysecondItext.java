package com.myitext;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.poi.util.PathUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;

/**
 * @author houlei
 * @DESC:对html的模板操作
 * @create 2018-12-21 11:32
 */
public class MysecondItext {

    private static final String DEST = "E:\\logs\\HelloWorld_html1.pdf";
    private static final String FONT = "simhei.ttf";
    private static final String HTMLPDF = "E:\\logs\\template1.html";


    public static void main(String[] args) throws Exception  {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(DEST));
        // step 3
        document.open();
        // step 4
        XMLWorkerFontProvider fontImp = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
        fontImp.register(FONT);
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                new FileInputStream(HTMLPDF), null, Charset.forName("UTF-8"), fontImp);
        // step 5
        document.close();
    }

}
