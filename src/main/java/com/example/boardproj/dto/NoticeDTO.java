package com.example.boardproj.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NoticeDTO {

    private Long nno;

    @NotNull(message = "빈칸은 사용할 수 없습니다.")
    @Size(min = 2, max = 50, message = "글자수는 2 ~ 50글자 사이입니다.")
    private String title;

    private String content;

    private String writer;

    private LocalDate regdate;

    private LocalDate updatedate;



}
