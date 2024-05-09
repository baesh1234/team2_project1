package com.team2_project1.project1.Mapper;

import com.team2_project1.project1.dto.MemberDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    @Insert("insert into member (email) value (#{email})")
    public int saveMember(MemberDto mDto);
}
