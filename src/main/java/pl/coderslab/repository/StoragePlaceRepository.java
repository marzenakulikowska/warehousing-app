package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.StoragePlace;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
@Transactional
public class StoragePlaceRepository {
    @PersistenceContext
    private EntityManager entityManager;
    //utworzenie i zapis
    public StoragePlace save(StoragePlace storagePlace) {
        entityManager.persist(storagePlace);
        return storagePlace;
    }
    //edycja
    public StoragePlace edit(StoragePlace storagePlace) {
        entityManager.merge(storagePlace);
        return storagePlace;
    }
    //pobieranie po id
    public StoragePlace findById(int id) {
        StoragePlace storagePlace = entityManager.find(StoragePlace.class, id);
        return storagePlace;
    }
    //usuwanie po id
    public void deleteById(int id) {
        StoragePlace storagePlace = entityManager.find(StoragePlace.class, id);
        entityManager.remove((entityManager.contains(storagePlace) ? storagePlace : entityManager.merge(storagePlace)));
    }
    public Collection<StoragePlace> findAll() {
        Query query = entityManager.createQuery("SELECT s FROM StoragePlace s");
        return query.getResultList();
    }
}
