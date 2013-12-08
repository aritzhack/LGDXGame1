package aritzh.libgdx.game1.java;

import aritzh.libgdx.game1.core.Game;
import aritzh.libgdx.game1.core.Proxy;
import aritzh.libgdx.game1.core.input.InputHandler;
import aritzh.libgdx.game1.core.input.KeyboardInput;
import aritzh.libgdx.game1.core.input.PlatformInput;
import aritzh.libgdx.game1.core.render.DesktopRenderer;
import aritzh.libgdx.game1.core.render.Renderer;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class DesktopProxy implements Proxy {

    @Override
    public boolean vsync() {
        return false;
    }

    @Override
    public PlatformInput createPlatformInput(InputHandler handler) {
        return new KeyboardInput(handler);
    }

    @Override
    public Renderer getRenderer(Game game) {
        return new DesktopRenderer(game);
    }
}
