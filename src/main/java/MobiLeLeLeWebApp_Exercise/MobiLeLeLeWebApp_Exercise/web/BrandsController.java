package MobiLeLeLeWebApp_Exercise.MobiLeLeLeWebApp_Exercise.web;


import MobiLeLeLeWebApp_Exercise.MobiLeLeLeWebApp_Exercise.service.BrandService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/brands")
public class BrandsController {
    private final BrandService brandService;

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public String allBrands(Model model) {
        model.addAttribute("brands", this.brandService.getAllBrands());
        return "brands";
    }
}
