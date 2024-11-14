package com.example.boardproj.controller;

import com.example.boardproj.dto.BoardDTO;
import com.example.boardproj.dto.NoticeDTO;
import com.example.boardproj.service.NoticeService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private final NoticeService noticeService;

    //등록 get
    @GetMapping("/register")
    public String registerGet(){

        return "notice/register";
    }
    //등록 Post
    @PostMapping("/register")
    public String registerPost(@Valid NoticeDTO noticeDTO, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()){
            bindingResult.getAllErrors();

            return "notice/register";
        }



        noticeService.register(noticeDTO);

        return "redirect:/notice/list";
    }
    // 읽기
    @GetMapping("/read")
    public String read(){

        return "notice/read";
    }
    // 목록
    @GetMapping("/list")
    public String list(){

        return "notice/list";
    }
    // 업데이트 Get

    @GetMapping("/update")
    public String updateGet(){

        return "notice/update";
    }
    // 업데이트 Post
    @PostMapping("/update")
    public String updatePost(){

        return "redirect:/notice/list";
    }
    // 삭제
    @PostMapping("/del")
    public String del(){

        return "redirect:/notice/list";
    }

}
