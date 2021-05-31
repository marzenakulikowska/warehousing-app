package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.Palette;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PaletteRepository {
    @PersistenceContext
    private EntityManager entityManager;
    //utworzenie i zapis encji
    public Palette save(Palette palette) {
        entityManager.persist(palette);
        return palette;
    }
    //edycja encji
    public Palette update(Palette palette) {
        entityManager.merge(palette);
        return palette;
    }
    //pobieranie po id
    public Palette find(int id){
        return entityManager.find(Palette.class, id);
    }
    //usuwanie po id
    public void delete(int id) {
        Palette palette = entityManager.find(Palette.class, id);
        entityManager.remove((entityManager.contains(palette)));
    }
}
