package com.example.test.controller;

import com.example.test.result.Result;
import com.example.test.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping(value = "/file")
public class FileUpload
{
    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Result f1(@RequestParam(value = "file") MultipartFile multipartFile)
    {
        String fileName = Utils.saveFile(multipartFile);
        Result result = new Result();
        if (fileName != null && fileName != "") {
            result.setCode(1);
            result.setMsg("保存文件成功!");
            String url = "http://127.0.0.1:8080/file/download/"+fileName;
            result.setData(url);
        }
        return null;
    }
    @RequestMapping(value = "/download/{fileName}", method = RequestMethod.GET)
    public void f2(@PathVariable("fileName") String fileName, HttpServletResponse response)
    {
        System.out.println(fileName);
        byte[] bytes = Utils.downloadFile(fileName);
        ServletOutputStream servletOutputStream = null;
        try {
            servletOutputStream = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            servletOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            servletOutputStream.flush();
            servletOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
