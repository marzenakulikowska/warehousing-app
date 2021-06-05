package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.Company;
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
    //utworzenie i zapis
    public Company save(Company company){
        if(company.getId() == null) {
            entityManager.persist(company);
        }else{
            entityManager.merge(company);
        }
        return company;
    }
    //edycja
    public Company edit(Company company) {
        entityManager.merge(company);
        return company;
    }
    //pobieranie po id
    public Company findById(Long id) {
        Company company = entityManager.find(Company.class, id);
        return company;
    }
    //usuwanie po id
    public void deleteById(Long id) {
        Company company = entityManager.find(Company.class, id);
       entityManager.remove((entityManager.contains(company) ? company : entityManager.merge(company)));
    }
    //lista
    public List<Company> showAll() {
        Query query = entityManager.createQuery("SELECT c FROM Company c");
        return query.getResultList();
    }
    //kolekcja
    public Collection<Company> findAll() {
        Query query = entityManager.createQuery("SELECT c FROM Company c");
        return query.getResultList();
    }
}
