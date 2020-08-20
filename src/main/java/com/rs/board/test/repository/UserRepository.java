package com.rs.board.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.board.test.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    public User findByUsername(String username);
    public User findByUsernameAndPassword(String username, String password);
}
