import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertEquals;

public class UserTest {
    User user;

    @Before
    public void beforeTests()
    {
        user = new User();
    }

    @Test
    public void testHashCodeNull()
    {
        //given

        //when
        int userHash = user.hashCode();
        //then
        assertEquals(0 , userHash);
    }

    @Test
    public void testHashCodeNotNull()
    {
        //given
        Long L = 1234L;
        int  hash =  L.hashCode();
        user.setId(L);

        //when
        int userHash = user.hashCode();

        //then
        assertEquals(hash , userHash);
    }

    @Test
    public void testEquals()
    {
        //given
        user.setId(2121L);

        //when
        User user2 = new User(2121L, "tempemail@wp.pl");

        //then
        assertTrue(user.equals(user2));
    }
}

