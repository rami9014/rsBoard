package com.rs.board.test.dto;

import lombok.Data;

@Data
public class FileDTO {
	private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;

    public FileDTO(String fileName, String fileDownloadUri, String fileType, long size) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }
    
}
