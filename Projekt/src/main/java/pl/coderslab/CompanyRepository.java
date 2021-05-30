package pl.coderslab;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Repository
@Transactional
public class CompanyRepository {
    @PersistenceContext
    private EntityManager entityManager;
    //utworzenie
    public Company create (Company company) {
        entityManager.persist(company);
        return company;
    }
    //edycja
    public Company edit(Company company) {
        entityManager.merge(company);
        return company;
    }
    //pobieranie po id
    public Company findById(int id) {
        Company company = entityManager.find(Company.class, id);
        return company;
    }
    //usuwanie po id
    public void deleteById(int id) {
        Company company = entityManager.find(Company.class, id);
       entityManager.remove((entityManager.contains(company) ? company : entityManager.merge(company)));
    }
    public Collection<Company> findAll() {
        Query query = entityManager.createQuery("Select c from Company c");
        return query.getResultList();
    }
    public List<Company> showAll() {
        Query query = entityManager.createQuery("SELECT c FROM Company c");
        return query.getResultList();
    }
}
