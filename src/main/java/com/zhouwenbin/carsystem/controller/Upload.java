package com.zhouwenbin.carsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping("/upload")
public class Upload {
    @PostMapping("/uploadimages")
    @ResponseBody
    public String uploadSource(@RequestParam("file") MultipartFile file , HttpServletRequest request) {
        System.out.println(file);
        String pathString = null;
        String Fname=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" +file.getOriginalFilename();
        if(file!=null) {
            pathString = "D:/IDEAs/carsystem/carsystem/src/main/resources/static/image/" + Fname;
        }

        try {
            File files=new File(pathString);
            //打印查看上传路径
            System.out.println(pathString);
            if(!files.getParentFile().exists()){
                files.getParentFile().mkdirs();
            }
            file.transferTo(files);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "{\"code\":0,\"msg\":\""+pathString+"\",\"filename\":\""+Fname+"\"}";
    }
}
