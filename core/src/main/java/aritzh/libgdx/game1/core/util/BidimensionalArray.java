package aritzh.libgdx.game1.core.util;

import java.util.Arrays;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BidimensionalArray<E> {

    private static final int DEFAULT_SIZE = 256;

    private Object[][] matrix;
    private int width, height;

    public BidimensionalArray() {
        this(BidimensionalArray.DEFAULT_SIZE, BidimensionalArray.DEFAULT_SIZE);
    }

    public BidimensionalArray(int width, int height) {
        this.matrix = new Object[width][height];
        this.width = width;
        this.height = height;
    }

    public void set(int x, int y, E value) {
        while(this.checkSize(x, y));
        try {
            this.matrix[x][y] = value;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error accessing index " + x + ", " + y);
        }
    }

    private boolean checkSize(int width, int height) {
        if (this.width > width && this.height > height) return false;

        if (this.width <= width) {
            this.width *= 2;
        }

        if (this.height <= height) {
            this.height *= 2;
        }

        Object[][] temp = this.matrix;
        this.matrix = new Object[this.width][this.height];
        System.arraycopy(temp, 0, this.matrix, 0, temp.length);
        return true;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(this.matrix);
    }
}
