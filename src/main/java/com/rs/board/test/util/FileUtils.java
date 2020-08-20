package com.rs.board.test.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.rs.board.test.entity.FileInfo;
import com.rs.board.test.entity.Post;


public class FileUtils {
     
    public static List<FileInfo> parseFileInfo(Post post, MultipartFile[] file) throws Exception {
    	
    	String uploadPath="";
    	
        List<FileInfo> fileList = (List<FileInfo>) new FileInfo();
 
        File target = new File(uploadPath);
        if(!target.exists()) target.mkdirs();
        
        for(int i=0; i<file.length; i++) {
 
            String orgFileName = file[i].getOriginalFilename();
            String orgFileExtension = orgFileName.substring(orgFileName.lastIndexOf("."));
            String saveFileName = UUID.randomUUID().toString().replaceAll("-", "") + orgFileExtension;
            Long saveFileSize = file[i].getSize();
            
//            log.debug("================== file start ==================");
//            log.debug("파일 실제 이름: "+orgFileName);
//            log.debug("파일 저장 이름: "+saveFileName);
//            log.debug("파일 크기: "+saveFileSize);
//            log.debug("content type: "+file[i].getContentType());
//            log.debug("================== file   END ==================");
 
            target = new File(uploadPath, saveFileName);
            file[i].transferTo(target);
            
//            Map<String, Object> fileInfo = new HashMap<String, Object>();
            FileInfo fileInfo = new FileInfo();
            
            fileInfo.setOrgFileName(saveFileName);
            fileInfo.setStoredFileName(saveFileName);
            fileInfo.setSize(saveFileSize);
            fileInfo.setFileType(file[i].getContentType());
            fileInfo.setPost(post);
            fileList.add(fileInfo);
            
        }
        return fileList;
    }
}
