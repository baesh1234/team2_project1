package com.team2_project1.project1.service;

import com.team2_project1.project1.dao.MemberDao;
import com.team2_project1.project1.dto.MemberDto;
import com.team2_project1.project1.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImp implements MemberService {
    private ResultDto rDto;

    @Autowired
    MemberDao memberDao;

    public ResultDto save(MemberDto memberDto) {
        rDto = new ResultDto();
        MemberDto savedMember = memberDao.saveMember(memberDto);

        // 저장 결과를 처리하는 코드를 작성합니다.
        // 예를 들어 저장이 성공했으면 성공 메시지를 설정합니다.
        if (savedMember != null) {
            rDto.setMessage("Member saved successfully");
        } else {
            rDto.setMessage("Failed to save member");
        }

        return rDto;
    }
}
