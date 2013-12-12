package aritzh.libgdx.game1.core.render.gui.components;

import aritzh.libgdx.game1.core.input.InputHandler;
import aritzh.libgdx.game1.core.render.gui.ClickHandler;
import aritzh.libgdx.game1.core.render.gui.GUI;
import aritzh.libgdx.game1.core.util.Rectangle;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GUIButton extends GUIElement {


    private final TextureRegion normal, clicked;
    private int pressed;

    public GUIButton(GUI parent, Rectangle bounds, ClickHandler handler, TextureRegion normal, TextureRegion clicked) {
        super(parent, bounds, handler);
        this.normal = normal;
        this.clicked = clicked;
    }

    @Override
    public void render() {
        this.getGUI().getGame().batch.draw((this.pressed<0 ? this.normal : this.clicked), this.getX(), this.getY());
    }

    @Override
    public void touchedDown(InputHandler.Pointer pointer, int finger) {
        super.touchedDown(pointer, finger);
        this.pressed = finger;
    }

    @Override
    public boolean touchedUp(InputHandler.Pointer pointer, int finger) {
        if(finger == this.pressed) this.pressed = -1;
        return super.touchedUp(pointer, finger);
    }

    @Override
    public void dragged(InputHandler.Pointer pointer, int finger) {
        super.dragged(pointer, finger);
        if(finger == this.pressed && !this.bounds.contains(pointer.getPoint())) this.pressed = -1;
        else if (this.pressed == -1 && this.bounds.contains(pointer.getPoint())) this.pressed = finger;
    }
}
