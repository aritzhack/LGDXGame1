package aritzh.libgdx.game1.core;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public interface Proxy {

    public boolean vsync();

    public PlatformInput createPlatformInput(InputHandler handler);
}
