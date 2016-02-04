package org.ivan.villa;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;

import spock.lang.AutoCleanup;
import spock.lang.Shared;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.ivan.villa.repository.*;
import org.ivan.villa.model.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = VillaTestResultsApplication.class)
@WebAppConfiguration
public class PopulateTablesTest {

    @Shared
    @AutoCleanup
    ConfigurableApplicationContext context;

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    TestCaseRepository testCaseRepository;
    @Autowired
    TestStepRepository testStepRepository;
    @Autowired
    AssertionRepository assertionRepository;

    private static final Logger logger = LogManager.getLogger(PopulateTablesTest.class);

    @Ignore
    @Test
    public void populateQATables() {

      System.out.println("+++++ Armando projecto 01 Metatada...");

          Project project = new Project();
              project.setName("P01 Metadata");
              project.setStartTimestamp(new Date());
              project.setEndTimestamp(new Date());
              project.setExecutionId("12345-12345-123345-123456-1234567");
              project.setFullTimeInMilis(10000d);

              TestCase testCase1 = new TestCase();
                  testCase1.setTestCaseName("100 Routes Loop - OW");
                  testCase1.setTestCaseId("ACA_MEX-2015-06-23 A1_C0_I2_PH1_PC0");
                  testCase1.setTestCaseStartTimeStamp(new Date());
                  testCase1.setTestCaseEndTimeStamp(new Date());
                  testCase1.setProject(project);
              TestCase testCase2 = new TestCase();
                  testCase2.setTestCaseName("100 Routes Loop - OW2");
                  testCase2.setTestCaseId("MEX-ACA-2015-06-24 A1_C0_I2_PH1_PC0");
                  testCase2.setTestCaseStartTimeStamp(new Date());
                  testCase2.setTestCaseEndTimeStamp(new Date());
                  testCase2.setProject(project);

          project.getTestCases().add(testCase1);
          project.getTestCases().add(testCase2);

                  TestStep testStep1 = new TestStep();
                      testStep1.setTestStepName("Best Fares RQ");
                      testStep1.setStartTimeStamp(new Date());
                      testStep1.setEndTimeStamp(new Date());
                      testStep1.setStatusCode(200);
                      testStep1.setTestCase(testCase1);
                  TestStep testStep2 = new TestStep();
                      testStep2.setTestStepName("Fare Details RQ");
                      testStep2.setStartTimeStamp(new Date());
                      testStep2.setEndTimeStamp(new Date());
                      testStep2.setStatusCode(500);
                      testStep2.setTestCase(testCase1);
                  TestStep testStep3 = new TestStep();
                      testStep3.setTestStepName("Best Fares RQ");
                      testStep3.setStartTimeStamp(new Date());
                      testStep3.setEndTimeStamp(new Date());
                      testStep3.setStatusCode(200);
                      testStep3.setTestCase(testCase2);
                  TestStep testStep4 = new TestStep();
                      testStep4.setTestStepName("Fare Details RQ");
                      testStep4.setStartTimeStamp(new Date());
                      testStep4.setEndTimeStamp(new Date());
                      testStep4.setStatusCode(404);
                      testStep4.setTestCase(testCase2);

              testCase1.getTestSteps().add(testStep1);
              testCase1.getTestSteps().add(testStep2);
              testCase2.getTestSteps().add(testStep3);
              testCase2.getTestSteps().add(testStep4);

                      Assertion assertion1 = new Assertion();
                          assertion1.setName("shouldHaveValidStatusCode");
                          assertion1.setMessage("Response status code [200] is correct");
                          assertion1.setPassed(true);
                          assertion1.setAssertionItems(23);
                          assertion1.setAssertionFails(0);
                          assertion1.setRelevance(10);
                          assertion1.setScore(999d);
                          assertion1.setTestStep(testStep1);
                      Assertion assertion2 = new Assertion();
                          assertion2.setName("shouldHaveValidSchema");
                          assertion2.setMessage("Schema matched correctly ¡Congratulations!");
                          assertion2.setPassed(true);
                          assertion2.setAssertionItems(2);
                          assertion2.setAssertionFails(0);
                          assertion2.setRelevance(10);
                          assertion2.setScore(10000d);
                          assertion2.setTestStep(testStep1);
                      Assertion assertion3 = new Assertion();
                          assertion3.setName("shouldHaveValidStatusCode");
                          assertion3.setMessage("Response status code:500 is not in acceptable list of status code");
                          assertion3.setPassed(false);
                          assertion3.setAssertionItems(23);
                          assertion3.setAssertionFails(23);
                          assertion3.setRelevance(10);
                          assertion3.setScore(0000d);
                          assertion3.setTestStep(testStep2);
                      Assertion assertion4 = new Assertion();
                          assertion4.setName("shouldHaveValidSchema");
                          assertion4.setMessage("Schema does not Match, this is terrible! (flanders scream)");
                          assertion4.setPassed(false);
                          assertion4.setAssertionItems(23);
                          assertion4.setAssertionFails(23);
                          assertion4.setRelevance(10);
                          assertion4.setScore(0000d);
                          assertion4.setTestStep(testStep2);
                      Assertion assertion5 = new Assertion();
                          assertion5.setName("shouldHaveValidStatusCode");
                          assertion5.setMessage("Response status code [200] is correct");
                          assertion5.setPassed(true);
                          assertion5.setAssertionItems(23);
                          assertion5.setAssertionFails(0);
                          assertion5.setRelevance(10);
                          assertion5.setScore(999d);
                          assertion5.setTestStep(testStep3);
                      Assertion assertion6 = new Assertion();
                          assertion6.setName("shouldHaveValidSchema");
                          assertion6.setMessage("Schema matched correctly ¡Congratulations!");
                          assertion6.setPassed(true);
                          assertion6.setAssertionItems(23);
                          assertion6.setAssertionFails(0);
                          assertion6.setRelevance(10);
                          assertion6.setScore(9999d);
                          assertion6.setTestStep(testStep3);
                      Assertion assertion7 = new Assertion();
                          assertion7.setName("shouldHaveValidStatusCode");
                          assertion7.setMessage("Response status code:404 is not in acceptable list of status code");
                          assertion7.setPassed(false);
                          assertion7.setAssertionItems(23);
                          assertion7.setAssertionFails(23);
                          assertion7.setRelevance(10);
                          assertion7.setScore(0000d);
                          assertion7.setTestStep(testStep4);
                      Assertion assertion8 = new Assertion();
                          assertion8.setName("shouldHaveValidSchema");
                          assertion8.setMessage("Schema does not Match, this is terrible! (flanders scream)");
                          assertion8.setPassed(false);
                          assertion8.setAssertionItems(23);
                          assertion8.setAssertionFails(23);
                          assertion8.setRelevance(10);
                          assertion8.setScore(0000d);
                          assertion8.setTestStep(testStep4);

                  testStep1.getAssertions().add(assertion1);
                  testStep1.getAssertions().add(assertion2);
                  testStep2.getAssertions().add(assertion3);
                  testStep2.getAssertions().add(assertion4);
                  testStep3.getAssertions().add(assertion5);
                  testStep3.getAssertions().add(assertion6);
                  testStep4.getAssertions().add(assertion7);
                  testStep4.getAssertions().add(assertion8);


                  assertionRepository.save(assertion1);
                  assertionRepository.save(assertion2);
                  assertionRepository.save(assertion3);
                  assertionRepository.save(assertion4);
                  assertionRepository.save(assertion5);
                  assertionRepository.save(assertion6);
                  assertionRepository.save(assertion7);
                  assertionRepository.save(assertion8);

    }
    @Ignore
    @Test
    public void populateProjectTable() {
      logger.info("........ Populating Project Table...");

      Project project = new Project();
          project.setName("P01 Metadata");
          project.setStartTimestamp(new Date());
          project.setEndTimestamp(new Date());
          project.setExecutionId("12345-12345-123345-123456-1234567");
          project.setFullTimeInMilis(10000d);
          projectRepository.save(project);

    }

