package com.team2_project1.project1.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Cheer {
    private  String comment_content;
    private String email;
    private LocalDateTime comment_datetime;
    private String image;


    public String getCommentContent() {
        return comment_content;
    }
}
