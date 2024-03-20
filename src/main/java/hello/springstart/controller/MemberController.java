package hello.springstart.controller;

import hello.springstart.domain.Member;
import hello.springstart.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    //1. 필드 주입 방식
    //@Autowired private final MemberService memberService;


    //2. setter 주입 방식
//    @Autowired
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }

    private final MemberService memberService;

    //스프링 내부에서 MemberController를 MemberService와 연결
    //컨트롤러, 서비스, 리포지토리를 스프링 컨테이너에 올려놓아야 함
    //3. 생성자 주입 방식
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/members/new")
    public String create(MemberForm memberForm){
        Member member = new Member();
        member.setName(memberForm.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }


}
