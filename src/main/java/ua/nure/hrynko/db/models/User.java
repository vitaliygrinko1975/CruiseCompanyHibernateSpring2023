package ua.nure.hrynko.db.models;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * User entity.
 */
    @Entity(name = "users")
    public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Size(max = 256)
    @Column(name = "login", nullable = false, unique = true)
    private String login;
    @NotNull
    @Size(max = 256)
    @Column(name = "password", nullable = false)
    private String password;
    @NotNull
    @Size(max = 256)
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @NotNull
    @Size(max = 256)
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @NotNull
    @Size(max = 256)
    @Column(name = "email", nullable = false,unique = true)
    private String email;
    @NotNull
    @Size(max = 256)
    @Column(name = "phone", nullable = false)
    private String phone;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "roles_id", nullable = false)
    private Role role;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "accounts_id", nullable = false)
    private Account account;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Role getRole() {return role;}
    public void setRole(Role role) {
        this.role = role;
    }
    public Account getAccount() {return account;}
    public void setAccount(Account account) {this.account = account;}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", role=" + role +
                ", account=" + account +
                '}';
    }
}

