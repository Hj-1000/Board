package com.example.boardproj.service;

import com.example.boardproj.dto.ReplyDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class ReplyServiceImplTest {

    @Autowired
    ReplyService replyService;

    @Test
    public void listpageTestttt(){
        Long bno = 1L;
        Pageable pageable = PageRequest.of(0,10);

        Page<ReplyDTO> replyDTOPage =
                replyService.listPage(bno, pageable);

        log.info(replyDTOPage.getTotalPages());
        log.info(replyDTOPage.getTotalElements());
        log.info(replyDTOPage.getContent());

//        Model model= null;
//        model.addAttribute("count", replyDTOPage.getTotalElements());
//        model.addAttribute("dtoList", replyDTOPage.getContent());
//        model.addAttribute("page", ??);
//        model.addAttribute("size", ??);




    }

    @Test
    public void updatedelTest(){
        // 1번 수정 및 지울예정

//        ReplyDTO replyDTO =
//                new ReplyDTO();
//        replyDTO.setRno(1L);
//        replyDTO.setReplyText("이걸로수정할래");
//
//        ReplyDTO replyDTO1 =
//                replyService.update(replyDTO);
//        log.info("수정이후 결과" + replyDTO1);
//
    }

    @Test
    public void listTest(){
//        List<ReplyDTO> replyDTOList =
////        replyService.list(5L);
//
//        replyDTOList.forEach(replyDTO -> log.info(replyDTO));
    }


    @Test
    public void registerTest(){
        // 입력하고 싶어요
        ReplyDTO replyDTO = new ReplyDTO();

        replyDTO.setReplyText("두번다는 댓글");
        replyDTO.setWriter("신형만");
        // 두가지 값만 넘어온다.
        // 그리고 어디에 달리는 댓글인지
        // 부모가 누구인지
        replyDTO.setBno(2L);

        try {
            replyService.register(replyDTO);

        }catch (EntityNotFoundException e){
            log.info("랄랄라");
        }
    }



}