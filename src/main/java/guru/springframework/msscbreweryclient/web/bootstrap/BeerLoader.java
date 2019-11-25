package guru.springframework.msscbreweryclient.web.bootstrap;

import guru.springframework.msscbreweryclient.web.domain.Beer;
import guru.springframework.msscbreweryclient.web.repositories.BeerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Slf4j
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .upc(1288378127L)
                    .minOnHand(12)
                    .price(new BigDecimal("12.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("Pale Ale")
                    .quantityToBrew(200)
                    .upc(1288312312L)
                    .minOnHand(12)
                    .price(new BigDecimal("8.95"))
                    .build());
        }
        log.info("Loaded Beers: {}", beerRepository.count());
    }


}
