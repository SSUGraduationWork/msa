package com.example.demo.src.file.Repository;



import com.example.demo.src.file.domain.Works;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WorkRepository extends JpaRepository<Works,Long> {
    @Query("SELECT w FROM Works w WHERE w.id = :workId")
    Works findWorkById(@Param("workId") Long workId);

    @Query("SELECT w FROM Works w WHERE w.teamId = :teamId")
    List<Works> findWorksByTeamId(@Param("teamId") Long teamId);
}
