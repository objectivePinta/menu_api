package com.objective.payntza.attractions.repositories;

import com.objective.payntza.attractions.model.Attraction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "attractions", path = "attractions")
public interface AttractionRepository extends CrudRepository<Attraction, Long> {

    List<Attraction> findAll();
}
