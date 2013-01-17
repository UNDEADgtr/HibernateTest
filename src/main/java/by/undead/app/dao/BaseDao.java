package by.undead.app.dao;

import by.undead.app.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dzmitry
 * Date: 16.01.13
 * Time: 17:17
 * To change this template use File | Settings | File Templates.
 */
public class BaseDao<T> implements DAO<T> {

    private Class cl;

    private HibernateUtil util = HibernateUtil.getInst();

    public BaseDao(Class<T> cl) {
        this.cl = cl;
    }

    @Override
    public T create(T transistObject) throws DaoException {
        Session session = util.getSession();
        Transaction tr = session.beginTransaction();
        try {
            session.save(transistObject);
            tr.commit();
        } catch (HibernateException ex){
                        tr.rollback();
            throw new DaoException(ex);
        }

        return transistObject;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public T read(Integer id) throws DaoException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public T load(Integer id) throws DaoException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public T update(T transistObject) throws DaoException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(Integer id) throws DaoException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<T> readAll() throws DaoException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public T createDelete(T transistObject) throws DaoException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
