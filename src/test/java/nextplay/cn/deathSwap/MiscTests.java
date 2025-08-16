package nextplay.cn.deathSwap;

import org.junit.Test;

/**
 * Life was like a box of chocolates
 * you never know what you're going to get.
 *
 * @author jonathan [admin@56fkj.cn]
 */
public class MiscTests {

    @Test
    public void enumTest() {
        enum arg {a, b}
        System.out.println("arg.a.ordinal() = " + arg.a.ordinal());
        System.out.println("arg.b.ordinal() = " + arg.b.ordinal());
    }
}
