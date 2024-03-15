package hello.springstart.repository;

import hello.springstart.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


public class MemotyMemberRepositoryTest {

    MemoryMemberRepository memberRepository = new MemoryMemberRepository();


    //테스트 하나가 끝날때마다 실행되는 코드
    //테스트 하나 종료하고 저장되었던 데이터 삭제해야 서순에 따른 오류 x
    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        memberRepository.save(member);
        
        //findById()로 출력시 optional 형태로 가져오기 때문에 .get() 메서드가 붙어야함
        Member member1 = memberRepository.findById(member.getId()).get();
        System.out.println("member1 = " + memberRepository.findById(member.getId()));

        //둘다 사용 가능
        //요새는 밑에거를 더 많이사용함
        assertEquals(member, member1);
        assertThat(member).isEqualTo(member1);

    }


    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberRepository.save(member2);

        Member result = memberRepository.findByName("spring1").get();

        assertThat(member1).isEqualTo(result);
        assertThat(member2).isNotEqualTo(result);

    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberRepository.save(member2);

        List<Member> result = memberRepository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}

