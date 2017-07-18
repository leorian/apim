package com.leorain.apim.tools;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.leorain.apim.entity.InterfaceHttpEntity;
import com.leorain.apim.entity.InterfaceParamEntity;
import com.leorain.apim.entity.InterfaceResultEntity;
import com.leorain.apim.entity.ProjectEntity;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/7/18 0018.
 */
public class HttpITextExportPdfUtil {

    public static final String[] HTML_PARAM_TITLE = {"名称", "类型", "说明", "是否必填", "JSON格式化传输", "示例", "默认值"};

    /**
     * @param projectEntity         项目信息
     * @param interfaceHttpEntities 项目接口信息
     * @param filePath              文件路径
     * @throws IOException
     * @throws DocumentException
     */
    public static void exportPdf(ProjectEntity projectEntity, List<InterfaceHttpEntity> interfaceHttpEntities, String filePath) throws IOException,
            DocumentException {
        if (CollectionUtils.isEmpty(interfaceHttpEntities)) {
            return;
        }

        //如果文件父级目录不存在，则创建
        File file = new File(filePath);
        file.getParentFile().mkdirs();

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        //项目名称
        Paragraph projectNameParagraph = new Paragraph(projectEntity.getProjectName() + "项目接口描述文档",
                new Font(bfChinese, 20, Font.BOLD));
        projectNameParagraph.setAlignment(Element.ALIGN_CENTER);
        document.add(projectNameParagraph);

        //分隔线
        DottedLineSeparator dottedLineSeparator = new DottedLineSeparator();
        Chunk lineChunk = new Chunk(dottedLineSeparator);
        document.add(new Paragraph(lineChunk));
        for (int i = 0; i < interfaceHttpEntities.size(); i++) {
            //接口名称既是章节名称
            InterfaceHttpEntity interfaceHttpEntity = interfaceHttpEntities.get(i);
            Chapter chapter = new Chapter(interfaceHttpEntity.getName(), i + 1);
            chapter.setTitle(new Paragraph(interfaceHttpEntity.getName(), new Font(bfChinese, 18, Font.BOLD)));
            document.add(chapter);
            //接口描述
            writerGeneralTextParagraph(document, "接口描述", interfaceHttpEntity.getDescription(), bfChinese);

            //请求方式
            writerGeneralTextParagraph(document, "请求方式", interfaceHttpEntity.getProtocol()
                    + "+" + interfaceHttpEntity.getMethod(), bfChinese);

            //数据格式
            writerGeneralTextParagraph(document, "数据格式", interfaceHttpEntity.getTransformat(), bfChinese);

            //参数说明
            BaseFont bfHeiTiFont = BaseFont.createFont("C:/Windows" + "/Fonts/SIMHEI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);//黑体
            List<InterfaceParamEntity> interfaceParamEntities = interfaceHttpEntity.getInterfaceParamEntities();
            PdfPTable pdfPTable = new PdfPTable(HTML_PARAM_TITLE.length);
            for (String htmlParamTitle : HTML_PARAM_TITLE) {
                PdfPCell pdfPCell = new PdfPCell(new Phrase(htmlParamTitle, new Font(bfChinese, 8, Font.BOLD)));
                pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfPCell.setPadding(5);
                pdfPTable.addCell(pdfPCell);
            }
            if (!CollectionUtils.isEmpty(interfaceHttpEntities)) {
                for (InterfaceParamEntity interfaceParamEntity : interfaceParamEntities) {
                    //参数名称
                    pdfPTable.addCell(buildParamPdfPCell(interfaceParamEntity.getParamName(), bfChinese));
                    //参数类型
                    pdfPTable.addCell(buildParamPdfPCell(interfaceParamEntity.getParamType(), bfChinese));
                    //说明
                    pdfPTable.addCell(buildParamPdfPCell(interfaceParamEntity.getParamDescribe(), bfChinese));
                    //是否必填
                    pdfPTable.addCell(buildParamPdfPCell(interfaceParamEntity.getRequired().toString(), bfChinese));
                    //JSON格式化传输
                    pdfPTable.addCell(buildParamPdfPCell(interfaceParamEntity.getJsontransformat().toString(), bfChinese));
                    //示例
                    pdfPTable.addCell(buildParamPdfPCell(interfaceParamEntity.getExample(), bfChinese));
                    //默认值
                    pdfPTable.addCell(buildParamPdfPCell(interfaceParamEntity.getDefaultValue(), bfChinese));
                }
            }
            writerComplexPdfPTableParagraph(document, "参数说明", pdfPTable, bfChinese);

            //返回示例和异常示例
            List<InterfaceResultEntity> interfaceResultEntities = interfaceHttpEntity.getInterfaceResultEntities();


        }

    }

    /**
     * @param document
     * @param title
     * @param content
     * @param bfChinese
     * @return
     */
    public static void writerGeneralTextParagraph(Document document, String title, String content, BaseFont bfChinese)
            throws DocumentException {
        //标题
        Paragraph interfaceDescribeParagraph = new Paragraph(title, new Font(bfChinese, 10, Font.BOLD));
        interfaceDescribeParagraph.setSpacingBefore(12);
        interfaceDescribeParagraph.setSpacingAfter(8);
        document.add(interfaceDescribeParagraph);
        //内容
        PdfPTable interfaceDescribePdfPTable = new PdfPTable(1);
        interfaceDescribePdfPTable.setWidthPercentage(100);
        PdfPCell interfaceDescribePdfPCell = new PdfPCell(new Phrase(content, new Font(bfChinese, 8, Font.NORMAL)));
        interfaceDescribePdfPCell.setBorderWidth(0);
        interfaceDescribePdfPCell.setBorderWidthLeft(3);
        interfaceDescribePdfPCell.setBorderColorLeft(BaseColor.LIGHT_GRAY);
        interfaceDescribePdfPCell.setPadding(10);
        interfaceDescribePdfPTable.addCell(interfaceDescribePdfPCell);
        document.add(interfaceDescribePdfPTable);
    }

    /**
     * @param document
     * @param title
     * @param pdfPTable
     * @param bfChinese
     * @return
     */
    public static void writerComplexPdfPTableParagraph(Document document, String title, PdfPTable pdfPTable, BaseFont bfChinese)
            throws DocumentException {
        //标题
        Paragraph interfaceDescribeParagraph = new Paragraph(title, new Font(bfChinese, 10, Font.BOLD));
        interfaceDescribeParagraph.setSpacingBefore(12);
        interfaceDescribeParagraph.setSpacingAfter(8);
        document.add(interfaceDescribeParagraph);
        //内容
        PdfPTable interfaceDescribePdfPTable = new PdfPTable(1);
        interfaceDescribePdfPTable.setWidthPercentage(100);
        PdfPCell interfaceDescribePdfPCell = new PdfPCell(pdfPTable);
        interfaceDescribePdfPCell.setBorderWidth(0);
        interfaceDescribePdfPCell.setBorderWidthLeft(3);
        interfaceDescribePdfPCell.setBorderColorLeft(BaseColor.LIGHT_GRAY);
        interfaceDescribePdfPCell.setPadding(10);
        interfaceDescribePdfPTable.addCell(interfaceDescribePdfPCell);
        document.add(interfaceDescribePdfPTable);
    }

    /**
     * @param content
     * @param bfChinese
     * @return
     */
    public static PdfPCell buildParamPdfPCell(String content, BaseFont bfChinese) {
        PdfPCell pdfPCell = new PdfPCell(new Phrase(content, new Font(bfChinese, 8, Font.NORMAL)));
        pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfPCell.setPadding(5);
        return pdfPCell;
    }
}
