package aritzh.libgdx.game1.core;

import aritzh.libgdx.game1.core.input.InputHandler;
import aritzh.libgdx.game1.core.input.PlatformInput;
import aritzh.libgdx.game1.core.render.Renderer;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public interface Proxy {

    public boolean vsync();

    public PlatformInput createPlatformInput(InputHandler handler);

    public Renderer getRenderer(Game game);
}
