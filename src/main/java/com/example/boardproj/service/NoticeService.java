package com.example.boardproj.service;

import com.example.boardproj.dto.NoticeDTO;

import java.util.List;

public interface NoticeService {
    //등록
    public void register(NoticeDTO noticeDTO);
    //읽기
    public NoticeDTO read(Long nno);
    //목록
    public List<NoticeDTO> list();

    //수정
    public void update(NoticeDTO noticeDTO);
    //삭제
    public void del(Long nno);
}
