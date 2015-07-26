package editor;

/**
 * Created by Filip on 2015-07-23.
 */
public interface TableSetup {
    void setWidth(int width);
    void setHeight(int height);
    void setxCoord(int xCoord);
    void setyCoord(int yCoord);
    void setId(String id);

    int getWidth();
    int getHeight();
    int getxCoord();
    int getyCoord();
    String getId();

}
