package ua.com.feiron.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.feiron.domain.Contact;

import java.util.List;

@Repository
@Transactional
public class ContactRepository {

    @Autowired
    SessionFactory sessionFactory;

    public void addContact(Contact contact) {
        this.sessionFactory.getCurrentSession().save(contact);
    }

    public List resultAll() {
        return this.sessionFactory.getCurrentSession().createQuery("from Contact").list();
    }

    public void deleteContact(Integer iD) {
        Contact contact = (Contact) this.sessionFactory.getCurrentSession().load(Contact.class, iD);
        if (null != contact) {
            this.sessionFactory.getCurrentSession().delete(contact);
        }
    }

}
