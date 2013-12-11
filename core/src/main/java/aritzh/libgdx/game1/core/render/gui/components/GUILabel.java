package aritzh.libgdx.game1.core.render.gui.components;

import aritzh.libgdx.game1.core.render.gui.ClickHandler;
import aritzh.libgdx.game1.core.render.gui.GUI;
import aritzh.libgdx.game1.core.util.Rectangle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GUILabel extends GUIElement{

    private final String text;
    private final BitmapFont font;

    public GUILabel(GUI parent, Rectangle bounds, ClickHandler handler, String text, BitmapFont font, boolean fixToTextSize) {
        super(parent, bounds, handler);
        this.text = text;
        if(font != null) this.font = font;
        else this.font = this.getGUI().getGame().font;
        if(fixToTextSize) {
            BitmapFont.TextBounds textBounds = this.font.getBounds(text);
            this.bounds = this.bounds.setSize((int)textBounds.width, (int)textBounds.height);
        }
    }

    public GUILabel(GUI parent, Rectangle bounds, ClickHandler handler, String text) {
        this(parent, bounds, handler, text, null, true);
    }

    @Override
    public void render() {
        this.font.draw(this.getGUI().getGame().batch, text, this.bounds.getX(), this.bounds.getY());
    }
}
