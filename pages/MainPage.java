package com.softserveinc.ita.commentstests.pages;

import java.util.List;

import com.softserveinc.ita.commentstests.domain.models.Category;
import com.softserveinc.ita.commentstests.domain.models.Comment;
import com.softserveinc.ita.commentstests.tools.controls.Link;
import com.softserveinc.ita.commentstests.tools.controls.interfaces.IButton;

/**
 * @author DP076 ATQC.
 *
 */
public class MainPage extends Page {

    /**
     * @param controls encapsulates map of web site.
     */
    private MainPageUIMap controls;
    /**
     * @param comments holds a list if comment line.
     */
    private String activateButton = "Activate";
    /**
     * @param inactivateButton holds the name of the deactivate button.
     */
    private String inactivateButton = "Inactivate";
    /**
     * @param removeFromCategoryButton holds the name of the remove from
     * category button.
     */
    private String removeFromCategoryButton = "RemoveFromCategory";
    /**
     * @param turnPageLeft holds a sign of listing - to the left.
     */
    private String turnPageLeft = "<";
    /**
     * @param turnPageRight holds a sign of listing - to the right.
     */
    private String turnPageRight = ">";

    /**
     * Constructor verifies if the page is the main page of comments web site.
     */
    public MainPage() {
        verifyUrlStartWith("http://comments.azurewebsites.net/",
                "This is the not main page");
        verifyTitle("Index", "This is the not main page");
        controls = new MainPageUIMap();
    }

    /**
     * This method gets pages quantity from footer.
     * Footer not present if there is one page
     * @return quantity of the pages.
     */
    public final short getPageQuantity() {
        short pageQuantity;
        if (controls.getFooterElements() == null) {
            pageQuantity = (short) 1;
            return pageQuantity;
        }
        short footerElementsSize = (short) controls.getFooterElements()
                .getSize();
        // if > present as last symbol in footer
        if (turnPageRight.equals(controls.getFooterElements()
                .get(footerElementsSize - 1).getText())) {
            pageQuantity = Short.valueOf(controls.getFooterElements()
                    .get(footerElementsSize - 2).getText());
            // if stay at last page at this moment
        } else {
            pageQuantity = footerElementsSize;
        }
        return pageQuantity;
    }

    /**
     * @return number of the current page.
     */
    public final short getCurrentPageNumber() {
        short currentPageNumber = 0;
        short footerElementsSize = (short) controls.getFooterElements()
                .getSize();
        // if we locate at page 1 "<" not present
        if (!turnPageLeft.equals(controls.getFooterElements().get(0)
                .getText())) {
            currentPageNumber = 1;
            return currentPageNumber;
        }
        // if we locate at last page ">" not present
        if (!turnPageRight.equals(controls.getFooterElements()
                .get(footerElementsSize - 1).getText())) {
            currentPageNumber = footerElementsSize;
            return currentPageNumber;
        }
        /*
         * if we not first and not last page. Make for loop from
         * second element because first element is "<", to element
         * before last because last element is ">".
         */
        for (int i = 1; i < footerElementsSize - 1; i++) {
            short footerIElement = Short.valueOf(controls.getFooterElements()
                    .get(i).getText());
            short footerINextElement = Short.valueOf(controls
                    .getFooterElements().get(i + 1).getText());
            if (footerIElement + 1 != footerINextElement) {
                currentPageNumber = (short) (footerIElement + 1);
                break;
            }
        }
        return currentPageNumber;
    }

    /**
     * This method switches pages using ">" .
     * @return returns new main page instance.
     */
    public final MainPage switchPageByRightArrow() {
        short currentPageNumber = getCurrentPageNumber();
        short lastPageNumber = getPageQuantity();
        if (currentPageNumber == lastPageNumber) {
            throw new IllegalStateException("You cant svitch to next page "
                    + "because you are at last page.");
        }
        short footerElementsSize = (short) controls.getFooterElements()
                .getSize();
        String rightArrowLinkXpath = ".//*[@id='main']/div/div[5]/form/table"
                    + "/tfoot/tr/td/a[" + Short.toString(footerElementsSize)
                    + "]";
            Link.getByXpath(rightArrowLinkXpath).click();
            return new MainPage();

    }
    /**
     * This method switches pages using "<" .
     * return returns new main page instance.
     * @return returns new main page instance.
     */
    public final MainPage switchPageByLeftArrow() {
        short currentPageNumber = getCurrentPageNumber();
        if (currentPageNumber == 1) {
            throw new IllegalStateException("You cant svitch to prevous page "
                    + "because you are at first page.");
        }
        String leftArrowLinkXpath = ".//*[@id='main']/div/div[5]/form/table"
                + "/tfoot/tr/td/a[1]";
        Link.getByXpath(leftArrowLinkXpath).click();
        return new MainPage();
    }

