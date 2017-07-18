package com.leorain.apim.itext;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * 
 * @Title: 单纯输出PDF报表
 * @Description:
 * @Copyright: Copyright (c) 2014
 * @Company: SinoSoft
 * 
 * @author: ShaoMin
 * @version: 1.0
 * @CreateDate：Nov 5, 2014
 */
public class PDFPractise {

    /**
     * @author ShaoMin
     * @param args
     */
    public static void main(String[] args) {

        PDFPractise tPDFPractise = new PDFPractise();
        try {
            tPDFPractise.createPdfFile();

            // tPDFPractise.createPDFFile();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建PDF
     * 
     * @author ShaoMin
     * @throws Exception
     */
    public void createPdfFile() throws Exception {
        Document doc = new Document();
        FileOutputStream out = new FileOutputStream("results/objects/practisePdfFile.pdf");
        PdfWriter.getInstance(doc, out);
        doc.open();

        BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font titleFont = new Font(bfChinese, 16, Font.BOLD);// 标题
        Font tableTitleFont = new Font(bfChinese, 12, Font.BOLD);// 表格标题
        Font conyentFont = new Font(bfChinese, 12, Font.NORMAL);// 内容

        Paragraph title = new Paragraph("受理材料收取凭证", titleFont);
        title.setAlignment(Rectangle.ALIGN_CENTER);// 居中
        doc.add(title);

        StringBuffer strBuff = new StringBuffer();
        strBuff.append("兹收到客户  " + "SAM-SHO");
        strBuff.append("（先生/女士）提交的保单号为    " + "123456789009876");
        strBuff.append("     的申请材料，共   " + " 2 " + "  张保单。");

        Paragraph content = new Paragraph(strBuff.toString(), conyentFont);
        content.setAlignment(Rectangle.ALIGN_JUSTIFIED);
        content.setFirstLineIndent(15f);// 首行缩进
        content.setSpacingBefore(30f);// 上留白
        doc.add(content);

        String cont2 = "申请保全项目    " + " CM-退保";
        content = new Paragraph(cont2, conyentFont);
        content.setAlignment(Rectangle.ALIGN_JUSTIFIED);
        content.setFirstLineIndent(15f);// 首行缩进
        content.setSpacingBefore(15f);// 上留白
        doc.add(content);

        String cont3 = "所提供材料明细如下：";
        content = new Paragraph(cont3, conyentFont);
        content.setAlignment(Rectangle.ALIGN_JUSTIFIED);
        content.setFirstLineIndent(15f);// 首行缩进
        content.setSpacingBefore(15f);// 上留白
        content.setSpacingAfter(15f);// 下留白
        doc.add(content);

        // 表格的处理是难点，特别是表格的跨行跨列
        // 可以使用跨行也可以使用表格嵌套
        int tCol = 5;
        PdfPTable table = new PdfPTable(tCol);
        table.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.setTotalWidth(500f);
        table.setWidths(new float[] { 0.4f, 0.25f, 0.25f, 0.25f, 0.25f });
        table.setWidthPercentage(100);
        table.setLockedWidth(true);

        String strTableTitle = "申请材料名称";
        Paragraph tableTitle = new Paragraph(strTableTitle, tableTitleFont);
        PdfPCell cell = new PdfPCell(tableTitle);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 水平居中
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);// 垂直居中
        cell.setRowspan(2);// 跨2行
        table.addCell(cell);

        strTableTitle = "申请材料类型";
        tableTitle = new Paragraph(strTableTitle, tableTitleFont);
        cell = new PdfPCell(tableTitle);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 水平居中
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);// 垂直居中
        cell.setColspan(2);// 跨2列
        table.addCell(cell);

        strTableTitle = "收取页数/份数";
        tableTitle = new Paragraph(strTableTitle, tableTitleFont);
        cell = new PdfPCell(tableTitle);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 水平居中
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);// 垂直居中
        cell.setRowspan(2);// 跨2行
        table.addCell(cell);

