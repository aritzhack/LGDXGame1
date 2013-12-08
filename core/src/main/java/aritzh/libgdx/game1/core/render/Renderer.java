package aritzh.libgdx.game1.core.render;

import aritzh.libgdx.game1.core.Game;
import aritzh.libgdx.game1.core.input.InputHandler;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class Renderer {

    public static final int MARGIN = 2;

    public static enum Layer {
        HUD, BACKGROUND, ENTITIES, WORLD, DEBUG
    }

    protected Game game;
    protected float elapsed;

    public Renderer(Game game) {
        this.game = game;
    }

    public void renderAll(float delta, boolean debug) {
        elapsed += delta;
        this.renderBackground(delta);
        this.renderWorld(delta);
        this.renderEntities(delta);
        this.renderHud(delta);

        if (debug) this.renderDebug(delta);
    }

    public void renderHud(float delta) {
        this.game.batch.draw(this.game.icons[0], (int) this.game.width - 64 - Renderer.MARGIN, (int) this.game.height - 64 - Renderer.MARGIN, 64, 64);
        this.game.currScreen.renderGUI();
    }

    public void renderBackground(float delta) {
    }

    public void renderEntities(float delta) {
        this.game.batch.draw(this.game.texture, this.game.width * 0.65f - this.game.texture.getWidth() / 2 + 100 * (float) Math.sin(this.elapsed), this.game.height / 2 - this.game.texture.getHeight() / 2 + 100 * (float) Math.cos(this.elapsed));
    }

    public void renderWorld(float delta) {
    }


    public void renderDebug(float delta) {

        this.game.font32.draw(this.game.batch, this.game.width + "x" + this.game.height, MARGIN * 3, this.game.height - MARGIN * 3);

        this.game.font32.draw(this.game.batch, "Platform: " + Gdx.app.getType().toString(), MARGIN, this.game.font32.getLineHeight() * (Gdx.app.getType() == Application.ApplicationType.Android || Gdx.app.getType() == Application.ApplicationType.iOS ? 2 : 3));

        this.printInputs();

        this.game.font32.draw(this.game.batch, "MyGame - FPS: " + Gdx.graphics.getFramesPerSecond(), MARGIN, this.game.font32.getLineHeight());
    }

    private void printInputs() {
        switch (Gdx.app.getType()) {
            case Android:
                for (int i = 0; i < 20; i++) {
                    InputHandler.Pointer p = this.game.input.getPointer(i);
                    if (p != null) {
                        String text = "C" + i + ": " + p;
                        final int textX = MARGIN + (i % 4) * 100;
                        final float textY = 150 - (i / 4) * this.game.font.getLineHeight();
                        this.game.font.draw(this.game.batch, text, textX, textY);
                    }
                }

                this.game.font.draw(this.game.batch, "Accelerometer: X:" + this.round(Gdx.input.getAccelerometerX(), 2) , MARGIN, this.game.font.getLineHeight() + this.game.font32.getLineHeight()*2);
                this.game.font.draw(this.game.batch, "Y:" + this.round(Gdx.input.getAccelerometerY(), 2), MARGIN + 150, this.game.font.getLineHeight() + this.game.font32.getLineHeight()*2);
                this.game.font.draw(this.game.batch, "Z:" + this.round(Gdx.input.getAccelerometerZ(), 2), MARGIN + 200, this.game.font.getLineHeight() + this.game.font32.getLineHeight()*2);
                break;
            default:
                if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) this.game.font32.setColor(Color.RED);
                this.game.font32.draw(this.game.batch, this.game.input.getPointer(0).toString(), MARGIN, this.game.font32.getLineHeight() * 2);
                this.game.font32.setColor(Color.WHITE);
                break;
        }
    }

    private BigDecimal round(float inputValue, int decimals){
        BigDecimal ret = new BigDecimal(Float.toString(inputValue));
        return ret.setScale(decimals, RoundingMode.HALF_UP);
    }
}
