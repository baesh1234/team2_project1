package com.team2_project1.project1.Controller;

import com.team2_project1.project1.domain.CheerComments;
import com.team2_project1.project1.service.CheerCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CommentController {
    private final CheerCommentService cheerCommentService;

    @Autowired
    public CommentController(CheerCommentService cheerCommentService) {
        this.cheerCommentService = cheerCommentService;
    }

    @GetMapping("/comments")
    public String list(Model model){
        List<CheerComments> cheerComments = cheerCommentService.findComment();
        model.addAttribute("cheerComments", cheerComments); // 속성 이름을 cheerComments로 변경
        return "comments/commentList";
    }




    @PostMapping("/saveComment")
    public String saveComment(@RequestParam("phone") String phone,
                              @RequestParam("comment_content") String commentContent) {
        CheerComments comment = new CheerComments();
        comment.setPhone_num(phone);
        comment.setComment_content(commentContent);
        cheerCommentService.saveComment(comment);
        return "redirect:/comments"; // 저장 후 댓글 목록 페이지로 리다이렉트
    }



}

