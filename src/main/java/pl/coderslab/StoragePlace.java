package pl.coderslab;
import org.hibernate.validator.constraints.Range;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="storagePlace")
public class StoragePlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Pattern(regexp ="[A|B|C|D|E|F|G]")
    private String column;
    @Pattern(regexp = "[0|1|2|3]")
    private String level;
    @Range(min = 1, max = 19)
    private int place;
    @Pattern(regexp = "[TAK|NIE]")
    private String available;
    @OneToMany(mappedBy = "storagePlace")
    private List<Cargo> cargoList = new ArrayList<>();

    public List<Cargo> getCargoList() {
        return cargoList;
    }

    public void setCargoList(List<Cargo> cargoList) {
        this.cargoList = cargoList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }
    public String getAvailable() {return available;}
    public void setAvailable(String available) {
        this.available = available;
    }
    
}
