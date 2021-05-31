package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.repository.CompanyRepository;

import java.util.List;

@Controller
public class CompanyController {
    private final CompanyRepository companyRepository;
    public CompanyController (CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    @RequestMapping(value = "/company/list")
    @ResponseBody
    public String allCompanies() {
        List<Company> companies = companyRepository.showAll();
        //model.addAttribute("companies", companies);
        return String.valueOf(companies.size());
    }



}
