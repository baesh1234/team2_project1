package com.team2_project1.project1.Mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface MemberMapper {
    @Insert("INSERT INTO member (email) VALUES (#{email})")
    void insertEmail(@Param("email") String email);

    @Select("SELECT COUNT(*) FROM member WHERE email = #{email}")
    int countByEmail(@Param("email") String email);

    @Select("SELECT COUNT(*) FROM member")
    int countAll();

}


