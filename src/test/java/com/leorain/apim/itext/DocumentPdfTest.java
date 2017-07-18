package com.leorain.apim.itext;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by xiezg@317hu.com on 2017/7/18 0018.
 */
public class DocumentPdfTest {
    public static final String DEST = "results/tables/colored_border.pdf";
    public static final String STRING = "{'age':23,'aihao':['pashan','movies'],'name':{'firstName':'中文问题','lastName':'san'," +
            "'aihao':['pashan','movies','name':{'firstName':'zhang','lastName':'san','aihao':['pashan','movies']}]}}";


    public static void main(String[] args) throws IOException, DocumentException {
        FontFactory.register("C:\\Windows\\Fonts\\simhei.ttf");
        FontFactory.register("C:\\Windows\\Fonts\\simkai.ttf");
        FontFactory.register("C:\\Windows\\Fonts\\simsun.ttc");
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(DEST));
        document.open();
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font f8 = new Font(bfChinese, 8, Font.NORMAL);

        Paragraph centerParagraph = new Paragraph("xx项目接口描述文档", new Font(bfChinese, 20, Font.BOLD));
        centerParagraph.setAlignment(Element.ALIGN_CENTER);
        document.add(centerParagraph);
        DottedLineSeparator separator = new DottedLineSeparator();
        Chunk linebreak = new Chunk(separator);
        document.add(new Paragraph(linebreak));
        for (int k = 0; k < 10; k++) {
            Chapter chapter = new Chapter("测试" + k, k);
//            chapter.addSection("测试" + k);
            chapter.setTitle(new Paragraph("测试" + k, new Font(bfChinese, 18, Font.BOLD)));
            document.add(chapter);
            //设置中文字体和字体样式


            //接口描述
            Paragraph interfaceDescribeParagraph = new Paragraph("接口描述", new Font(bfChinese, 10, Font.BOLD));
            interfaceDescribeParagraph.setSpacingBefore(12);
            interfaceDescribeParagraph.setSpacingAfter(8);
            document.add(interfaceDescribeParagraph);
            PdfPTable interfaceDescribePdfPTable = new PdfPTable(1);
            interfaceDescribePdfPTable.setWidthPercentage(100);
            PdfPCell interfaceDescribePdfPCell = new PdfPCell(new Phrase("查询用户基本信息", f8));
            interfaceDescribePdfPCell.setBorderWidth(0);
            interfaceDescribePdfPCell.setBorderWidthLeft(3);
            interfaceDescribePdfPCell.setBorderColorLeft(BaseColor.LIGHT_GRAY);
            interfaceDescribePdfPCell.setPadding(10);
            interfaceDescribePdfPTable.addCell(interfaceDescribePdfPCell);
            document.add(interfaceDescribePdfPTable);

            Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.RED);
            Font font1 = FontFactory.getFont("黑体", BaseFont.WINANSI, 8);
            //接口地址
            Paragraph interfaceAddressParagraph = new Paragraph("接口地址", new Font(bfChinese, 10, Font.BOLD));
            interfaceAddressParagraph.setSpacingBefore(12);
            interfaceAddressParagraph.setSpacingAfter(8);
            document.add(interfaceAddressParagraph);
            PdfPTable interfaceAddressPdfPTable = new PdfPTable(1);
            interfaceAddressPdfPTable.setWidthPercentage(100);
            PdfPCell interfaceAddressPdfPCell = new PdfPCell(new Phrase("/user/findUser", paragraphFont));
            interfaceAddressPdfPCell.setBorderWidth(0);
            interfaceAddressPdfPCell.setBorderWidthLeft(3);
            interfaceAddressPdfPCell.setBorderColorLeft(BaseColor.LIGHT_GRAY);
            interfaceAddressPdfPCell.setPadding(10);
            interfaceAddressPdfPTable.addCell(interfaceAddressPdfPCell);
            document.add(interfaceAddressPdfPTable);


            //请求方式
            Paragraph requestMethodParagraph = new Paragraph("请求方式", new Font(bfChinese, 10, Font.BOLD));
            requestMethodParagraph.setSpacingBefore(12);
            requestMethodParagraph.setSpacingAfter(8);
            document.add(requestMethodParagraph);
            PdfPTable requestMethodPdfPTable = new PdfPTable(1);
            requestMethodPdfPTable.setWidthPercentage(100);
            PdfPCell requestMethodPdfPCell = new PdfPCell(new Phrase("HTTP+POST", paragraphFont));
            requestMethodPdfPCell.setBorderWidth(0);
            requestMethodPdfPCell.setBorderWidthLeft(3);
            requestMethodPdfPCell.setBorderColorLeft(BaseColor.LIGHT_GRAY);
            requestMethodPdfPCell.setPadding(10);
            requestMethodPdfPTable.addCell(requestMethodPdfPCell);
            document.add(requestMethodPdfPTable);

