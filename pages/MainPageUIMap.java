package com.softserveinc.ita.commentstests.pages;

import java.util.List;

import com.softserveinc.ita.commentstests.tools.controls.Button;
import com.softserveinc.ita.commentstests.tools.controls.Dropdown;
import com.softserveinc.ita.commentstests.tools.controls.Grid;
import com.softserveinc.ita.commentstests.tools.controls.Label;
import com.softserveinc.ita.commentstests.tools.controls.Link;
import com.softserveinc.ita.commentstests.tools.controls.interfaces.IButton;
import com.softserveinc.ita.commentstests.tools.controls.interfaces.IDropdown;
import com.softserveinc.ita.commentstests.tools.controls.interfaces.ILabel;
import com.softserveinc.ita.commentstests.tools.controls.interfaces.ILink;
import com.softserveinc.ita.commentstests.domain.models.Comment;

/**
 * @author Dp-076 ATQC
 * This class describes UI elements of the main page.
 */
public class MainPageUIMap {
    /**
     * Refresh link of the main page.
     */
    private ILink refreshLink;
    /**
     * Create new comment button of the main page.
     */
    private IButton createNewCommentButton;
    /**
     * Duplicate comment button of the main page.
     */
    private IButton duplicateCommentButton;
    /**
     * Edit comment button of the main page.
     */
    private IButton editCommentButton;
    /**
     * Delete button of the main page.
     */
    private IButton deleteCommentButton;
    /**
     * Select an Action dropdown of the main page.
     */
    private IDropdown selectAnActionDropdown;
    /**
     * Label of the selectCategoryName dropdown of the main page.
     */
    private ILabel categoryNameLabel;
    /**
     * Select category name dropdown of the main page.
     */
    private IDropdown selectCategoryNameDropdown;
    /**
     * Label of the status dropdown of the main page.
     */
    private ILabel statusLabel;
    /**
     * Select status dropdown of the main page.
     */
    private IDropdown selectCommentsStatusDropdown;
    /**
     * Apply button of the main page.
     */
    private IButton applyButton;
    /**
     * Link of the header of the number column.
     */
    private ILink numberColumnHeaderLink;
    /**
     * Link of the header of the comment text column.
     */
    private ILink commentTextColumnHeaderLink;
    /**
     * Link of the header of the status column.
     */
    private ILink statusColumnHeaderLink;
    /**
     * Label of the header of the categories column.
     */
    private ILabel categoriesColumnHeaderLabel;
    /**
     * Footer elements of the main page.
     */
    private Grid footerElements;

    /**
     * The constructor of the class.
     */
    public MainPageUIMap() {
    }
    /**
     * This method is getter for new CommentsInMainPage object.
     * @return CommentsInMainPage - object with list of comment
     * on current page, and with some utilitarian methods.
     */
    public final CommentsInMainPage getCommentsInMainPage() {
        return new CommentsInMainPage();
    }
    /**
     * @return List of comments on the main page.
     */
    public final List<CommentItemLine> getTableOfComments() {
        return getCommentsInMainPage().getCommentList();
    }
    /**
     * @return List of comments on the main page without checkboxes.
     */
    public final List<Comment> getcommentWithoutCheckboxList() {
        return getCommentsInMainPage().commentWithoutCheckboxList();
    }
    /**
     * Getter for footerElements field.
     * @return footerElements field of this page.
     */
    public final Grid getFooterElements() {
        if (this.footerElements == null) {
            this.footerElements = Grid.getByXpath(
                    ".//*[@id='main']/div//form/table/tfoot/tr/td/a");
        }
        return footerElements;
    }

    /**
     * Getter for refreshLink field.
     * @return "Refresh" link of this page.
     */
    public final ILink getRefreshLink() {
        if (this.refreshLink == null) {
            this.refreshLink = Link.getByLinkText("Refresh");
        }
        return refreshLink;
    }

    /**
     * Getter for createNewCommentButton field.
     * @return create new comment button of this page.
     */
    public final IButton getCreateNewCommentButton() {
        if (this.createNewCommentButton == null) {
            this.createNewCommentButton = Button
                    .getByCss("#command-navigation > input:nth-child(1)");
        }
        return createNewCommentButton;
    }

