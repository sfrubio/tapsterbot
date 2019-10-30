package utils;

public interface TapsterbotService {
    
    void tapOnScreen(Integer x, Integer y);

    void tapOnTopScreen(Integer x, Integer y);

    void tapOnMiddleScreen(Integer x, Integer y);

    void tapOnBottomScreen(Integer x, Integer y);

    void returnToCenter();

    void drawCircle(Integer x, Integer y, Integer radius);

    void drawArc(Integer x, Integer y);

    void dragAndDrop(Integer[] startCoords, Integer[] endCoords);
}
