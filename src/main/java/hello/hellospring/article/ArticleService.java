package hello.hellospring.article;

import hello.hellospring.Global;

import java.util.ArrayList;
import java.util.List;

public class ArticleService {
    private ArticleRepository articleRepository;

    ArticleService() {
        articleRepository = new ArticleRepository();
    }

    public int save(String title, String content) {
        return this.articleRepository.save(title, content);
    }

    public List<ArticleDTO> findByAll() {
        return this.articleRepository.findByAll();
    }

    public ArticleDTO _articleFindById(int id) {
        return this.articleRepository._articleFindById(id);
    }

    public void delete(ArticleDTO article) {
        this.articleRepository.delete(article);
    }

    public void update(ArticleDTO article, String title, String content) {
        this.articleRepository.update(article, title, content);
    }
}
