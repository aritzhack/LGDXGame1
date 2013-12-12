package aritzh.libgdx.game1.core.util;

import com.google.common.base.Function;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BidimensionalArray<E> implements Iterable<E> {

    private static final int DEFAULT_SIZE = 256;

    private Object[][] matrix;
    private int width, height;

    public BidimensionalArray() {
        this(BidimensionalArray.DEFAULT_SIZE, BidimensionalArray.DEFAULT_SIZE);
    }

    public BidimensionalArray(int width, int height) {
        this.width = closestBiggerPorwerOfTwo(width);
        this.height = closestBiggerPorwerOfTwo(height);
        this.matrix = new Object[width][height];
    }

    public void set(int x, int y, E value) {
        //noinspection StatementWithEmptyBody
        while(this.checkSize(x, y));
        try {
            this.matrix[x][y] = value;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error setting index " + x + ", " + y);
            e.printStackTrace();
        }
    }

    public BidimensionalArray<Boolean> applyToAll(Function<E, Boolean> function){
        BidimensionalArray<Boolean> ret = new BidimensionalArray<Boolean>(this.width, this.height);

        for(int x = 0; x<this.width; x++){
            for(int y = 0; y<this.height; y++){
                ret.set(x, y, function.apply(this.get(x, y)));
            }
        }
        return ret;
    }

    @SuppressWarnings("unchecked")
    public E get(int x, int y){
        if(x >= this.width || y>= this.height) return null;
        return (E) this.matrix[x][y];
    }

    private boolean checkSize(int width, int height) {
        if (this.width > width && this.height > height) return false;

        int lastWidth = this.width;
        int lastHeight = this.height;

        if (this.width <= width) {
            this.width *= 2;
        }

        if (this.height <= height) {
            this.height *= 2;
        }

        this.matrix = Arrays.copyOf(this.matrix, this.width);

        for(int i = 0; i<this.width; i++){
            if(i<lastWidth) this.matrix[i] = Arrays.copyOf(this.matrix[i], this.height);
            else this.matrix[i] = new Object[this.height];
        }
        return true;
    }

    private static int closestBiggerPorwerOfTwo(int number){
        return 32 - Integer.numberOfLeadingZeros(number - 1);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(this.matrix);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public Iterator<E> iterator() {
        return new BidimensionalArrayIterator();
    }

    private class BidimensionalArrayIterator implements Iterator<E> {

        int currX, currY;
        BidimensionalArray<E> array = BidimensionalArray.this;

        @Override
        public boolean hasNext() {
            return !(this.currX+1 < BidimensionalArray.this.getWidth() && this.currY+1 < BidimensionalArray.this.getHeight());
        }

        @Override
        public E next() {
            if(!this.hasNext()) return null;
            this.currX++;
            if(this.currX == array.getWidth()){
                this.currX = 0;
                this.currY++;
            }

            return array.get(this.currX, this.currY);
        }

        @Override
        public void remove() {
            array.set(this.currX, this.currY, null);
        }
    }
}
