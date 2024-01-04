package hello.hellospring.member;

import hello.hellospring.Global;

import java.util.ArrayList;
import java.util.List;

public class MemberService {
    MemberRepository memberRepository;
    public MemberService() {
        memberRepository = new MemberRepository();
    }
    public Member _memberFindByUserid(String userId) {
        return this.memberRepository._memberFindByUserid(userId);
    }

    public int create(String userId, String password) {
        return this.memberRepository.join(userId, password);
    }
    public Member memberFindById(int id) {
        return this.memberRepository.memberFindById(id);
    }
    public void login(Member checkedMember) {
        Global.setLoginedMember(checkedMember);
    }

    public void logout() {
        Global.setLoginedMember(null);
    }
}
