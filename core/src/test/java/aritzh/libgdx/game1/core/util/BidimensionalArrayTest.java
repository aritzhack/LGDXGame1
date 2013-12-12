package aritzh.libgdx.game1.core.util;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Random;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BidimensionalArrayTest {

    private static final int TIMES = 100000000, MAX_SIZE = 8191;

    @Test
    public void testToString() throws Exception {
        BidimensionalArray<Integer> bidiArray = new BidimensionalArray<Integer>(10, 10);
        List<Entry> entries = Lists.newArrayList();
        Random r = new Random();

        for(int i = 0; i<TIMES; i++){
            int x = r.nextInt(MAX_SIZE);
            int y = r.nextInt(MAX_SIZE);

            if(bidiArray.get(x, y) == null) continue;

            int value = r.nextInt();

            entries.add(new Entry(x, y, value));
            bidiArray.set(x, y, value);
        }

        for (Entry entry : entries){
            assert bidiArray.get(entry.x, entry.y) == entry.value;
        }
    }

    private static class Entry {

        public final int x;
        public final int y;
        public final int value;

        public Entry(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
