package com.surge.Jwt;

import com.surge.Jwt.entity.User;
import com.surge.Jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class JwtApplication {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@PostConstruct
		public void initUsers() {
			List<User> users  = Stream.of(
					new User(1,"osagie", passwordEncoder.encode("password"), "osagieabel@icloud.com"),
					new User(2 ,"user1", passwordEncoder.encode("pwd1"), "user1@icloud.com"),
					new User(3 ,"user2", passwordEncoder.encode("pwd2"), "user2@icloud.com"),
					new User(4 ,"user3", passwordEncoder.encode("pwd3"), "user3@icloud.com"),
					new User(5 ,"user4", passwordEncoder.encode("pwd4"), "user4@icloud.com")
			).collect(Collectors.toList());
			userRepository.saveAll(users);
		};

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}

}
