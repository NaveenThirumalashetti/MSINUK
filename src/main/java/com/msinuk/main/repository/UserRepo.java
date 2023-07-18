package com.msinuk.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msinuk.main.model.LoginResponse;
import com.msinuk.main.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	User findByUserName(String username);

}
