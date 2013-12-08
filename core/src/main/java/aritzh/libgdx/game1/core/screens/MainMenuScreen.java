package aritzh.libgdx.game1.core.screens;

import aritzh.libgdx.game1.core.Game;
import aritzh.libgdx.game1.core.util.RenderUtil;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class MainMenuScreen extends MyScreen {

    private static final int MARGIN = 6;

    public MainMenuScreen(final Game game) {
        super(game, new OrthographicCamera());
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
