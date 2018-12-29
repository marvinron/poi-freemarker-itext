package com.poi.markreplace;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Bookmark;
import org.apache.poi.hwpf.usermodel.Bookmarks;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * @author houlei
 * @DESC:
 * @create
 */
public class ReplaceMark extends XWPFDocument {

    public static void replaceBookmarks(HWPFDocument doc, Map<String, String> bookmarkValues)  {
        try {
            Bookmarks bookmarks = doc.getBookmarks();
            for (int i = 0; i < bookmarks.getBookmarksCount(); i++) {
                Bookmark bookmark = bookmarks.getBookmark(i);
                String bookmarkName = bookmark.getName();
                int start = bookmark.getStart();
                int end = bookmark.getEnd();
                Range range = new Range(start, end, doc);
                String text = range.text();
                if (StringUtils.isBlank(bookmarkValues.get(bookmarkName))
                        || StringUtils.equals(text, bookmarkValues.get(bookmarkName))) {
                    continue;
                }

                if (StringUtils.isBlank(text)) {
                    range.insertBefore(bookmarkValues.get(bookmarkName));
                } else {
                    if (text.equals("0")) {
                        text = "[]";
                    }
                    range.replaceText(text, bookmarkValues.get(bookmarkName));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void replaceBookmarks2013 (XWPFDocument doc, Map<String, Object> bookmarkValues) throws InvalidFormatException {
        byte[] byteArray  = (byte[])bookmarkValues.get("data");
        ByteArrayInputStream byteInputStream = new ByteArrayInputStream(byteArray);
        doc.addPictureData(byteInputStream, XWPFDocument.PICTURE_TYPE_PNG);


    }

        /**
         * 将输入流中的数据写入字节数组
         *
         * @param in
         * @return
         */
    public static byte[] inputStream2ByteArray(InputStream in, boolean isClose) {
        byte[] byteArray = null;
        try {
            int total = in.available();
            byteArray = new byte[total];
            in.read(byteArray);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isClose) {
                try {
                    in.close();
                } catch (Exception e2) {
                    e2.getStackTrace();
                }
            }
        }
        return byteArray;
    }






    public static void main(String[] args) throws Exception {
        byte[] bytes = null;
        InputStream in = new FileInputStream(new File("E:\\logs\\456.doc"));
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Map<String,String> map = new HashMap<String, String>();
        map.put("date","E:\\logs\\123.png");
        map.put("title","huoren");
        HWPFDocument document = new HWPFDocument(in);
        replaceBookmarks(document,map);
        document.write(os);
        bytes = os.toByteArray();
        String destFile ="E:\\logs\\new100.doc";
        /*File file = new File("E:\\logs\\new123.doc");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(bytes);
        fileOutputStream.flush();*/
        Path path = Paths.get(destFile);
        Files.write(path,bytes);
    }

}
