package aritzh.libgdx.game1.android;

import aritzh.libgdx.game1.core.Proxy;
import aritzh.libgdx.game1.core.input.InputHandler;
import aritzh.libgdx.game1.core.input.OnScreenInput;
import aritzh.libgdx.game1.core.input.PlatformInput;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AndroidProxy implements Proxy {

    @Override
    public boolean vsync() {
        return true;
    }

    @Override
    public PlatformInput createPlatformInput(InputHandler handler) {
        return new OnScreenInput(handler);
    }
}
