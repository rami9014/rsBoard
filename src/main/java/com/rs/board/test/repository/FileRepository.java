package com.rs.board.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rs.board.test.entity.FileInfo;


public interface FileRepository extends JpaRepository<FileInfo, Long> {
//    @Query("select f from UploadFile f where post_id = :id")
//    List<FileInfo> findAllByPostId(Long id);
	
}
