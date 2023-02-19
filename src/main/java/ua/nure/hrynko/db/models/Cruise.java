package ua.nure.hrynko.db.models;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
/**
 * Cruise entity.
 */
@Entity(name = "cruises")
public class Cruise implements Serializable {
    private static final long serialVersionUID = -6889036256149495388L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotNull
    @Size(max = 256)
    @Column(name = "name", nullable = false)
    private String name;
    @NotNull
    @Size(max = 256)
    @Column(name = "description", nullable = false)
    private String description;
    @NotNull
    @Column(name = "price", nullable = false)
    private Double price;
    @NotNull
    @Column(name = "capacity", nullable = false)
    private Integer capacity;
    @NotNull
    @Column(name = "start_of_cruise", nullable = false)
    private Date startOfCruise;
    @Column(name = "duration", nullable = false)
    private Integer duration;
    @NotNull
    @Size(max = 256)
    @Column(name = "status", nullable = false)
    private String status;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public Double getPrice() {return price;}
    public void setPrice(Double price) {this.price = price;}
    public Integer getCapacity() {return capacity;}
    public void setCapacity(Integer capacity) {this.capacity = capacity;}
    public Date getStartOfCruise() {return startOfCruise;}
    public void setStartOfCruise(Date startOfCruise) {this.startOfCruise = startOfCruise;}
    public Integer getDuration() {return duration;}
    public void setDuration(Integer duration) {this.duration = duration;}
    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}

    @Override
    public String toString() {
        return "Cruise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", capacity=" + capacity +
                ", startOfCruise=" + startOfCruise +
                ", duration=" + duration +
                ", status='" + status + '\'' +
                '}';
    }
}
