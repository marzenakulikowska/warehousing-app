package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.repository.CompanyRepository;
import pl.coderslab.repository.PaletteRepository;
import java.util.Collection;
import java.util.List;

@Controller
public class WarehousingFormController {
    private final CompanyRepository companyRepository;
    private final PaletteRepository paletteRepository;
    public WarehousingFormController(CompanyRepository companyRepository, PaletteRepository paletteRepository) {
        this.companyRepository = companyRepository;
        this.paletteRepository = paletteRepository;
    }
    @RequestMapping(value = "/warehousing/form/company")
    public String getFormCompany(Model model) {
        Company company = new Company();
        model.addAttribute("company", company);
        return "warehousingFormCompany";
    }
    @RequestMapping(value = "/warehousing/form/palette")
    public String getFormPalette(Model model) {
        Palette palette = new Palette();
        model.addAttribute("palette", palette);
        return "warehousingFormPalette";
    }
    @RequestMapping(value = "/warehousing/form/company", method = RequestMethod.POST)
    public String postCompany(@ModelAttribute Company company) {
       companyRepository.save(company);
        return "redirect:/warehousing/form/palette";
        //return "warehousingFormPalette";
    }
//    @RequestMapping(value = "/company/list", method = RequestMethod.GET)
//    public String allCompanies(Model model) {
//    List<Company> companies = companyRepository.showAll();
//    model.addAttribute("companies", companies);
//    return "companiesList";
//    }
//    @ModelAttribute("companies")
//    public Collection<Company> companies() {
//        return companyRepository.findAll();
//    }
}
