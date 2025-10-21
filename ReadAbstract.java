package lecteurFichiers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    // by line
    @Override
    public void inverse() throws IOException {
        System.out.println("---------- INVERSE ------------");
        // lines list
        List<String> line = Files.readAllLines(Paths.get(this.pathFile), StandardCharsets.UTF_8);
        for (int i = line.size() - 1; i >= 0; i--) {
            System.out.println(line.get(i));
        }
        System.out.println("");
    }

    // by char
    @Override
    public void palindromique() {
        System.out.println("---------- PALINDROMIQUE ------------");
        try (
                FileInputStream in = new FileInputStream(this.pathFile)) {
            // to create an acumulator
            StringBuilder word = new StringBuilder();
            int i = 0;
            while ((i = in.read()) != -1) {
                char ch = (char) i;
                if (Character.isLetter(ch)) {
                    // get the letters
                    word.append(ch);
                } else {
                    // reverse == palindromique 
                    System.out.print(word.reverse().toString());
                    word.setLength(0);
                    // print separators
                    System.out.print(ch);
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        System.out.println("");
        System.out.println("");
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
            try (InputStream in1 = new BufferedInputStream(new FileInputStream(a)); InputStream in2 = new BufferedInputStream(new java.io.FileInputStream(b))) {
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

    private static String typeFile(File f) {
        String n = f.getName();
        int p = n.lastIndexOf('.');
        return n.substring(p + 1);
    }

}
