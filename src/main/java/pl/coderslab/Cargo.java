package pl.coderslab;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="cargo")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @ManyToOne
//    @JoinColumn(name = "company_id", nullable = false) //NAZWA KOLUMNY W tabeli cargo
    private Company company;
    @NotNull
    @ManyToOne
//    @JoinColumn(name = "palette_id", nullable = false)
    private Palette palette;
    @NotNull
    @ManyToOne
//    @JoinColumn(name = "storagePlace_id", nullable = false)
    private StoragePlace storagePlace;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Palette getPalette() {
        return palette;
    }

    public void setPalette(Palette palette) {
        this.palette = palette;
    }

    public StoragePlace getStoragePlace() {
        return storagePlace;
    }

    public void setStoragePlace(StoragePlace storagePlace) {
        this.storagePlace = storagePlace;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", company=" + company +
                ", palette=" + palette +
                ", storagePlace=" + storagePlace +
                '}';
    }
}
