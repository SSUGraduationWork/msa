package com.example.demo.src.file.Repository;

import com.example.demo.src.file.domain.Workers;
import com.example.demo.src.file.domain.Works;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface WorkerRepository extends JpaRepository<Workers, Workers.WorkerId> {

    @Query("SELECT w.works FROM Workers w WHERE w.userId = :userId AND w.teamId = :teamId AND w.writeYn=false")
    List<Works> findAllByUserIdAndTeamId(@Param("userId") Long userId, @Param("teamId") Long teamId);

    @Query("SELECT w FROM Workers w WHERE w.userId = :userId AND w.works.id = :workId")
    Workers findByUsersIdAndWorksId(@Param("userId") Long userId, @Param("workId") Long workId);

}