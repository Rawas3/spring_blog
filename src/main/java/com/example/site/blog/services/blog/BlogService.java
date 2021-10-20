package com.example.site.blog.services.blog;

import com.example.site.blog.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {

    void saveBlog(Blog blog);

    Page<Blog> getProductsPaginated(Pageable page);

    Blog getBlog(Long id);

    void deleteBlog(Long id);
}
