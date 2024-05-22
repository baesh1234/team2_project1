package com.team2_project1.project1.service;

import com.team2_project1.project1.domain.CheerComments;
import com.team2_project1.project1.repository.CheerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheerCommentService {
    private final CheerRepository cheerRepository;

    @Autowired
    public CheerCommentService(CheerRepository cheerRepository){
        this.cheerRepository = cheerRepository;
    }

    public String save_comment(CheerComments cheerComments){
        cheerRepository.saveComment(cheerComments);
        return cheerComments.getComment_content();
    }

    public List<CheerComments> findComment(){
        return cheerRepository.findAllComment();
    }
    // 전체 댓글 조회
    public List<CheerComments> findComments(){
        return cheerRepository.findAllComment();
    }

    // 댓글 저장 메서드
    public void saveComment(CheerComments comment) {
        cheerRepository.saveComment(comment);
    }

}
