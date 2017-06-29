package main.java.consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application2 {

	private static final Logger log = LoggerFactory.getLogger(Application2.class);

	public static void main(String args[]) {
		SpringApplication.run(Application2.class);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		System.out.println("restTemplate");
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		System.out.println("run");
		return args -> {
			Quote quote = restTemplate.getForObject(
					"http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
			log.info(quote.toString());
		};
	}
}