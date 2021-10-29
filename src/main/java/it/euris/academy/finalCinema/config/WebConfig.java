package it.euris.academy.finalCinema.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry){
    registry
        .addMapping("*")
        .allowedMethods("OPTIONS", "GET", "PUT", "DELETE", "PATCH")
        .allowedOrigins("*")
        .allowedHeaders("*");
  }
}
