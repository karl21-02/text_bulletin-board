package hello.hellospring.article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.service.annotation.GetExchange;

import java.util.Map;

@AllArgsConstructor
@Setter
@Getter
public class Article {
    private int id;
    private String title;
    private String content;
    private int memberId;
    private String userId;
    private String regDate;

    Article (Map<String, Object> row) {
        this.id = (int)row.get("id");
        this.title = (String)row.get("title");
        this.content = (String)row.get("content");
        this.memberId = (int)row.get("memberId");
        this.userId = (String)row.get("userId");
        this.regDate = row.get("regDate").toString();

    }
}
