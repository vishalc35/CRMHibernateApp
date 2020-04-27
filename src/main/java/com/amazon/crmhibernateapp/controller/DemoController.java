package com.amazon.crmhibernateapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class DemoController {


//     http://localhost:8080/SimpleWebApp/hello ----deeleting becuase basic usage is over as we have to move on to other concepts
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello Vishal!!";
    }



}
