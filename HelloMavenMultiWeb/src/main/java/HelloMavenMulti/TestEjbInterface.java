package HelloMavenMulti;

import javax.ejb.Remote;

/**
 * Created by rakib on 7/31/16.
 */
@Remote
public interface TestEjbInterface {
    public String testMethod();
}
