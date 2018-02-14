package by.anjeymash.tasks.roadcam.dao.impl;

import java.util.Calendar;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import by.anjeymash.tasks.roadcam.dao.RoadCamDAO;
import by.anjeymash.tasks.roadcam.model.Registration;

@Repository
public class RoadCamDAOImpl implements RoadCamDAO {
	private static final DateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	
	private SessionFactory sessionFactory;
	
	@Autowired(required=true)
	@Qualifier(value="sessionFactory")
	public void  setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public RoadCamDAOImpl() {
	}

	@Override
	public List<Registration> getRegistrations() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Registration order by regId", Registration.class).getResultList();
	}

	@Override
	public Registration addRegistration(Registration reg) {
		Session session = sessionFactory.getCurrentSession();
		java.util.Date currentDate = Calendar.getInstance().getTime();
		reg.setRegDate(DATE_FORMATTER.format(currentDate));
		session.saveOrUpdate(reg);
		return reg;
	}

	@Override
	public List<Registration> getRegistrationsForNum(String num) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<Registration> query = session.createQuery("from Registration where regNum = :code ");
		query.setParameter("code", num);
		List<Registration> list = query.list();
		return list;
	}

	@Override
	public int getAllRegCount() {
		int count = 0;
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("deprecation")
		Object result = session.createCriteria(Registration.class).setProjection(Projections.rowCount()).uniqueResult();
		count = Integer.parseInt(result.toString());
		return count;

	}
}
