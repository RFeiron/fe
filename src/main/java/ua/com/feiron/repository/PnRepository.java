package ua.com.feiron.repository;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.feiron.domain.Pn;

import java.util.List;

@Repository
@Transactional
public class PnRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void addProduct(Pn pn) {
        this.sessionFactory.getCurrentSession().save(pn);
    }

    public List<Pn> listAll() {
        return this.sessionFactory.getCurrentSession().createQuery("from Pn").list();
    }

    public void removeProduct(Integer iD) {
        Pn pn = (Pn) this.sessionFactory.getCurrentSession().load(Pn.class, iD);
        if (null != pn) {
            this.sessionFactory.getCurrentSession().delete(pn);
        }
    }


}
