package com.ega.Ega;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Import({CorsConfiguration.class,WebConfig.class})
@SpringBootApplication
public class EgaApplication {


	public static void main(String[] args) {
		SpringApplication.run(EgaApplication.class, args);
	}

}
