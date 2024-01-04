package hello.hellospring.member;

import hello.hellospring.Global;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MemberRepository {

    public Member _memberFindByUserid(String userId) {
        List<Member> memberList = findByAll();

        for(Member member : memberList) {
            if(userId.equals(member.getUserId())) {
                return member;
            }
        }
        return null;
    }

    public int join (String userId, String password) {
        // userId, password
        String sql = String.format("INSERT INTO member SET userId = '%s', password = '%s', regDate = now()", userId, password);
        int id = Global.getDbConnection().insert(sql);

        return id;
    }

    public Member memberFindById(int id) {
        List<Member> memberList = findByAll();

        for(Member member : memberList) {
            if(id == member.getId()) {
                return member;
            }
        }

        return null;
    }

    public List<Member> findByAll() {
        List<Member> memberList = new ArrayList<>();

        String sql = "select * from member;";
        List<Map<String, Object>> rows = Global.getDbConnection().selectRows(sql);
        for(Map<String, Object> row : rows) {
            Member member = new Member(row);
            memberList.add(member);
        }

        return memberList;
    }
}
