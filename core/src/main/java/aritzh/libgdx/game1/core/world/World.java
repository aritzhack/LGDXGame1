package aritzh.libgdx.game1.core.world;

import aritzh.libgdx.game1.core.Game;
import aritzh.libgdx.game1.core.util.BidimensionalArray;
import com.badlogic.gdx.files.FileHandle;
import com.google.common.base.Preconditions;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class World {

    private final Game game;
    private final BidimensionalArray<Tile> world;

    private World(Game game, BidimensionalArray<Tile> world){
        this.game = game;
        this.world = world;
    }

    public Tile getTile(int x, int y){
        return this.world.get(x, y);
    }

    public Game getGame() {
        return game;
    }

    public static World loadWorld(Game game, FileHandle handle){
        Preconditions.checkArgument(!handle.isDirectory(), "World file is a file, not a directory!");
        Preconditions.checkArgument(!handle.exists(), "World file must exist, use World.newWorld() in order to create a new one!");
        Preconditions.checkArgument(game != null, "Game must not be null!");

        int width, height;

        // TODO Load world, maybe use BDS?

        BidimensionalArray<Tile> array = new BidimensionalArray<Tile>(width, height);

        return new World(game, array);
    }
}
