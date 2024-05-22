package com.team2_project1.project1.Mapper;

import com.team2_project1.project1.domain.EmailVerification;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface EmailVerificationMapper {
    @Insert("INSERT INTO EmailVerification (email, token, expirationTime) VALUES (#{email}, #{token}, #{expirationTime})")
    void insertEmailVerification(EmailVerification emailVerification);

    @Select("SELECT * FROM EmailVerification WHERE token = #{token}")
    EmailVerification findByToken(@Param("token") String token);
}