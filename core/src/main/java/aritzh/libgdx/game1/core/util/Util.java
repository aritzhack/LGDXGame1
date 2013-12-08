package aritzh.libgdx.game1.core.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Util {

    public static <T> T[] flattenArray(T[][] array) {
        ArrayList<T> retList = new ArrayList<T>();
        for (T[] row : array) {
            for (T t : row) {
                retList.add(t);
            }
        }
        return retList.toArray(array[0]);
    }

    public static TextureRegion[] getInternalAnimation(String path, int iconWidth, int iconHeight) {
        Texture iconSheet = new Texture(Gdx.files.internal(path));
        return Util.flattenArray(TextureRegion.split(iconSheet, iconWidth, iconHeight));
    }
}
