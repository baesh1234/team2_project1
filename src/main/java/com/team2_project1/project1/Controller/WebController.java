package com.team2_project1.project1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

//vue와 Spring을 연결하는 어노테이션 CrossOrigin
@CrossOrigin(origins = "http://localhost:8081")
@Controller
public class WebController {

    @RequestMapping("/")
    public String home(){ return "index"; }

}
