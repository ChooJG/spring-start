package hello.springstart.service;

import hello.springstart.domain.Member;
import hello.springstart.repository.MemberRepository;
import hello.springstart.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    //memberService의 구현체를 외부에서 주입하도록 변경
    //기존에 memberRepository가 test단에 하나, 여기에 하나 따로 생겼다면
    //이제는 테스트 단에서만 memberRepository 생성
    //MemoryMemberRepository를 외부에서 주입해준다고 생각하자
    //@Autowired 어노테이션이 있어서 스프링 컨테이너에 등록된 repository 객체와 자동으로 연동
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
    * 회원가입
    * */
    public Long join(Member member){
        //중복 회원은 불가능
//        Optional<Member> result = memberRepository.findByName(member.getName());
//
//        //result가 null이 아니라면
//        //Optional로 감쌌기 때문에 가능
//        if(result.isPresent()){
//            throw new IllegalStateException("이미 존재하는 이름입니다");
//        }

        //중복회원 검증
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다");
                        });
    }

    /*
    * 전체 멤버 조회
    * */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }


    public Optional<Member> findOne(Long id) {
        return memberRepository.findById(id);
    }








}
