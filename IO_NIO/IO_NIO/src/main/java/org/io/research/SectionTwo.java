package org.io.research;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
            
            //Files.createDirectory(dir);
            //Files.createDirectory(dir2);
            //Files.createFile(source);
            Files.copy(source, target);
            //Files.delete(target);
            //Files.move(source, target);
        } catch (IOException e) { e.printStackTrace(); }
    }
}