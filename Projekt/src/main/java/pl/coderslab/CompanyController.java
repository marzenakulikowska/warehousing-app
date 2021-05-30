package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CompanyController {
    public CompanyRepository companyRepository;
    public CompanyController (CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
//    @RequestMapping(value = "/company/list", method = RequestMethod.GET)
//    public String allBooks(Model model) {
//        List<Company> companies = CompanyRepository.showAll();
//        model.addAttribute("companies", companies);
//        return "companiesList";
//    }



}
