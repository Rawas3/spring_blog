package com.example.site.blog.controllers;

import com.example.site.blog.models.Blog;
import com.example.site.blog.services.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/blog")
    public String blogMain(Model model, @PageableDefault(size = 3, sort = {"id"}, direction = Sort.Direction.ASC) Pageable page) {
        model.addAttribute("blogsPage", blogService.getProductsPaginated(page));

        /*model.addAttribute("blogs", blogService.getBlogs());*/
        return "blog";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model) {

        return "blog_add";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(Model model, Blog blog) {

        blogService.addBlog(blog);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("blog", blogService.getBlog(id));
        return "blog_details";
    }

    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("blog", blogService.getBlog(id));
        return "blog_edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(Model model, Blog blog) {
        blogService.editBlog(blog);
        return "redirect:/blog";
    }

    @RequestMapping("/blog/{id}/remove")
    public String blogPostDelete(@PathVariable(value = "id") long id, Model model) {
      blogService.deleteBlog(id);
        return "redirect:/blog";
    }
}
