//package org.yyf.javase.temp;
//
//import org.xhtmlrenderer.pdf.ITextFontResolver;
//import org.xhtmlrenderer.pdf.ITextRenderer;
//
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.pdf.BaseFont;
//
//import java.io.ByteArrayOutputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.StringWriter;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import freemarker.cache.ClassTemplateLoader;
//import freemarker.template.*;
//
///**
// * 合同生成预览工具类
// */
//public class PDFBuilderUtil {
//
//    private PDFBuilderUtil() {
//    }
//    private static final  String TEMP_PATH = "/template/";
//
//    private static Configuration cfg;
//
//    static {
//        cfg = new Configuration(Configuration.VERSION_2_3_23);
//        cfg.setTemplateLoader(new ClassTemplateLoader(PDFBuilderUtil.class, TEMP_PATH));
//        cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_23));
//        cfg.setDefaultEncoding("UTF-8");
//        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
//        cfg.setIncompatibleImprovements(new Version(2, 3, 23));
//    }
//
//    public static byte[] createPDF(String name, Object obj) throws IOException, TemplateException, DocumentException {
//        String html = getHtmlTemplate(name, obj);
//
//        ByteArrayOutputStream data = new ByteArrayOutputStream();
//        ITextRenderer renderer = new ITextRenderer();
//        ITextFontResolver fontResolver = renderer.getFontResolver();
//
//        //方法一：使用Windows系统字体(TrueType)
//       // BaseFont baseFont = BaseFont.createFont(TEMP_PATH+"/fonts/SIMSUN.TTC", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//
//        //方法二：使用iTextAsian.jar中的字体
//        //BaseFont baseFont = BaseFont.createFont("STSong-Light",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
//        fontResolver.addFont(TEMP_PATH+"fonts/SIMSUN.TTC", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//       // String baseUrl = PDFBuilder.class.getResource("/images/").toString();
//        //renderer.setDocumentFromString(html, baseUrl);
//        renderer.setDocumentFromString(html);
//        renderer.layout();
//        renderer.createPDF(data);
//        data.close();
//        return data.toByteArray();
//    }
//
//    public static String getHtmlTemplate(String name, Object obj) throws IOException, TemplateException {
//        Template temp = cfg.getTemplate(name+".html");
//        StringWriter writer = new StringWriter();
//        temp.process(obj, writer);
//        writer.close();
//        return writer.getBuffer().toString();
//    }
//
//
//    public static void main(String[] args) {
//
//        try {
//
//            Map<String, Object> map = new HashMap<>();
//            map.put("contractNo", "1212121");//协议编号
//            map.put("transferorName", "zhngan");//出让人姓名
//            map.put("transferorId", "12323232");//"CF系统的唯一标识#
//            map.put("transferorIdentityNo", "234343");//身份证号码/注册证号码
//
//            map.put("transfereeName", "3434343");//受让人姓名/名称
//            map.put("loanTerm","333");
//
//
//            map.put("payDate", "2018-03-22");//签订时间： 发起支付申请的日期
//
//            List<Map<String,String>> list  = new ArrayList<>();
//            Map<String,String> sources = new HashMap<>();
//            sources.put("arAmount","2000");
//            sources.put("transferAmount","2000");
//            sources.put("arDuration","60");
//            sources.put("arStartDate","2017-08-30");
//            sources.put("arDueDate","2017-11-30");
//            sources.put("arPayDate","2018-01-30");
//
//            list.add(sources);
//            map.put("arSourceList",list);
//            map.put("transferAmount","2000");
//            map.put("tradeContractNo","2017080066001");
//
//
//            //byte[] bytes = PDFBuilder.createPDF("L1-L2债权转让协议",map);
//
//            FileOutputStream fileOutputStream = new FileOutputStream("/Users/weilongshi/Desktop/demo.pdf");
//            fileOutputStream.write(bytes);
//            fileOutputStream.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }
//}
