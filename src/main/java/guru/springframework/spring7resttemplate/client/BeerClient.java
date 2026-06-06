package guru.springframework.spring7resttemplate.client;

import guru.springframework.spring7resttemplate.model.BeerDTO;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface BeerClient {

    Page<BeerDTO> listBeers(String beerName);

    BeerDTO getBeerById(UUID id);

    BeerDTO createBeer(BeerDTO newDTO);
}
