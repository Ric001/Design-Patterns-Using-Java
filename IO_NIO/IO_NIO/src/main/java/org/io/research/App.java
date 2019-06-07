package org.io.research;

public class App {
    public static void main(String[] args) {
        new App().sectionOne();
    }    

    public void sectionOne() {
        SectionOne.fileExample();
        SectionOne.fileWriterAndReaderExample();
        SectionOne.fileWithBytes();
        SectionOne.filesAndDirs();
        SectionOne.deletingAndRenamingFiles();
        SectionOne.listFiles();

        SectionOne.consoleObj();
    }
}
