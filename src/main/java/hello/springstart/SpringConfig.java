package hello.springstart;

import hello.springstart.repository.MemberRepository;
import hello.springstart.repository.MemoryMemberRepository;
import hello.springstart.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//스프링 실행시 빈 등록
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}
