package com.example.demo.src.file.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class MemberDto {

    private Long id;
    private Integer studentNumber;
    private String name;
    private String pictureUrl;

    public MemberDto(){

    }
}

