package org.ivan.villa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

import org.ivan.villa.model.Project;
import org.ivan.villa.repository.ProjectRepository;
import org.ivan.villa.util.Util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;


@RestController
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    private static final Logger logger = LogManager.getLogger(ProjectController.class);
    private Util util = new Util();


    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/project/{projectId}", method=RequestMethod.GET)
    public Project getProjectById(@PathVariable Long projectId){
      try{
        logger.info("....... Getting project ... ["+ projectId+"]");
        Project project = new Project();
        project = projectRepository.getProjectById(projectId);
        return project;
      } catch(Exception e) {
        logger.error(e);
        return null;
      }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/project/", method=RequestMethod.GET)
    public List<Project> getAllToday(){
      try{
        logger.info("....... Getting projects from today" );
        List<Project> results = new ArrayList<Project>();
        Date from = util.getTodayFirstHour();
        Date to = util.getTodayLastHour();
        results.addAll(projectRepository.getProjectsByDates(from, to));
        logger.info("....... Results found:  " + results.size());
        return results;
      } catch(Exception e) {
        logger.error(e);
        return null;
      }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/project", method=RequestMethod.GET)
    public List<Project> getProjectByDates(@RequestParam("startDate") String startDate,
                                           @RequestParam("endDate") String endDate){
      try{
        logger.info("....... Getting projects from: [ " + startDate + " ] to: [ " + endDate + " ]" );
        List<Project> results = new ArrayList<Project>();
        Date from = util.setFirstHour(startDate);
        Date to = util.setLastHour(endDate);
        results.addAll(projectRepository.getProjectsByDates(from, to));
        logger.info("....... Results found:  " + results.size());
        return results;
      } catch(Exception e) {
        logger.error(e);
        return null;
      }
    }

    //@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/project/", method=RequestMethod.POST)
    public ResponseEntity<Project> InsertProjectResult(@RequestBody Project project){
      try{
        if(project != null){
          logger.info("Project: " + project.getExecutionId());
        } else {
          logger.info("naranjas :");
        }
        return new ResponseEntity<Project>(project, HttpStatus.OK);
      } catch(Exception e) {
        logger.error(e);
        return null;
      }
    }

}
