package com.example.site.blog.services.blog;

import com.example.site.blog.repository.BlogRepository;
import com.example.site.blog.models.Blog;
import com.example.site.blog.wexceptions.BlogNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService{

    private final BlogRepository blogRepository;

    @Override
    public void saveBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Page<Blog> getProductsPaginated(Pageable page) {
        return blogRepository.findAll(page);
    }

    @Override
    public Blog getBlog(Long id) {
        return blogRepository.findById(id).orElseThrow(BlogNotFoundException::new);
    }

    @Override
    public void deleteBlog (Long id) {
        blogRepository.deleteById(id);
    }

}
