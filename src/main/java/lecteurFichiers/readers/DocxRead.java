package lecteurFichiers.readers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import lecteurFichiers.ReadAbstract;

public class DocxRead extends ReadAbstract {

    public DocxRead(String pathFile) {
        super(pathFile);
    }

    private List<String> extractText() throws IOException {
        List<String> lines = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(pathFile); XWPFDocument doc = new XWPFDocument(fis)) {

            for (XWPFParagraph p : doc.getParagraphs()) {
                String text = p.getText().trim();
                if (!text.isEmpty()) {
                    lines.add(text);
                }
            }
        }
        return lines;
    }

    @Override
    public void read() {
        try {
            List<String> lines = extractText();
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.err.println("Error: " + pathFile);
            e.printStackTrace();
        }
    }

    @Override
    public void inverse() {
        System.out.println("---------- INVERSE ------------");
        try {
            List<String> lines = extractText();
            Collections.reverse(lines);
            for (String line : lines) {
                System.out.println(line);
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
            List<String> lines = extractText();
            for (String line : lines) {
                System.out.println(reverseEachWord(line));
            }
        } catch (Exception e) {
            System.err.println("error");
            e.printStackTrace();
        }
    }
}
