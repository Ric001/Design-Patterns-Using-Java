package org.io.research;

public class App {
    public static void main(String[] args) throws Exception{
        //new App().sectionOne();
        //new App().sectionTwo();
        new App().sectionThree();
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

    private void sectionThree() throws Exception{
<<<<<<< HEAD
        SectionThree.performMeta();
        SectionThree.consultingPermissionsToAFile();
=======
        //SectionThree.performMeta();
        //SectionThree.basicFileAttributes();
        //SectionThree.permissionsToAFile();
        SectionThree.basicFileAttributeView();
>>>>>>> 963d14e8d0c00287e6795c44400996de6343812b
    }
}
