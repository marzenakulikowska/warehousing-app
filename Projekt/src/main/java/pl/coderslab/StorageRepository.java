package pl.coderslab;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
@Transactional
public class StorageRepository {
    @PersistenceContext
    private EntityManager entityManager;
    //utworzenie
    public Storage create(Storage storage) {
        entityManager.persist(storage);
        return storage;
    }
    //edycja
    public Storage edit(Storage storage) {
        entityManager.merge(storage);
        return storage;
    }
    //pobieranie po id
    public Storage findById(int id) {
        Storage storage = entityManager.find(Storage.class, id);
        return storage;
    }
    //usuwanie po id
    public void deleteById(int id) {
        Storage storage = entityManager.find(Storage.class, id);
        entityManager.remove((entityManager.contains(storage) ? storage : entityManager.merge(storage)));
    }
    public Collection<Storage> findAll() {
        Query query = entityManager.createQuery("SELECT s FROM Storage s");
        return query.getResultList();
    }
}
