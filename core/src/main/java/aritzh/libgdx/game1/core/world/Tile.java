package aritzh.libgdx.game1.core.world;

import aritzh.libgdx.game1.core.util.Rectangle;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Tile {

    public static final Map<Integer, Tile> idToTile = Maps.newHashMap();
    public static final int TILE_SIZE = 64;
    private final int id;
    private final String name;
    private final Rectangle bound;
    private Rectangle bounds;
    private TextureRegion texture;
    private float hardness = 1.0f;
    private World world;

    public Tile(int id, String name, World world) {
        this(id, name, world, 1.0f, new Rectangle(0, 0, 64, 64), world.getGame().tiles[0]);
    }

    public Tile(int id, String name, World world, float hardness, Rectangle bound, TextureRegion texture) {
        Preconditions.checkArgument(!Tile.idToTile.containsKey(id), "ID " + id + " already used by tile: " + idToTile.get(id));
        this.hardness = hardness;
        this.bound = bound;
        this.texture = texture;
        this.id = id;
        this.name = name;
        this.world = world;
    }

    @Override
    public String toString() {
        return "tile." + this.name;
    }

    public void render(int x, int y) {
        this.world.getGame().batch.draw(this.texture, x * TILE_SIZE, y * TILE_SIZE);
    }

    public int getId() {
        return this.id;
    }

    public Rectangle getBounds() {
        return this.bounds;
    }

    public TextureRegion getTexture() {
        return this.texture;
    }

    public float getHardness() {
        return this.hardness;
    }
}
