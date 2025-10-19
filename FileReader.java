package lecteurFichiers;

import java.io.File;
import java.util.Scanner;
import lecteurFichiers.readers.CsvRead;
import lecteurFichiers.readers.TxtRead;

public class FileReader {

    public static void main(String[] args) {

        File dir = new File(System.getProperty("user.dir") + "/lecteurFichiers/files");
        System.out.println(dir);
        File[] files = dir.listFiles(File::isFile);
        System.out.println(files.length);
        System.out.println("----------------------");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose a type of file:");
            System.out.println("----------------------");
            System.out.println("1 -> txt");
            System.out.println("2 -> csv");
            System.out.println("3 -> pdf");
            System.out.println("4 -> docx");
            System.out.println("5 -> json");
            System.out.println("0 -> exit");
            System.out.println("----------------------");
            String typeFile = scanner.nextLine();

            if (typeFile.equals("0")) {
                break;
            }
            if (Integer.parseInt(typeFile) < 0 || Integer.parseInt(typeFile) > 5) {
                System.out.println("Invalid option !!");
                continue;
            }

            switch (Integer.parseInt(typeFile)) {
                case 1:
                    System.out.println("-----------  TXT  -----------");
                    for (File f : files) {
                        String name = f.getName();
                        // System.out.println(name);
                        if (name.endsWith(".txt")) {
                            String dirPath = dir + File.separator + name;
                            // System.out.println("Path: " + dirPath);
                            TxtRead textRead = new TxtRead(dirPath);
                            try {
                                textRead.read();
                                System.out.println("");
                                System.out.println("");
                                System.out.println("---------- INVERSE ------------");
                                textRead.inverse();
                                System.out.println("");
                                System.out.println("---------- PALINDROMIQUE ------------");
                                textRead.palindromique();
                                System.out.println("");
                                System.out.println("");
                                System.out.println("---------- COMPARE TO ------------");
                            } catch (Exception e) {
                                e.getStackTrace();
                            }
                            System.out.println("----------------------");
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("-----------  CSV  -----------");
                    for (File f : files) {
                        String name = f.getName();
                        // System.out.println(name);
                        if (name.endsWith(".csv")) {
                            String dirPath = dir + File.separator + name;
                            // System.out.println("Path: " + dirPath);
                            CsvRead CsvRead = new CsvRead(dirPath);
                            try {
                                CsvRead.read();
                                System.out.println("");
                                System.out.println("");
                                System.out.println("---------- INVERSE ------------");
                                CsvRead.inverse();
                                System.out.println("");
                                System.out.println("---------- PALINDROMIQUE ------------");
                                CsvRead.palindromique();
                                System.out.println("");
                                System.out.println("");
                                System.out.println("---------- COMPARE TO ------------");
                            } catch (Exception e) {
                                e.getStackTrace();
                            }
                            System.out.println("----------------------");
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("-----------  PDF  -----------");
                    break;
                case 4:
                    System.out.println("-----------  DOCX  -----------");
                    break;
                case 5:
                    System.out.println("-----------  JSON  -----------");
                    break;
            }
        }
    }
}
