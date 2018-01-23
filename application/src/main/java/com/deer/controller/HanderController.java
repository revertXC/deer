package com.deer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("web")
public class HanderController {

    @RequestMapping("{path}")
    public String toPage(@PathVariable String path){
        return path;
    }

}
