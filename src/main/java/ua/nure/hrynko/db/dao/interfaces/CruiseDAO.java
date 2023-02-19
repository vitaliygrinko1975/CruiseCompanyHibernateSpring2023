package ua.nure.hrynko.db.dao.interfaces;


import ua.nure.hrynko.db.models.Cruise;
import ua.nure.hrynko.db.models.User;

import java.util.List;

public interface CruiseDAO extends AbstractDAO<Cruise> {

    List<Cruise> findAllCruises();
}
