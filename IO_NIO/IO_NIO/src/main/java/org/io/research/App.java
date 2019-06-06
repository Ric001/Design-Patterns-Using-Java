package org.io.research;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;


public class App {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        fileExample();
        fileWriterAndReaderExample();
        fileWithBytes();
        filesAndDirs();
        deletingAndRenamingFiles();
        listFiles();
    }

    private static void fileExample() {
        try {
            boolean newFile = false;
            File file = new File("fileWrite1.txt");
            System.out.println(file.exists());
            newFile = file.createNewFile();
            System.out.println(newFile);
            System.out.println(file.exists());
        } catch (IOException e) { e.printStackTrace(); }
    }

    private static void fileWriterAndReaderExample() {
        char[] in = new char[50];
        int size = 0;
        try {
            File file = new File("fileWrite2.txt");
            FileWriter fw = new FileWriter(file);
            fw.write("howdy\nfolks\n");

            fw.flush();
            fw.close();
            FileReader fr = new FileReader(file);
            size = fr.read(in);
            System.out.print(size + " ");
            for (char c : in) 
                System.out.print(c);

            fr.close();
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static void fileWithBytes() {
        byte[] in = new byte[250];
        int size = 0;
        try {
            File file = new File("byteFile1.txt");
            FileOutputStream fo = new FileOutputStream(file);
            String content = "Beca Pramheda\n The First Commander";
            fo.write(content.getBytes("UTF-8"));
            fo.flush();
            fo.close();

            FileInputStream fi = new FileInputStream(file);
            size = fi.read(in);
            System.out.println(size + " ");
            for(byte c : in)
                System.out.print((char)c);
            fi.close();
        } catch(Exception e) { e.printStackTrace(); }
    }

    public static void filesAndDirs() {
        try {
            File books = new File("books");
          books.mkdir();
            if (books.isDirectory()) {
                Logger.getLogger(App.class.getName()).info(books.getName() + " is my directory");                
            }
            File bookTitles = new File(books, "BooksTitle.txt");
            bookTitles.createNewFile();
            if (bookTitles.isFile()) {
                Logger.getLogger(App.class.getName()).info(bookTitles.getName() + " is my file");
            }

            PrintWriter writer = new PrintWriter(new FileWriter(bookTitles));
            writer.println("1- El Coronel no tiene quien le escriba");
            writer.println("2 - Steve Jobs ");
            writer.flush();
            writer.close();
            
            BufferedReader reader = new BufferedReader(new FileReader(bookTitles));
            String line = "";
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static void deletingAndRenamingFiles() {
        try{
            File delDir = new File("delDir");
            delDir.mkdir();
            
            File delFile1 = new File(delDir, "delFile1.txt");
            delFile1.createNewFile();

            File delFile2 = new File(delDir, "delFile2.txt");
            delFile2.createNewFile();
            
            delFile1.delete();
            System.out.println("delDir is " + delDir.delete());
            
            File newName = new File("newName.txt");
            delFile2.renameTo(newName);
            
            File newDir = new File("currentDir");
            delDir.renameTo(newDir);

            

        } catch(Exception e) { e.printStackTrace(); }
    }

    public static void listFiles() {
        try {
            File currentDir = new File("currentDir");
            String[] fileList = currentDir.list();
            for (String fileName : fileList) 
                System.out.println("File Name: " + fileName);
            System.out.println("File List Count on currentDir: " + fileList.length);
        } catch (Exception e) { e.printStackTrace(); }
    } 
}
