package ua.nure.hrynko.servise.interfaces;

import ua.nure.hrynko.db.models.Cruise;
import ua.nure.hrynko.db.models.User;

import java.util.List;

public interface CruiseService extends Service<Cruise> {
    Cruise getById(int id);
    List<Cruise> getAll();
}