            //数据格式
            Paragraph dataFormatParagraph = new Paragraph("数据格式", new Font(bfChinese, 10, Font.BOLD));
            dataFormatParagraph.setSpacingBefore(12);
            dataFormatParagraph.setSpacingAfter(8);
            document.add(dataFormatParagraph);
            PdfPTable dataFormatPdfPTable = new PdfPTable(1);
            dataFormatPdfPTable.setWidthPercentage(100);
            PdfPCell dataFormatPdfPCell = new PdfPCell(new Phrase("JSON", paragraphFont));
            dataFormatPdfPCell.setBorderWidth(0);
            dataFormatPdfPCell.setBorderWidthLeft(3);
            dataFormatPdfPCell.setBorderColorLeft(BaseColor.LIGHT_GRAY);
            dataFormatPdfPCell.setPadding(10);
            dataFormatPdfPTable.addCell(dataFormatPdfPCell);
            document.add(dataFormatPdfPTable);

            //参数说明
            PdfPTable p1 = new PdfPTable(7);
            PdfPCell pdfPCell01 = new PdfPCell(new Phrase("名称", new Font(bfChinese, 8, Font.BOLD)));
            pdfPCell01.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfPCell01.setPadding(5);
            PdfPCell pdfPCell02 = new PdfPCell(new Phrase("类型", new Font(bfChinese, 8, Font.BOLD)));
            pdfPCell02.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfPCell02.setPadding(5);
            PdfPCell pdfPCell03 = new PdfPCell(new Phrase("说明", new Font(bfChinese, 8, Font.BOLD)));
            pdfPCell03.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfPCell03.setPadding(5);
            PdfPCell pdfPCell04 = new PdfPCell(new Phrase("是否必填", new Font(bfChinese, 8, Font.BOLD)));
            pdfPCell04.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfPCell04.setPadding(5);
            PdfPCell pdfPCell05 = new PdfPCell(new Phrase("JSON格式化传输", new Font(bfChinese, 8, Font.BOLD)));
            pdfPCell05.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfPCell05.setPadding(5);
            PdfPCell pdfPCell06 = new PdfPCell(new Phrase("示例", new Font(bfChinese, 8, Font.BOLD)));
            pdfPCell06.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfPCell06.setPadding(5);
            PdfPCell pdfPCell07 = new PdfPCell(new Phrase("默认值", new Font(bfChinese, 8, Font.BOLD)));
            pdfPCell07.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfPCell07.setPadding(5);
            p1.addCell(pdfPCell01);
            p1.addCell(pdfPCell02);
            p1.addCell(pdfPCell03);
            p1.addCell(pdfPCell04);
            p1.addCell(pdfPCell05);
            p1.addCell(pdfPCell06);
            p1.addCell(pdfPCell07);

