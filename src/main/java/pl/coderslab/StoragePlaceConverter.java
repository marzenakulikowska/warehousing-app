package pl.coderslab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.repository.CompanyRepository;
import pl.coderslab.repository.StoragePlaceRepository;

public class StoragePlaceConverter implements Converter<String,StoragePlace> {
    @Autowired
    private StoragePlaceRepository storagePlaceRepository;
    @Override
    public StoragePlace convert(String s) {
        return storagePlaceRepository.findById(Long.parseLong(s));
    }

}
