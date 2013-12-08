package aritzh.libgdx.game1.core.screens;

import aritzh.libgdx.game1.core.input.InputHandler;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class MyScreen implements Screen {

    protected final OrthographicCamera camera;
    protected final List<ClickableRegion> regions = Lists.newArrayList();

    public MyScreen(OrthographicCamera camera) {
        this.camera = camera;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public boolean clickedAt(InputHandler.Pointer pointer) {
        for (ClickableRegion region : regions) {
            if (region.contains(pointer.getPoint())) {
                if (region.clicked(pointer.getButton())) return true;
            }
        }
        return false;
    }
}
