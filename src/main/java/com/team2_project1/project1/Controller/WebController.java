package com.team2_project1.project1.Controller;


import com.team2_project1.project1.Mapper.MemberMapper;
import com.team2_project1.project1.domain.EmailRequest;
import com.team2_project1.project1.service.EmailVerificationService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

//vue와 Spring을 연결하는 어노테이션 CrossOrigin
@CrossOrigin(origins = "http://localhost:8081")
//restController로 해야지 vue와 연결 된다???
@RestController
public class WebController {

    @Autowired
    private EmailVerificationService emailVerificationService;

    @PostMapping("/sendEmail")
    public void sendEmail(@RequestBody EmailRequest emailRequest){
        System.out.println(emailRequest.getTo());
        emailVerificationService.sendVerificationEmail(emailRequest.getTo());
    }

    @GetMapping("/verify")
    public void verifyEmail(@RequestParam("token") String token, HttpServletResponse response) throws IOException {
        boolean isVerified = emailVerificationService.verifyToken(token);

        if (isVerified) {
            response.sendRedirect("인증이 성공하였습니다.");
        } else {
            response.sendRedirect("/verification-failure.html");
        }
    }


    @Autowired
    private MemberMapper memberMapper;

    @GetMapping("/emailCount")
    public int getEmailCount() {
        return memberMapper.countAll();
    }

}
