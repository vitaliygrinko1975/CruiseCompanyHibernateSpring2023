package ua.nure.hrynko.db.models;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;



/**
 * account entity.
 */
@Entity(name = "accounts")
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name = "balance", nullable = false)
    private Double balance;
    @NotNull
    @Size(max = 256)
    @Column(name = "file_name", nullable = false)
    private String fileName;
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
    public String getFileName() {return fileName;}
    public void setFileName(String fileName) {this.fileName = fileName;}
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", fileName='" + fileName + '\'' +'}';
    }
}

