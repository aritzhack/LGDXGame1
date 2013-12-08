package aritzh.libgdx.game1.core.input;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class OnScreenInput extends PlatformInput {

    public OnScreenInput(InputHandler handler) {
        super(handler);
    }

    @Override
    public boolean isLeftPressed() {
        // TODO Get screen region for left
        return false;
    }

    @Override
    public boolean isRightPressed() {
        // TODO Get screen region for right
        return false;
    }

    @Override
    public boolean isJumpPressed() {
        // TODO Get screen region for jump
        return false;
    }

    @Override
    public boolean isPausePressed() {
        // TODO Get screen region for pause
        return false;
    }
}
