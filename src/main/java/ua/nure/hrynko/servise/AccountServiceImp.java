package ua.nure.hrynko.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.nure.hrynko.db.dao.MySqlAccountsDAO;
import ua.nure.hrynko.db.models.Account;
import ua.nure.hrynko.servise.interfaces.AccountService;


import java.util.List;

@Service
public class AccountServiceImp implements AccountService {

    @Autowired
    private MySqlAccountsDAO mySqlAccountsDAO;

    @Transactional
    @Override
    public void save(Account obj) {
        mySqlAccountsDAO.save(obj);
    }

    @Transactional
    @Override
    public void update(Account obj) {
        mySqlAccountsDAO.update(obj);
    }

    @Transactional
    @Override
    public void delete(Account obj) {mySqlAccountsDAO.delete(obj);
    }

    @Override
    public Account getById(int id) {return mySqlAccountsDAO.getById(id);}

    @Transactional(readOnly = true)
    @Override
    public List<Account> getAll() {
        return mySqlAccountsDAO.getAll();
    }

    }
