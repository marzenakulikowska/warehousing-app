package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.repository.CargoRepository;
import pl.coderslab.repository.CompanyRepository;
import pl.coderslab.repository.PaletteRepository;
import pl.coderslab.repository.StoragePlaceRepository;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
public class WarehousingFormController {
    private final CompanyRepository companyRepository;
    private final PaletteRepository paletteRepository;
    private final StoragePlaceRepository storagePlaceRepository;
    private final CargoRepository cargoRepository;
    public WarehousingFormController(CompanyRepository companyRepository, PaletteRepository paletteRepository, CargoRepository cargoRepository, StoragePlaceRepository storagePlaceRepository) {
        this.companyRepository = companyRepository;
        this.paletteRepository = paletteRepository;
        this.storagePlaceRepository = storagePlaceRepository;
        this.cargoRepository = cargoRepository;
    }
    //STRONA GŁÓWNA - localhost:8080
    @RequestMapping(value = "/")
    public String homePage() {
        return "homePage";
    }

    //FORMULARZ DODAWANIA FIRM
    @RequestMapping(value = "/warehousing/form/company")
    public String getFormCompany(Model model) {
        Company company = new Company();
        model.addAttribute("company", company);
        return "warehousingFormCompany";
    }
    //FORMULARZ DODAWANIA PALET
    @RequestMapping(value = "/warehousing/form/palette")
    public String getFormPalette(Model model) {
        Palette palette = new Palette();
        model.addAttribute("palette", palette);
        return "warehousingFormPalette";
    }
    //ZAPIS FIRMY DO BAZY DANYCH
    @RequestMapping(value = "/warehousing/form/company", method = RequestMethod.POST)
    public String postCompany(@ModelAttribute @Valid Company company, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "warehousingFormCompany";
        }
        companyRepository.save(company);
        return "positiveMessage";
    }
    //ZAPIS PALETY DO BAZY DANYCH
    @RequestMapping(value = "/warehousing/form/palette", method = RequestMethod.POST)
    public String postPalette(@ModelAttribute @Valid Palette palette, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "warehousingFormPalette";
        }
        paletteRepository.save(palette);
        return "positiveMessage";
    }
    //LISTA FIRM
    @RequestMapping(value = "/company/list", method = RequestMethod.GET)
    public String allCompanies(Model model) {
    List<Company> companies = companyRepository.showAll();
    model.addAttribute("companies", companies);
    return "companiesList";
    }
    //EDYCJA FIRMY
    @RequestMapping(value = {"/warehousing/form/company/edit/{id}"})
    public String editCompany(@PathVariable Long id, Model model) {
        Company companyToEdit = companyRepository.findById(id);
        model.addAttribute("company", companyToEdit);
        return "warehousingFormCompany";
    }
    //USUNIĘCIE FIRMY
    @RequestMapping(value = {"/warehousing/form/company/delete/{id}"})
    public String deleteCompany(@PathVariable Long id, Model model) {
        Company companyToDelete = companyRepository.findById(id);
        model.addAttribute("company", companyToDelete);
        if(companyToDelete != null) {
            companyRepository.deleteById(id);
        }
        return "redirect:/company/list";
    }
    //LISTA PALET
    @RequestMapping(value = "/palette/list", method = RequestMethod.GET)
    public String allPalettes(Model model) {
        List<Palette> palettes = paletteRepository.showAll();
        model.addAttribute("palettes", palettes);
        return "palettesList";
    }
    //EDYCJA PALETY
    @RequestMapping(value = {"/warehousing/form/palette/edit/{id}"})
    public String editPalette(@PathVariable Long id, Model model) {
        Palette paletteToEdit = paletteRepository.findById(id);
        model.addAttribute("palette", paletteToEdit);
        return "warehousingFormPalette";
    }
    //USUNIĘCIE PALETY
