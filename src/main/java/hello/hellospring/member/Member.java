package hello.hellospring.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@Setter
@Getter
public class Member {
    int id;
    String userId;
    String password;
    String regDate;

    public Member (Map<String, Object> row) {
        this.id = (int)row.get("id");
        this.userId = (String)row.get("userId");
        this.password = (String) row.get("password");
        this.regDate = row.get("regDate").toString();

    }


}
