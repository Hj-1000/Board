package com.example.boardproj.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;
    @Email
    @Column(length = 50, nullable = false)
    private String email;
    @Column(length = 16, nullable = false)
    private String password;
    @Column(length = 50, nullable = false)
    private String mname;
    @Column(length = 50)
    private String address;
}
