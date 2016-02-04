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

import org.ivan.villa.model.TestCase;
import org.ivan.villa.model.Assertion;

/*
* Ivan Villa
*/

@Entity
@Table(name = "TestStep")
public class TestStep{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NotNull
  @Column(name = "testStepName")
  private String testStepName;

  @NotNull
  @Column(name = "startTimeStamp")
  private Date startTimeStamp;

  @NotNull
  @Column(name = "endTimeStamp")
  private Date endTimeStamp;

  @NotNull
  @Column(name = "statusCode")
  private Integer statusCode;

  @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
  @JoinColumn (name="testCaseId",referencedColumnName="id",nullable=true,unique=false)
  private TestCase testCase;

  @Column(name = "assertion")
  @OneToMany(fetch=FetchType.LAZY, mappedBy="testStep", targetEntity=Assertion.class, cascade=CascadeType.ALL)
  private Set<Assertion> assertions = new HashSet<Assertion>();


  public void setTestStepName(String testStepName){
    this.testStepName = testStepName;
  }

  public String gettestStepName(){
    return testStepName;
  }

  public void setStartTimeStamp(Date startTimeStamp){
    this.startTimeStamp = startTimeStamp;
  }

  public Date getStartTimeStamp(){
    return startTimeStamp;
  }

  public void setEndTimeStamp(Date endTimeStamp){
    this.endTimeStamp = endTimeStamp;
  }

  public Date getEndTimeStamp(){
    return endTimeStamp;
  }

  public void setStatusCode(Integer statusCode){
    this.statusCode = statusCode;
  }

  public Integer getStatusCode(){
    return statusCode;
  }

  public void setTestCase(TestCase testCase){
    this.testCase = testCase;
  }
  @JsonIgnore
  public TestCase getTestCase(){
    return testCase;
  }

  public void setAssertions(Set<Assertion> assertions){
    this.assertions = assertions;
  }

  public Set<Assertion> getAssertions(){
    return assertions;
  }

}
