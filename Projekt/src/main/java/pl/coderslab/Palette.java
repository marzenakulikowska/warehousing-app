package pl.coderslab;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="palette")
public class Palette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int height;
    private int width;
    private int length;
    @NotBlank
    private int weight;
    @NotBlank
    private String BeginningOfStorage;
    @NotBlank
    private String EndOfStorage;
    // ?????????????
    @OneToMany(mappedBy = "warehousing")
    private List<Warehousing> warehousingList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return BeginningOfStorage;
    }

    public void setBeginningOfStorage(String beginningOfStorage) {
        BeginningOfStorage = beginningOfStorage;
    }

    public String getEndOfStorage() {
        return EndOfStorage;
    }

    public void setEndOfStorage(String endOfStorage) {
        EndOfStorage = endOfStorage;
    }
}
