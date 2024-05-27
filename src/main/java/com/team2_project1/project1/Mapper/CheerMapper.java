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

    @Insert("INSERT INTO cheer_comments (comment_content, email) VALUES (#{commentContent}, #{email})")
    void insertCheer(Cheer cheer);

}
