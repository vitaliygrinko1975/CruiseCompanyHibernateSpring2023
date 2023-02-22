package ua.nure.hrynko.servise.interfaces;

import org.springframework.transaction.annotation.Transactional;
import ua.nure.hrynko.db.models.Account;

public interface AccountService extends Service<Account> {


    @Transactional
    void save(Account obj);

    @Transactional
    void update(Account obj);

    @Transactional
    void delete(Account obj);
}




