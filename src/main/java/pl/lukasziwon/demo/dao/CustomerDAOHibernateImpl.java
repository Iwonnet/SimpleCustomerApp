package pl.lukasziwon.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import pl.lukasziwon.demo.entity.Customer;

@Repository
public class CustomerDAOHibernateImpl implements CustomerDAO {

	private EntityManager entityManager;

	@Autowired
	public CustomerDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Customer> findAll() {

		Session currentSession = entityManager.unwrap(Session.class);
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		List<Customer> campaigns = theQuery.getResultList();
		return campaigns;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(theCustomer);

	}

	@Override
	public Customer findById(int theId) {

		Session currentSession = entityManager.unwrap(Session.class);
		Customer theCustomer = currentSession.get(Customer.class, theId);

		return theCustomer;
	}

	@Override
	public void deleteById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");

		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();

	}

}
