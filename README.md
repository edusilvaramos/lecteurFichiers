Lecteur de Fichiers (Java Mini Project)

This mini-app reads and processes different file types from the local files/ directory, showcasing clean OOP in Java (interfaces, abstract classes, and polymorphism). It includes small text utilities like “palindromique” (reverse the letters of each word while preserving punctuation/spacing), line-wise inverse, and regular output.

---

How to Run

Make sure you have Java 17+ and Maven installed.

```bash
mvn clean compile
mvn org.codehaus.mojo:exec-maven-plugin:3.5.0:java -Dexec.mainClass=lecteurFichiers.FileReader
```

Resources :

https://youtu.be/J9y5Spv8WsE?si=7yTFng6vtMxfZOql
https://pdfbox.apache.org/
https://mvnrepository.com/artifact/org.apache.pdfbox/pdfbox/3.0.6
https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml/5.4.1
https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html
https://youtu.be/N7AyIfUQxGc?si=aexcggBr6lujNKA9
