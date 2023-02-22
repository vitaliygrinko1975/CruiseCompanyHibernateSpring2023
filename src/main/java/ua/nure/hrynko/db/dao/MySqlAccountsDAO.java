package ua.nure.hrynko.db.dao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ua.nure.hrynko.db.dao.interfaces.AccountDAO;
import ua.nure.hrynko.db.models.Account;
import javax.persistence.Entity;

@Repository
public class MySqlAccountsDAO extends MySqlAbstractDAO<Account> implements AccountDAO {

    public MySqlAccountsDAO() {
        aClass = Account.class;
        tableName = Account.class.getAnnotation(Entity.class).name();
    }
    public Integer saveAndReturnId(Account account) {
        Integer id;
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            id = (Integer) session.save(account);
            tx.commit();
        }
        return id;
    }

}
