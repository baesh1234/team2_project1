package com.team2_project1.project1.model;

import lombok.Data;

@Data
public class Cheer {
    private  String comment_content;
    private String email;


    public String getCommentContent() {
        return comment_content;
    }
}
