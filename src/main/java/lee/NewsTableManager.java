package lee;

import org.crazyit.app.domain.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class NewsTableManager {
	
	private static Configuration configuration = null;
	private static SessionFactory sessionFactory = null;
	private static ServiceRegistry serviceRegistry = null;
	

	public static void main(String[] args)
			throws Exception {
		NewsTableManager nm = new NewsTableManager();
		for(int i =0;i<38;i++) {
			nm.save();
		}
		//		nm.query();
	}

	private void query()throws Exception {
		configuration = new Configuration().configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session sess = sessionFactory.openSession();
		News n = (News) sess.get(News.class, new Long(761210452008112128L));
		System.out.println(n.getId() +", " + n.getTitle() + ", " +n.getContent());

		sess.close();
		sessionFactory.close();
	}

	private void save()throws Exception {
		configuration = new Configuration().configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		News n = new News();
		n.setTitle("mycat");
		n.setContent("i am zhengnengliang");
		sess.save(n);
		tx.commit();
		sess.close();
		sessionFactory.close();
	}
}
