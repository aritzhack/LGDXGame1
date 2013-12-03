package aritzh.libgdx.game1.core.screens;

import aritzh.libgdx.game1.core.Game;
import aritzh.libgdx.game1.core.util.RenderUtil;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class MainMenuScreen implements Screen {

    private static final int MARGIN = 6;
    private final Game game;
    private final OrthographicCamera camera;

    public MainMenuScreen(final Game game) {
        this.game = game;
        this.camera = new OrthographicCamera();
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            this.game.setScreen(new GameScreen(this.game));
        }

        camera.update();

        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        this.game.batch.setProjectionMatrix(camera.combined);
        this.game.batch.begin();

        RenderUtil.drawCenteredMultilineString(this.game.font32, this.game.batch, "Main menu\nClick to play the Game!");
        this.game.font32.draw(this.game.batch, Gdx.input.getX() + ", " + Gdx.input.getY(), MARGIN, this.game.font32.getLineHeight());

        this.game.batch.end();

    }

    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, width, height);
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
