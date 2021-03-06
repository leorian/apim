package com.leorain.apim.tools;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.leorain.apim.entity.*;
import com.leorain.apim.enums.ExampleTypeEnum;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
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

        BaseFont bfChinese = BaseFont.createFont("C:/Windows" + "/Fonts/SIMHEI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);//黑体
        //项目名称
        Paragraph projectNameParagraph = new Paragraph(projectEntity.getProjectName() + "项目接口描述文档",
                new Font(bfChinese, 20, Font.BOLD));
        projectNameParagraph.setAlignment(Element.ALIGN_CENTER);
        document.add(projectNameParagraph);

        //分隔线
        DottedLineSeparator dottedLineSeparator = new DottedLineSeparator();
        Chunk lineChunk = new Chunk(dottedLineSeparator);
        document.add(new Paragraph(lineChunk));

        PdfPTable projectPdfPTable = new PdfPTable(6);
        //项目名称
        PdfPCell projectPdfPCell01 = new PdfPCell(new Phrase("项目名称:", new Font(bfChinese, 8, Font.BOLD)));
        projectPdfPCell01.setPadding(10);
        projectPdfPCell01.setHorizontalAlignment(Element.ALIGN_CENTER);
        projectPdfPTable.addCell(projectPdfPCell01);

        PdfPCell projectPdfPCell02 = new PdfPCell(new Phrase(projectEntity.getProjectName(), new Font(bfChinese, 8, Font.NORMAL)));
        projectPdfPCell02.setPadding(10);
        projectPdfPCell02.setHorizontalAlignment(Element.ALIGN_CENTER);
        projectPdfPTable.addCell(projectPdfPCell02);

        //项目经理
        PdfPCell projectPdfPCell03 = new PdfPCell(new Phrase("项目经理:", new Font(bfChinese, 8, Font.BOLD)));
        projectPdfPCell03.setPadding(10);
        projectPdfPCell03.setHorizontalAlignment(Element.ALIGN_CENTER);
        projectPdfPTable.addCell(projectPdfPCell03);

        PdfPCell projectPdfPCell04 = new PdfPCell(new Phrase(projectEntity.getProjectManagerText(), new Font(bfChinese, 8, Font.NORMAL)));
        projectPdfPCell04.setPadding(10);
        projectPdfPCell04.setHorizontalAlignment(Element.ALIGN_CENTER);
        projectPdfPTable.addCell(projectPdfPCell04);

        //项目创建时间
        PdfPCell projectPdfPCell05 = new PdfPCell(new Phrase("创建时间:", new Font(bfChinese, 8, Font.BOLD)));
        projectPdfPCell05.setPadding(10);
        projectPdfPCell05.setHorizontalAlignment(Element.ALIGN_CENTER);
        projectPdfPTable.addCell(projectPdfPCell05);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        PdfPCell projectPdfPCell06 = new PdfPCell(new Phrase(simpleDateFormat.format(projectEntity.getCreateDateTime()), new Font(bfChinese, 8, Font.NORMAL)));
        projectPdfPCell06.setPadding(10);
        projectPdfPCell06.setHorizontalAlignment(Element.ALIGN_CENTER);
        projectPdfPTable.addCell(projectPdfPCell06);

        //组内成员
        PdfPCell projectPdfPCell07 = new PdfPCell(new Phrase("组内成员:", new Font(bfChinese, 8, Font.BOLD)));
        projectPdfPCell07.setPadding(10);
        projectPdfPCell07.setHorizontalAlignment(Element.ALIGN_CENTER);
        projectPdfPTable.addCell(projectPdfPCell07);

        List<ProjectMemberEntity> projectMemberEntityList = projectEntity.getProjectMemberEntities();
        String memebers = "";
        if (!CollectionUtils.isEmpty(projectMemberEntityList)) {
            for (ProjectMemberEntity projectMemberEntity : projectMemberEntityList) {
                memebers += projectMemberEntity.getUserName();
                memebers += "  ";
            }
        }
        PdfPCell projectPdfPCell08 = new PdfPCell(new Phrase(memebers, new Font(bfChinese, 8, Font.NORMAL)));
        projectPdfPCell08.setPadding(10);
        projectPdfPCell08.setColspan(5);
        projectPdfPCell08.setHorizontalAlignment(Element.ALIGN_CENTER);
        projectPdfPTable.addCell(projectPdfPCell08);

        //项目描述：
        PdfPCell projectPdfPCell09 = new PdfPCell(new Phrase("项目描述:", new Font(bfChinese, 8, Font.BOLD)));
        projectPdfPCell09.setPadding(10);
        projectPdfPCell09.setHorizontalAlignment(Element.ALIGN_CENTER);
        projectPdfPTable.addCell(projectPdfPCell09);

        PdfPCell projectPdfPCell10 = new PdfPCell(new Phrase(projectEntity.getProjectDescribe(), new Font(bfChinese, 8, Font.NORMAL)));
        projectPdfPCell10.setPadding(10);
        projectPdfPCell10.setColspan(5);
        projectPdfPCell10.setHorizontalAlignment(Element.ALIGN_CENTER);
        projectPdfPTable.addCell(projectPdfPCell10);

        //项目接口清单
        PdfPCell projectPdfPCell11 = new PdfPCell(new Phrase("接口清单:", new Font(bfChinese, 8, Font.BOLD)));
        projectPdfPCell11.setPadding(10);
        projectPdfPCell11.setHorizontalAlignment(Element.ALIGN_CENTER);
        projectPdfPTable.addCell(projectPdfPCell11);
        String interfaceNames = "";
        for (int i = 0; i < interfaceHttpEntities.size(); i++) {
            interfaceNames += ((i + 1) + "、" + interfaceHttpEntities.get(i).getName() + "\n\n");
        }

        PdfPCell projectPdfPCell12 = new PdfPCell(new Phrase(interfaceNames, new Font(bfChinese, 8, Font.NORMAL)));
        projectPdfPCell12.setPadding(10);
        projectPdfPCell12.setColspan(5);
        projectPdfPCell12.setHorizontalAlignment(Element.ALIGN_LEFT);
        projectPdfPTable.addCell(projectPdfPCell12);

        //项目简介模块
        projectPdfPTable.setSpacingBefore(50);
        projectPdfPTable.setWidthPercentage(100);
        document.add(projectPdfPTable);

        for (int i = 0; i < interfaceHttpEntities.size(); i++) {
            //接口名称既是章节名称
            InterfaceHttpEntity interfaceHttpEntity = interfaceHttpEntities.get(i);
            Chapter chapter = new Chapter(interfaceHttpEntity.getName(), i + 1);
            chapter.setTitle(new Paragraph(interfaceHttpEntity.getName(), new Font(bfChinese, 18, Font.BOLD)));
            document.add(chapter);
            //接口描述
            writerGeneralTextParagraph(document, "接口描述", interfaceHttpEntity.getDescription(), bfChinese);

            //接口地址
            writerGeneralTextParagraph(document, "接口地址", interfaceHttpEntity.getAddress(), bfChinese);

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
            if (!CollectionUtils.isEmpty(interfaceResultEntities)) {
                for (InterfaceResultEntity interfaceResultEntity : interfaceResultEntities) {
                    if (interfaceResultEntity.getExampleType().equals(ExampleTypeEnum.NORMAL.name())) {
                        writerComplexParagraphParagraph(document, "返回示例",
                                JsonITextParagraphUtil.formatJson(interfaceResultEntity.getExampleContent())
                                , bfChinese, ExampleTypeEnum.NORMAL);
                        writerComplexParagraphParagraph(document, "注意事项",
                                JsonITextParagraphUtil.formatJson(interfaceResultEntity.getAttentionMatters())
                                , bfChinese, ExampleTypeEnum.EXCEPTION);
                    }
                }

                for (InterfaceResultEntity interfaceResultEntity : interfaceResultEntities) {
                    if (interfaceResultEntity.getExampleType().equals(ExampleTypeEnum.EXCEPTION.name())) {
                        writerComplexParagraphParagraph(document, "异常示例",
                                JsonITextParagraphUtil.formatJson(interfaceResultEntity.getExampleContent())
                                , bfChinese, ExampleTypeEnum.NORMAL);
                        writerComplexParagraphParagraph(document, "注意事项",
                                JsonITextParagraphUtil.formatJson(interfaceResultEntity.getAttentionMatters())
                                , bfChinese, ExampleTypeEnum.EXCEPTION);
                    }
                }
            }
        }

        document.close();
    }

    /**
     * 写入普通文本
     *
     * @param document
     * @param title
     * @param content
     * @param bfChinese
     * @return
     */
    public static void writerGeneralTextParagraph(Document document, String title, String content, BaseFont bfChinese)
            throws DocumentException {
        //标题
        Paragraph paragraph = new Paragraph(title, new Font(bfChinese, 10, Font.BOLD));
        paragraph.setSpacingBefore(12);
        paragraph.setSpacingAfter(8);
        document.add(paragraph);
        //内容
        PdfPTable pdfPTable = new PdfPTable(1);
        pdfPTable.setWidthPercentage(100);
        PdfPCell pdfPCell = new PdfPCell(new Phrase(content, new Font(bfChinese, 8, Font.NORMAL)));
        pdfPCell.setBorderWidth(0);
        pdfPCell.setBorderWidthLeft(3);
        pdfPCell.setBorderColorLeft(BaseColor.LIGHT_GRAY);
        pdfPCell.setPadding(10);
        pdfPTable.addCell(pdfPCell);
        document.add(pdfPTable);
    }

    /**
     * 写入复杂表格，表格嵌套
     *
     * @param document
     * @param title
     * @param nestPdfPTable
     * @param bfChinese
     * @return
     */
    public static void writerComplexPdfPTableParagraph(Document document, String title, PdfPTable nestPdfPTable, BaseFont bfChinese)
            throws DocumentException {
        //标题
        Paragraph paragraph = new Paragraph(title, new Font(bfChinese, 10, Font.BOLD));
        paragraph.setSpacingBefore(12);
        paragraph.setSpacingAfter(8);
        document.add(paragraph);
        //内容
        PdfPTable pdfPTable = new PdfPTable(1);
        pdfPTable.setWidthPercentage(100);
        PdfPCell pdfPCell = new PdfPCell(nestPdfPTable);
        pdfPCell.setBorderWidth(0);
        pdfPCell.setBorderWidthLeft(3);
        pdfPCell.setBorderColorLeft(BaseColor.LIGHT_GRAY);
        pdfPCell.setPadding(10);
        pdfPTable.addCell(pdfPCell);
        document.add(pdfPTable);
    }

    /**
     * @param document
     * @param title
     * @param nestParagraph
     * @param bfChinese
     * @return
     */
    public static void writerComplexParagraphParagraph(Document document, String title, Paragraph nestParagraph, BaseFont bfChinese
            , ExampleTypeEnum exampleTypeEnum)
            throws DocumentException {
        //标题
        if (exampleTypeEnum.name().equals(ExampleTypeEnum.NORMAL.name())) {
            Paragraph paragraph = new Paragraph(title, new Font(bfChinese, 10, Font.BOLD));
            paragraph.setSpacingBefore(12);
            paragraph.setSpacingAfter(8);
            document.add(paragraph);
        } else {
            Paragraph paragraph = new Paragraph(title, new Font(bfChinese, 10, Font.BOLD, BaseColor.RED));
            paragraph.setSpacingBefore(12);
            paragraph.setSpacingAfter(8);
            document.add(paragraph);
        }
        //内容
        PdfPTable pdfPTable = new PdfPTable(1);
        pdfPTable.setWidthPercentage(100);
        PdfPCell pdfPCell = new PdfPCell(nestParagraph);
        pdfPCell.setBorderWidth(0);
        pdfPCell.setBorderWidthLeft(3);
        pdfPCell.setBorderColorLeft(BaseColor.LIGHT_GRAY);
        pdfPCell.setPadding(10);
        pdfPTable.addCell(pdfPCell);
        document.add(pdfPTable);
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
