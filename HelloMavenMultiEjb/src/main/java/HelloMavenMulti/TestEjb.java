package HelloMavenMulti;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * Created by rakib on 7/31/16.
 */
@Stateless
public class TestEjb implements TestEjbInterface {
    public String testMethod() {
        return "Test EJB ABC";
    }
}
