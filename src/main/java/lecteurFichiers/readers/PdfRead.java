package lecteurFichiers.readers;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import lecteurFichiers.ReadAbstract;

public class PdfRead extends ReadAbstract {

    public PdfRead(String pathFile) {
        super(pathFile);
    }

    // pdfbox
    private String extractText() throws Exception {
        try (PDDocument doc = Loader.loadPDF(new File(pathFile))) {
            PDFTextStripper stripper = new PDFTextStripper();
            // there is only one page in the pdf document test 
            // stripper.setEndPage(doc.getNumberOfPages());
            return stripper.getText(doc);
        }
    }

    @Override
    public void read() {
        try {
            String content = extractText();
            System.out.println(content);
        } catch (Exception e) {
            System.err.println("Error");
            e.printStackTrace();
        }
    }

    @Override
    public void inverse() {
        System.out.println("---------- INVERSE ------------");
        try {
            String content = extractText();
            List<String> lines = new ArrayList<>(content.lines().toList());
            Collections.reverse(lines);
            for (String l : lines) {
                System.out.println(l);
            }
        } catch (Exception e) {
            System.err.println("Error" + pathFile);
            e.printStackTrace();
        }
    }

    @Override
    public void palindromique() {
        System.out.println("---------- PALINDROMIQUE ------------");
        try {
            String content = extractText();
            content.lines().forEach(line -> System.out.println(reverseEachWord(line)));
        } catch (Exception e) {
            System.err.println("error");
            e.printStackTrace();
        }
    }

}
