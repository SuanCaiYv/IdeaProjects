package com.example.test.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils
{
    public static String saveFile(MultipartFile file)
    {
        String fileName = file.getOriginalFilename().replaceAll(" ", "_");
        Path path = Paths.get("/test/chap0_exa1/"+fileName);
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            file.transferTo(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
    public static byte[] downloadFile(String fileName)
    {
        FileInputStream fileInputStream = null;
        fileName = "/test/chap0_exa1/"+fileName;
        try {
            fileInputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] bytes = new byte[0];
        try {
            bytes = new byte[fileInputStream.available()];
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileInputStream.read(bytes, 0, fileInputStream.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}
