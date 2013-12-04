package aritzh.libgdx.game1.core.input;

import static com.badlogic.gdx.Input.Keys.*;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class KeyboardInput extends PlatformInput {

    public KeyboardInput(InputHandler handler) {
        super(handler);
    }

    @Override
    public boolean isLeftPressed() {
        return this.handler.isKeyDown(LEFT) || this.handler.isKeyDown(A);
    }

    @Override
    public boolean isRightPressed() {
        return this.handler.isKeyDown(RIGHT) || this.handler.isKeyDown(D);
    }

    @Override
    public boolean isJumpPressed() {
        return this.handler.isKeyDown(SPACE) || this.handler.isKeyDown(W);
    }
}
