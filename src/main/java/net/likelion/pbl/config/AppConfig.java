package net.likelion.pbl.config;

import net.likelion.pbl.MemberRepository;
import net.likelion.pbl.MemberService;
import net.likelion.pbl.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//@Configuration
public class AppConfig {

    /* @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    } */
}
