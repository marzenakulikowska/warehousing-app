package pl.coderslab;

import org.springframework.stereotype.Controller;
import pl.coderslab.repository.StoragePlaceRepository;

@Controller
public class StoragePlaceController {
    private final StoragePlaceRepository storagePlaceRepository;

    public StoragePlaceController(StoragePlaceRepository storagePlaceRepository) {
        this.storagePlaceRepository = storagePlaceRepository;
    }
}
