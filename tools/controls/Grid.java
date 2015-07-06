package com.softserveinc.ita.commentstests.tools.controls;

import java.util.List;

import com.softserveinc.ita.commentstests.tools.ContextVisible;
import com.softserveinc.ita.commentstests.tools.ControlLocation;
import com.softserveinc.ita.commentstests.tools.ControlWrapper;
import com.softserveinc.ita.commentstests.tools.ControlWrapperList;
/**
 * This class returns a grid of comments in a page.
 *
 * @author Dp-076 ATQC
 */
public final class Grid {
    /**
     * Object-list of ControlWrapper class.
     */
    private List<ControlWrapper> controlList;
    /**
     * Constructor.
     *
     * @param theControlList
     *            - object-list of ControlWrapper class.
     */
    private Grid(final List<ControlWrapper> theControlList) {
        controlList = theControlList;
    }
    /**
     * Method finds grid by xpath.
     * @param xpathExpression locator
     * @return get grid by xpath
     */
    public static Grid getByXpath(final String xpathExpression) {
        return getGrid(ControlLocation.getByXPath(xpathExpression));
    }
    /**
     * Method finds grid by class name.
     * @param className locator
     * @return get grid by class name
     */
    public static Grid getByClassName(final String className) {
        return getGrid(ControlLocation.getByClassName(className));
    }
    /**
     * Method returns grid as WebElement.
     * @param controlLocation locator
     * @return get grid as WebElement
     */
    private static Grid getGrid(final ControlLocation controlLocation) {
        return new Grid(ControlWrapperList.getList(ContextVisible.get()
                .getList(controlLocation)));
    }
    /**
     * Method should get index of grid.
     * @param index of grid
     * @return get index of grid
     */
    public ControlWrapper get(final int index) {
        return controlList.get(index);
    }
    /**
     * Method returns size of grid.
     * @return size of grid
     */
    public int getSize() {
        return controlList.size();
    }
}
