package pl.coderslab;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="palette")
public class Palette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private int height;
    private int width;
    private int length;
    @NotNull
    private int weight;
    @NotBlank
    private String beginningOfStorage;
    @NotBlank
    private String expectedEndOfStorage;
    @OneToMany(mappedBy = "palette")
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBeginningOfStorage() {
        return beginningOfStorage;
    }

    public String getEndOfStorage() {
        return expectedEndOfStorage;
    }

    public void setBeginningOfStorage(String beginningOfStorage) {
        this.beginningOfStorage = beginningOfStorage;
    }

    public String getExpectedEndOfStorage() {
        return expectedEndOfStorage;
    }

    public void setExpectedEndOfStorage(String expectedEndOfStorage) {
        this.expectedEndOfStorage = expectedEndOfStorage;
    }

}
