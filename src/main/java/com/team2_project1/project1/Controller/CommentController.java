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
        model.addAttribute("comment_content", cheerComments);
        return "comments/commentList";
    }

//    @PostMapping("/saveComment")
//    public ResponseEntity<String> saveComment(@RequestParam("comment_content") String commentText) {
//        CheerComments comment = new CheerComments(commentText);
//        cheerCommentService.saveComment(comment); // 서비스를 통해 댓글 저장
//        return ResponseEntity.ok("Comment saved successfully");
//    }
}

