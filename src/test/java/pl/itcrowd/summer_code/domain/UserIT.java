package pl.itcrowd.summer_code.domain;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pl.itcrowd.summer_code.dao.UserDAO;

import java.net.URL;

import static org.junit.Assert.fail;

@UsingDataSet
@RunWith(Arquillian.class)
public class UserIT {

    @ArquillianResource
    private URL deploymentURL;

    @Drone
    private WebDriver driver;

    @Deployment
    public static WebArchive createDeployment()
    {
        return ShrinkWrap.create(WebArchive.class, "UserIT.war").addClasses(User.class, UserDAO.class).addAsResource("META-INF/persistence.xml");
    }

    @Test
    public void listAsClient() throws Exception
    {
//        Given
        driver.navigate().to(deploymentURL);
//        When
//        Then
        fail("Not implemented yet");
    }
}
