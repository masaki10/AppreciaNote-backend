package com.taketeru.apprecianote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
//@Import(WebSecurityConfig.class)
public class ApprecianoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApprecianoteApplication.class, args);
	}

}
