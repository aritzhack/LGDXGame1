package aritzh.libgdx.game1.core.input;

import aritzh.libgdx.game1.core.Game;
import aritzh.libgdx.game1.core.util.Point;
import aritzh.libgdx.game1.core.util.Rectangle;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;

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
        if (keycode == Input.Keys.Q || keycode == Input.Keys.BACK) Gdx.app.exit();
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

    public Point unprojectCoord(int x, int y) {
        Vector3 coord = new Vector3(x, y, 0);
        this.game.currScreen.getCamera().unproject(coord);
        return new Point((int) coord.x, (int) coord.y);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        pointers[pointer] = new Pointer(button, this.unprojectCoord(screenX, screenY));
        this.game.currScreen.getCurrGUI().touchedDown(pointers[pointer], pointer);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        pointers[pointer] = null;
        return this.game.currScreen.getCurrGUI().touchedUp(new Pointer(button, this.unprojectCoord(screenX, screenY)), pointer);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        this.pointers[pointer] = new Pointer(Input.Buttons.LEFT, this.unprojectCoord(screenX, screenY));
        this.game.currScreen.getCurrGUI().dragged(this.pointers[pointer], pointer);
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return this.game.currScreen.scrolled(amount);
    }

    public boolean isKeyDown(int... keycodes) {
        for (int keycode : keycodes) {
            if (keycode < KEY_ARRAY_SIZE && this.keys[keycode]) return true;
        }
        return false;
    }

    public boolean isPointerDown(int pointer) {
        return pointer < 20 && this.pointers[pointer] != null;
    }

    public Pointer getPointer(int pointer) {
        if (Gdx.app.getType() == Application.ApplicationType.Desktop && this.pointers[0] == null) {
            return new Pointer(-1, this.unprojectCoord(Gdx.input.getX(), Gdx.input.getY()));
        } else return pointer <= 20 || pointer > 0 ? this.pointers[pointer] : null;
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

        public Pointer(int button, Point point) {
            this.button = button;
            this.point = point;
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

        @Override
        public String toString() {
            return point.getX() + "x" + point.getY();
        }
    }
}
