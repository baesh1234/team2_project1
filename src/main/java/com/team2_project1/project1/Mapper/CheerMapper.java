package com.team2_project1.project1.Mapper;


import com.team2_project1.project1.model.Cheer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CheerMapper {
    @Select("SELECT * FROM cheer_comments")
    List<Cheer> getAllCheer();

    @Insert("INSERT INTO cheer_comments (comment_content, email, image) VALUES (#{commentContent}, #{email}, #{image})")
    void insertCheer(Cheer cheer);

    @Select("SELECT * FROM cheer_comments WHERE id = #{id}")
    Cheer getCheerById(Long id);
}
