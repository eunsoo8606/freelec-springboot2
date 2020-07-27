package com.jojodu.book.springboot.web;

import com.jojodu.book.springboot.service.posts.PostsService;
import com.jojodu.book.springboot.web.dto.PostsListResponseDto;
import com.jojodu.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){
        List<PostsListResponseDto> list = postsService.findAllDesc();
        System.out.println(list);
        model.addAttribute("posts", postsService.findAllDesc());

        return "index";
    }

    @GetMapping("/posts/save")
    public String postSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        System.out.println("날아온 아이디 값==" + id);
        PostsResponseDto dto = postsService.findById(id);
        System.out.println("조회결과====" + dto.toString());
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
