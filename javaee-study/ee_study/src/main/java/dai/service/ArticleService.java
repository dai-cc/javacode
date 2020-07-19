package dai.service;

import dai.mapper.ArticleMapper;
import dai.model.Article;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleService {

   /*
   @Autowired
    private ArticleMapper articleMapper;
    // 这里飘红没关系，如果不想看见飘红就改成@Resource
    */
   @Resource
   private ArticleMapper articleMapper;

   public Article queryById(Integer id) {
      return articleMapper.selectByPrimaryKey(id);
   }


   public List<Article> queryByUserId(Integer userId) {
      return articleMapper.queryByUserId(userId);
   }
}
