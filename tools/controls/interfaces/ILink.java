package com.softserveinc.ita.commentstests.tools.controls.interfaces;
/**
 * This interface is a layer between controls level and higher levels.
 *
 * @author Dp-076 ATQC
 */
public interface ILink {
    /**
     * Wrapper for the WebElement method "click()".
     */
    void click();
    /**
     * Wrapper for the WebElement method "getText()".
     *
     * @return text
     */
    String getText();
    /**
     * Wrapper for the WebElement method "isDisplayed".
     *
     * @return true, if displayed or false if not
     */
    boolean isDisplayed();
}
