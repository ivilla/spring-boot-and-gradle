package org.ivan.villa.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.ivan.villa.model.TestCase;


/*
* Ivan Villa
*/

@Entity
@Table(name = "Project")
public class Project{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NotNull
  @Column(name = "name")
  private String name;

  @NotNull
  @Column(name = "startTimestamp")
  private Date startTimestamp;

  @NotNull
  @Column(name = "endTimestamp")
  private Date endTimestamp;

  @NotNull
  @Column(name = "executionId")
  private String executionId;

  @NotNull
  @Column(name = "fullTimeInMilis")
  private Double fullTimeInMilis;

  @Column(name = "testCase")
  @OneToMany(fetch=FetchType.LAZY, mappedBy="project", targetEntity=TestCase.class, cascade=CascadeType.ALL)
  private Set<TestCase> testCases = new HashSet<TestCase>();




  public void setName(String name){
    this.name = name;
  }

  public String getName(){
    return name;
  }

  public void setStartTimestamp(Date startTimestamp){
    this.startTimestamp = startTimestamp;
  }

  public Date getStartTimestamp(){
    return startTimestamp;
  }

  public void setEndTimestamp(Date endTimestamp){
    this.endTimestamp = endTimestamp;
  }

  public Date getEndTimestamp(){
    return endTimestamp;
  }

  public void setExecutionId(String executionId){
    this.executionId = executionId;
  }

  public String getExecutionId(){
    return executionId;
  }

  public void setFullTimeInMilis(Double fullTimeInMilis){
    this.fullTimeInMilis = fullTimeInMilis;
  }

  public Double getFullTimeInMilis(){
    return fullTimeInMilis;
  }

  public void setTestCases(Set<TestCase> testCases){
    this.testCases = testCases;
  }

  public Set<TestCase> getTestCases(){
    return testCases;
  }

}
