package ua.nure.hrynko.db.models;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;


/**
 * Order entity.
 */
@Entity(name = "orders")
public class Order implements Serializable {
    private static final long serialVersionUID = -6889036256149495388L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user;
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cruises_id", referencedColumnName = "id")
    private Cruise cruise;
    @NotNull
    @Column(name = "status", nullable = false)
    private String status;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
    public Cruise getCruise() {return cruise;}
    public void setCruise(Cruise cruise) {this.cruise = cruise;}
    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return id.equals(order.id) && user.equals(order.user) && cruise.equals(order.cruise) && status.equals(order.status);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, user, cruise, status);
    }
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", cruise=" + cruise +
                ", status='" + status + '\'' +
                '}';
    }
}
