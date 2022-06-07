package com.xar.lore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.xar.lore.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
public class LoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoreApplication.class, args);
	}

}
