package com.team2_project1.project1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class WebController {
    @RequestMapping("/")
    public String home(){ return "index";
    }
    // HelloWorld 페이지 (helloworld.html)
    @RequestMapping("/hello")
    public String helloWorld() {
        return "helloworld";
    }

}

