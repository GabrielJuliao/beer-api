package com.gabrieljuliao.beerapi.mapper;

import com.gabrieljuliao.beerapi.dto.BeerDTO;
import com.gabrieljuliao.beerapi.model.Beer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BeerMapper {

    BeerMapper INSTANCE = Mappers.getMapper(BeerMapper.class);

    Beer toModel(BeerDTO beerDTO);

    BeerDTO toDTO(Beer beer);
}
