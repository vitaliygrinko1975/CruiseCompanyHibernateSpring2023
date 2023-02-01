package ua.nure.hrynko.db.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ua.nure.hrynko.db.dao.interfaces.RoleDAO;
import ua.nure.hrynko.db.models.Role;

import javax.persistence.Entity;

@Repository
public class MySqlRolesDAO extends MySqlAbstractDAO<Role> implements RoleDAO {
        public MySqlRolesDAO() {
        aClass = Role.class;
        tableName = Role.class.getAnnotation(Entity.class).name();
    }

    @Override
    public Role findRoleByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            Criteria c = session.createCriteria(Role.class);
            c.add(Restrictions.eq("name", name));
            return (Role) c.uniqueResult();
        }
    }

  }

