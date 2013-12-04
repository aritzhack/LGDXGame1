package aritzh.libgdx.game1.java;

import aritzh.libgdx.game1.core.Game;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class GameDesktop {
    public static void main(String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.useGL20 = true;
        config.foregroundFPS = 0; // Max FPS when window is in foreground
        config.width = 800;
        config.height = 480;
        new LwjglApplication(new Game(new DesktopProxy()), config);
    }
}
