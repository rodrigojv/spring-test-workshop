package py.com.sodep;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by rodrigovillalba on 7/26/17.
 */

public class BrokenTest {

    @Test
    public void test() {
        Assert.fail("Force broken test");

        //Assert.assertEquals(true, true);
    }
}
