package ua.azbest.ProxyBandTask;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.azbest.ProxyBandTask.model.User;
import ua.azbest.ProxyBandTask.repositories.UserRepository;

@SpringBootApplication
public class ProxyBandTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyBandTaskApplication.class, args);
    }

/*
	@Bean
	CommandLineRunner runner(UserRepository repository) {
		return args -> {
			String email = "email1@gmail.com";
			User user = new User(
				"Name1",
				email
			);

			repository.findUserByEmail(email)
							.ifPresentOrElse(
									s -> System.out.println(email + " already taken"),
									() -> {
								System.out.println("Inserting User " + user);
								repository.insert(user);
							});

		};
	}
//*/
}
