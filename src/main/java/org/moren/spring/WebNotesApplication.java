package org.moren.spring;

import org.moren.spring.model.Role;
import org.moren.spring.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebNotesApplication implements ApplicationRunner {

	private RoleRepository roleRepository;

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

	@Autowired
	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
}
