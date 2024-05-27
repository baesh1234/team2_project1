package com.team2_project1.project1.Mapper;


import org.apache.ibatis.annotations.*;


@Mapper
public interface MemberMapper {
    @Insert("INSERT INTO member (email) VALUES (#{email})")
    void insertEmail(@Param("email") String email);

    @Select("SELECT COUNT(*) FROM member WHERE email = #{email}")
    int countByEmail(@Param("email") String email);

    @Update("UPDATE `javadb2`.`member` SET `book`='1' WHERE email = #{email}")
    int updateBook(@Param("email") String email);

    @Select("select book from member where email = #{email}")
    boolean findBook(@Param("email") String email);
}
