package aritzh.libgdx.game1.core.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class RenderUtil {

    public static void drawCenteredString(final BitmapFont font, final Batch batch, final CharSequence charSequence) {
        RenderUtil.drawCenteredString(font, batch, charSequence, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public static void drawCenteredString(final BitmapFont font, final Batch batch, final CharSequence charSequence, float minX, float minY, float maxX, float maxY) {
        BitmapFont.TextBounds bounds = font.getBounds(charSequence);
        float newX = minX + (maxX - minX - bounds.width) / 2;
        float newY = minY + (maxY - minY - bounds.height) / 2;
        font.drawMultiLine(batch, charSequence, newX, newY);
    }

    public static void drawCenteredMultilineString(final BitmapFont font, final Batch batch, final CharSequence charSequence) {
        RenderUtil.drawCenteredMultilineString(font, batch, charSequence, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public static void drawCenteredMultilineString(final BitmapFont font, final Batch batch, final CharSequence charSequence, int minX, int minY, int maxX, int maxY) {
        float lastHeight = 0;
        final String[] lines = charSequence.toString().split("\n");
        for (int i = lines.length - 1; i >= 0; i--) {
            String s = lines[i];
            RenderUtil.drawCenteredString(font, batch, s, minX, minY + lastHeight * 2, maxX, maxY);
            lastHeight += font.getLineHeight();
        }
    }
}
