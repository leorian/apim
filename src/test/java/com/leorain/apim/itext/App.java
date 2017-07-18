package com.leorain.apim.itext;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.html.CssAppliers;
import com.itextpdf.tool.xml.html.CssAppliersImpl;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class App {
    public static void main(String[] args) throws DocumentException, IOException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("pdf3.pdf"));
        // step 3
        document.open();

        // 使用我们的字体提供器，并将其设置为unicode字体样式
        MyFontsProvider fontProvider = new MyFontsProvider();
        fontProvider.addFontSubstitute("lowagie", "garamond");
        fontProvider.setUseUnicode(true);
        CssAppliers cssAppliers = new CssAppliersImpl(fontProvider);
        HtmlPipelineContext htmlContext = new HtmlPipelineContext(cssAppliers);
        htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
        XMLWorkerHelper.getInstance().getDefaultCssResolver(true);
        // step 4
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                new FileInputStream("index2.html"), null, Charset.forName("UTF-8"), fontProvider);
        //step 5
        document.close();

        System.out.println("PDF Created!");
    }
}
