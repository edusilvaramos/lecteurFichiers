package lecteurFichiers;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import lecteurFichiers.readers.CsvRead;
import lecteurFichiers.readers.DocxRead;
import lecteurFichiers.readers.JsonRead;
import lecteurFichiers.readers.PdfRead;
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
            System.out.println("6 -> Compare to");
            System.out.println("0 -> exit");
            System.out.println("----------------------");
            String typeFile = scanner.nextLine();

            if (typeFile.equals("0")) {
                break;
            }
            if (Integer.parseInt(typeFile) < 0 || Integer.parseInt(typeFile) > 6) {
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
                                textRead.inverse();
                                System.out.println("");
                                textRead.palindromique();
                            } catch (Exception e) {
                                e.getStackTrace();
                            }
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
                                CsvRead.inverse();
                                CsvRead.palindromique();
                            } catch (Exception e) {
                                e.getStackTrace();
                            }
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("-----------  PDF  -----------");
                    for (File f : files) {
                        String name = f.getName();
                        // System.out.println(name);
                        if (name.endsWith(".pdf")) {
                            String dirPath = dir + File.separator + name;
                            // System.out.println("Path: " + dirPath);
                            PdfRead pdfRead = new PdfRead(dirPath);
                            try {
                                pdfRead.read();
                                pdfRead.inverse();
                                System.out.println("");
                                pdfRead.palindromique();
                            } catch (Exception e) {
                                e.getStackTrace();
                            }
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("-----------  DOCX  -----------");
                    for (File f : files) {
                        String name = f.getName();
                        // System.out.println(name);
                        if (name.endsWith(".docx")) {
                            String dirPath = dir + File.separator + name;
                            // System.out.println("Path: " + dirPath);
                            ReadAbstract docxRead = new DocxRead(dirPath);
                            try {
                                docxRead.read();
                                docxRead.inverse();
                                System.out.println("");
                                docxRead.palindromique();
                            } catch (Exception e) {
                                e.getStackTrace();
                            }
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("-----------  JSON  -----------");
                    for (File f : files) {
                        String name = f.getName();
                        // System.out.println(name);
                        if (name.endsWith(".json")) {
                            String dirPath = dir + File.separator + name;
                            // System.out.println("Path: " + dirPath);
                            ReadAbstract JsonRead = new JsonRead(dirPath);
                            try {
                                JsonRead.read();
                                JsonRead.inverse();
                                System.out.println("");
                                JsonRead.palindromique();
                            } catch (Exception e) {
                                e.getStackTrace();
                            }
                            break;
                        }
                    }
                    break;
                case 6: {
                    for (int i = 0; i < files.length; i++) {
                        System.out.println(i + 1 + " -> " + files[i].getName());
                    }
                    System.out.print("Choose the first file: ");
                    int i1 = Integer.parseInt(scanner.nextLine()) - 1;
                    System.out.print("second file: ");
                    int i2 = Integer.parseInt(scanner.nextLine()) - 1;

                    try {
                        String resumo = ReadAbstract.compareTo(files[i1], files[i2]);
                        System.out.println("== result ==");
                        System.out.println(resumo);
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                }

            }

        }

    }
}
