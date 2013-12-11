package aritzh.libgdx.game1.core.render.gui.components;

import aritzh.libgdx.game1.core.input.InputHandler;
import aritzh.libgdx.game1.core.render.gui.ClickHandler;
import aritzh.libgdx.game1.core.render.gui.GUI;
import aritzh.libgdx.game1.core.util.Rectangle;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class GUIElement {

    protected final GUI parent;
    protected ClickHandler handler;
    protected Rectangle bounds;

    public GUIElement(GUI parent, int x, int y, int width, int height, ClickHandler handler) {
        this(parent, new Rectangle(x, y, width, height), handler);
    }

    public GUIElement(GUI parent, Rectangle bounds, ClickHandler handler) {
        this.parent = parent;
        this.bounds = bounds;
        this.handler = handler;
    }

    public abstract void render();

    public GUI getGUI() {
        return parent;
    }

    public int getX() {
        return this.bounds.getX();
    }

    public int getY() {
        return this.bounds.getY();
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void touchedDown(InputHandler.Pointer pointer, int finger) {

    }

    public boolean touchedUp(InputHandler.Pointer pointer, int finger) {
        return this.handler != null && this.bounds.contains(pointer.getPoint()) && this.handler.handle(pointer, finger);
    }

    public void dragged(InputHandler.Pointer pointer, int finger){

    }
}
