package aritzh.libgdx.game1.core.screens;

import aritzh.libgdx.game1.core.util.Rectangle;
import com.google.common.base.Function;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ClickableRegion extends Rectangle {
    private final Function<Integer, Boolean> clickHandler;

    public ClickableRegion(int x, int y, int width, int height, Function<Integer, Boolean> clickHandler) {
        super(x, y, width, height);
        this.clickHandler = clickHandler;
    }

    public ClickableRegion(Rectangle region, Function<Integer, Boolean> clickHandler) {
        super(region);
        this.clickHandler = clickHandler;
    }

    public boolean clicked(int button) {
        return this.clickHandler.apply(button) == Boolean.TRUE;
    }
}
