package org.ivan.villa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RestController;
import org.ivan.villa.model.*;
import org.ivan.villa.repository.*;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@RestController
public class TestResultController {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    AssertionRepository assertionRepository;

    private static final Logger logger = LogManager.getLogger(TestResultController.class);

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/results")
    public List<Project> getAll(){
      try{
        logger.info("....... Getting all results... ");
        List<Project> results = new ArrayList<Project>();
        results.addAll(projectRepository.getAll());
        logger.info("....... Results found:  " + results.size());
        return results;
      } catch(Exception e) {
        logger.error(e);
        return null;
      }
    }


}
