package aritzh.libgdx.game1.core;

import aritzh.libgdx.game1.core.input.InputHandler;
import aritzh.libgdx.game1.core.screens.MainMenuScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends com.badlogic.gdx.Game {
    public final Proxy proxy;
    public Texture texture;
    public SpriteBatch batch;
    public BitmapFont font;
    public BitmapFont font32;
    public InputHandler inputProcessor;

    public Game(Proxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public void create() {
        texture = new Texture(Gdx.files.internal("libgdx-logo.png"));
        font = new BitmapFont();
        font32 = new BitmapFont(Gdx.files.internal("arial32.fnt"), false);
        batch = new SpriteBatch();
        inputProcessor = new InputHandler(this);
        Gdx.input.setInputProcessor(this.inputProcessor);
        Gdx.graphics.setVSync(this.proxy.vsync());
        this.setScreen(new MainMenuScreen(this));
    }
}
