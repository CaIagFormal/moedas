package kotacoes.moedas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MoedasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoedasApplication.class, args);
	}

}