    /**
     * This method switches pages using bottom navigation panel.
     *
     * @param pageNumber
     *            (Short) Number of page to switch.
     * @throws Exception
     * @return new main page instance.
     */
    public final MainPage switchPage(final short pageNumber) {
        short currentPageNumber = getCurrentPageNumber();
        short lastPageNumber = getPageQuantity();
        if (pageNumber == currentPageNumber) {
            throw new IllegalStateException("You cant switch "
                    + "because you alerady at this page.");
        }
        if (pageNumber > lastPageNumber) {
            throw new IllegalStateException("You cant switch "
                    + "because pageNumber to switch out of range pages.");
        }
        short index = 0;
        if (currentPageNumber == 1) {
            index = (short) (pageNumber - 1);
        } else if (pageNumber < currentPageNumber) {
            index = (short) (pageNumber + 1);
        } else if (pageNumber > currentPageNumber) {
            index = pageNumber;
        }
        String pageLinkXpath = ".//*[@id='main']/div/div[5]/form/table"
                + "/tfoot/tr/td/a[" + Short.toString(index) + "]";
        Link.getByXpath(pageLinkXpath).click();
        return new MainPage();
    }

    /**
     * @return activateButton.
     */
    public final String getActivateAction() {
        return activateButton;
    }

    /**
     * @return inactivateButton.
     */
    public final String getInactivateAction() {
        return inactivateButton;
    }

    /**
     * @return removeFromCategoryButton.
     */
    public final String getRemoveFromCategoryAction() {
        return removeFromCategoryButton;
    }

    /**
     * @param category - The name of category for selection.
     * @return Main page with selected option.
     */
    public final MainPage selectCategoryInDropdown(final String category) {
        controls.getSelectCategoryNameDropdown().selectByVisibleText(
                category.trim());
        return this;
    }

    /**
     * @param categories - array that needs to be translated into a string.
     * @return the string of categories names.
     */
    public static String categoriesArrayToString(final Category[] categories) {
        String result = "";
        for (Category category : categories) {
            result += category.getCategoryText();
            }
        return result;
    }

    /**
     * @param status - The name of status for selection.
     * @return Main page with selected option.
     */
    public final MainPage selectStatusInDropdown(final String status) {
        controls.getSelectCommentsStatusDropdown().selectByVisibleText(
                status.trim());
        return this;
    }

