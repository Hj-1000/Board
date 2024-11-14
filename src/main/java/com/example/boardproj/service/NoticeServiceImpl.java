package com.example.boardproj.service;

import com.example.boardproj.config.CustomModelMapper;
import com.example.boardproj.dto.NoticeDTO;
import com.example.boardproj.entity.Notice;
import com.example.boardproj.repository.NoticeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.codehaus.groovy.classgen.FinalVariableAnalyzer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class NoticeServiceImpl implements NoticeService{

    private final NoticeRepository noticeRepository;
    private ModelMapper modelMapper = new ModelMapper();


    @Override
    public void register(NoticeDTO noticeDTO) {
        log.info("컨트롤러로 들어온 글등록" + noticeDTO);
        Notice notice =
        modelMapper.map(noticeDTO, Notice.class);


        noticeRepository.save(notice);

    }

    @Override
    public NoticeDTO read(Long nno) {
        Optional<Notice> optionalNotice =
        noticeRepository.findById(nno);
        //예외처리
        Notice notice =
        optionalNotice.orElseThrow(EntityNotFoundException::new);

        NoticeDTO noticeDTO =
        modelMapper.map(notice, NoticeDTO.class);



        return noticeDTO;
    }

    @Override
    public List<NoticeDTO> list() {

        List<Notice> noticeList =
        noticeRepository.findAll();

        List<NoticeDTO> noticeDTOList =
        noticeList.stream().map(notice -> modelMapper.map(notice, NoticeDTO.class))
                .collect(Collectors.toList());

        return noticeDTOList;
    }

    @Override
    public void update(NoticeDTO noticeDTO) {
        Optional<Notice> optionalNotice =
        noticeRepository.findById(noticeDTO.getNno());

        Notice notice =
        optionalNotice.orElseThrow(EntityNotFoundException::new);

        notice.setTitle(noticeDTO.getTitle());
        notice.setContent(noticeDTO.getContent());

    }

    @Override
    public void del(Long nno) {

        noticeRepository.deleteById(nno);

    }
}
