package aritzh.libgdx.game1.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import aritzh.libgdx.game1.core.Game;

public class GameDesktop {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.useGL20 = true;
        config.foregroundFPS = 0; // Max FPS when window is in foreground
        config.width = 480;
        config.height = 800;
		new LwjglApplication(new Game(new DesktopProxy()), config);
	}
}
