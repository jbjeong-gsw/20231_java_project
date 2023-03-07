package kr.hs.gsw.web.simplest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimplestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimplestApplication.class, args);
		System.out.println("내 프로그램이 실행되었다.");

	}

}
