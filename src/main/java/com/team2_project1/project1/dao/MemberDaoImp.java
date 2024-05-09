package com.team2_project1.project1.dao;

import com.team2_project1.project1.Mapper.MemberMapper;
import com.team2_project1.project1.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImp implements MemberDao {
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public MemberDto saveMember(MemberDto mDto) {
        // MyBatis를 이용하여 email을 저장합니다.
        int rowsAffected = memberMapper.saveMember(mDto);

        // 저장 결과를 처리하는 코드를 작성합니다.
        // 예를 들어 저장이 성공했으면 성공 메시지를 설정합니다.
        if (rowsAffected > 0) {
            // 저장이 성공한 경우
            System.out.println("Email saved successfully.");
        } else {
            // 저장이 실패한 경우
            System.out.println("Failed to save email.");
        }

        return mDto;
    }
}
