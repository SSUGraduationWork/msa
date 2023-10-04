package com.example.demo.src.file.client;

import com.example.demo.src.file.vo.MemberDto;
import com.example.demo.src.file.vo.TeamMemberResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="team-service" )
public interface TeamServiceClient {

    @GetMapping("/team-service/teammember/member/{teamId}")
    List<MemberDto> findTeamById(@PathVariable Long teamId);

    @GetMapping("/team-service/teammember/{teamId}/{memberId}")
    TeamMemberResponse findByTeamsIdAndUsersId(@PathVariable Long teamId,@PathVariable Long memberId);

    @PostMapping("/team-service/teammember/add/contribution")
    void addContribution(@RequestBody TeamMemberResponse teamMemberResponse);
}
