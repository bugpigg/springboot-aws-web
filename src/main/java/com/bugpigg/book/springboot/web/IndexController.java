package com.bugpigg.book.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index"; // 앞의 경로와, 뒤의 확장자는 자동으로 지정된다
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
