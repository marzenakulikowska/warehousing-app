package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class WarehousingFormController {
    private final CompanyRepository companyRepository;
    private final PaletteRepository paletteRepository;
    public WarehousingFormController(CompanyRepository companyRepository, PaletteRepository paletteRepository) {
        this.companyRepository = companyRepository;
        this.paletteRepository = paletteRepository;
    }
    @RequestMapping(value = "/warehousing/form")
    public String getPersonForm(Model model) {
        Company company = new Company();
        model.addAttribute("warehousing", company);
        return "warehousingForm";
    }
    @ModelAttribute("companies")
    public Collection<Company> companies() {
        return companyRepository.findAll();
    }
}
