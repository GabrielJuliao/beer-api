package com.gabrieljuliao.beerapi.repository;

import com.gabrieljuliao.beerapi.model.Beer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BeerRepository extends CrudRepository<Beer, Long> {
    Optional<Beer> findByName(String name);
}
