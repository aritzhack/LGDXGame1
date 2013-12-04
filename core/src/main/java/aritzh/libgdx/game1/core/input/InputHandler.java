package aritzh.libgdx.game1.core.input;

import aritzh.libgdx.game1.core.Game;
import aritzh.libgdx.game1.core.util.Point;
import aritzh.libgdx.game1.core.util.Rectangle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class InputHandler implements InputProcessor {

    private static final int KEY_ARRAY_SIZE = 1024;
    private final boolean[] keys = new boolean[KEY_ARRAY_SIZE];
    private final Pointer[] pointers = new Pointer[20];
    private final Game game;

    public InputHandler(Game game) {
        this.game = game;
        this.game.proxy.createPlatformInput(this);
    }

    @Override
    public boolean keyDown(int keycode) {
        keys[keycode] = true;

        switch (keycode) {
            case Input.Keys.MENU:
                Gdx.input.vibrate(1000);
                return true;
            case Input.Keys.Q:
                Gdx.app.exit();
                return true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        keys[keycode] = false;
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        pointers[pointer] = new Pointer(button, screenX, screenY);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        pointers[pointer] = null;
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public boolean isKeyDown(int keycode) {
        return keycode < KEY_ARRAY_SIZE && this.keys[keycode];
    }

    public boolean isPointerDown(int pointer) {
        return pointer < 20 && this.pointers[pointer] != null;
    }

    public Pointer getPointer(int pointer) {
        return pointer < 20 ? this.pointers[pointer] : null;
    }

    public boolean isPointerPressedAt(int x, int y, int width, int height) {
        Rectangle r = new Rectangle(x, y, width, height);
        for (Pointer p : this.pointers) {
            if (p == null) continue;
            if (r.contains(p.getPoint())) return true;
        }
        return false;
    }

    public static class Pointer {
        private final int button;
        private final Point point;

        public Pointer(int button, int x, int y) {
            this.button = button;
            this.point = new Point(x, y);
        }

        public int getButton() {
            return button;
        }

        public int getX() {
            return this.point.getX();
        }

        public int getY() {
            return this.point.getY();
        }

        public Point getPoint() {
            return point;
        }
    }
}
