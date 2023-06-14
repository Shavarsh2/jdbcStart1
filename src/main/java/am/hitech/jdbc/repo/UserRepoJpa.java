package am.hitech.jdbc.repo;

import am.hitech.jdbc.interfaces.UserRepository;
import am.hitech.jdbc.model.User;
import am.hitech.jdbc.util.HiberneteUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class UserRepoJpa implements UserRepository {
    SessionFactory sessionFactory = HiberneteUtil.getSessionFactory();

    public List<User> getByNameSearch(String name, String userName) {
        Session session = sessionFactory.openSession();
        Query<User> query = null;
        if(name == null && userName == null){//isEmpty
            query = session.createQuery("select u from User u", User.class);
            return query.getResultList();
        } else if (name != null && userName == null) {
            query = session.createQuery("select u from User u where u.firstName like :name", User.class);
            query.setParameter("name",name + "%");
            return query.getResultList();
        } else if (name == null) {
            query = session.createQuery("select u from User u where u.lastName like :username", User.class);
            query.setParameter("username",userName + "%");
            return query.getResultList();
        } else {
            query = session.createQuery("select u from User u where u.firstName like :name and u.lastName like :username", User.class);
            query.setParameter("name",name + "%");
            query.setParameter("username",userName + "%");
            return query.getResultList();
        }
    }

    public List<User> getByName(String name) {
        Session session = sessionFactory.openSession();

        Query<User> userQuery = session.createQuery("select u from User u where u.firstName = :name", User.class);
        userQuery.setParameter("name", name);
        List<User> user = userQuery.getResultList();
        return user;
    }

    public User getById(int id) {
        Session session = sessionFactory.openSession();
        User user = session.find(User.class, id);
        return user;
    }

    @Override
    public int creatUserV2(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        int row = (Integer) session.save(user);
        session.getTransaction().commit();
        return row;
    }

    @Override
    public int updateUser(User user) {
        int row = 1;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            row = 0;
            return row;
        }
        session.close();
        return row;
    }

    @Override
    public int deleteUser(User user) {
        int row = 1;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            row = 0;
            return row;
        }
        session.close();
        return row;
    }

    @Override
    public User getbyPassToken(String pass) {
        return null;
    }

    @Override
    public int updateUserPass(User user) {
        return 0;
    }

    @Override
    public User getByUsername(String email) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //String query1 = "SELECT * FROM user WHERE email = 'email'";
        Query query = session.createQuery("SELECT u FROM User u  WHERE email = :email");
        query.setParameter("email", email);
        User user = (User) query.uniqueResult();
        return user;
    }

    public List<User> getAll() {
        Session session = sessionFactory.openSession();
        String query = "select * from user";
        NativeQuery<User> nativeQuery = session.createNativeQuery(query).addEntity(User.class);
        List<User> users = nativeQuery.getResultList();
        return users;
    }

    public User getByUsername1(String email) {//erkrord tarberak
        Session session = sessionFactory.openSession();
        String query = "SELECT * FROM user WHERE email = :u";
        NativeQuery<User> nativeQuery = session.createNativeQuery(query, User.class);
        nativeQuery.setParameter("u", email);
        User user = nativeQuery.getSingleResult();
        return user;
    }
    public long getCount(){
        Session session = sessionFactory.openSession();
        String query = "select count(u) from User u";
        Query query1 = session.createQuery(query,Long.class);
        long count = (long) query1.uniqueResult();
        return count;
    }


    //public void creat(User user){
    //    Session session = sessionFactory.openSession();
    //    session.beginTransaction();
    //    session.save(user);
    //    session.getTransaction().commit();
    //    session.close();//kara lini;
    //}
    //public void delete(User user){
    //    Session session = sessionFactory.openSession();
    //    Transaction transaction = session.beginTransaction();
    //    session.delete(user);
    //    transaction.commit();
    //}
}
