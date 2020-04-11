/**
 * The Disk class holds coordinates of a disk in the game.
 *
 * @author Amirreza Hashemi
 * @version 1.0
 * @since 4/4/2020
 */
public class Disk {
    //The vertical coordinates of disk.
    private int x;
    //The horizontal coordinates of disk.
    private int y;

    /**
     * Instantiates a new Disk.
     *
     * @param x the vertical coordinates of disk
     * @param y the horizontal coordinates of disk
     */
    public Disk(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets x.
     *
     * @return the vertical coordinates of disk
     */
    public int getX() {
        return x;
    }

    /**
     * Gets y.
     *
     * @return the horizontal coordinates of disk
     */
    public int getY() {
        return y;
    }
}
