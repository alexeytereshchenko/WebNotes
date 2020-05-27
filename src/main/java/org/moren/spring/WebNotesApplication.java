package org.moren.spring;

import lombok.AllArgsConstructor;
import org.moren.spring.model.Role;
import org.moren.spring.repository.RoleRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class WebNotesApplication implements ApplicationRunner {

	private final RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(WebNotesApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if (roleRepository.findAll().isEmpty()) {
			Role userRole = new Role();
			userRole.setName("ROLE_USER");
			roleRepository.save(userRole);

			Role adminRole = new Role();
			adminRole.setName("ROLE_ADMIN");
			roleRepository.save(adminRole);
		}
	}
}
