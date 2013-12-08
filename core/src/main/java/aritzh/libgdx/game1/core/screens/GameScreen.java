package aritzh.libgdx.game1.core.screens;

import aritzh.libgdx.game1.core.Game;
import aritzh.libgdx.game1.core.input.InputHandler;
import aritzh.libgdx.game1.core.render.Renderer;
import aritzh.libgdx.game1.core.render.gui.ClickHandler;
import aritzh.libgdx.game1.core.render.gui.GUIButton;
import aritzh.libgdx.game1.core.util.Rectangle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GameScreen extends MyScreen {

    private static final String TAG = "LGDXG1";
    private final Renderer renderer;

    public GameScreen(final Game game) {
        super(game, new OrthographicCamera());
        this.renderer = this.game.proxy.getRenderer(this.game);

        final Rectangle rectangle = new Rectangle((int) this.game.width - 64 - Renderer.MARGIN, (int) this.game.height - 64 - Renderer.MARGIN, 64, 64);

        final ClickHandler handler = new ClickHandler() {
            @Override
            public boolean handle(InputHandler.Pointer pointer, int finger) {
                Gdx.app.debug(TAG, "Yeah!");
                return false;
            }
        };
        this.guiElements.add(new GUIButton(this, rectangle, handler, this.game.icons[0], this.game.icons[8]));
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        this.game.batch.setProjectionMatrix(this.camera.combined);
        this.game.batch.begin();

        this.renderer.renderAll(delta, true);

        this.game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        this.camera.setToOrtho(false, width, height);
        this.game.width = width;
        this.game.height = height;
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }

}
