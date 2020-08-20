package com.rs.board.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rs.board.test.entity.FileInfo;
import com.rs.board.test.entity.Post;
import com.rs.board.test.repository.FileRepository;
import com.rs.board.test.repository.PostRepository;
import com.rs.board.test.util.FileUtils;

@Service
public class PostService {

	@Autowired 
	PostRepository postRepository;
	@Autowired 
	FileRepository fileRepository;
	
	public Post save(Post post, MultipartFile[] file) throws Exception {
		Post createdPost = postRepository.save(post);
		if(createdPost != null && file != null) {
			List<FileInfo> fileList = FileUtils.parseFileInfo(createdPost, file);		    
		    for(FileInfo fileInfo: fileList) {
		    	fileRepository.save(fileInfo); 
		    }			
		}
		return createdPost;
	}
	
}
