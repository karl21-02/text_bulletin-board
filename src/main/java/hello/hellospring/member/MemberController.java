package hello.hellospring.member;

import hello.hellospring.Global;

public class MemberController {

    MemberService memberService;

    public MemberController() {
        this.memberService = new MemberService();
    }
    public void join() {
        String userId;
        // 중복 id 검증
        while(true) {
            System.out.print("아이디 : ");
            userId = Global.getScanner().nextLine().trim();
            boolean flag = false;

            Member member = this.memberService._memberFindByUserid(userId);

            if(member != null) {
                System.out.println("중복 아이디가 존재합니다.");
                flag = true;
            }

            if(flag) continue;
            System.out.println("아이디 통과");
            break;
        }

        String password;
        // 비밀번호 확인 검증
        while(true) {
            System.out.print("비밀번호 : ");
            password = Global.getScanner().nextLine().trim();
            System.out.print("비밀번호 확인 : ");
            String passwordConfirm = Global.getScanner().nextLine().trim();

            if(password.equals(passwordConfirm)) {
                break;
            }

            System.out.println("비밀번호가 일치하지 않습니다.");
        }

        int joinedMemberId = this.memberService.create(userId, password);

        if(joinedMemberId == -1) {
            System.out.println("회원가입에 실패하였습니다.");
            return;
        }
        else {
            System.out.println(userId + "님! 가입을 환영합니다.");
        }
    }
    public void login() {
        if(Global.getLoginedMember() != null) {
            System.out.println("현재 로그인 상태입니다.");
            return;
        }

        Member checkedMember = null;

        System.out.print("아이디 : ");
        String userId = Global.getScanner().nextLine().trim();
        System.out.print("비밀번호 : ");
        String password = Global.getScanner().nextLine().trim();

        Member member = this.memberService._memberFindByUserid(userId);
        checkedMember = member;

        if (checkedMember == null) {
            System.out.println("해당 회원이 존재하지 않습니다.");
            return;
        }

        if(!password.equals(checkedMember.getPassword())) {
            System.out.println("비밀번호가 일치 하지 않습니다.");
            return;
        }

        this.memberService.login(checkedMember);

        System.out.println(checkedMember.getUserId() + "님 환영합니다.");
    }
    public void logout() {
        if (Global.getLoginedMember() == null) {
            System.out.println("로그인 상태가 아닙니다");
            return;
        }

        this.memberService.logout();
        System.out.println("로그아웃 되었습니다.");
    }
}
