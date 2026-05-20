package net.likelion.pbl;

import net.likelion.pbl.MemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PblApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext =
				SpringApplication.run(PblApplication.class, args);

		MemberService memberService =
				applicationContext.getBean(MemberService.class);

		System.out.println("memberService = " + memberService);
		System.out.println("MemberService Bean 조회 성공");
	}

}