    /**
     * Getter for duplicateCommentButton field.
     * @return duplicate button of this page.
     */
    public final IButton getDuplicateCommentButton() {
        if (this.duplicateCommentButton == null) {
            this.duplicateCommentButton = Button
                    .getByCss("#command-navigation > input:nth-child(2)");
        }
        return duplicateCommentButton;
    }
    /**
     * Getter for editCommentButton field.
     * @return edit button of this page.
     */
    public final IButton getEditCommentButton() {
        if (this.editCommentButton == null) {
            this.editCommentButton = Button
                    .getByCss("#command-navigation > input:nth-child(3)");
        }
        return editCommentButton;
    }

    /**
     * Getter for deleteCommentButton field.
     * @return delete button of this page.
     */
    public final IButton getDeleteCommentButton() {
        if (this.deleteCommentButton == null) {
            this.deleteCommentButton = Button
                    .getByCss("#command-navigation > input:nth-child(4)");
        }
        return deleteCommentButton;
    }

    /**
     * Getter for selectAnActionDropdown field.
     * @return Select an Action dropdown of this page.
     */
    public final IDropdown getSelectAnActionDropdown() {
        if (this.selectAnActionDropdown == null) {
            this.selectAnActionDropdown = Dropdown.getById("commandSelect");
        }
        return selectAnActionDropdown;
    }

    /**
     * Getter for categoryNameLabel field.
     * @return label of category name dropdown of this page.
     */
    public final ILabel getCategoryNameLabel() {
        if (this.categoryNameLabel == null) {
            this.categoryNameLabel = Label
                    .getByXpath("/html/body/div[1]/section/div//div/form/"
                            + "span[1]/label");
        }
        return categoryNameLabel;
    }

    /**
     * Getter for selectCategoryNameDropdown field.
     * @return select category name dropdown of this page.
     */
    public final IDropdown getSelectCategoryNameDropdown() {
        if (this.selectCategoryNameDropdown == null) {
            this.selectCategoryNameDropdown = Dropdown.getById("SelectedCateg");
        }
        return selectCategoryNameDropdown;
    }

    /**
     * Getter for statusLabel field.
     * @return label of status dropdown of this page.
     */
    public final ILabel getStatusLabel() {
        if (this.statusLabel == null) {
            this.statusLabel = Label
                    .getByXpath("/html/body/div[1]/section/div/"
                            + "/div/form/span[3]");
        }
        return statusLabel;
    }

    /**
     * Getter for selectCommentsStatusDropdown field.
     * @return select comments status dropdown of this page.
     */
    public final IDropdown getSelectCommentsStatusDropdown() {
        if (this.selectCommentsStatusDropdown == null) {
            this.selectCommentsStatusDropdown = Dropdown
                    .getById("SelectedStatus");
        }
        return selectCommentsStatusDropdown;
    }

    /**
     * Getter for applyButton field.
     * @return apply button of this page.
     */
    public final IButton getApplyButton() {
        if (this.applyButton == null) {
            this.applyButton = Button.getById("applybutton");
        }
        return applyButton;
    }

    /**
     * Getter for numberColumnHeaderLink field.
     * @return link of the header of the number column.
     */
    public final ILink getNumberColumnHeaderLink() {
        if (this.numberColumnHeaderLink == null) {
            this.numberColumnHeaderLink = Link.getByLinkText("Number");
        }
        return numberColumnHeaderLink;
    }

    /**
     * Getter for commentTextColumnHeaderLink field.
     * @return link of the header of the comment text column.
     */
    public final ILink getCommentTextColumnHeaderLink() {
        if (this.commentTextColumnHeaderLink == null) {
            this.commentTextColumnHeaderLink = Link
                    .getByLinkText("Comment Text");
        }
        return commentTextColumnHeaderLink;
    }

    /**
     * Getter for statusColumnHeaderLink field.
     * @return link of the header of the status column.
     */
    public final ILink getStatusColumnHeaderLink() {
        if (this.statusColumnHeaderLink == null) {
            this.statusColumnHeaderLink = Link.getByLinkText("Active");
        }
        return statusColumnHeaderLink;
    }

    /**
     * Getter for categoriesColumnHeaderLabel field.
     * @return label of the header of the categories column.
     */
    public final ILabel getCategoriesColumnHeaderLabel() {
        if (this.categoriesColumnHeaderLabel == null) {
            this.categoriesColumnHeaderLabel = Label.getByXpath(
                    "/html/body/div[1]/section/div//form/table/thead/tr/th[5]");
        }
        return categoriesColumnHeaderLabel;
    }
}
