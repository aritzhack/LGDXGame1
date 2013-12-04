package aritzh.libgdx.game1.core.util;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Rectangle {

    private final int x, y, width, height;

    public Rectangle() {
        this(0, 0, 0, 0);
    }

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle(int width, int height) {
        this(0, 0, width, height);
    }

    public Rectangle translate(int dx, int dy) {
        return new Rectangle(this.x + dx, this.y + dx, this.width, this.height);
    }

    public Rectangle setSize(int width, int height) {
        return new Rectangle(this.x, this.y, width, height);
    }

    public Rectangle scale(int sx, int sy) {
        return new Rectangle(this.x, this.y, this.width * sx, this.height * sy);
    }

    public boolean contains(Point point) {
        return point.getX() >= this.x && point.getX() <= this.x + this.width && point.getY() >= this.y && point.getY() <= this.y + this.height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
