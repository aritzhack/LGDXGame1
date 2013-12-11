package aritzh.libgdx.game1.core.render.gui.components;

import aritzh.libgdx.game1.core.render.gui.ClickHandler;
import aritzh.libgdx.game1.core.render.gui.GUI;
import aritzh.libgdx.game1.core.util.Rectangle;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GUIImage extends GUIElement {

    private final TextureRegion texture;

    public GUIImage(GUI parent, TextureRegion texture, Rectangle clickBounds, ClickHandler handler) {
        super(parent, clickBounds, handler);
        this.texture = texture;
    }

    @Override
    public void render() {
        this.getGUI().getGame().batch.draw(this.texture, this.getX(), this.getY());
    }
}
