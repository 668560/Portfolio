package portefolie.DiningAI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DiningAiApplication {

	public static void main(String[] args) {
		
		  ConfigurableApplicationContext context=SpringApplication.run(DiningAiApplication.class, args);
		 Object dataSource=context.getBean("dataSource");
		System.out.println(dataSource);
		 
	
		//SpringApplication.run(DiningAiApplication.class, args);
	}

}