    /**
     * @return true if check boxes are checked off and false if not.
     */
    public final boolean areCheckboxesCheckedOff() {
        List<CommentItemLine> commentsList = controls.getTableOfComments();
        for (CommentItemLine commentItemLine : commentsList) {
            if (!commentItemLine.getCheckbox().isSelected()) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return Main page after clicking on comment number column header link.
     */
    public final MainPage commentNumberColumnHeaderClick() {
        controls.getNumberColumnHeaderLink().click();
        return new MainPage();
    }

    /**
     * @return Main page after clicking on comment text column header link.
     */
    public final MainPage commentTextColumnHeaderClick() {
        controls.getCommentTextColumnHeaderLink().click();
        return new MainPage();
    }

    /**
     * @return Main page after clicking on comment status column header link.
     */
    public final MainPage commentStatusColumnHeaderClick() {
        controls.getStatusColumnHeaderLink().click();
        return new MainPage();
    }

    /**
     * @return Main page after clicking on apply button.
     */
    public final MainPage applyButtonClick() {
        controls.getApplyButton().click();
        return new MainPage();
    }

    /**
     * clicks to the CreateNewCommentButton.
     * @return new instance of Edit Page.
     */
    public final EditPage createNewCommentButtonClick() {
        controls.getCreateNewCommentButton().click();
        return new EditPage();
    }
    /**
     * @return CreateNewCommentButton.
     */
    public final IButton createNewCommentButton() {
                return controls.getCreateNewCommentButton();
            }

    /**
     * selects the activate option in select an action drop down.
     * @return new instance of main page.
     */
    public final MainPage selectActivateAction() {
        controls.getSelectAnActionDropdown().selectByVisibleText(
                getActivateAction());
        return new MainPage();
    }

    /**
     * selects the deactivate option in select an action drop down.
     * @return new instance of main page.
     */
    public final MainPage selectInactivateAction() {
        controls.getSelectAnActionDropdown().selectByVisibleText(
                getInactivateAction());
        return new MainPage();
    }

    /**
     * This method clicks on "Delete" button after selecting comments.
     * @return new alert page with confirm dialog(yes/no).
     */
    public  final ConfirmDialogPage deleteButtonClick() {
        controls.getDeleteCommentButton().click();
        return new ConfirmDialogPage();
    }

    /**
     * This method clicks on "Delete" button when no one comment selected.
     * @return new alert page with confirm dialog(yes/no).
     */
    public final ErrorDialogPage deleteEmptyButtonClick() {
        controls.getDeleteCommentButton().click();
        return new ErrorDialogPage();
    }

    /**
     * clicks to duplicate button.
     * @return new instance of Edit Page.
     */
    public final EditPage duplicateButtonClick() {
        controls.getDuplicateCommentButton().click();
        return new EditPage();
    }

    /**
     * clicks on duplicate button.
     * @return new instance of ErrorDialog Page.
     */
    public final ErrorDialogPage duplicateEmptyButtonClick() {
        controls.getDuplicateCommentButton().click();
        return new ErrorDialogPage();
    }

    /**
     * clicks on Edition button.
     * @return new instance of Edit Page.
     */
    public final EditPage editButtonClick() {
        controls.getEditCommentButton().click();
        return new EditPage();
    }

    /**
     * clicks on EditCommentButton.
     * @return new instance of ErrorDialog Page.
     */
    public final ErrorDialogPage editEmptyButtonClick() {
        controls.getEditCommentButton().click();
        return new ErrorDialogPage();
    }

    /**
     * selects remove from category action in drop down.
     * @return new instance of ConfirmDialog Page.
     */
    public final ConfirmDialogPage removeFromCategoryButtonClick() {
        controls.getSelectAnActionDropdown().selectByVisibleText(
                getRemoveFromCategoryAction());
        return new ConfirmDialogPage();
    }

    /**
     * @return new instance of ErrorDialog Page.
     */
    public final ErrorDialogPage removeFromCategoryEmptyButtonClick() {
        controls.getSelectAnActionDropdown().selectByVisibleText(
                getRemoveFromCategoryAction());
        return new ErrorDialogPage();
    }

    /**
     * @return new instance of ErrorDialog Page.
     */
    public final ErrorDialogPage removeFromCategoryNotSpecificCategory() {
        controls.getSelectAnActionDropdown().selectByVisibleText(
                getRemoveFromCategoryAction());
        return new ErrorDialogPage();
    }
    /**
     * @return table of comments.
     */
    public final List<CommentItemLine> getCommentListWithChekbox() {
        return this.controls.getTableOfComments();
    }
    /**
     * @return comments line with out of check box.
     */
    public final List<Comment> getCommentListWithOutChekbox() {
        return this.controls.getcommentWithoutCheckboxList();
    }

    // This method find comment at current page
    /**
     * @param commentNumber takes a number for search.
     * @return line of comments.
     */
    public final CommentItemLine findCommentOnPage(final Short commentNumber) {
        List<CommentItemLine> commentsList = controls.getTableOfComments();
            for (CommentItemLine commentItemLine : commentsList) {
                if (commentItemLine.getComment().getCommentNumber()
                        == commentNumber) {
                    return commentItemLine;
                }
            }
            return null;
    }

    //This method find comment at all pages
    /**
     * @param commentNumber takes a number for search.
     * @return comment by number.
     */
    public final CommentItemLine findComment(final Short commentNumber) {
        MainPage mainPage = new MainPage();
        if (getCurrentPageNumber() != 1) {
        mainPage = switchPage((short) 1);
        }
        boolean isCommentNotFound = true;
        while (isCommentNotFound) {
            if (mainPage.findCommentOnPage(commentNumber) != null) {
                isCommentNotFound = false;
                return mainPage.findCommentOnPage(commentNumber);
            }
            if (mainPage.getCurrentPageNumber() == mainPage.getPageQuantity()) {
                break;
            }
            mainPage = mainPage.switchPageByRightArrow();
        }
        return null;
    }

    /**
     * This method is getter for CommentsInMainPage object.
     * @return CommentsInMainPage - object with list of comment
     *  on current page, and with some utilitarian methods.
     */
    public final CommentsInMainPage getCommentsInMainPage() {
        return controls.getCommentsInMainPage();
    }
    /**
     * @return ConfirmDialog Page.
     */
    public final ConfirmDialogPage getConfirmDialogPage() {
        return new ConfirmDialogPage();
    }
    /**
     * @return Main page after clicking on refresh link.
     */
    public final MainPage refreshLinkClick() {
        controls.getRefreshLink().click();
        return new MainPage();
    }

}
