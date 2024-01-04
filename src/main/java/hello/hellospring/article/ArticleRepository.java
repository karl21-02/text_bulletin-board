package hello.hellospring.article;

import hello.hellospring.Global;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArticleRepository {
    public int save(String title, String content) {
        // title, content, Global.getLoginedMember().getId()
        String sql = String.format("INSERT INTO article SET title = '%s', content = '%s', memberId = %d, regDate=now();", title, content, Global.getLoginedMember().getId());
        int id =  Global.getDbConnection().insert(sql);

        return id;
    }

    public List<ArticleDTO> findByAll() {
        ArrayList<ArticleDTO> articleList = new ArrayList<>();
        List<Map<String, Object>> rows = Global.getDbConnection().selectRows("select A.*, M.userId from article as A join member as M on A.memberId = M.id;");
        System.out.println(rows);
        for (Map<String, Object> row : rows) {
            ArticleDTO article = new ArticleDTO(row);

            articleList.add(article);
        }

        return articleList;
    }

    public ArticleDTO _articleFindById(int id) {
        List<ArticleDTO> articleList = this.findByAll();

        for(int i=0; i<articleList.size(); i++) {
            if (id == articleList.get(i).getId()) {
                return articleList.get(i);
            }
        }
        return null;
    }

    public void delete(ArticleDTO article) {
        String sql = String.format("DELETE FROM article WHERE id=%d", article.getId());
        Global.getDbConnection().delete(sql);
    }

    public void update(ArticleDTO article, String title, String content) {
        String sql = String.format("UPDATE article SET title = '%s', content='%s' WHERE id = %d;", title, content, article.getId());

        Global.getDbConnection().update(sql);
    }
}
