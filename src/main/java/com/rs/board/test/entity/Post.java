package com.rs.board.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Post extends BaseEntity{

	@Id
	@GeneratedValue	
	@Column(name ="post_id")
	private Long id;
	
	private String title;
	private String content;
	private String writer;
	
}
