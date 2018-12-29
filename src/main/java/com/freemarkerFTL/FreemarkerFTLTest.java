package com.freemarkerFTL;

import com.freemarkerFTL.common.PDFKit;
import com.poi.bean.MainInfoBean;
import com.poi.util.PathUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author houlei
 * @DESC:用ftl做模板
 * @create 2018-12-21 14:48
 */
public class FreemarkerFTLTest {
    public static void main(String[] args) {


        Map<String,Object> templateBO=new HashMap<String,Object>();
        templateBO.put("templateName","Hello iText! Hello freemarker!");
        templateBO.put("ITEXTUrl","http://developers.itextpdf.com/examples-itext5");
        templateBO.put("freeMarkerUrl","http://www.zheng-hang.com/chm/freemarker2_3_24/ref_directive_if.html");
        templateBO.put("JFreeChartUrl","http://www.yiibai.com/jfreechart/jfreechart_referenced_apis.html");
        templateBO.put("imageUrl","http://mss.vip.sankuai.com/v1/mss_74e5b6ab17f44f799a524fa86b6faebf/360report/logo_1.png");
        List<MainInfoBean> scores=new ArrayList<MainInfoBean>();
        for (int i = 0; i < 9; i++) {
            MainInfoBean mainInfoBean = new MainInfoBean();
            mainInfoBean.setLegalName("大白");
            mainInfoBean.setPrimUserEmail("dabai@163.com");
            mainInfoBean.setPrimUserPhone("123456789");
            mainInfoBean.setRetailAddr("金长安");
            mainInfoBean.setRetailName("大白");
            mainInfoBean.setRetailRegcode("110");
            scores.add(mainInfoBean);
        }
        templateBO.put("scores",scores);
        String templatePath=PathUtil.getCurrentPath()+"templates";
        long old = System.currentTimeMillis();
        String path= createPDF(templateBO,"hello.pdf");
        long now = System.currentTimeMillis();
        System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒"); // 转化用时
        System.out.println(path);

    }

    public static   String createPDF(Object data, String fileName){
        //pdf保存路径
        try {
            //设置输出路径
            PDFKit kit = new PDFKit();
            kit.setSaveFilePath("/Users/fgm/Desktop/pdf/hello1.pdf");
            String saveFilePath=kit.exportToFile(fileName,data);
            return  saveFilePath;
        } catch (Exception e) {
           e.printStackTrace();
            return null;
        }

    }


}
