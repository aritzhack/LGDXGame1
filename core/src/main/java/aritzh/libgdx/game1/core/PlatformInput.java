package aritzh.libgdx.game1.core;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class PlatformInput {

    private InputHandler handler;

    public PlatformInput(InputHandler handler){
        this.handler = handler;
    }

    public abstract boolean isLeftPressed();
    public abstract boolean isRightPressed();
    public abstract boolean isJumpPressed();

}