//    @RequestMapping(value = {"/warehousing/form/palette/delete/{id}"})
//    public String deletePalette(@PathVariable Long id, Model model) {
//        Palette paletteToDelete = paletteRepository.findById(id);
//        model.addAttribute("palette", paletteToDelete);
//        if(paletteToDelete != null) {
//            paletteRepository.deleteById(id);
//        }
//        return "redirect:/palette/list";
//    }
    //USUNIĘCIE PALETY
    @RequestMapping(value = "/warehousing/form/palette/delete/{id}")
    public String deletePalette(@PathVariable Long id, Model model) {
        Palette paletteToDelete = paletteRepository.findById(id);
        if(paletteToDelete != null) {
            model.addAttribute("palette", paletteToDelete);
            return "deletePaletteConfirm";
        } else {
            return "redirect:/palette/list";
        }
    }
    //POTWIERDZENIE USUNIĘCIA PALETY
    @RequestMapping(value = {"/warehousing/form/palette/delete/{id}"}, method = RequestMethod.POST)
    public String deletePalette(@PathVariable Long id, @RequestParam String confirm) {
        Palette paletteToDelete = paletteRepository.findById(id);
        if(paletteToDelete != null && confirm.equals("true")) {
            paletteRepository.deleteById(id);
        }
        return "redirect:/palette/list";
    }
    //FORMULARZ DODAWANIA MIEJSCA PALETOWEGO
    @RequestMapping(value = "/warehousing/form/storagePlace")
    public String getFormStoragePlace(Model model) {
        StoragePlace storagePlace = new StoragePlace();
        model.addAttribute("storagePlace", storagePlace);
        return "warehousingFormStoragePlace";
    }
    //ZAPIS MIEJSCA PALETOWEGO DO BAZY DANYCH
    @RequestMapping(value = "/warehousing/form/storagePlace", method = RequestMethod.POST)
    public String postStoragePlace(@ModelAttribute @Valid StoragePlace storagePlace, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "warehousingFormStoragePlace";
        }
        storagePlaceRepository.save(storagePlace);
        return "positiveMessage";
    }
    //FORMULARZ DODAWANIA ŁADUNKU
    @RequestMapping(value = "/warehousing/form/cargo")
    public String getFormCargo(Model model) {
        Cargo cargo = new Cargo();
        model.addAttribute("cargo", cargo);
        return "warehousingFormCargo";
    }
    //ZAPIS ŁADUNKU DO BAZY DANYCH
    @RequestMapping(value = "/warehousing/form/cargo", method = RequestMethod.POST)
    public String postCargo(@ModelAttribute Cargo cargo) {
        cargoRepository.save(cargo);
        return "positiveMessage";
    }
    //LISTA MIEJSC PALETOWYCH
    @RequestMapping(value = "/storagePlace/available/list", method = RequestMethod.GET)
    public String allAvailableStoragePlaces(Model model) {
        List<StoragePlace> storagePlaces = storagePlaceRepository.showAll();
        model.addAttribute("storagePlaces", storagePlaces);
        return "storagePlacesAvailableList";
    }
//    //ZAKOŃCZENIE MAGAZYNOWANIA PALETY
//    @RequestMapping(value = {"/endWarehousing/palette/{id}"})
//    public String endWarehousingPalette(@PathVariable Long id, Model model) {
//        Palette paletteToEndWarehousing = paletteRepository.findById(id);
//        model.addAttribute("palette", paletteToEndWarehousing);
//        paletteRepository.endWarehousingById(id);
//        return "endWarehousingMessage";
//    }
    @ModelAttribute("companies")
    public Collection<Company> companies() {
        return companyRepository.findAll();
    }
    @ModelAttribute("palettes")
    public Collection<Palette> palettes() {
        return paletteRepository.findAll();
    }
//    @ModelAttribute("storagePlaces")
//    public Collection<StoragePlace> storagePlaces() {
//        return storagePlaceRepository.findAll();
//    }
}
