package com.example.demo.src.file.vo;


import com.example.demo.src.file.domain.Works;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WorkResponse {

    private Long id;
    private Long teamId;
    private String workName;
    private Integer importance;
    private Integer status;
    private Integer workerNumber;
    private boolean delYn;
    private LocalDateTime endDate;

    public WorkResponse() {
        // 기본 생성자 내용 (선택적)
    }

    @Builder
    public WorkResponse(Long workId,Long teamId,String workName,Integer importance, Integer status,Integer workerNumber,boolean delYn,LocalDateTime endDate){
        this.id=workId;
        this.teamId=teamId;
        this.workName=workName;
        this.importance=importance;
        this.status=status;
        this.workerNumber=workerNumber;
        this.delYn=delYn;
        this.endDate=endDate;
    }

    public static WorkResponse from(Works works) {
        return WorkResponse.builder()
                .workId(works.getId())
                .workName(works.getWorkName())
                .teamId(works.getTeamId())
                .importance(works.getImportance())
                .status(works.getStatus())
                .workerNumber(works.getWorkerNumber())
                .delYn(works.isDelYn())
                .endDate(works.getEndDate())
                .build();
    }


}
