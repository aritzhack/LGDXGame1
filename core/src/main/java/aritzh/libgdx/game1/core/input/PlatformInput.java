package aritzh.libgdx.game1.core.input;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class PlatformInput {

    protected InputHandler handler;

    public PlatformInput(InputHandler handler) {
        this.handler = handler;
    }

    public abstract boolean isLeftPressed();

    public abstract boolean isRightPressed();

    public abstract boolean isJumpPressed();

}
