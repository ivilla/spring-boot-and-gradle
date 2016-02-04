package org.ivan.villa.repository;

import java.util.List;
import org.ivan.villa.model.TestStep;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestStepRepository extends CrudRepository<TestStep, Long>{
  @Query("select t from TestStep t")
  public List<TestStep> getAll();

}
