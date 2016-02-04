package org.ivan.villa.repository;

import java.util.List;
import org.ivan.villa.model.TestCase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCaseRepository extends CrudRepository<TestCase, Long>{
  @Query("select t from TestCase t")
  public List<TestCase> getAll();

}
