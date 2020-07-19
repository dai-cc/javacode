package dai.controller;

import dai.model.Article;
import dai.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/query/{id}")
    public Object queryById(@PathVariable("id") Integer id){
        Article article = articleService.queryById(id);
        return article;
    }

    @RequestMapping("/queryByUserId")
    public Object queryByUserId(Integer userId){
        List<Article> articles = articleService.queryByUserId(userId);
        return articles;
    }
}
