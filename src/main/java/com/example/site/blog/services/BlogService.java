package com.example.site.blog.services;

import com.example.site.blog.exception.BlogNotFoundException;
import com.example.site.blog.models.Blog;
import com.example.site.blog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    public void addBlog(Blog blog) {
        blogRepository.save(blog);
    }

    public Page<Blog> getProductsPaginated(Pageable page) {
        return blogRepository.findAll(page);
    }
    public List<Blog> getBlogs() {
        return blogRepository.findAll();
    }

    public Blog getBlog(Long id) {
        return blogRepository.findById(id).orElseThrow(BlogNotFoundException::new);
    }

    public void editBlog(Blog blog) {
        blogRepository.save(blog);
    }

    public void deleteBlog (Long id) {
        blogRepository.deleteById(id);
    }


}
