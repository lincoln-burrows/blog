package com.eungsoo.blog.models;

import lombok.Getter;

@Getter
public class CommentsRequestDto {
    private String contentsid;
    private String username;
    private String comments;
}