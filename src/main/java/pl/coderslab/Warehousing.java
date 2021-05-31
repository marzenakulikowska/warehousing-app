package pl.coderslab;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="warehousing")
public class Warehousing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @ManyToOne
    private Company company;
    @NotNull
    @ManyToOne
    private Palette palette;
    @NotNull
    @ManyToOne
    private StoragePlace storagePlace;
}
