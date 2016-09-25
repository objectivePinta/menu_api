package com.objective.payntza.attractions.controller;

import com.objective.payntza.attractions.model.Attraction;
import com.objective.payntza.attractions.repositories.AttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/attractions")
public class AttractionController {

    @Autowired
    AttractionRepository attractionRepository;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Attraction> getAll() {
      return  attractionRepository.findAll();
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public void saveNewAttraction(@RequestBody Attraction attraction) {
        attractionRepository.save(attraction);
    }


    @RequestMapping(value = "call",method = RequestMethod.GET)
    public void call() {
        System.out.println("Hello");
    }

    public void callHello() {
        restTemplate.getForObject("http://localhost:8080/attractions/call",null);
    }
}
