package aritzh.libgdx.game1.core;

import aritzh.libgdx.game1.core.input.InputHandler;
import aritzh.libgdx.game1.core.screens.MainMenuScreen;
import aritzh.libgdx.game1.core.screens.MyScreen;
import aritzh.libgdx.game1.core.util.Util;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Game extends com.badlogic.gdx.Game {
    public final Proxy proxy;
    public Texture texture;
    public TextureRegion[] icons;
    public SpriteBatch batch;
    public BitmapFont font;
    public BitmapFont font32;
    public InputHandler input;
    public MyScreen currScreen;
    public float width, height;

    public Game(Proxy proxy) {
        this.proxy = proxy;

    }

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        texture = new Texture(Gdx.files.internal("libgdx-logo.png"));
        icons = Util.getInternalAnimation("iconSheet.png", 64, 64);
        font = new BitmapFont();
        font32 = new BitmapFont(Gdx.files.internal("arial32.fnt"), false);
        batch = new SpriteBatch();
        input = new InputHandler(this);
        Gdx.input.setInputProcessor(this.input);
        Gdx.graphics.setVSync(this.proxy.vsync());
        this.setScreen(new MainMenuScreen(this));
    }

    public void setScreen(Screen screen) {
        super.setScreen(screen);
        this.currScreen = (MyScreen) screen;
    }
}
