package lecteurFichiers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public abstract class ReadAbstract implements interfaceRead {

    protected final String pathFile;

    protected ReadAbstract(String pathFile) {
        this.pathFile = new File(pathFile).getAbsolutePath();
    }

    // by char
    @Override
    public void read() throws IOException {
        try {
            FileInputStream in = new FileInputStream(this.pathFile);
            int i = in.read();
            while (i != -1) {
                System.out.print((char) i);
                i = in.read();
            }
            in.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        System.out.println("");
        System.out.println("");
    }

    @Override
    public void inverse() throws IOException {
        System.out.println("---------- INVERSE ------------");
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(this.pathFile)))) {
            // System.out.println(br.readLine());
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        inverseLines(lines);
        System.out.println();
    }

    protected static String inverseLines(List<String> line) {
        StringBuilder out = new StringBuilder();
        for (int i = line.size() - 1; i >= 0; i--) {
            System.out.println(line.get(i));
        }
        return out.toString();
    }

    @Override
    public void palindromique() {
        System.out.println("---------- PALINDROMIQUE ------------");
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(this.pathFile)))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(reverseEachWord(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    protected static String reverseEachWord(String line) {
        StringBuilder out = new StringBuilder(line.length());
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (Character.isLetter(c)) {
                word.append(c);
            } else {
                if (word.length() > 0) {
                    out.append(word.reverse());
                    word.setLength(0);
                }
                out.append(c);
            }
        }
        // flush final
        if (word.length() > 0) {
            out.append(word.reverse());
        }
        return out.toString();
    }

    public static String compareTo(File a, File b) throws IOException {
        String extA = typeFile(a);
        String extB = typeFile(b);
        boolean sameType = extA.equalsIgnoreCase(extB);

        long sizeA = a.length();
        long sizeB = b.length();
        boolean sameSize = sizeA == sizeB;

        boolean sameContent = false;
        if (sameSize) {
            try (
                    FileInputStream in1 = new FileInputStream(a); FileInputStream in2 = new FileInputStream(b)) {
                sameContent = true;
                int x, y;
                while ((x = in1.read()) != -1) {
                    y = in2.read();
                    if (x != y) {
                        sameContent = false;
                        break;
                    }
                }
            }
        }

        return "type: " + (sameType ? "egual (" + extA + ")" : (extA + " vs " + extB))
                + " /// size: " + (sameSize ? "egual (" + sizeA + " B)" : (sizeA + " vs " + sizeB + " B"))
                + " //// content: " + (sameContent ? "egual" : "different");
    }

    // get the type/ after "."
    private static String typeFile(File f) {
        String n = f.getName();
        int p = n.lastIndexOf('.');
        return n.substring(p + 1);
    }

}
