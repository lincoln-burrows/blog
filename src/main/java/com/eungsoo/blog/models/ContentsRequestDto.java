package com.eungsoo.blog.models;

import lombok.Getter;

@Getter
public class ContentsRequestDto {
    private String title;
    private String username;
    private String contents;
}