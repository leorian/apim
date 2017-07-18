package com.leorain.apim.itext;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by xiezg@317hu.com on 2017/7/18 0018.
 */
public class DocumentPdfTest {
    public static final String DEST = "results/tables/colored_border.pdf";

    public static void main(String[] args) throws IOException, DocumentException {
        FontFactory.register("C:\\Windows\\Fonts\\simhei.ttf");
        FontFactory.register("C:\\Windows\\Fonts\\simkai.ttf");
        FontFactory.register("C:\\Windows\\Fonts\\simsun.ttc");
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(DEST));
        document.open();
        for (int k = 0; k < 10; k++) {
            //设置中文字体和字体样式
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            Font f8 = new Font(bfChinese, 8, Font.NORMAL);

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

            Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL);
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
        }
        document.close();
    }
}
