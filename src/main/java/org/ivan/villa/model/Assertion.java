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

import org.ivan.villa.model.TestStep;

/*
* Ivan Villa
*/

@Entity
@Table(name = "Assertion")
public class Assertion{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @NotNull
  private String name;
  @NotNull
  private String message;
  @NotNull
  private Boolean passed;
  @NotNull
  private Integer assertionItems;
  @NotNull
  private Integer assertionFails;
  @NotNull
  private Integer relevance;
  @NotNull
  private Double score;

  @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
  @JoinColumn (name="testStepId",referencedColumnName="id",nullable=true,unique=false)
  private TestStep testStep;



  public void setName(String name){
    this.name = name;
  }

  public String getName(){
    return name;
  }

  public void setMessage(String message){
    this.message = message;
  }

  public String getMessage(){
    return message;
  }

  public void setPassed(Boolean passed){
    this.passed = passed;
  }

  public Boolean getPassed(){
    return passed;
  }

  public void setAssertionItems(Integer assertionItems){
    this.assertionItems = assertionItems;
  }

  public Integer getAssertionItems(){
    return assertionItems;
  }

  public void setAssertionFails(Integer assertionFails){
    this.assertionFails = assertionFails;
  }

  public Integer getAssertionFails(){
    return assertionFails;
  }

  public void setRelevance(Integer relevance){
    this.relevance = relevance;
  }

  public Integer getRelevance(){
    return relevance;
  }

  public void setScore(Double score){
    this.score = score;
  }

  public Double getScore(){
    return score;
  }

  public void setTestStep(TestStep testStep){
    this.testStep = testStep;
  }
  @JsonIgnore
  public TestStep getTestStep(){
    return testStep;
  }


}
