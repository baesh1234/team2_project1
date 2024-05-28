package com.team2_project1.project1.Controller;


import com.team2_project1.project1.model.Cheer;
import com.team2_project1.project1.service.CheerService;
import com.team2_project1.project1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class CheerController {


    private final CheerService cheerService;

    public CheerController(CheerService cheerService) {
        this.cheerService = cheerService;
    }
    @Autowired
    MemberService memberService;

    @GetMapping("/api/Cheer")
    public List<Cheer> getAllCheer() {
        return cheerService.getAllCheer();

    }
    @PostMapping("/api/Cheer")
    public void insertCheer(@RequestBody Cheer cheer){
        cheerService.insertCheer(cheer);
    }

    @PostMapping("/api/checkEmail")
    public String checkEmail(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        boolean emailExists = memberService.findBook(email);
        if (emailExists) {
            return "인증이 완료되었습니다.";
        } else {
            return "사전등록을 해주세요.";
        }
    }

}



