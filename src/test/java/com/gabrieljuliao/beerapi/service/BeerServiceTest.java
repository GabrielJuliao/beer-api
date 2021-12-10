package com.gabrieljuliao.beerapi.service;

import com.gabrieljuliao.beerapi.builder.BeerDTOBuilder;
import com.gabrieljuliao.beerapi.dto.BeerDTO;
import com.gabrieljuliao.beerapi.exception.BeerAlreadyRegisteredException;
import com.gabrieljuliao.beerapi.mapper.BeerMapper;
import com.gabrieljuliao.beerapi.model.Beer;
import com.gabrieljuliao.beerapi.repository.BeerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BeerServiceTest {
    private final static Long INVALID_BEER_ID = 1L;

    @Mock
    private BeerRepository beerRepository;

    @InjectMocks
    private BeerService beerService;

    private BeerMapper beerMapper = BeerMapper.INSTANCE;

    @Test
    void whenBeerIsInformedThenItShouldBeCreated() throws BeerAlreadyRegisteredException {
//        given
        BeerDTO expectedBeerDTO = BeerDTOBuilder.builder().build().toBeerDTO();
        Beer expectedSavedBeer = beerMapper.toModel(expectedBeerDTO);

//        when
        Mockito.when(beerRepository.findByName(expectedBeerDTO.getName())).thenReturn(Optional.empty());
        Mockito.when(beerRepository.save(expectedSavedBeer)).thenReturn(expectedSavedBeer);

//        then
        BeerDTO createdBeerDTO = beerService.createBeer(expectedBeerDTO);

        assertThat(createdBeerDTO.getId(), is(equalTo(expectedBeerDTO.getId())));
        assertThat(createdBeerDTO.getName(), is(equalTo(expectedBeerDTO.getName())));
        assertThat(createdBeerDTO.getQuantity(), is(equalTo(expectedBeerDTO.getQuantity())));
    }
}
