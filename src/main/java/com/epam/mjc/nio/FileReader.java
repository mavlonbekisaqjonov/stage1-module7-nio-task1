package com.epam.mjc.nio;

import java.io.*;
import java.util.logging.Logger;

public class FileReader {
    private static final Logger logger = Logger.getLogger(FileReader.class.getName());

    public Profile getDataFromFile(File file) {
        StringBuilder outt = new StringBuilder();

        try (FileInputStream fr =new FileInputStream(file)){
            int byteData;
            while ((byteData = fr.read()) != -1) {
                outt.append((char) byteData);
            }
        } catch(IOException e){
            logger.warning("This is a warning message!");
        }

        String out = outt.toString();

        String[] lines = out.split("\n");
        String name = lines[0].split(": ")[1].trim();
        int age = Integer.parseInt(lines[1].split(": ")[1].trim());
        String email = lines[2].split(": ")[1].trim();
        long phone = Long.parseLong(lines[3].split(": ")[1].trim());

        return new Profile(name, age, email, phone);
    }
}
