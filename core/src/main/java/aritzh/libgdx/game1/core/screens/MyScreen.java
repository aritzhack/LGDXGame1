package aritzh.libgdx.game1.core.screens;

import aritzh.libgdx.game1.core.Game;
import aritzh.libgdx.game1.core.render.gui.GUI;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class MyScreen extends GUI implements Screen {

    protected final OrthographicCamera camera;
    protected GUI currGUI = this;

    public MyScreen(Game game, OrthographicCamera camera) {
        super(game);
        this.camera = camera;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public GUI getCurrGUI() {
        return currGUI;
    }
}
