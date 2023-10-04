package com.example.demo.src.file.dto.response;


import com.example.demo.src.file.vo.MemberDto;
import lombok.Builder;
import lombok.Data;


@Data
public class BoardMemberResponse {


    private Long userId;
    private String writerName;
    private String pictureUrl;
    private Integer studentNumber;
    @Builder
    public BoardMemberResponse (Long userId, String writerName,String pictureUrl,Integer studentNumber){
        this.userId=userId;
        this.writerName=writerName;
        this.pictureUrl=pictureUrl;
        this.studentNumber=studentNumber;
    }

    public static BoardMemberResponse  from(MemberDto memberDto) {
        return BoardMemberResponse .builder()
                .userId(memberDto.getId())
                .writerName(memberDto.getName())
                .pictureUrl(memberDto.getPictureUrl())
                .studentNumber(memberDto.getStudentNumber())
                .build();
    }

}