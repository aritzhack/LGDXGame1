package aritzh.libgdx.game1.core.render.gui;

import aritzh.libgdx.game1.core.Game;
import aritzh.libgdx.game1.core.input.InputHandler;
import aritzh.libgdx.game1.core.render.gui.components.GUIElement;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class GUI {

    protected final List<GUIElement> guiElements = Lists.newArrayList();
    protected final Game game;

    public GUI(Game game) {
        this.game = game;
    }

    public void touchedDown(InputHandler.Pointer pointer, int finger) {
        for (GUIElement element : guiElements) {
            if (element.getBounds().contains(pointer.getPoint())) {
                element.touchedDown(pointer, finger);
            }
        }
    }

    public boolean touchedUp(InputHandler.Pointer pointer, int finger) {
        for (GUIElement element : guiElements) {
            if (element.touchedUp(pointer, finger)) return true;
        }
        return false;
    }

    public void dragged(InputHandler.Pointer pointer, int finger) {
        for (GUIElement element : guiElements) {
            element.dragged(pointer, finger);
        }
    }

    public List<GUIElement> getElements() {
        return guiElements;
    }

    public Game getGame() {
        return game;
    }

    public void renderGUI() {
        for (GUIElement element : this.guiElements) {
            element.render();
        }
    }

    public void addGUIElement(GUIElement element){
        this.guiElements.add(element);
    }

    public boolean scrolled(int amount) {
        return false;
    }
}
