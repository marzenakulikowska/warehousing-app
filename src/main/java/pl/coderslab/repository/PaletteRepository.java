package pl.coderslab.repository;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.stereotype.Repository;
import pl.coderslab.Palette;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class PaletteRepository {
    @PersistenceContext
    private EntityManager entityManager;
    //zapis
    public Palette save(Palette palette) {
        if(palette.getId() == null) {
            entityManager.persist(palette);
        }else{
            entityManager.merge(palette);
        }
        return palette;
    }
    //edycja
    public Palette edit(Palette palette) {
        entityManager.merge(palette);
        return palette;
    }
    //pobieranie po id
    public Palette findById (Long id){
        return entityManager.find(Palette.class, id);
    }

    //usuwanie po id
    public void deleteById(Long id) {
        Palette palette = entityManager.find(Palette.class, id);
        entityManager.remove((entityManager.contains(palette)));
    }
    //lista
    public List<Palette> showAll() {
        Query query = entityManager.createQuery("SELECT p FROM Palette p");
        return query.getResultList();
    }
    //kolekcja
    public Collection<Palette> findAll() {
        Query query = entityManager.createQuery("SELECT p FROM Palette p");
        return query.getResultList();
    }
    //zakończenie magazynowania
//    public void endWarehousingById(Long id) {
//        Palette palette = entityManager.find(Palette.class, id);
//        Date nowDate = new Date();
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//        palette.setExpectedEndOfStorage(sdf1.format(nowDate));
//
//    }
}
