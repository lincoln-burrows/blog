package com.eungsoo.blog.controller;


import com.eungsoo.blog.models.Comments;
import com.eungsoo.blog.models.CommentsRequestDto;
import com.eungsoo.blog.models.Contents;

import com.eungsoo.blog.repository.CommentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentsRestController {

    private final CommentsRepository CommentsRepository;
    private final com.eungsoo.blog.service.CommentsService CommentsService;

    // 게시글 전체 조회
    @GetMapping("/api/comments")
    public List<Comments> getComments() {
        return CommentsRepository.findAllByOrderByCreatedAtDesc();

    }

    // 댓글 특정 조회
    @GetMapping("/api/comments/{contensid}")
    public Comments getComments(@PathVariable Long id) {
        Comments comments=  CommentsRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("contentsid가 존재하지 않습니다."));
        return comments;
    }

    // 게시글 생성
    @PostMapping("/api/comments")
    public Comments createComments(@RequestBody CommentsRequestDto requestDto) {
        Comments Comments = new Comments(requestDto);
        return CommentsRepository.save(Comments);
    }

    // 댓글 수정
    @PutMapping("/api/comments/{id}")
    public Long updateComments(@PathVariable Long id, @RequestBody CommentsRequestDto requestDto) {
        CommentsService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/comments/{id}")
    public Long deleteComments(@PathVariable Long id) {
        CommentsRepository.deleteById(id);
        return id;
    }

}