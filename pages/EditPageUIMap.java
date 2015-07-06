package com.softserveinc.ita.commentstests.pages;

import com.softserveinc.ita.commentstests.domain.models.Category;
import com.softserveinc.ita.commentstests.tools.controls.Button;
import com.softserveinc.ita.commentstests.tools.controls.Checkbox;
import com.softserveinc.ita.commentstests.tools.controls.Label;
import com.softserveinc.ita.commentstests.tools.controls.Link;
import com.softserveinc.ita.commentstests.tools.controls.TextInput;
import com.softserveinc.ita.commentstests.tools.controls.ValidationLabel;
import com.softserveinc.ita.commentstests.tools.controls.interfaces.IButton;
import com.softserveinc.ita.commentstests.tools.controls.interfaces.ICheckbox;
import com.softserveinc.ita.commentstests.tools.controls.interfaces.ILabel;
import com.softserveinc.ita.commentstests.tools.controls.interfaces.ILink;
import com.softserveinc.ita.commentstests.tools.controls.interfaces.ITextInput;
import com.softserveinc
        .ita.commentstests.tools.controls.interfaces.IValidationLabel;

/**
 * @author Dp-076 ATQC
 * This class describes UI elements of the new/duplicate/edit page.
 */
public class EditPageUIMap {
    /**
     * Return link of the new/duplicate/edit page.
     */
    private ILink returnLink;
    /**
     * Refresh link of the new/duplicate/edit page.
     */
    private ILink refreshLink;
    /**
     * Save button of the new/duplicate/edit page.
     */
    private IButton saveButton;
    /**
     * SaveReturn button of the new/duplicate/edit page.
     */
    private IButton saveReturnButton;
    /**
     * Comment text field of the new/duplicate/edit page.
     */
    private ITextInput commentTextField;
    /**
     * Number text field of the new/duplicate/edit page.
     */
    private ITextInput commentNumberField;
    /**
     * Active checkbox of the new/duplicate/edit page.
     */
    private ICheckbox activeCheckbox;
    /**
     * Select all categories button of the new/duplicate/edit page.
     */
    private IButton selectAllCategoriesButton;
    /**
     * Select one category button of the new/duplicate/edit page.
     */
    private IButton selectOneCategorieButton;
    /**
     * Unselect all categories button of the new/duplicate/edit page.
     */
    private IButton unSelectAllCategoriesButton;
    /**
     * Unselect one category button of the new/duplicate/edit page.
     */
    private IButton unSelectOneCategorieButton;
    /**
     * Error red label of the new/duplicate/edit page.
     */
    private IValidationLabel errorField;
    /**
     *  Available categories field of the new/duplicate/edit page.
     */
    private CategoriesWindowInEditPage availableCategories;
    /**
     *  Selected categories field of the new/duplicate/edit page.
     */
    private CategoriesWindowInEditPage selectedCategories;
    /**
     *  Available categories field label of the new/duplicate/edit page.
     */
    private ILabel availableCategoriesWindowName;
    /**
     *  Selected categories field label of the new/duplicate/edit page.
     */
    private ILabel selectedCategoriesWindowName;
    /**
     *  Comment text field label of the new/duplicate/edit page.
     */
    private ILabel commentTextFieldLabel;
    /**
     *  Comment number field label of the new/duplicate/edit page.
     */
    private ILabel commentNumberFieldLabel;
    /**
     * The constructor of the class.
     */
    public EditPageUIMap() { }
    /**
     * Getter for Return link.
     * @return "Return" link of this page.
     */
    public final ILink getReturnLink() {
        if (this.returnLink == null) {
            this.returnLink = Link.getByXpath("//*[@id='logindisplay']/a");
        }
        return returnLink;
    }
    /**
     * Getter for Refresh link.
     * @return "Refresh" link of this page.
     */
    public final ILink getRefreshLink() {
        if (this.refreshLink == null) {
            this.refreshLink = Link
                    .getByXpath(".//*[@id='editor-navigation']/a");
        }
        return refreshLink;
    }
    /**
     * Getter for Save button.
     * @return "Save" button of this page.
     */
    public final IButton getSaveButton() {
        if (this.saveButton == null) {
            this.saveButton = Button
                    .getByXpath(".//*[@id='editor-navigation']/input[1]");
        }
        return saveButton;
    }
    /**
     * Getter for SaveReturn button.
     * @return "SaveReturn" button of this page.
     */
    public final IButton getSaveReturnButton() {
        if (this.saveReturnButton == null) {
            this.saveReturnButton = Button
                    .getByXpath(".//*[@id='editor-navigation']/input[2]");
        }
        return saveReturnButton;
    }
    /**
     * Getter for comment text field.
     * @return "Text field" of this page.
     */
    public final ITextInput getCommentTextField() {
        if (this.commentTextField == null) {
            this.commentTextField = TextInput.getById("Text");
        }
        return commentTextField;
    }
    /**
     * Getter for number field.
     * @return "Number field" of this page.
     */
    public final ITextInput getCommentNumberField() {
        if (this.commentNumberField == null) {
            this.commentNumberField = TextInput.getById("Number");
        }
        return commentNumberField;
    }
    /**
     * Getter for active checkbox.
     * @return Active checkbox of this page.
     */
    public final ICheckbox getActiveCheckbox() {
        if (this.activeCheckbox == null) {
            this.activeCheckbox = Checkbox.getById("Active");
        }
        return activeCheckbox;
    }
    /**
     * Getter for select one category button.
     * @return "Select one category" button of this page.
     */
    public final IButton getSelectOneCategorieButton() {
        if (this.selectOneCategorieButton == null) {
            this.selectOneCategorieButton = Button.getByName("CurSelect");
        }
        return this.selectOneCategorieButton;
    }
    /**
     * Getter for unselect one category button.
     * @return "Unselect one category" button of this page.
     */
    public final IButton getUnSelectOneCategorieButton() {
        if (this.unSelectOneCategorieButton == null) {
            this.unSelectOneCategorieButton = Button
                    .getByName("CurUnSelectBtn");
        }
        return this.unSelectOneCategorieButton;
    }
    /**
     * Getter for select all categories button.
     * @return "Select all categories" button of this page.
     */
    public final IButton getSelectAllCategoriesButton() {
        if (this.selectAllCategoriesButton == null) {
            this.selectAllCategoriesButton = Button.getByName("AllSelect");
        }
        return selectAllCategoriesButton;
    }
    /**
     * Getter for unselect all categories button.
     * @return "Unselect all categories" button of this page.
     */
    public final IButton getUnSelectAllCategoriesButton() {
        if (this.unSelectAllCategoriesButton == null) {
            this.unSelectAllCategoriesButton = Button
                    .getByName("AllUnSelectBtn");
        }
        return unSelectAllCategoriesButton;
    }
    /**
     * Getter for text field label.
     * @return text field label of this page.
     */
    public final ILabel getCommentTextFieldLabel() {
        if (this.commentTextFieldLabel == null) {
            this.commentTextFieldLabel = Label.getByXpath(
                    "//*[@id='commentfields']/div[1]/div[1]/label");
        }
        return commentTextFieldLabel;
    }
    /**
     * Getter for number field label.
     * @return number field label of this page.
     */
    public final ILabel getCommentNumberFieldLabel() {
        if (this.commentNumberFieldLabel == null) {
            this.commentNumberFieldLabel = Label.getByXpath(
                    "//*[@id='commentfields']/div[2]/div[1]/label");
        }
        return commentNumberFieldLabel;
    }
    /**
     * Getter for available categories field label.
     * @return available categories field label of this page.
     */
    public final ILabel getAvailableCategoriesWindowName() {
        this.availableCategoriesWindowName = Label.getByXpath(
                "//*[@id='categoryselector']/div[1]/div[1]");
        return availableCategoriesWindowName;
    }
    /**
     * Getter for selected categories field label.
     * @return selected categories field label of this page.
     */
    public final ILabel getSelectedCategoriesWindowName() {
        this.selectedCategoriesWindowName = Label.getByXpath(
                "//*[@id='categoryselector']/div[3]/div[1]");
        return selectedCategoriesWindowName;
    }
    /**
     * This method return object CategoriesWindowInEditPage.
     * @return CategoriesWindowInEditPage field available
     * categories of this page.
     */
    public final CategoriesWindowInEditPage getAavailableCategories() {
        availableCategories = new CategoriesWindowInEditPage(
                "//*[@id='alvailablecategories']");
        return availableCategories;
    }
    /**
     * This method return object CategoriesWindowInEditPage.
     * @return CategoriesWindowInEditPage field selected
     * categories of this page.
     */
    public final CategoriesWindowInEditPage getSelectedCategories() {
        selectedCategories = new CategoriesWindowInEditPage(
                "//*[@id='selectedCategories']");
        return selectedCategories;
    }
    /**
     * This method gets categories array from CategoriesWindowInEditPage
     *  object.
     * @return categories array from available categories field.
     */
    public final Category[] getCategoriesInAvailableCategories() {
        availableCategories = getAavailableCategories();
        return this.availableCategories.getCategoryNameList();
    }
    /**
     * This method gets categories array from CategoriesWindowInEditPage
     *  object.
     * @return categories array from selected categories field.
     */
    public final Category[] getCategoriesInSelectedCategories() {
        selectedCategories = getSelectedCategories();
        return this.selectedCategories.getCategoryNameList();
    }
    /**
     * This method gets Error message object.
     * @return error message label of this page.
     */
    public final IValidationLabel getErrorMessage() {
        this.errorField = ValidationLabel.getById("errorfield");
        return errorField;
    }
    /**
     * This method checkON checkboxes from available categories field.
     *  @param category - Array of categories.
     */
    public final void clickOnCheckBoxAvaible(final Category[] category) {
        getAavailableCategories().clickCheckBox(category);
    }
    /**
     * This method checkON checkboxes from selected categories field.
     *  @param category - Array of categories.
     */
    public final void clickOnCheckBoxSelect(final Category[] category) {
        getSelectedCategories().clickCheckBox(category);
    }
}

