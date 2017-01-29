package core;

import java.awt.*;

/**
 * Created by mahonbd on 1/28/2017.
 */
public interface Clickable {

    void clickNotify(Point mousePos, boolean move, boolean click, boolean release);
}
