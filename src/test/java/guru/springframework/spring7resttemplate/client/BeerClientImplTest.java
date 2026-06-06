package guru.springframework.spring7resttemplate.client;

import guru.springframework.spring7resttemplate.model.BeerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

import static guru.springframework.spring7resttemplate.model.BeerStyle.IPA;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BeerClientImplTest {

    @Autowired
    BeerClientImpl beerClient;

    @Test
    void testCreateBeer() {
        BeerDTO newDTO = BeerDTO.builder()
                .price(new BigDecimal("10.99"))
                .beerName("Mango Bobs")
                .beerStyle(IPA)
                .quantityOnHand(500)
                .upc("12345")
                .build();

        BeerDTO savedDTO = beerClient.createBeer(newDTO);
        assertNotNull(savedDTO);
    }

    @Test
    void getBeerById() {
        Page<BeerDTO> beerDTOs = beerClient.listBeers(null);

        BeerDTO dto = beerDTOs.getContent().get(0);
        BeerDTO byId = beerClient.getBeerById(dto.getId());

        assertNotNull(byId);
    }

    @Test
    void listBeersNoBeerName() {
        beerClient.listBeers(null);
    }

    @Test
    void listBeers() {
        beerClient.listBeers("ALE");
    }
}
