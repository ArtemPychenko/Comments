package com.softserveinc.ita.commentstests.pages;

import com.softserveinc.ita.commentstests.tools.controls.Button;
import com.softserveinc.ita.commentstests.tools.controls.Label;
import com.softserveinc.ita.commentstests.tools.controls.interfaces.IButton;
import com.softserveinc.ita.commentstests.tools.controls.interfaces.ILabel;

/**
 * @author Dp-076 ATQC
 * This class allows to create the error dialog page object.
 */
public class ErrorDialogPage extends Page {

    /**
     *The "Ok" button of the error dialog page.
     */
    private IButton okButton;
    /**
     * The text of the error dialog page.
     */
    private ILabel label;

    /**
     * The constructor of the class.
     */
    public ErrorDialogPage() {

        this.okButton = Button
                .getByXpath("//div[div[@id='dialog']]//button");
        this.label = Label.getByXpath("//p[@id='msgText']");
    }

    /**
     * @return the text of this error dialog page.
     */
    public final String getMessage() {
        return this.label.getText();
    }

    /**
     * @return the "Ok" button of this error dialog page.
     */
    public final IButton getOkButton() {
        return this.okButton;
    }

    /**
     * @return Main page after clicking "Ok" button on this
     * error dialog page.
     */
    public final MainPage clickOk() {
        this.okButton.click();
        return new MainPage();
    }

}
