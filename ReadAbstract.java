package lecteurFichiers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public abstract class ReadAbstract implements IntrfaceRead {

    protected final String pathFile;

    protected ReadAbstract(String pathFile) {
        this.pathFile = pathFile;

    }

    // by char
    @Override
    public void read() throws IOException {
        File f = new File(this.pathFile);
        try {
            FileInputStream in = new FileInputStream(f);
            int i = in.read();
            while (i != -1) {
                System.out.print((char) i);
                i = in.read();
            }
            in.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    // by line
    @Override
    public void inverse() throws IOException {
        Path p = Paths.get(this.pathFile);
        List<String> line = Files.readAllLines(p, StandardCharsets.UTF_8);
        for (int i = line.size() - 1; i >= 0; i--) {
            System.out.println(line.get(i));
        }
    }

    // by char
    @Override
    public void palindromique() {
        File f = new File(this.pathFile);
        try (
                FileInputStream in = new FileInputStream(f)) {
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
    }
    // by word
    // @Override
    // public abstract void compareTo();
}
