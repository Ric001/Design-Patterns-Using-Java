package org.io.research;

public class App {
    public static void main(String[] args) {
        //new App().sectionOne();
        new App().sectionTwo();
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

    private void sectionTwo() {
        SectionTwo.usePath();
        SectionTwo.converFileToPath();
        SectionTwo.creatingFiles(); 
        SectionTwo.performingMoreOperations();
        SectionTwo.getPathInfo();
        SectionTwo.getPaths();
    }
}
