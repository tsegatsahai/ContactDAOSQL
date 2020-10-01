
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
    private User user;

    public UserTest() {
        this.user = new User();
    }

    @Test
    public void testEmail(){
        System.out.println("Testing validity of Email:");
        assertTrue(user.setEmail("tyt2c@mtmail.mtsu.edu"));
        assertTrue(user.setEmail("deep@flexson.com"));
        assertFalse(user.setEmail("tsega@gmail@com"));
        assertFalse(user.setEmail("23@yahoo.com."));
        System.out.println('\n');
    }

    @Test
    public void testPassword(){
        System.out.println("Testing validity of Password:");
        assertTrue(user.setPassword("passWoRd"));
        assertTrue(user.setPassword("123456"));
        assertFalse(user.setPassword("pass"));
        assertFalse(user.setPassword("a58nc"));
        System.out.println('\n');
    }

    @Test
    public void testName(){
        System.out.println("Testing validity of Name:");
        assertTrue(user.setName("Tsega Tsahai"));
        assertTrue(user.setName("Mary-Jane Lopez"));
        assertFalse(user.setName("tsega.tsahai"));
        assertFalse(user.setName("Gamer78"));
        System.out.println('\n');
    }

    @Test
    public void testBirthday(){
        System.out.println("Testing validity of Birthday:");
        assertTrue(user.setBirthday("9/12/1998"));
        assertTrue(user.setBirthday("11/26/1968"));
        assertFalse(user.setBirthday("02/30/1991"));
        assertFalse(user.setBirthday("03/11/2022"));
        System.out.println('\n');

    }

    @Test
    public void testGender(){
        System.out.println("Testing validity of Gender:");
        assertTrue(user.setGender('f'));
        assertTrue(user.setGender('M'));
        assertFalse(user.setGender('R'));
        assertFalse(user.setGender('p'));
        System.out.println('\n');
    }

}
