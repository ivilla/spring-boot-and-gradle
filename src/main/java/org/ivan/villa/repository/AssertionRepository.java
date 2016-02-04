package org.ivan.villa.repository;

import java.util.List;
import org.ivan.villa.model.Assertion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssertionRepository extends CrudRepository<Assertion, Long>{
  @Query("select t from Assertion t")
  public List<Assertion> getAll();

}