        strTableTitle = "备注";
        tableTitle = new Paragraph(strTableTitle, tableTitleFont);
        cell = new PdfPCell(tableTitle);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 水平居中
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);// 垂直居中
        cell.setRowspan(2);// 跨2行
        table.addCell(cell);

        // 这边属于第二行的表格
        // 思路上，这点很关键
        strTableTitle = "原件";
        tableTitle = new Paragraph(strTableTitle, tableTitleFont);
        cell = new PdfPCell(tableTitle);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 水平居中
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);// 垂直居中
        table.addCell(cell);

        strTableTitle = "复印件";
        tableTitle = new Paragraph(strTableTitle, tableTitleFont);
        cell = new PdfPCell(tableTitle);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 水平居中
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);// 垂直居中
        table.addCell(cell);

        String[] arrTitle = { "保险合同", "保险合同收据或发票", "保单贷款申请书", "保全变更申请书", "被保险人变更清单", "健康及财务告知", "授权委托书", "投保人身份证件", "被保险人身份证件", "身故受益人身份证件", "受托人身份证件", "投保人账号", "被保险人/监护人账号 ", "生存证明", "关系证明 ",
                "其他受理材料 " };
        int tRow = arrTitle.length;

        for (int i = 0; i < tRow; i++) {
            for (int j = 0; j < tCol; j++) {
                if (j == 0) {
                    // 左侧标题
                    strTableTitle = arrTitle[i];
                    tableTitle = new Paragraph(strTableTitle, conyentFont);
                    cell = new PdfPCell(tableTitle);
                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);// 水平居中
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);// 垂直居中
                    table.addCell(cell);
                } else {
                    strTableTitle = i + "--" + j;
                    tableTitle = new Paragraph(strTableTitle, conyentFont);
                    cell = new PdfPCell(tableTitle);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 水平居中
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);// 垂直居中
                    table.addCell(cell);
                }
            }
        }
        table.setSpacingAfter(15f);// 下留白
        doc.add(table);

        // 所有的都要指定中文，不然显示不出来
        // Phrase没有位置的操作,但是空格会被保留
        // 也可以使用表格处理，隐藏边框即可
        Phrase tPhrase = new Phrase("    申请人:                                     " + "                                         " + "                                         " + "保全试算金额:",
                conyentFont);
        Paragraph tParagraph = new Paragraph(tPhrase);
        doc.add(tParagraph);

        // 尾部表格处理
        PdfPTable footTable = new PdfPTable(2);
        footTable.setTotalWidth(760f);
        footTable.setWidths(new float[] { 4.6f, 1f });
        footTable.setHorizontalAlignment(Element.ALIGN_LEFT);

        strTableTitle = "   申请日期：";
        tableTitle = new Paragraph(strTableTitle, conyentFont);
        cell = new PdfPCell(tableTitle);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);// 水平居中
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);// 垂直居中
        cell.setBorderWidth(0);
        footTable.addCell(cell);

        strTableTitle = "受理人：";
        tableTitle = new Paragraph(strTableTitle, conyentFont);
        cell = new PdfPCell(tableTitle);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);// 水平居中
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);// 垂直居中
        cell.setBorderWidth(0);
        footTable.addCell(cell);

        strTableTitle = "   申请人电话：";
        tableTitle = new Paragraph(strTableTitle, conyentFont);
        cell = new PdfPCell(tableTitle);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);//
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);// 垂直居中
        cell.setBorderWidth(0);
        footTable.addCell(cell);

        strTableTitle = "受理日期：";
        tableTitle = new Paragraph(strTableTitle, conyentFont);
        cell = new PdfPCell(tableTitle);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);//
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);// 垂直居中
        cell.setBorderWidth(0);
        footTable.addCell(cell);

        doc.add(footTable);
        
        tParagraph = new Paragraph();
        Chunk tChunk = new Chunk("   说明:  ",conyentFont);
        tParagraph.add(tChunk);
        
        tChunk = new Chunk("                                                                               ",conyentFont);
        tChunk.setUnderline(0.1f, -2f);
        tParagraph.add(tChunk);
        tChunk = new Chunk("                                                                           ",conyentFont);
        tChunk.setUnderline(0.1f, -2f);
        tParagraph.add(tChunk);
        tChunk = new Chunk("                                                                        ",conyentFont);
        tChunk.setUnderline(0.1f, -2f);
        tParagraph.add(tChunk);
        
        tParagraph.setLeading(30f);
        tChunk = new Chunk("                                                                          ",conyentFont);
        tChunk.setUnderline(0.1f, -2f);
        tParagraph.add(tChunk);
        tChunk = new Chunk("                                                                          ",conyentFont);
        tChunk.setUnderline(0.1f, -2f);
        tParagraph.add(tChunk);
        
        doc.add(tParagraph);
        
        doc.close();
        System.out.println("结束.....");
    }

    /**
     * 
     * @author ShaoMin
     * 
     */
    public void createPDFFile() {

        Document document = new Document(PageSize.A4, 80, 79, 20, 45); // A4纸大小,//
                                                                       // 左、右、上、下
        try {
            // 中文处理
            BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);

            Font FontChinese = new Font(bfChinese, 14, Font.NORMAL); // 其他所有文字字体
            Font BoldChinese = new Font(bfChinese, 14, Font.BOLD); // 粗体
            Font titleChinese = new Font(bfChinese, 20, Font.BOLD); // 模板抬头的字体
            Font moneyFontChinese = new Font(bfChinese, 8, Font.NORMAL); // 币种和租金金额的小一号字体
            Font subBoldFontChinese = new Font(bfChinese, 8, Font.BOLD); // 币种和租金金额的小一号字体

            // 使用PDFWriter进行写文件操作
            PdfWriter.getInstance(document, new FileOutputStream("temp/pdf/pdfFile.pdf"));
            document.open(); // 打开文档

            // ------------开始写数据-------------------
            Paragraph title = new Paragraph("起租通知书", titleChinese);// 抬头
            title.setAlignment(Element.ALIGN_CENTER); // 居中设置
            title.setLeading(1f);// 设置行间距//设置上面空白宽度
            document.add(title);

            title = new Paragraph("致：XXX公司", BoldChinese);// 抬头
            title.setSpacingBefore(25f);// 设置上面空白宽度
            document.add(title);

            title = new Paragraph("         贵我双方签署的编号为 XXX有关起租条件已满足，现将租赁合同项下相关租赁要素明示如下：", FontChinese);
            title.setLeading(22f);// 设置行间距
            document.add(title);

            float[] widths = { 10f, 25f, 30f, 30f };// 设置表格的列宽和列数 默认是4列

            PdfPTable table = new PdfPTable(widths);// 建立一个pdf表格
            table.setSpacingBefore(20f);// 设置表格上面空白宽度
            table.setTotalWidth(500);// 设置表格的宽度
            table.setWidthPercentage(100);// 设置表格宽度为%100
            // table.getDefaultCell().setBorder(0);//设置表格默认为无边框

            String[] tempValue = { "1", "2011-07-07", "2222元", "233元", "2014-12-22", "3000元", "9999元" }; // 租金期次列表
            int rowCount = 1; // 行计数器
            PdfPCell cell = null;
            // ---表头
            cell = new PdfPCell(new Paragraph("期次", subBoldFontChinese));// 描述
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("租金日", subBoldFontChinese));// 描述
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("各期租金金额", subBoldFontChinese));// 描述
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("各期租金后\n剩余租金", subBoldFontChinese));// 描述
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            cell.setFixedHeight(20);
            table.addCell(cell);

            for (int j = 1; j < tempValue.length; j++) {
                if (j % 2 == 1) { // 第一列 日期
                    cell = new PdfPCell(new Paragraph(rowCount + "", moneyFontChinese));// 描述
                    cell.setFixedHeight(20);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
                    table.addCell(cell);
                    rowCount++;
                }
                cell = new PdfPCell(new Paragraph(tempValue[j], moneyFontChinese));// 描述
                cell.setFixedHeight(20);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
                table.addCell(cell);
            }
            document.add(table);

            title = new Paragraph("                租金总额：XXX", FontChinese);
            title.setLeading(22f);// 设置行间距
            document.add(title);
            title = new Paragraph("         特此通知！", FontChinese);
            title.setLeading(22f);// 设置行间距
            document.add(title);
            // -------此处增加图片和日期，因为图片会遇到跨页的问题，图片跨页，图片下方的日期就会脱离图片下方会放到上一页。
            // 所以必须用表格加以固定的技巧来实现
            float[] widthes = { 50f };// 设置表格的列宽和列数
            PdfPTable hiddenTable = new PdfPTable(widthes);// 建立一个pdf表格
            hiddenTable.setSpacingBefore(11f); // 设置表格上空间
            hiddenTable.setTotalWidth(500);// 设置表格的宽度
            hiddenTable.setWidthPercentage(100);// 设置表格宽度为%100
            hiddenTable.getDefaultCell().disableBorderSide(1);
            hiddenTable.getDefaultCell().disableBorderSide(2);
            hiddenTable.getDefaultCell().disableBorderSide(4);
            hiddenTable.getDefaultCell().disableBorderSide(8);

            Image upgif = Image.getInstance("source/imag/bage.png");
            upgif.scalePercent(7.5f);// 设置缩放的百分比%7.5
            upgif.setAlignment(Element.ALIGN_RIGHT);

            cell = new PdfPCell(new Paragraph("", FontChinese));// 描述
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);// 设置内容水平居中显示
            cell.addElement(upgif);
            cell.setPaddingTop(0f); // 设置内容靠上位置
            cell.setPaddingBottom(0f);
            cell.setPaddingRight(20f);
            cell.setBorder(Rectangle.NO_BORDER);// 设置单元格无边框
            hiddenTable.addCell(cell);

            cell = new PdfPCell(new Paragraph("XX 年 XX 月 XX 日                    ", FontChinese));// 金额
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);// 设置内容水平居中显示
            cell.setPaddingTop(0f);
            cell.setPaddingRight(20f);
            cell.setBorder(Rectangle.NO_BORDER);
            hiddenTable.addCell(cell);
            document.add(hiddenTable);
            System.out.println("拼装起租通知书结束...");
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 支持中文
     * 
     * @return
     */
    public Font getChineseFont() {
        BaseFont bfChinese;
        Font fontChinese = null;
        try {
            bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            // fontChinese = new Font(bfChinese, 12, Font.NORMAL);
            fontChinese = new Font(bfChinese, 12, Font.NORMAL, BaseColor.BLUE);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fontChinese;

    }

}
