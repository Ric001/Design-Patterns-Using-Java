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
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class SectionThree {

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
    }
}