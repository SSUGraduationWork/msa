package com.example.demo.src.file.domain;

import com.example.demo.src.file.WorkTimeEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Setter
@Table(name ="Works")
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Works extends WorkTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_id")
    private Long id;


    @Column(name = "team_id", nullable = false)
    private Long teamId;

    @Column(name = "work_name", length = 50)
    private String workName;



    @Column(name = "importance")
    private Integer importance;

    @Column(name = "status")
    private Integer status;

    @Column(name = "worker_number")
    private Integer workerNumber;

    //추후 삭제
    @Column(name = "del_yn")
    private boolean delYn;

    @CreatedDate
    @Column(name = "end_date", updatable = false)
    private LocalDateTime endDate;

    @JsonIgnore
    @OneToMany(mappedBy = "works", cascade = ALL, orphanRemoval = true)
    private List<Workers> workersList = new ArrayList<>();


    @Builder
    public Works(Long teamId,String workName,Integer importance, Integer status,Integer workerNumber,LocalDateTime endDate){
        this.teamId=teamId;
        this.workName=workName;
        this.importance=importance;
        this.status=status;
        this.workerNumber=workerNumber;
        this.endDate=endDate;
    }

}
