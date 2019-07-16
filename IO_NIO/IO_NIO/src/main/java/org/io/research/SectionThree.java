/**
 * This section is for Writing and reading attributes the
 * easy way.
 * 
 */
package org.io.research;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.logging.Logger;
public class SectionThree {
    private static final Logger LOG = Logger.getLogger(SectionThree.class.getName());
    public static void performMeta() throws IOException {
        //I/O way to set the last time that file was modified
        ZonedDateTime janFirstDateTime = ZonedDateTime.of(LocalDate.of(2017, 1, 1),
        LocalTime.of(10, 0), ZoneId.of("US/Pacific"));

        Instant januaryFirst = janFirstDateTime.toInstant();
        
        File file = new File("C:/temp/file.txt");
        File dir = new File("C:/temp/");
        dir.mkdir();
        file.createNewFile();
        file.setLastModified(
            januaryFirst.getEpochSecond() * 1000 
        );
        System.out.println(file.lastModified());
        file.delete();

        // NIO.2 Way to know when was the last time a path was modified
        Path path = Paths.get("C:/temp/file2");
        Files.createFile(path);
        FileTime fileTime = FileTime.fromMillis(januaryFirst.getEpochSecond() * 1000);
        Files.setLastModifiedTime(path, fileTime);
        System.out.println(Files.getLastModifiedTime(path));
        Files.delete(path);
    }

<<<<<<< HEAD
    public static void consultingPermissionsToAFile() {
        Path dir = Paths.get("temp/permissions/");
        Path path = Paths.get("permission.txt");
        try {
            Files.createDirectory(dir);
            Files.createFile(path.resolve(dir));
            System.out.println("Path isReadable: " + Files.isReadable(path));
            System.out.println("Path isWritable: " + Files.isWritable(path));
            System.out.println("Path isExecutable: " + Files.isExecutable(path));
        } catch (IOException e) {
            e.printStackTrace();
        } 
=======
    public static void permissionsToAFile()throws IOException {
        LOG.info("[ENTERING permissionsToAFile(): void throws IOException]");
        Path dir = Paths.get("temp/permissions");
        Path file = Paths.get("permissions.txt");
        
        
        Files.createDirectory(dir);
        file = dir.resolve(file);
        Files.createFile(file);
        Files.deleteIfExists(file);
        Files.deleteIfExists(dir);
        System.out.println(Files.isExecutable(file));
        System.out.println(Files.isReadable(file));
        System.out.println(Files.isWritable(file));
    }

    public static void basicFileAttributes() throws IOException {
        LOG.info("[ENTERING basicFileAttributes(): void]");
        Path songsListDir = Paths.get("hunger/songs");
        Files.createDirectories(songsListDir);
        BasicFileAttributes basicFileAttributes = Files.readAttributes(songsListDir, BasicFileAttributes.class);
        System.out.println("Last Modified Time: " + basicFileAttributes.lastModifiedTime());
        System.out.println("Is Directory: " + basicFileAttributes.isDirectory());
        System.out.println("Last Access: " + basicFileAttributes.lastAccessTime());
        System.out.println("Creation Date: " + basicFileAttributes.creationTime());
    }

    public static void basicFileAttributeView() throws IOException {
        LOG.info("[ENTERING basicFileAttributeView(): void throws IOException]");
        Path testDir = Paths.get("expertise");
        Path testFile = Paths.get("silence.txt");
        testFile = testDir.resolve(testFile);  
        Files.deleteIfExists(testFile);
        Files.deleteIfExists(testDir); 
        Files.createDirectory(testDir);
        Files.createFile(testFile);

        BasicFileAttributes basic = Files.readAttributes(testFile, BasicFileAttributes.class);
        FileTime created = basic.creationTime();
        FileTime lastModified = basic.lastModifiedTime();
        FileTime recentUpdate = FileTime.fromMillis(System.currentTimeMillis());

        BasicFileAttributeView attributesUpdater = Files.getFileAttributeView(testFile, BasicFileAttributeView.class);
        attributesUpdater.setTimes(lastModified, recentUpdate, created);
>>>>>>> 963d14e8d0c00287e6795c44400996de6343812b
    }
}