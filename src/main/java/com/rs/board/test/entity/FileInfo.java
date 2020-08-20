package com.rs.board.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class FileInfo extends BaseEntity{
	@Id
	@GeneratedValue
	@Column(name = "upload_file_id")
	private Long Id;

	@Column
	private String orgFileName;
	
	@Column
	private String storedFileName;

	@Column
	private String fileDownloadUri;

	@Column
	private String fileType;

	@Column
	private Long size;

	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;



}
