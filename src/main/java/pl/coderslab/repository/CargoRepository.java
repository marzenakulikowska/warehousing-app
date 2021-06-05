package pl.coderslab.repository;
import org.springframework.stereotype.Repository;
import pl.coderslab.Cargo;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CargoRepository {
    @PersistenceContext
    private EntityManager entityManager;
    //zapis
    public Cargo save(Cargo cargo){
        entityManager.persist(cargo);
        return cargo;
    }
    //edycja
    public Cargo edit(Cargo cargo) {
        entityManager.merge(cargo);
        return cargo;
    }
    //pobieranie po id
    public Cargo findById(int id) {
        Cargo cargo = entityManager.find(Cargo.class, id);
        return cargo;
    }
    //usuwanie po id
    public void deleteById(int id) {
        Cargo cargo = entityManager.find(Cargo.class, id);
        entityManager.remove((entityManager.contains(cargo) ? cargo : entityManager.merge(cargo)));
    }
}