    @Ignore
    @Test
    public void populateTestCaseTable() {
      logger.info("........ Populating TestCase Table...");

      Project project = new Project();
          project.setName("P01 Metadata");
          project.setStartTimestamp(new Date());
          project.setEndTimestamp(new Date());
          project.setExecutionId("12345-12345-123345-123456-1234567");
          project.setFullTimeInMilis(10000d);
          //projectRepository.save(project);

      TestCase testCase1 = new TestCase();
          testCase1.setTestCaseName("100 Routes Loop - OW3");
          testCase1.setTestCaseId("ACA_MEX-2015-06-23 A1_C0_I2_PH1_PC0");
          testCase1.setTestCaseStartTimeStamp(new Date());
          testCase1.setTestCaseEndTimeStamp(new Date());
          //testCase1.setProject(project);

      TestCase testCase2 = new TestCase();
          testCase2.setTestCaseName("100 Routes Loop - OW4");
          testCase2.setTestCaseId("MEX-ACA-2015-06-24 A1_C0_I2_PH1_PC0");
          testCase2.setTestCaseStartTimeStamp(new Date());
          testCase2.setTestCaseEndTimeStamp(new Date());
          //testCase2.setProject(project);

          testCaseRepository.save(testCase1);
          testCaseRepository.save(testCase2);

    }

    //@Ignore
    @Test
    public void populateTestStepTable() {
      logger.info("........ Populating TestStep Table...");

      TestStep testStep1 = new TestStep();
          testStep1.setTestStepName("Best Fares RQ");
          testStep1.setStartTimeStamp(new Date());
          testStep1.setEndTimeStamp(new Date());
          testStep1.setStatusCode(200);

      TestStep testStep2 = new TestStep();
          testStep2.setTestStepName("Fare Details RQ");
          testStep2.setStartTimeStamp(new Date());
          testStep2.setEndTimeStamp(new Date());
          testStep2.setStatusCode(500);

          testStepRepository.save(testStep1);
          testStepRepository.save(testStep2);

    }

    @Ignore
    @Test
    public void populateAssertionTable() {
      logger.info("........ Populating Assertion Table...");

    }

}
