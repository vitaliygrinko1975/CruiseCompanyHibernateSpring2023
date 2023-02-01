package ua.nure.hrynko.db.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * Ship entity.
 */

@Entity(name = "ships")
public class Ship implements Serializable {
    private static final long serialVersionUID = -6889036256149495388L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(max = 256)
    @Column(name = "name", nullable = false)
    private String name;
    @NotNull
    @Size(max = 256)
    @Column(name = "description", nullable = false)
    private String description;
    @NotNull
    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public Integer getCapacity() {return capacity;}
    public void setCapacity(Integer capacity) {this.capacity = capacity;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ship)) return false;
        Ship ship = (Ship) o;
        return id == ship.id && name.equals(ship.name) && description.equals(ship.description) && capacity.equals(ship.capacity);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, capacity);
    }
    @Override
    public String toString() {
        return "Ship{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
