package com.example.site.blog.controllers;

import com.example.site.blog.services.blog.BlogService;
import com.example.site.blog.models.Blog;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/blog")
    public String blogMain(Model model,
                           @PageableDefault(size = 6, sort = {"id"}, direction = Sort.Direction.ASC) Pageable page) {
        model.addAttribute("blogsPage", blogService.getProductsPaginated(page));
        return "5-blog/page-blog";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        return "5-blog/page-blogAdd";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam("file") MultipartFile file, Model model, Blog blog) throws IOException {
        blogService.saveBlog(blog);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("blog", blogService.getBlog(id));
        return "5-blog/page-blogDetails";
    }

    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("blog", blogService.getBlog(id));
        return "5-blog/page-blogEdit";
    }

    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(Model model, Blog blog) {
        blogService.saveBlog(blog);
        return "redirect:/blog";
    }

    @RequestMapping("/blog/{id}/remove")
    public String blogPostDelete(@PathVariable(value = "id") long id, Model model) {
      blogService.deleteBlog(id);
        return "redirect:/blog";
    }
}
