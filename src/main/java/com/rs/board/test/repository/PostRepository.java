package com.rs.board.test.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.board.test.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
	Page<Post> findAll(Pageable pageable);
}
