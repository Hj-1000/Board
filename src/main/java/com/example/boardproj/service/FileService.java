package com.example.boardproj.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Component
public class FileService {

    @Value("${imgLocation}")
    private String imgLocation;

    public void register(MultipartFile multipartFile, String newImgName){
        //들어온 사진이름

        System.out.println(imgLocation+ "\\" +newImgName);


        //사진 경로 및 이름
        File file  = new File(imgLocation  + "\\" +newImgName);
        //사진저장

        try {
            multipartFile.transferTo(file);

        }catch (IOException e){

        }

    }

    public void delFile(String filepath){
        File deleteFile = new File(filepath);

        if (deleteFile.exists()){
            deleteFile.delete(); // 물리 파일 삭제
            System.out.println("파일 삭제 성공");
        }else{
            System.out.println("파일 삭제 실패");
        }

    }

}
