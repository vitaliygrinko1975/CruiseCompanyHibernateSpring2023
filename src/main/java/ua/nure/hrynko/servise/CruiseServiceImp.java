package ua.nure.hrynko.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.nure.hrynko.db.dao.MySqlCruisesDAO;
import ua.nure.hrynko.db.models.Cruise;
import ua.nure.hrynko.servise.interfaces.CruiseService;

import java.util.List;

@Service
public class CruiseServiceImp implements CruiseService{

    @Autowired
    private MySqlCruisesDAO mySqlCruisesDAO;


    @Transactional
    @Override
    public void save(Cruise obj) {
        mySqlCruisesDAO.save(obj);
    }

    @Transactional
    @Override
    public void update(Cruise obj) {
        mySqlCruisesDAO.update(obj);
    }

    @Transactional
    @Override
    public void delete(Cruise obj) {mySqlCruisesDAO.delete(obj);
    }

    @Override
    public Cruise getById(int id) {return mySqlCruisesDAO.getById(id);}

    @Transactional(readOnly = true)
    @Override
    public List<Cruise> getAll() {
        return mySqlCruisesDAO.getAll();
    }

    }
