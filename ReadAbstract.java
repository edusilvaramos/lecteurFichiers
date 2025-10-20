package lecteurFichiers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
    }

    // by line
    @Override
    public void inverse() throws IOException {
        List<String> line = Files.readAllLines(Paths.get(this.pathFile), StandardCharsets.UTF_8);
        for (int i = line.size() - 1; i >= 0; i--) {
            System.out.println(line.get(i));
        }
    }

    // by char
    @Override
    public void palindromique() {
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
    }

    // @Override
    // public abstract void compareTo();
}
