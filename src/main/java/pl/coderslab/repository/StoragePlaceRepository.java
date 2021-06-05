package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.StoragePlace;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Repository
@Transactional
public class StoragePlaceRepository {
    @PersistenceContext
    private EntityManager entityManager;
    //zapis
    public StoragePlace save(StoragePlace storagePlace) {
        if(storagePlace.getId() == null) {
            entityManager.persist(storagePlace);
        }else{
            entityManager.merge(storagePlace);
        }
        return storagePlace;
    }
    //edycja
    public StoragePlace edit(StoragePlace storagePlace) {
        entityManager.merge(storagePlace);
        return storagePlace;
    }
    //pobieranie po id
    public StoragePlace findById(Long id) {
        StoragePlace storagePlace = entityManager.find(StoragePlace.class, id);
        return storagePlace;
    }
    //usuwanie po id
    public void deleteById(Long id) {
        StoragePlace storagePlace = entityManager.find(StoragePlace.class, id);
        entityManager.remove((entityManager.contains(storagePlace) ? storagePlace : entityManager.merge(storagePlace)));
    }
    //lista
    public List<StoragePlace> showAll() {
        Query query = entityManager.createQuery("SELECT s FROM StoragePlace s");
        return query.getResultList();
    }
    //kolekcja
    public Collection<StoragePlace> findAll() {
        Query query = entityManager.createQuery("SELECT s FROM StoragePlace s");
        return query.getResultList();
    }
}
