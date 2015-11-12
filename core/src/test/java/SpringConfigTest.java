import org.junit.Test;

import wang.ming15.parentserver.core.SpringConfig;

/**
 * Created by wanggnim on 2015/11/12.
 */
public class SpringConfigTest {

    @Test
    public void testLoad() {
        SpringConfig.INSTANCE.printInfo();
    }
}

