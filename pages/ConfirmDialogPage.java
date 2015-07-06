package com.softserveinc.ita.commentstests.pages;

import com.softserveinc.ita.commentstests.tools.controls.Button;
import com.softserveinc.ita.commentstests.tools.controls.Label;
import com.softserveinc.ita.commentstests.tools.controls.interfaces.IButton;
import com.softserveinc.ita.commentstests.tools.controls.interfaces.ILabel;

/**
 * @author Dp-076 ATQC
 * This class allows to create the confirm dialog page object.
 */
public class ConfirmDialogPage extends Page {

    /**
     * The text of the confirm dialog page.
     */
    private ILabel label;
    /**
     * The "Yes" button of the confirm dialog page.
     */
    private IButton yesButton;
    /**
     * The "No" button of the confirm dialog page.
     */
    private IButton noButton;

    /**
     * The constructor of the class.
     */
    public ConfirmDialogPage() {

        this.label = Label.getByXpath("//p[@id='msgText']");
        this.yesButton = Button
                .getByXpath("//div[div[@id='dialog']]//button[1]");
        this.noButton = Button
                .getByXpath("//div[div[@id='dialog']]//button[2]");

    }

    /**
     * @return the text message of this confirm dialog page.
     */
    public final String getMessage() {
        return this.label.getText();
    }

    /**
     * @return Main page after clicking "Yes" button on this
     * confirm dialog page.
     */
    public final MainPage clickYes() {
        this.yesButton.click();
        return new MainPage();
    }

    /**
     * @return the "Yes" button of this confirm dialog page.
     */
    public final IButton getYesButton() {
        return this.yesButton;
    }

    /**
     * @return Main page after clicking "No" button on this
     * confirm dialog page.
     */
    public final MainPage clickNo() {
        this.noButton.click();
        return new MainPage();
    }

    /**
     * @return the "No" button of this confirm dialog page.
     */
    public final IButton getNoButton() {
        return this.noButton;
    }
}
