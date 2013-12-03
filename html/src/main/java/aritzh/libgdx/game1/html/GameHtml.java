package aritzh.libgdx.game1.html;

import aritzh.libgdx.game1.core.Game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class GameHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new Game(new HtmlProxy());
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 800);
	}
}
