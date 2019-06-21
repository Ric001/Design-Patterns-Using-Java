package org.io.research;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class SectionTwo {

    public static void usePath() {
        Path path = Paths.get("temp", "file.txt");
        Path dir = Paths.get("temp/");
        try {
            Files.deleteIfExists(path);
            Files.deleteIfExists(dir);
            Files.createDirectory(dir);
            Files.createFile(path);
        } catch(IOException e) { e.printStackTrace(); }
    }

    public static  void converFileToPath() {
        File file = new File("FileToConvert");
        Path path = Paths.get("");
        //this is how we do it
        Path converted = file.toPath();
        File convertedFile = path.toFile();
    }

    public static void creatingFiles() {
        Path path = Paths.get("complices/losdos/soda/stereo");
        Path file = Paths.get("complices/losdos/soda/stereo/file.txt");
        try {
            Files.deleteIfExists(file);
            Files.deleteIfExists(path);
            System.out.println("Dir leveles exists: " + Files.exists(path));
            Files.createDirectories(path);
            System.out.println("Dir levels exists: " + Files.exists(path));
            Files.createFile(file);
            System.out.println("File exists: " + Files.exists(file));
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static void performingMoreOperations() {
        Path source = Paths.get("temp2/test1.txt");
        Path target = Paths.get("temp3/test2.txt");
        Path dir = Paths.get("temp2/");
        Path dir2 = Paths.get("temp3");
        try { 
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static void getPathInfo() {
        Path path = Paths.get("C:/home/java/workspace");
        System.out.println("getFileName: " + path.getFileName());
        System.out.println("getName(1): " + path.getName(1));
        System.out.println("getNameCount: " + path.getNameCount());
        System.out.println("getParent: " + path.getParent());
        System.out.println("subpath(0,2): " + path.subpath(0, 2));
        System.out.println("toString: " + path.toString());
    }

    public static void getPaths() {
        int spaces = 1; 
        Path myPath = Paths.get("tmp", "dir1", "dir2", "dir3", "file.txt");
        for (Path subPath : myPath) {
            System.out.format("%" + spaces + "s%s%n", "", subPath);
            spaces += 2;
        }
    }

    public static void normalizingPaths() {
        String buildProject = "/Build_Project/scripts";
        
        String upTwoDirectories = "../..";
        
        String myProject = "/My_Project/source";
        Path path = Paths.get(buildProject, upTwoDirectories, myProject);
        
        System.out.println("Original: " + path);
        System.out.println("Normalized: " + path.normalize());
    }
    
    public static void resolveSomePaths() {
        Path dir = Paths.get("/home/java");
        Path file = Paths.get("models/Mode.pdf");
        Path result = dir.resolve(file);
        System.out.println("result = " + result);
    }

    public static void relativizeSomePaths() {
        Path dir = Paths.get("/home/java");
        Path music = Paths.get("/home/java/country/Swift.mp3");
        Path mp3 = dir.relativize(music);
        System.out.println(mp3);
    }
}