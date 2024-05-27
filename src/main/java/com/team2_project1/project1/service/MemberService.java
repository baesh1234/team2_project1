package com.team2_project1.project1.service;

import com.team2_project1.project1.Mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;
    /*사전 등록 서비스
    * 1.  */

    public String bookMember(String email) {
        if(memberMapper.countByEmail(email) == 1){
            if(!memberMapper.findBook(email)){
                //등록 컬럼을 true로 바꿈
                memberMapper.updateBook(email);
                return "성공적으로 등록되었습니다.";
            }else {
                return "이미 등록된 이메일 입니다.";
            }
        }else{
            return "이메일 인증을 먼저 진행해 주세요.";
        }
    }
   // 이메일 중복체크
    public boolean findBook(String email) {
        return memberMapper.findBook(email);
    }

}
