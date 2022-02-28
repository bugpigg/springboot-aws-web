package com.bugpigg.book.springboot.web;

import com.bugpigg.book.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) { // 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있다.
        model.addAttribute("posts", postsService.findAllDesc());
        return "index"; // 앞의 경로와, 뒤의 확장자는 자동으로 지정된다
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
