package com.form.org.Repository;

import com.form.org.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepositoyry extends JpaRepository<Article,Integer> {
}
