package miv.study.cruddemo.dao;

import miv.study.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao {

    EntityManager entityManager;

    @Autowired
    public EmployeeDaoHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Session session = entityManager.unwrap(Session.class);

        Query<Employee> query = session.createQuery("from Employee", Employee.class);

        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee); // if (id == 0) => save, else => update by id.
    }

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<?> query = session.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
