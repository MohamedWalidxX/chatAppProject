package chatPack;

import java.awt.image.BufferedImage;

public class Image {
    private final int id;
    private final BufferedImage image;

    public Image(int id, BufferedImage image) {
        this.id = id;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public BufferedImage getImage() {
        return image;
    }

}
