package org.ivan.villa.repository;

import java.util.List;
import org.ivan.villa.model.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{

  @Query("SELECT p FROM Project p")
  public List<Project> getAll();

  @Query("SELECT p FROM Project p WHERE p.id = :projectId")
  public Project getProjectById(@Param("projectId") Long projectId);

  @Query("SELECT p FROM Project p WHERE p.startTimestamp BETWEEN :start AND :end")
  public List<Project> getProjectsByDates(@Param("start") Date start, @Param("end") Date end);


}
