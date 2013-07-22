package pl.itcrowd.summer_code.dao;

import pl.itcrowd.summer_code.domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getUsers()
    {
        return entityManager.createQuery("from User order by id", User.class).getResultList();
    }

    public User save(User user)
    {
        return entityManager.merge(user);
    }
}
