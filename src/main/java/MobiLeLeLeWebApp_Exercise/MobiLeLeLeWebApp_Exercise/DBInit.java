package MobiLeLeLeWebApp_Exercise.MobiLeLeLeWebApp_Exercise;

import MobiLeLeLeWebApp_Exercise.MobiLeLeLeWebApp_Exercise.model.entities.*;
import MobiLeLeLeWebApp_Exercise.MobiLeLeLeWebApp_Exercise.model.entities.enums.*;
import MobiLeLeLeWebApp_Exercise.MobiLeLeLeWebApp_Exercise.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final OfferRepository offerRepository;

    public DBInit(ModelRepository modelRepository, BrandRepository brandRepository,
                  OfferRepository offerRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.offerRepository = offerRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Brand fordBrand = new Brand();
        fordBrand.setName("Ford");

        Brand hondaBrand = new Brand();
        hondaBrand.setName("Honda");

        brandRepository.saveAll(List.of(fordBrand, hondaBrand));

        Model fiestaModel = initFiesta(fordBrand);

        initEscort(fordBrand);
        initNC750S(hondaBrand);

        createFiestaOffer(fiestaModel);

    }

    private void createFiestaOffer(Model fiestaModel) {
        Offer fiestaOffer = new Offer();

        fiestaOffer.setEngine(Engine.GASOLINE);
        fiestaOffer.setImageUrl("https://media.autoexpress.co.uk/image/private/s--7btEt2wi--/v1562244788/autoexpress/2017/07/dsc_1328-1.jpg");
        fiestaOffer.setMileAge(40000);
        fiestaOffer.setPrice(BigDecimal.valueOf(10000));
        fiestaOffer.setYear(2019);
        fiestaOffer.setDescription("Driven by an old grandma. It stayed in the garage in the winter.");
        fiestaOffer.setTransmission(Transmission.MANUAL);
        fiestaOffer.setModel(fiestaModel);

        offerRepository.save(fiestaOffer);
    }

    private Model initNC750S(Brand hondaBrand) {
        Model nc750s = new Model();

        nc750s.setName("NC750S");
        nc750s.setCategory(Category.MOTORCYCLE);
        nc750s.setImageUrl("https://www.m50honda.ie/wp-content/uploads/2018/04/118747_NC750S-1.jpg");
        nc750s.setStartYear(2014);
        nc750s.setBrand(hondaBrand);

        return modelRepository.save(nc750s);
    }

    private Model initEscort(Brand fordBrand) {
        Model escort = new Model();

        escort.setName("Escort");
        escort.setCategory(Category.CAR);
        escort.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/Ford_Escort_MkI_1100_1972.JPG/1920px-Ford_Escort_MkI_1100_1972.JPG");
        escort.setStartYear(1968);
        escort.setEndYear(2002);
        escort.setBrand(fordBrand);

        return modelRepository.save(escort);
    }

    private Model initFiesta(Brand fordBrand) {
        Model fiesta = new Model();

        fiesta.setName("Fiesta");
        fiesta.setCategory(Category.CAR);
        fiesta.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg/420px-2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg");
        fiesta.setStartYear(1976);
        fiesta.setBrand(fordBrand);

        return modelRepository.save(fiesta);
    }
}
