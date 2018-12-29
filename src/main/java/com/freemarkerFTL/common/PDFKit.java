package com.freemarkerFTL.common;

import com.freemarkerFTL.util.FreeMarkerUtil;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @author houlei
 * @DESC:pdf的工具类
 * @create 2018-12-21 15:03
 */
public class PDFKit {

    private String saveFilePath;

    /**
     * @description     导出pdf到文件
     * @param fileName  输出PDF文件名
     * @param data      模板所需要的数据
     *
     */
    public String exportToFile(String fileName,Object data){

        String htmlData= FreeMarkerUtil.getContent(fileName, data);
        if(StringUtils.isEmpty(saveFilePath)){
            saveFilePath=getDefaultSavePath(fileName);
        }
        File file=new File(saveFilePath);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        FileOutputStream outputStream=null;
        try{
            //设置输出路径
            outputStream=new FileOutputStream(saveFilePath);
            //设置文档大小
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);
            //输出为PDF文件
            convertToPDF(writer,document,htmlData);
        }catch(Exception ex){
            throw new RuntimeException("PDF export to File fail",ex);
        }finally{
            IOUtils.closeQuietly(outputStream);
        }
        return saveFilePath;

    }

    /**
     * @description PDF文件生成
     */
    private  void convertToPDF(PdfWriter writer,Document document,String htmlString){
        //获取字体路径
        String fontPath=getFontPath();
        document.open();
        try {
            XMLWorkerHelper.getInstance().parseXHtml(writer,document,
                    new ByteArrayInputStream(htmlString.getBytes()),
                    XMLWorkerHelper.class.getResourceAsStream("/default.css"),
                    Charset.forName("UTF-8"),new XMLWorkerFontProvider(fontPath));
        } catch (IOException e) {
            e.printStackTrace();
            throw new  RuntimeException("PDF文件生成异常",e);
        }finally {
            document.close();
        }

    }
    /**
     * @description 创建默认保存路径
     */
    private  String  getDefaultSavePath(String fileName){
        String classpath=PDFKit.class.getClassLoader().getResource("").getPath();
        String saveFilePath=classpath+"pdf/"+fileName;
        File f=new File(saveFilePath);
        if(!f.getParentFile().exists()){
            f.mkdirs();
        }
        return saveFilePath;
    }

    /**
     * @description 获取字体设置路径
     */
    public static String getFontPath() {
        String classpath=PDFKit.class.getClassLoader().getResource("").getPath();
        String fontpath=classpath+"fonts";
        return fontpath;
    }




    public String getSaveFilePath() {
        return saveFilePath;
    }

    public void setSaveFilePath(String saveFilePath) {
        this.saveFilePath = saveFilePath;
    }

}
