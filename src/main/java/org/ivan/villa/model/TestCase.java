package org.ivan.villa.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.ivan.villa.model.Project;
import org.ivan.villa.model.TestStep;

/*
* Ivan Villa
*/

@Entity
@Table(name = "TestCase")
public class TestCase{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NotNull
  @Column(name = "testCaseName")
  private String testCaseName;

  @NotNull
  @Column(name = "testCaseId")
  private String testCaseId;
  @NotNull
  @Column(name = "testCaseStartTimeStamp")
  private Date testCaseStartTimeStamp;

  @NotNull
  @Column(name = "testCaseEndTimeStamp")
  private Date testCaseEndTimeStamp;

  @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
  @JoinColumn (name="projectId",referencedColumnName="id",nullable=true,unique=false)
  private Project project;

  @Column(name = "testStep")
  @OneToMany(fetch=FetchType.LAZY, mappedBy="testCase", targetEntity=TestStep.class, cascade=CascadeType.ALL)
  private Set<TestStep> testSteps = new HashSet<TestStep>();


  public void setTestCaseName(String testCaseName){
    this.testCaseName = testCaseName;
  }

  public String getTestCaseName(){
    return testCaseName;
  }

  public void setTestCaseId(String testCaseId){
    this.testCaseId = testCaseId;
  }

  public String getTestCaseId(){
    return testCaseId;
  }

  public void setTestCaseStartTimeStamp(Date testCaseStartTimeStamp){
    this.testCaseStartTimeStamp = testCaseStartTimeStamp;
  }

  public Date getTestCaseStartTimeStamp(){
    return testCaseStartTimeStamp;
  }

  public void setTestCaseEndTimeStamp(Date testCaseEndTimeStamp){
    this.testCaseEndTimeStamp = testCaseEndTimeStamp;
  }

  public Date getTestCaseEndTimeStamp(){
    return testCaseEndTimeStamp;
  }

  public void setProject(Project project){
    this.project = project;
  }
  @JsonIgnore
  public Project getProject(){
    return project;
  }

  public void setTestSteps(Set<TestStep> testSteps){
    this.testSteps = testSteps;
  }

  public Set<TestStep> getTestSteps(){
    return testSteps;
  }

}