            BaseFont bfCeshiFont = BaseFont.createFont("C:/Windows" + "/Fonts/SIMHEI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);//黑体
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 7; j++) {
                    PdfPCell ceshi = new PdfPCell(new Phrase("测试01", new Font(bfCeshiFont, 8, Font.NORMAL)));
                    ceshi.setHorizontalAlignment(Element.ALIGN_CENTER);
                    ceshi.setPadding(5);
                    p1.addCell(ceshi);
                }
            }


            Paragraph parameterParagraph = new Paragraph("参数说明", new Font(bfChinese, 10, Font.BOLD));
            parameterParagraph.setSpacingBefore(12);
            parameterParagraph.setSpacingAfter(8);
            document.add(parameterParagraph);
            PdfPTable parameterPdfPTable = new PdfPTable(1);
            parameterPdfPTable.setWidthPercentage(100);
            PdfPCell parameterPdfPCell = new PdfPCell(p1);
            parameterPdfPCell.setBorderWidth(0);
            parameterPdfPCell.setBorderWidthLeft(3);
            parameterPdfPCell.setBorderColorLeft(BaseColor.LIGHT_GRAY);
            parameterPdfPCell.setPadding(10);
            parameterPdfPTable.addCell(parameterPdfPCell);
            document.add(parameterPdfPTable);


            //返回示例
            Paragraph returnExampleParagraph = new Paragraph("返回示例", new Font(bfChinese, 10, Font.BOLD));
            returnExampleParagraph.setSpacingBefore(12);
            returnExampleParagraph.setSpacingAfter(8);
            document.add(returnExampleParagraph);
            PdfPTable returnExamplePdfPTable = new PdfPTable(1);
            returnExamplePdfPTable.setWidthPercentage(100);
            PdfPCell returnExamplePdfPCell = new PdfPCell(JsonFormatTool2.formatJson(STRING));
            returnExamplePdfPCell.setBorderWidth(0);
            returnExamplePdfPCell.setBorderWidthLeft(3);
            returnExamplePdfPCell.setBorderColorLeft(BaseColor.LIGHT_GRAY);
            returnExamplePdfPCell.setPadding(10);
            returnExamplePdfPTable.addCell(returnExamplePdfPCell);
            document.add(returnExamplePdfPTable);
            PdfPTable returnExampleAttentionMatterPdfPTable = new PdfPTable(1);
            returnExampleAttentionMatterPdfPTable.setWidthPercentage(100);
            PdfPCell returnExampleAttentionMatterPdfPCell = new PdfPCell(JsonFormatTool2.formatJson(STRING));
            returnExampleAttentionMatterPdfPCell.setBorderWidth(0);
            returnExampleAttentionMatterPdfPCell.setBorderWidthLeft(3);
            returnExampleAttentionMatterPdfPCell.setBorderColorLeft(BaseColor.LIGHT_GRAY);
            returnExampleAttentionMatterPdfPCell.setPadding(10);
            returnExampleAttentionMatterPdfPTable.addCell(returnExampleAttentionMatterPdfPCell);
            returnExampleAttentionMatterPdfPTable.setSpacingBefore(6);
            document.add(returnExampleAttentionMatterPdfPTable);

            //异常示例
            Paragraph exceptionExampleParagraph = new Paragraph("异常示例", new Font(bfChinese, 10, Font.BOLD));
            exceptionExampleParagraph.setSpacingBefore(12);
            exceptionExampleParagraph.setSpacingAfter(8);
            document.add(exceptionExampleParagraph);

            PdfPTable exceptionExamPdfPTable = new PdfPTable(1);
            exceptionExamPdfPTable.setWidthPercentage(100);
            PdfPCell exceptionExamPdfPCell = new PdfPCell(JsonFormatTool2.formatJson(STRING));
            exceptionExamPdfPCell.setBorderWidth(0);
            exceptionExamPdfPCell.setBorderWidthLeft(3);
            exceptionExamPdfPCell.setBorderColorLeft(BaseColor.LIGHT_GRAY);
            exceptionExamPdfPCell.setPadding(10);
            exceptionExamPdfPTable.addCell(exceptionExamPdfPCell);
            document.add(exceptionExamPdfPTable);

            PdfPTable exceptionExamAttentionMatterPdfPTable = new PdfPTable(1);
            exceptionExamAttentionMatterPdfPTable.setWidthPercentage(100);
//            Phrase phrase = new Phrase("{\n" +
//                    "    \"data\": {\n" +
//                    "        \"accountGoldTotal\": 14.5,\n" +
//                    "        \"alipayBinding\": true,\n" +
//                    "        \"approveStatus\": 1,\n" +
//                    "        \"careCentralUrl\": \"http://dev.317hu.com\",\n" +
//                    "        \"deptAndWardMessage\": false,\n" +
//                    "        \"nurseTrainUrl\": \"http://nursetrain.dev.317hu.com\",\n" +
//                    "        \"privilegeUrl\": \"http://privilegesit.317hu.com:8080\",\n" +
//                    "        \"trainingPrivilege\": true,\n" +
//                    "        \"userCentralUrl\": \"http://usercenter.sit.317hu.com:3000\"\n" +
//                    "    },\n" +
//                    "    \"success\": true\n" +
//                    "}",
//                    paragraphFont);
//            Paragraph paragraph = new Paragraph(phrase);
            PdfPCell exceptionExamAttentionMatterPdfPCell = new PdfPCell(JsonFormatTool2.formatJson(STRING));
            exceptionExamAttentionMatterPdfPCell.setBorderWidth(0);
            exceptionExamAttentionMatterPdfPCell.setBorderWidthLeft(3);
            exceptionExamAttentionMatterPdfPCell.setBorderColorLeft(BaseColor.LIGHT_GRAY);
            exceptionExamAttentionMatterPdfPCell.setPadding(10);
            exceptionExamAttentionMatterPdfPTable.addCell(exceptionExamAttentionMatterPdfPCell);
            exceptionExamAttentionMatterPdfPTable.setSpacingBefore(6);
            document.add(exceptionExamAttentionMatterPdfPTable);
        }
        document.close();
    }
}
