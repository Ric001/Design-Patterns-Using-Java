package org.io.research;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class App 
{
    public static void main( String[] args )
    {
        fileExample();
        fileWriterAndReaderExample();
        fileWithBytes();
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
        } catch(Exception e) { e.printStackTrace();}
    }
}
