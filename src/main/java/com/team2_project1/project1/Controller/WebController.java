package com.team2_project1.project1.Controller;


import com.team2_project1.project1.Mapper.MemberMapper;
import com.team2_project1.project1.domain.EmailRequest;
import com.team2_project1.project1.service.EmailVerificationService;
import com.team2_project1.project1.service.MemberService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

//vue와 Spring을 연결하는 어노테이션 CrossOrigin
@CrossOrigin(origins = "http://localhost:8081")
//restController로 해야지 vue와 연결 된다???
@RestController
public class WebController {

    @Autowired
    private EmailVerificationService emailVerificationService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberMapper memberMapper;

    @GetMapping("/emailCount")
    public int getEmailCount() {
        return memberMapper.countAll();
    }

    @PostMapping("/sendEmail")
    public void sendEmail(@RequestBody EmailRequest emailRequest){
        System.out.println(emailRequest.getTo());
        emailVerificationService.sendVerificationEmail(emailRequest.getTo());
    }

    @GetMapping("/verify")
    public void verifyEmail(@RequestParam("token") String token, HttpServletResponse response) throws IOException {
        boolean isVerified = emailVerificationService.verifyToken(token);

        if (isVerified) {
            response.sendRedirect("/verification-success.html");
        } else {
            response.sendRedirect("/verification-failure.html");
        }
    }

    @PostMapping("/memberBook")
    public ResponseEntity<String> memberBook(@RequestBody EmailRequest emailRequest){
        //서비스의 결과 메시지를 가져옴
        String message = memberService.bookMember(emailRequest.getTo());
        //등록 성공 메시지이면 ResponseEntity를 이용하여 http 200ok를 날리고 그렇지 않을경우 400을 날림
        if (message.equals("성공적으로 등록되었습니다.")) {
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
    }
}
