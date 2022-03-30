package com.eungsoo.blog.models;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Comments extends Timestamped {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // nullable = false 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String contentsid;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String comments;



    public Comments(String contentsid, String username, String comments) {
        this.contentsid = contentsid;
        this.username = username;
        this.comments = comments;
    }

    // 댓글 생성
    public Comments(CommentsRequestDto requestDto) {
        this.contentsid = requestDto.getContentsid();
        this.username = requestDto.getUsername();
        this.comments = requestDto.getComments();
    }

    // 댓글 수정
    public void update(CommentsRequestDto requestDto) {
        this.contentsid = requestDto.getContentsid();
        this.username = requestDto.getUsername();
        this.comments = requestDto.getComments();
    }
}