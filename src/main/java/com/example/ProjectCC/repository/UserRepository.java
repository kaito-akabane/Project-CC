package com.example.ProjectCC.repository;

import com.example.ProjectCC.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}