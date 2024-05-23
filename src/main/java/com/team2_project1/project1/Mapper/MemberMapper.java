package com.team2_project1.project1.Mapper;


import org.apache.ibatis.annotations.*;


@Mapper
public interface MemberMapper {
    @Insert("INSERT INTO member (email) VALUES (#{email})")
    void insertEmail(@Param("email") String email);

    @Select("SELECT COUNT(*) FROM member WHERE email = #{email}")
    int countByEmail(@Param("email") String email);

<<<<<<< HEAD
    @Select("SELECT COUNT(*) FROM member")
    int countAll();

=======
    @Update("UPDATE `javadb2`.`member` SET `book`='1' WHERE email = #{email}")
    boolean updateBook(@Param("email") String email);

    @Select("select book from member where email = #{email}")
    boolean findBook(@Param("email") String email);
>>>>>>> 84302148d64134f8961e719dbec4004a7cba2b8a
}


