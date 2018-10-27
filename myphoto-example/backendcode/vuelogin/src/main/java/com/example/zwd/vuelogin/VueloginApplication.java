package com.example.zwd.vuelogin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.zwd.vuelogin.mapper")
public class VueloginApplication {

	public static void main(String[] args) {
		SpringApplication.run(VueloginApplication.class, args);
	}
}
