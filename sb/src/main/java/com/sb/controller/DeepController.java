package com.sb.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;

@Controller
public class DeepController {
    @ResponseBody
    @GetMapping("/f1")
    public FileSystemResource file(){
        FileSystemResource fileSystemResource =  new FileSystemResource("/Users/mmin/workspace/java/3p/sb/pom.xml");
        return fileSystemResource;
    }

}
