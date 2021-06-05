package pl.coderslab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.repository.CompanyRepository;
import pl.coderslab.repository.PaletteRepository;

public class CompanyConverter implements Converter<String,Company> {
    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public Company convert(String s) {
        return companyRepository.findById(Long.parseLong(s));
    }

}
