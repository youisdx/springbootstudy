package com.springboot.mybatis.controller;


import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class UploadController {


    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile srcFile, RedirectAttributes redirectAttributes){


        String returnFileName = "";

        try {
            //构建上传目标路径,找到了项目的traget的classes目录
            File destFile=new File
                    (ResourceUtils.getURL("classpath:").getPath());
            if(!destFile.exists()){
                destFile=new File("");
            }
            //出处目标文件的绝对路径
            System.out.println("file path"+destFile.getAbsolutePath());


            //拼接子路径
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            String times = simpleDateFormat.format(new Date());


            File upload=new File(destFile.getAbsolutePath(),"upload/"+times);
            //若目标文件夹不存在，则创建
            if(!upload.exists()) {
                upload.mkdirs();
            }
            System.out.println("完整的上传路径："+upload.getAbsolutePath()+"/"+srcFile);
            //根据srcFile大小，准备一个字节数组
            byte[] bytes = srcFile.getBytes();
            //拼接上传路径
            //Path path = Paths.get(UPLOAD_FOLDER + srcFile.getOriginalFilename());
            //通过项目路径，拼接上传路径
            Path path = Paths.get(upload.getAbsolutePath()+"/"+srcFile.getOriginalFilename());
            //** 开始将源文件写入目标地址
            Files.write(path, bytes);
            returnFileName  ="http://localhost:8080/upload/"+srcFile.getOriginalFilename();

        }catch (IOException e){
            e.printStackTrace();
        }
        return "redirect:upload_status";
    }


    //匹配upload_status页面
    @GetMapping("/upload_status")
    public String uploadStatusPage(){
        return "upload_status";
    }

}
