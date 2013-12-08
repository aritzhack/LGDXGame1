package aritzh.libgdx.game1.core.render.gui;

import aritzh.libgdx.game1.core.input.InputHandler;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public interface ClickHandler {

    public boolean handle(InputHandler.Pointer pointer, int finger);
}
