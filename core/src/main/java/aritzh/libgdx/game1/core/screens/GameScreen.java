package aritzh.libgdx.game1.core.screens;

import aritzh.libgdx.game1.core.Game;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GameScreen implements Screen {

    private static final int MARGIN = 2;
    private final Game game;
    private final OrthographicCamera camera;
    private float elapsed;

    public GameScreen(final Game game) {
        this.game = game;
        this.camera = new OrthographicCamera();
    }

    @Override
    public void render(float delta) {

        if (Gdx.input.isKeyPressed(Input.Keys.Q)) Gdx.app.exit();

        elapsed += delta;
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        this.game.batch.setProjectionMatrix(this.camera.combined);
        this.game.batch.begin();

        this.game.batch.draw(this.game.texture, this.camera.viewportWidth / 2 - this.game.texture.getWidth() / 2 + 100 * (float) Math.sin(this.elapsed), this.camera.viewportHeight * 0.65f - this.game.texture.getHeight() / 2 + 100 * (float) Math.cos(this.elapsed));
        this.game.font32.draw(this.game.batch, this.camera.viewportWidth + "x" + this.camera.viewportHeight, MARGIN * 3, this.camera.viewportHeight - MARGIN * 3);

        this.game.font32.draw(this.game.batch, "Platform: " + Gdx.app.getType().toString(), MARGIN, this.game.font32.getLineHeight() * (Gdx.app.getType() == Application.ApplicationType.Android || Gdx.app.getType() == Application.ApplicationType.iOS ? 2 : 3));

        this.printInputs();

        this.game.font32.draw(this.game.batch, "MyGame - FPS: " + Gdx.graphics.getFramesPerSecond(), MARGIN, this.game.font32.getLineHeight());

        this.game.batch.end();
    }

    private void printInputs() {
        switch (Gdx.app.getType()) {
            case Android:
            case iOS:
                for (int i = 0; i < 20; i++) {
                    if (Gdx.input.isTouched(i)) {
                        String text = "C" + i + ": " + Gdx.input.getX(i) + ", " + Gdx.input.getY(i);
                        final int textX = MARGIN + (i % 4) * 100;
                        final float textY = 150 - (i / 4) * this.game.font.getLineHeight();
                        this.game.font.draw(this.game.batch, text, textX, textY);
                    }
                }
                break;
            default:
                this.game.font32.draw(this.game.batch, Gdx.input.getX() + "x" + Gdx.input.getY(), MARGIN, this.game.font32.getLineHeight() * 2);
                break;
        }
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
