package com.example.demo.src.file.controller;


import com.example.demo.src.file.Service.WorkService;
import com.example.demo.src.file.common.CommonCode;
import com.example.demo.src.file.common.Response;
import com.example.demo.src.file.vo.WorkResponse;
import com.example.demo.src.file.vo.WorkerResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
//@CrossOrigin(origins="http://localhost:8081")
@RequestMapping("/work-service")
public class WorkController {
    private final WorkService workService;

    //게시글 리스트+페이징 추후 필요+정렬 필요
    @GetMapping("/work/list/{memberId}/{teamId}")
    public ResponseEntity<List<WorkResponse>> boardList(
            @PathVariable("memberId") Long memberId,
            @PathVariable("teamId") Long teamId){

        return ResponseEntity.ok( workService.workList(memberId,teamId));
    }

    @GetMapping("/work/find/{memberId}/{workId}")
    public  ResponseEntity<WorkerResponse> findByUsersIdAndWorksId( @PathVariable("memberId") Long memberId,
                                                             @PathVariable("workId") Long workId){
        return ResponseEntity.ok( workService.findByUsersIdAndWorksId(memberId,workId));
    }

    @GetMapping("/work/find/{workId}")
    public  ResponseEntity<WorkResponse> findWorkById(@PathVariable Long workId){
        return ResponseEntity.ok( workService.findWorkById(workId));
    }

    @PostMapping("/work/setTrue/{memberId}/{workId}")
    public void setTrue(@PathVariable("memberId") Long memberId,
                                              @PathVariable("workId") Long workId){
         workService.setTrue(memberId,workId);
    }
    @PostMapping("/work/set")
    void updateWork(@RequestBody  WorkResponse workResponse){
        workService.updateWork(workResponse);
    }

    @GetMapping("/worklist/{teamId}")
    public ResponseEntity<List<WorkResponse>> findWorksByTeamId( @PathVariable("teamId") Long teamId){

        return ResponseEntity.ok( workService.findWorksByTeamId(teamId));
    }
}
