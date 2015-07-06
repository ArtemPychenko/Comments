package com.softserveinc.ita.commentstests.tools;

import org.openqa.selenium.WebElement;
/**
 * @author Dp-076 ATQC
 * This class is wrapper for WebElement methods.
 */
public class ControlWrapper {
    /**
     * identify of WebElement searchContext field .
     */
    protected WebElement searchContext;
    /**
     * Constructor.
     * @param theSearchContext
     *            - WebElement object
     */
    public ControlWrapper(final WebElement theSearchContext) {
        searchContext = theSearchContext;
    }
    /**
     * Wrapped access point to WebElement methods.
     * @return WebElement object.
     */
    public final WebElement get() {
        return searchContext;
    }
    /**
     * Wrapper for WebElement method "click()".
     */
    public final void click() {
        get().click();
    }
    /**
     * Wrapper for WebElement method "clear()".
     */
    public final void clear() {
        get().clear();
    }
    /**
     * Wrapper for WebElement method "submit()".
     */
    public final void submit() {
        get().submit();
    }
    /**
     * Wrapper for WebElement method "isSelected()".
     * @return selected element
     */
    public final boolean isSelected() {
        return get().isSelected();
    }
    /**
     * Wrapper for WebElement method "isEnabled()".
     * @return enabled element
     */
    public final boolean isEnabled() {
        return get().isEnabled();
    }
    /**
     * Wrapper for WebElement method "getText()".
     * @return text
     */
    public final String getText() {
        return get().getText();
    }
    /**
     * Wrapper for WebElement method "isSelected()".
     * @param text to send
     */
    public final void sendText(final String text) {
        get().sendKeys(text);
    }
    /**
     * Wrapper for WebElement method "isDisplayed()".
     * @return true, if element displayed and false, if not
     */
    public final boolean isDisplayed() {
        return get().isDisplayed();
    }
    /**
     * Wrapper for WebElement method "getAttribute".
     * @param attrName to send
     * @return attribute name
     */
    public final String getAttribute(final String attrName) {
        return get().getAttribute(attrName);
    }

}
