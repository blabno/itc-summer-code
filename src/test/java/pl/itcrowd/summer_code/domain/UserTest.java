package pl.itcrowd.summer_code.domain;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import pl.itcrowd.summer_code.dao.UserDAO;

import javax.ejb.EJB;
import java.util.List;

import static org.junit.Assert.assertEquals;

@UsingDataSet
@RunWith(Arquillian.class)
public class UserTest {

    @EJB
    private UserDAO userDAO;

    @Deployment
    public static Archive createDeployment()
    {
        return ShrinkWrap.create(WebArchive.class, "test.war").addClasses(User.class, UserDAO.class).addAsResource("META-INF/persistence.xml");
    }

    @Test
    public void list() throws Exception
    {
//        Given
//        When
        final List<User> users = userDAO.getUsers();
//        Then
        assertEquals(2, users.size());
    }
}
