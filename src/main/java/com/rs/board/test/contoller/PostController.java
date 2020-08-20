package com.rs.board.test.contoller;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rs.board.test.entity.Post;
import com.rs.board.test.repository.PostRepository;
import com.rs.board.test.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	PostService postService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public Page<Post> getPostList(@PageableDefault(size=5, sort="createdTime")Pageable pageRequest) {
		
		return  postRepository.findAll(pageRequest);
	}
	@RequestMapping(value="/detail/{id}", method=RequestMethod.GET)
	public Post getPostDetail(@PathVariable Long id) {
		try {
			Post postDetail = postRepository.findOne(id);
			if(postDetail != null) {
				return postDetail;	
			}else {
				return null;
			}			
		}catch(Exception e) {
			return null;
		}
	}
    
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeGET() {
		//TODO front에서 페이지 이동
	    return "/post/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String createPost(Post post,RedirectAttributes redirectAttributes) {
//	public String createPost(Post post,MultipartFile[] file) {
		try {
			Post createdPost = postService.save(post,null);
//			Post createdPost = postService.save(post,file);
//			return createdPost;
			return "redirect:/post/list";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
	public Post updatePost(@PathVariable Long id, @RequestBody Post updatePost) {
		try {
			Post post = postRepository.findOne(id);
			if(post != null) {
				postRepository.save(updatePost);	
				return updatePost;
			}else {
				return null;
			}			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public String deletePost(@PathVariable Long id) {
		try {
			postRepository.delete(id);
			return "delete success";
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}