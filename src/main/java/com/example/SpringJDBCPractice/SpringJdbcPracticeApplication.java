package com.example.SpringJDBCPractice;

import com.example.SpringJDBCPractice.entity.User;
import com.example.SpringJDBCPractice.repository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJdbcPracticeApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcPracticeApplication.class, args)
			.getBean(SpringJdbcPracticeApplication.class).execute();
	}
	
	@Autowired
	UserCrudRepository repository;
	
	private void execute() {
		executeInsert();
		executeSelect();
	}
	
	private void executeInsert() {
		User user = new User(null, "Kang");
		user = repository.save(user);
		System.out.println("등록 데이터 : "+user);
	}
	
	private void executeSelect() {
		System.out.println("전체 데이터 출력");
		Iterable<User> users = repository.findAll();
		for(User u : users) {
			System.out.println(u);
		}
	}
}
