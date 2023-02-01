package ua.nure.hrynko.db.models;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


/**
 * account entity.
 */
@Entity(name = "accounts")
public class Account implements Serializable {
    private static final long serialVersionUID = 4716395168539434663L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name = "balance", nullable = false)
    private Double balance;
    @NotNull
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "accounts_id", referencedColumnName = "id")
    private List<User> users;
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return id.equals(account.id) && balance.equals(account.balance);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, balance);
    }
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}

