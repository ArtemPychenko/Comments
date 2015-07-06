package com.softserveinc.ita.commentstests.pages;

import com.softserveinc.ita.commentstests.domain.models.Category;
import com.softserveinc.ita.commentstests.domain.models.Comment;
import com.softserveinc.ita.commentstests.tools.controls.interfaces.IButton;
import com.softserveinc.ita.commentstests.tools.controls.interfaces.ICheckbox;
import com.softserveinc.ita.commentstests.tools.controls.interfaces.ILabel;
import com.softserveinc.ita.commentstests.tools.controls.interfaces.ITextInput;
import com.softserveinc.ita.commentstests.tools.controls.interfaces
.IValidationLabel;

/**
 * @author Dp-076 ATQC
 * This class describes the edit page object.
 */
public class EditPage extends Page {
    /**
     * UI Map controls for this page.
     */
    private EditPageUIMap controls;
    /**
     * The constructor of the class.
     */
    public EditPage() {
        verifyUrlStartWith("http://comments.azurewebsites.net/Editor/",
                "This is not the New/Duplicate/Edit page");
        controls = new EditPageUIMap();
    }

    /**
     * This method sets data to fields from current comment.
     * @param comment - comment object.
     * @return EditPage object.
     */
    public final EditPage setCommentData(Comment comment) {
        /* comment text field */
        controls.getCommentTextField().click();
        controls.getCommentTextField().clear();
        controls.getCommentTextField().type(comment.getCommentText());
        /* set comment number field */
        controls.getCommentNumberField().click();
        controls.getCommentNumberField().clear();
        controls.getCommentNumberField().type(
                comment.getCommentNumber().toString());
        /* set active check box */
        if (comment.getActive() != controls.getActiveCheckbox().isSelected()) {
            controls.getActiveCheckbox().click();
        }
        controls.getUnSelectAllCategoriesButton().click();
        this.clickOnCheckBoxAvailable(comment.getCategories());
        controls.getSelectOneCategorieButton().click();
    return this;
    }

    /**
     * This method sets text to text field from current comment.
     * @param comment - comment object.
     * @return EditPage object.
     */
    public final EditPage setCommentTextField(Comment comment){
        controls.getCommentTextField().click();
        controls.getCommentTextField().clear();
        controls.getCommentTextField().type(comment.getCommentText());
        return this;
   }
    /**
     * This method sets number to number field from current comment.
     * @param comment - comment object.
     * @return EditPage object.
     */
    public final EditPage setCommentNumberField(Comment comment){
        controls.getCommentNumberField().click();
        controls.getCommentNumberField().clear();
        controls.getCommentNumberField()
        .type(comment.getCommentNumber().toString());
        return this;
   }
    /**
     * This method gets data from fields to comment object.
     * @return Comment object.
     */
    public final Comment getCommentData() {
        return new Comment()
                .setCommentText(controls.getCommentTextField().getText())
                .setCommentNumber(getCommentNumber())
                .setActive(controls.getActiveCheckbox().isSelected())
                .setCategories(getCategoriesInSelectedCategories());
    }

    /**
     * This method return Short from number field.
     * @return Short number or null if field is empty.
     */
    private Short getCommentNumber() {
        String commentNumberString = controls.getCommentNumberField().getText();
        if (commentNumberString.equals("")) {
            return null;
        }
        return Short.parseShort(commentNumberString);
    }
    /**
     * @return Edit page after clicking "Refresh" link.
     */
    public final EditPage refreshPage() {
        controls.getRefreshLink().click();
        return new EditPage();
    }

    /**
     * @return text of the error message of this page.
     */
    public final String getErrorMessage() {
        return controls.getErrorMessage().getText();
    }

    /**
     * @return Main page after clicking "Return" link of this page.
     */
    public final MainPage quitByReturn() {
        controls.getReturnLink().click();
        return new MainPage();
    }
    /**
     * @return Edit page after clicking "Save" button of this page.
     */
    public final EditPage doSave() {
        controls.getSaveButton().click();
        return new EditPage();
    }
    /**
     * @return Main page after clicking "Save&Return" button of this page
     * in case, if saving operation was successful.
     */
    public final MainPage successfulSaveReturn() {
        controls.getSaveReturnButton().click();
        return new MainPage();
    }
    /**
     * @return Edit page after clicking "Save&Return" button of this page
     * in case, if saving operation was unsuccessful.
     */
    public final EditPage unSuccessfulSaveReturn() {
        controls.getSaveReturnButton().click();
        return new EditPage();
    }
    /**
     * @return "Save&Return" button of this page.
     */
    public final IButton getSaveReturnButton() {
       return controls.getSaveReturnButton();
    }

    public void clickOnCheckBoxAvailable(Category[] category) {
        controls.clickOnCheckBoxAvaible(category);
    }

    public void clickOnCheckBoxSelect(Category[] category) {
        controls.clickOnCheckBoxSelect(category);
    }

    public Category[] getCommentsInAvailableCategories() {
        return controls.getCategoriesInAvailableCategories();
    }

    public Category[] getCategoriesInSelectedCategories() {
        return controls.getCategoriesInSelectedCategories();
    }
    /**
     * @return label of the comment text input field.
     */
    public final ILabel getTextInputLabel() {
        return controls.getCommentTextFieldLabel();
    }
    /**
     * @return label of the comment number input field.
     */
    public final ILabel getNumberInputLabel() {
        return controls.getCommentNumberFieldLabel();
    }
    /**
     * @return comment text input field.
     */
    public final ITextInput getTextField() {
        return controls.getCommentTextField();
    }
    /**
     * @return comment number input field.
     */
    public final ITextInput getNumberField() {
        return controls.getCommentNumberField();
    }
    public ICheckbox getActiveCheckbox() {
        return controls.getActiveCheckbox();
    }
    public ILabel getNameAvailableCategoriesWindows() {
        return controls.getAvailableCategoriesWindowName();
    }

    public ILabel getNameSelectedCategoriesWindows() {
        return controls.getSelectedCategoriesWindowName();
    }

    public IButton getSelectAllCategoriesButton() {
        return controls.getSelectAllCategoriesButton();
    }

    public EditPage clickSelectAllCategoriesButton() {
        getSelectAllCategoriesButton().click();
        return this;
    }
    /**
     * @return validation message.
     */
    public final IValidationLabel getValidationLabel() {
        return controls.getErrorMessage();
    }
}
