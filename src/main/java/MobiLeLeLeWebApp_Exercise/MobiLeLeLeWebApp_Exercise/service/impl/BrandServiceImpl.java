package MobiLeLeLeWebApp_Exercise.MobiLeLeLeWebApp_Exercise.service.impl;

import MobiLeLeLeWebApp_Exercise.MobiLeLeLeWebApp_Exercise.model.entities.*;
import MobiLeLeLeWebApp_Exercise.MobiLeLeLeWebApp_Exercise.model.view.*;
import MobiLeLeLeWebApp_Exercise.MobiLeLeLeWebApp_Exercise.repository.ModelRepository;
import MobiLeLeLeWebApp_Exercise.MobiLeLeLeWebApp_Exercise.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BrandServiceImpl implements BrandService {
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(ModelRepository modelRepository,
                            ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BrandViewModel> getAllBrands() {
        List<BrandViewModel> result = new ArrayList<>();// <- final result here

        List<Model> allModels = modelRepository.findAll();

        allModels.forEach(model -> {
            Brand brandEntity = model.getBrand();

            Optional<BrandViewModel> brandViewModelOptimal = findByName(result,
                    brandEntity.getName());

            if (!brandViewModelOptimal.isPresent()) {
                //Model is not yet in the result, so we will create a new model
                BrandViewModel newBrandViewModel = new BrandViewModel();


                modelMapper.map(brandEntity, newBrandViewModel);
                result.add(newBrandViewModel);
                brandViewModelOptimal = Optional.of(newBrandViewModel);
            }

            ModelViewModel newModelViewModel = new ModelViewModel();
            modelMapper.map(model, newModelViewModel);
            brandViewModelOptimal.get().addModel(newModelViewModel);
        });

        return result;
    }

    private static Optional<BrandViewModel> findByName(List<BrandViewModel> allModels, String brandName) {
        return allModels.stream()
                .filter(model -> model.getName().equals(brandName))
                .findAny();
    }
}
