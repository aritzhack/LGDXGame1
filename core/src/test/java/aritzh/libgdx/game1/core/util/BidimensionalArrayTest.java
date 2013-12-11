package aritzh.libgdx.game1.core.util;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BidimensionalArrayTest {

    @org.junit.Test
    public void testToString() throws Exception {
        BidimensionalArray<Integer> bidiArray = new BidimensionalArray<Integer>(10, 10);

        bidiArray.set(100, 100, 50);

        System.out.println(bidiArray);
    }
}
