package com.example.SpringJDBCPractice.repository;

import com.example.SpringJDBCPractice.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User, Integer> {

}