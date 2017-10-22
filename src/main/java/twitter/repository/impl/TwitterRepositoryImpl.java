package twitter.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import twitter.model.TwitterMessage;
import twitter.repository.TwitterRepository;

import java.util.List;


public class TwitterRepositoryImpl implements TwitterRepository {


        private SessionFactory sessionFactory;


        public TwitterRepositoryImpl() {
            initRepo();
        }

        private void initRepo() {
            Configuration config = new Configuration().configure();
            config.addAnnotatedClass(TwitterMessage.class);
            ServiceRegistry service = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
            sessionFactory = config.buildSessionFactory(service);
            //test();
        }

        public List<TwitterMessage> getAllTwitts() {
            Session session = sessionFactory.openSession();
            List<TwitterMessage> twitters = session.createQuery("from TwitterMessage").list();
            return twitters;
        }

        public TwitterMessage persistTwitterMessage(TwitterMessage twitterMessage) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(twitterMessage);
            session.getTransaction().commit();
            return twitterMessage;
        }
        

        public TwitterMessage getTweet(long id) {
        	Session session = sessionFactory.openSession();
        	TwitterMessage twitterMessage = (TwitterMessage)session.get(TwitterMessage.class, id);
        	return twitterMessage;
        }
    }



