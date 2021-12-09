package com.example.site.blog.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "blogs")
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    @NotBlank(message = "Name cannot be null")
    private String title;


    @Type(type="text")
    private String full_text;
    private Integer views;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public String getAuthorName()
    {
        return author != null ? author.getUsername() : "<none>";
    }
}
