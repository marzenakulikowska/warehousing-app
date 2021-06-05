package pl.coderslab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.repository.PaletteRepository;

public class PaletteConverter implements Converter<String,Palette> {
    @Autowired
    private PaletteRepository paletteRepository;
    @Override
    public Palette convert(String s) {
        return paletteRepository.findById(Long.parseLong(s));
    }

}
