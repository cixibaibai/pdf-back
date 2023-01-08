package com.abc.bac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;

@RestController
@RequestMapping("/preview")
public class TestController {

    @GetMapping("/getFile")
    public void getFile(HttpServletResponse response) throws Exception {
        File file = new File("E:\\农行\\test1.pdf");
        FileInputStream is = new FileInputStream(file);
        response.setContentType("application/pdf;");
        response.setHeader("Content-disposition", "attachment;filename=" + "文件名");
        BufferedInputStream bis = new BufferedInputStream(is);
        BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
        byte[] buffer = new byte[2048];
        int len;
        while((len = bis.read(buffer, 0, buffer.length)) != -1) {
            bos.write(buffer, 0, len);
            bos.flush();
        }
        if(bis != null) {
            bis.close();
        }
        if(bos != null) {
            bos.close();
        }
    }

    @PostMapping("/test")
    public String test() {
        return "hello";
    }
}
