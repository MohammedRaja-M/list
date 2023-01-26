package test.co.student;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;




@ComponentScan("package test.co.student.controller")  
@Configuration  
@EnableAutoConfiguration  
@EntityScan("test.co.student.model;") 
@EnableJpaRepositories("test.co.student.service;")
@SpringBootApplication
public class StudentDetailsList1Application{

	public static void main(String[] args) {
		SpringApplication.run(StudentDetailsList1Application.class, args);
	}
	@Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
	@Bean
	   public Docket swaggerConfiguration() {
	      return new Docket(DocumentationType.SWAGGER_2)
	    		  .select()
	    		  .paths(PathSelectors.ant("/api/v1/student/*"))
	    		  .apis(RequestHandlerSelectors.basePackage("test.co.student"))
	    		  .build();
	   }

	

}
