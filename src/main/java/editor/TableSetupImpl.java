package editor;

import java.io.Serializable;

/**
 * Created by Filip on 2015-07-25.
 */
public class TableSetupImpl implements TableSetup, Serializable {
    String id;
    int xCoord;
    int yCoord;
    int width;
    int height;


    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getxCoord() {
        return xCoord;
    }

    @Override
    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    @Override
    public int getyCoord() {
        return yCoord;
    }

    @Override
    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TableSetupImpl{" +
                "ID='" + id + '\'' +
                ", xCoord=" + xCoord +
                ", yCoord=" + yCoord +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
