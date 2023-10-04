package com.example.demo.src.file.Service;

import com.example.demo.src.file.Repository.WorkRepository;
import com.example.demo.src.file.Repository.WorkerRepository;
import com.example.demo.src.file.domain.Workers;
import com.example.demo.src.file.domain.Works;
import com.example.demo.src.file.vo.WorkResponse;
import com.example.demo.src.file.vo.WorkerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WorkService {

private WorkerRepository workerRepository;
private WorkRepository workRepository;
    public List<WorkResponse> workList(Long userId,Long teamId){
        List<Works> workList=workerRepository.findAllByUserIdAndTeamId(userId,teamId);


        return workList.stream()
                .map(work-> WorkResponse
                        .builder()
                        .workId(work.getId())
                        .workName(work.getWorkName())
                        .build())
                .collect(Collectors.toList());
    }

    public WorkerResponse findByUsersIdAndWorksId(Long userId, Long workId){
        Workers workers=workerRepository.findByUsersIdAndWorksId(userId,workId);
        WorkerResponse workerResponse=new WorkerResponse();
        workerResponse.setWriteYn(workers.getWriteYn());
        return workerResponse;
    }
    public void setTrue(Long userId, Long workId){
        Workers workers=workerRepository.findByUsersIdAndWorksId(userId,workId);
        workers.setWriteYn(true);
        workerRepository.save(workers);
    }
    public void updateWork(WorkResponse workResponse){
        Works works=workRepository.findWorkById(workResponse.getId());
        works.setStatus(workResponse.getStatus());
        workRepository.save(works);
    }

    public static Works toEntity(WorkResponse workResponse) {
        return  Works.builder()
                .teamId(workResponse.getTeamId())
                .workName(workResponse.getWorkName())
                .importance(workResponse.getImportance())
                .status(workResponse.getStatus())
                .workerNumber(workResponse.getWorkerNumber())
                .endDate(workResponse.getEndDate())
                .build();
    }

    public List<WorkResponse> findWorksByTeamId(Long teamId){
        List<Works> results=workRepository.findWorksByTeamId(teamId);
        return results.stream()
                .map(result -> {
                    Works works=  result;
                    WorkResponse response = WorkResponse.from(works);
                    return response;
                })
                .collect(Collectors.toList());
    }
    public WorkResponse findWorkById(Long workId){
        Works works=workRepository.findWorkById(workId);
        WorkResponse response = WorkResponse.from(works);
        return response;
    }


}
