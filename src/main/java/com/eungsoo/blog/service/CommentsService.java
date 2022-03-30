package com.eungsoo.blog.service;

import com.eungsoo.blog.models.Comments;
import com.eungsoo.blog.models.CommentsRequestDto;
import com.eungsoo.blog.models.Contents;
import com.eungsoo.blog.models.ContentsRequestDto;
import com.eungsoo.blog.repository.CommentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.stream.events.Comment;

@RequiredArgsConstructor
@Service
public class CommentsService {

    private final CommentsRepository CommentsRepository;

    @Transactional
    public Long update(Long id, CommentsRequestDto requestDto) {
        Comments Comments = CommentsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        Comments.update(requestDto);
        return Comments.getId();
    }
}