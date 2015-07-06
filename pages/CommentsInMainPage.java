package com.softserveinc.ita.commentstests.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.softserveinc.ita.commentstests.domain.models.Category;
import com.softserveinc.ita.commentstests.domain.models.Comment;
import com.softserveinc.ita.commentstests.domain.repositories
.CategoriesRepository;
import com.softserveinc.ita.commentstests.tools.controls.Checkbox;
import com.softserveinc.ita.commentstests.tools.controls.Grid;
import com.softserveinc.ita.commentstests.tools.controls.interfaces.ICheckbox;
import com.softserveinc.ita.commentstests.tools.controls.Label;

/**
 * @author Dp-076 ATQC
 * This class describes CommentsInMainPage essence,
 * which includes comments table of the main page.
 */
public class CommentsInMainPage {
    /**
     * Grid of comments on the main page.
     */
    private Grid tableWithComment;
    /**
     * Path to grid.
     */
    private String path;
    /**
     * List of comments from the table of the main page.
     */
    private List<CommentItemLine> comments;
    /**
     * List of comments with selected checkboxes from the table
     * of the main page.
     */
    private List<CommentItemLine> commentsLineWithSelectedCheckbox;
    /**
     * Controls for UI elements of the main page.
     */
    protected MainPageUIMap controls;
    /**
     * The main page object.
     */
    protected MainPage mainPage;
    /**
     * List storing all of the comments line for further conservation of
     * / search / comparison.
     */
    private Queue<CommentItemLine> commetsQueue;
    /**
     *List with all selected comments in this time.
     */
    private List<Comment> selectedComments;

    /**
     * The constructor of the class.
     */
    public CommentsInMainPage() {
        this.path = "//*[@id='main']/div//form/table/tbody/tr";
        this.tableWithComment = Grid.getByXpath(this.path);
        this.comments = new ArrayList<CommentItemLine>();
        this.selectedComments = new ArrayList<Comment>();
        this.commetsQueue = new LinkedList<CommentItemLine>();
        this.commentsLineWithSelectedCheckbox =
                new ArrayList<CommentItemLine>();

        int commentCount = tableWithComment.getSize();
        for (int i = 0; i < commentCount; i++) {
            ICheckbox checkbox = Checkbox.getByName(tableWithComment, i,
                    "SelectedId");
            Short number = Short.valueOf(Label.getByClassName(tableWithComment,
                    i, "numbercolumn").getText());
            String text = Label.getByClassName(tableWithComment, i,
                    "textcolumn").getText();
            boolean status = (Label.getByClassName(tableWithComment, i,
                    "inactivecolumn").getText().equals("V")) ? true : false;
            String[] category = (Label.getByClassName(tableWithComment, i,
                    "categorycolumn").getText()).split(", ");
            Category[] categories = new Category[category.length];
            for (int j = 0; j < category.length; j++) {
                categories[j] = stringToCategory(category[j]);
            }
            Comment comment = new Comment().setCommentNumber(number)
                    .setCommentText(text).setActive(status)
                    .setCategories(categories);
            CommentItemLine line = new CommentItemLine(comment, checkbox);
            comments.add(line);
            if (checkbox.isSelected()) {
                selectedComments.add(comment);
                this.commentsLineWithSelectedCheckbox.add(line);
            }
        }
    }

    /**
     * @return comment list.
     */
    public final List<CommentItemLine> getCommentList() {
        return this.comments;
    }

    /**
     * @return comment list without checkbox objects.
     */
    public final List<Comment> commentWithoutCheckboxList() {
        List<Comment> result = new ArrayList<Comment>();
        for (CommentItemLine commentItemLine : comments) {
            result.add(commentItemLine.getComment());
        }
        return result;
    }

    /**
     *  Checker: are all comments unselected.
     * @return boolean answer on this question.
     */
    public final boolean areAllCommentsUnselected() {
        if (this.selectedComments.size() > 0) {
            return false;
        }
        return true;
    }

    /**
     * Checker: are all comments unselected.
     * @return boolean answer on this question.
     */
    public final boolean areAllCommentsSelected() {
        if (this.selectedComments.size() == this.comments.size()) {
            return true;
        }
        return false;
    }

    /**
     * This method compare comments in current object with
     * comments from input parameter object.
     * @param commentsForCompare
     * @return boolean result of comparison.
     */
    public final boolean equals(CommentsInMainPage commentsForCompare) {
        for (int i = 0; i < comments.size(); i++) {
            if (!comments
                    .get(i)
                    .getComment()
                    .equals(commentsForCompare.getCommentList().get(i)
                            .getComment())) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param str - The category in the string representation.
     * @return the category object.
     */
    private static Category stringToCategory(final String str) {
        Category[] allCat = CategoriesRepository.getAllValidCategories();
        for (Category category : allCat) {
            if (category.getCategoryText().equalsIgnoreCase(str)) {
                return category;
            }
        }
        return CategoriesRepository.getAllValidOneInvalidcategories()[6];
    }

    /**
     * Checker: are all comments selected.
     * @return boolean answer on this question.
     */
    public final CommentsInMainPage selectAllComments() {
        for (CommentItemLine commentItemLine : getCommentList()) {
            if (!commentItemLine.getCheckbox().isSelected()) {
                this.selectedComments.add(commentItemLine.getComment());
                commentItemLine.getCheckbox().click();
            }
        }
        return this;
    }
    /**
     * This method select all comments on the page.
     * @return this object
     */
    public final CommentsInMainPage unselectAllComments() {
        this.selectedComments.clear();
        for (CommentItemLine commentItemLine : getCommentList()) {
            if (commentItemLine.getCheckbox().isSelected()) {
                commentItemLine.getCheckbox().click();
            }
        }
        return this;
    }
    /**
     * @return CommentsInMainPage with all selected checkboxes.
     */
    public final CommentsInMainPage selectAllCommentsInMainPage() {
        for (CommentItemLine commentItemLine : getCommentList()) {
            if (!commentItemLine.getCheckbox().isSelected()) {
                commentItemLine.getCheckbox().click();
            }
        }
        return this;
    }


    /**
     * @return result of the check, are all comments in the status column have
     * Active status.
     */
    public final boolean areAllRowsActive() {
        for (CommentItemLine commentItemLine : getCommentList()) {
            if (commentItemLine.getComment().getActive()) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return result of the check, are all comments in the status column have
     * Inactive status.
     */
    public final boolean areAllRowsInactive() {
        for (CommentItemLine commentItemLine : getCommentList()) {
            if (!commentItemLine.getComment().getActive()) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param number - number of the comment to be find.
     * @return comment with given number, or null if the comment
     * with given number is not found.
     */
    public final Comment findCommentByNumber(final short number) {
        for (CommentItemLine commentItemLine : getCommentList()) {
            if (commentItemLine.getComment().getCommentNumber() == number) {
                return commentItemLine.getComment();
            }
        }
        return null;
    }

    /**
     * @return first occurrence of the CommentItemLine with unselected checkbox
     * or null if such object is not present.
     */
    public final CommentItemLine getRandomCommentLine() {
        for (CommentItemLine commentItemLine : getCommentList()) {
            if (!commentItemLine.isSelected()) {
                return commentItemLine;
            }
        }
        return null;
    }


    /**
     * @return first occurrence of the CommentItemLine with active status and
     * unselected checkbox or null if such object is not present.
     */
    public final CommentItemLine getActiveCommentLine() {
        for (CommentItemLine commentItemLine : getCommentList()) {
            if (commentItemLine.getComment().getActive()) {
                if (!commentItemLine.isSelected()) {
                    return commentItemLine;
                }
            }
        }
        return null;
    }


    /**
     * @return first occurrence of the CommentItemLine with inactive status and
     * unselected checkbox or null if such object is not present.
     */
    public final CommentItemLine getInactiveCommentLine() {
        for (CommentItemLine commentItemLine : getCommentList()) {
            if (!commentItemLine.getComment().getActive()) {
                if (!commentItemLine.isSelected()) {
                    return commentItemLine;
                }
            }
        }
        return null;
    }

    /**
     * @return first occurrence of the CommentItemLine with active status and
     * unselected checkbox assigned to only one category
     * or null if such object is not present.
     */
    public final CommentItemLine getActiveCommentLineAssignedToOnlyCategory() {
        for (CommentItemLine commentItemLine : getCommentList()) {
            if (commentItemLine.getComment().getCategories().length == 1) {
                if (commentItemLine.getComment().getActive()) {
                    if (!commentItemLine.isSelected()) {
                        return commentItemLine;
                    }
                }
            }
        }
        return null;
    }

    /**
     * @return first occurrence of the CommentItemLine with unselected checkbox
     * assigned to only one categoryor null if such object is not present.
     */
    public final CommentItemLine getCommentLineAssignedToOnlyCategory() {
        for (CommentItemLine commentItemLine : getCommentList()) {
            if (commentItemLine.getComment().getCategories().length == 1) {
                    if (!commentItemLine.isSelected()) {
                        return commentItemLine;
                    }
            }
        }
        return null;
    }

    /**
     * @return first occurrence of the CommentItemLine with unselected checkbox
     * assigned to two or more categories or null if such object is not present.
     */
    public final CommentItemLine getCommentLineAssignedNotToOnlyCategory() {
        for (CommentItemLine commentItemLine : getCommentList()) {
            if (commentItemLine.getComment().getCategories().length > 1) {
                if (!commentItemLine.isSelected()) {
                    return commentItemLine;
                }
            }
        }
        return null;
    }

    /**
     * This method select active comments on the page.
     * @param count - number of comments for select.
     * @return this object.
     */
    public final CommentsInMainPage selectActiveComments(int count) {
        for (CommentItemLine commentItemLine : getCommentList()) {
            if (commentItemLine.getComment().getActive()
                    && !commentItemLine.getCheckbox().isSelected()) {
                commentItemLine.getCheckbox().click();
                this.selectedComments.add(commentItemLine.getComment());
                count--;
                if (count == 0) {
                    break;
                }
            }
        }
        return this;
    }

    /**
     * This method select inactive comments on the page.
     * @param count - number of comments for select.
     * @return this object.
     */
    public final CommentsInMainPage selectInactiveComments(int count) {
        for (CommentItemLine commentItemLine : getCommentList()) {
            if (!(commentItemLine.getComment().getActive())
                    && !commentItemLine.getCheckbox().isSelected()) {
                commentItemLine.getCheckbox().click();
                this.selectedComments.add(commentItemLine.getComment());
                count--;
                if (count == 0) {
                    break;
                }
            }
        }
        return this;
    }

    /**
     * @return result of check, are all comments on main page selected.
     */
    public final boolean areCommentsAreSelected() {
        for (CommentItemLine commentItemLine : comments) {
            if (commentItemLine.isSelected()) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param commentLine - Line of comments table.
     * @return result of check, is given CommentItemLine has checked checkbox.
     */
    public final boolean isCommentCheboxIsChecked(
            final CommentItemLine commentLine) {
        if (commentLine.getCheckbox().isSelected()) {
            return true;
        }
        return false;
    }

    /**
     * Checker: Is any comment from input List present in current object.
     * @param aimCommentList - aim list for check.
     * @return boolean boolean answer on this question.
     */
    public final boolean isCommentsPresent(final List<Comment> aimCommentList) {
        for (Comment aimComment : aimCommentList) {
            for (CommentItemLine comment : this.getCommentList()) {
                if (comment.getComment().equals(aimComment)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This Method return list of all selected comments in this time.
     * @return list of all selected comments in this time.
     */
    public final List<Comment> getSelectedComments() {
        return this.selectedComments;
    }
    /**
     * Getter for commentsLineWithSelectedCheckbox field.
     * @return list of CommentItemLine with selected checkboxes in this time.
     */
    public final List<CommentItemLine> getSelectedCommentsLine() {
        return this.commentsLineWithSelectedCheckbox;
    }

    /**
     * @param list - The list of the CommentItemLine objects.
     * @param category - The category for checking.
     * @return The method returns result of the check, is each object
     *         of the list contain given category.
     */
    public final boolean isCommentsInListContainCategory(
            final List<CommentItemLine> list, final Category category) {
        for (CommentItemLine tableString : list) {
            if (!tableString.getComment().containsCategory(category)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param list - The list of the CommentItemLine objects.
     * @param status - The status for checking.
     * @return The method returns result of the check, is each object
     *         of the list contain given status.
     */
    public final boolean isCommentsInListContainStatus(
            final List<CommentItemLine> list, final String status) {
        for (CommentItemLine tableString : list) {
            if (!tableString.getComment()
                    .commentStatusToStringActiveOrInactive()
                    .equalsIgnoreCase(status)) {
                return false;
            }
        }
        return true;
    }


    /**
     * @param list - The list of the CommentItemLine objects.
     * @return The method returns result of the check, is the list sorted by
     *         number in ascending order.
     */
    public final  boolean isListSortedByNumberAscOrder(
            final List<CommentItemLine> list) {
        List<Short> sortedList = new ArrayList<Short>();
        for (CommentItemLine commentItem : list) {
            sortedList.add(commentItem.getComment().getCommentNumber());
        }
        Collections.sort(sortedList);
        for (int i = 0; i < sortedList.size(); i++) {
            if (list.get(i).getComment().getCommentNumber()
                    != sortedList.get(i)) {
                return false;
            }
        }
        return true;
    }
    /**
     * @param list - The list of the CommentItemLine objects.
     * @return The method returns result of the check, is the list sorted by
     *         number in descending order.
     */
    public final boolean isListSortedByNumberDescOrder(
            final List<CommentItemLine> list) {
        List<Short> sortedList = new ArrayList<Short>();
        for (CommentItemLine commentItem : list) {
            sortedList.add(commentItem.getComment().getCommentNumber());
        }
        Collections.sort(sortedList, Collections.reverseOrder());
        for (int i = 0; i < sortedList.size(); i++) {
            if (list.get(i).getComment().getCommentNumber()
                    != sortedList.get(i)) {
                return false;
            }
        }
        return true;
    }
    /**
     * @param list - The list of the CommentItemLine objects.
     * @return The method returns result of the check, is the list sorted by
     *         comment text in ascending order.
     */
    public final boolean isListSortedByCommentTextAscOrder(
            final List<CommentItemLine> list) {
        List<String> sortedList = new ArrayList<String>();
        for (CommentItemLine commentItem : list) {
            sortedList.add(commentItem.getComment().getCommentText());
        }
        Collections.sort(sortedList);
        for (int i = 0; i < sortedList.size(); i++) {
            if (!list.get(i).getComment().getCommentText()
                    .equals(sortedList.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param list - The list of the CommentItemLine objects.
     * @return The method returns result of the check, is the list sorted by
     *         comment text in descending order.
     */
    public final boolean isListSortedByCommentTextDescOrder(
            final List<CommentItemLine> list) {
        List<String> sortedList = new ArrayList<String>();
        for (CommentItemLine commentItem : list) {
            sortedList.add(commentItem.getComment().getCommentText());
        }
        Collections.sort(sortedList, Collections.reverseOrder());
        for (int i = 0; i < sortedList.size(); i++) {
            if (!list.get(i).getComment().getCommentText()
                    .equals(sortedList.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param list - The list of CommentItemLine objects.
     * @param status - The comment status for check.
     * @return result of the check, are all comments in list have not
     * given status.
     */
    public final boolean isCommentsInListDoNotContainsStatus(
            final List<CommentItemLine> list,
            final String status) {
        for (CommentItemLine tableString : list) {
            if (tableString.getComment()
                    .commentStatusToStringActiveOrInactive()
                    .equalsIgnoreCase(status)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return first element from CommentItemLine Queue for further
     * conservation of / search / comparison.
     */
    public final CommentItemLine commentLineForComparison() {
        return this.commetsQueue.poll();
    }

    /**
     * @param commentLine - element to be added to CommentItemLine Queue.
     * @return main page.
     */
    public final MainPage saveCommentLine(final CommentItemLine commentLine) {
        this.commetsQueue.add(commentLine);
        return new MainPage();
    }
    /**
     * This method searches and saves for a specified amount of
     * inactive comments.
     * @param count - given amount of comments.
     * @return this object.
     */
    public final CommentsInMainPage selectInactiveCommentsAndSave(
            final int count) {
        selectInactiveComments(count);
        return this;
    }
    /**
     * This method searches and saves for a specified amount of active comments.
     * @param count - given amount of comments.
     * @return this object.
     */
    public final CommentsInMainPage selectActiveCommentsAndSave(
            final int count) {
        selectActiveComments(count);
        return this;
    }
    /**
     * This method searches and saves for a specified amount of
     * inactive comments.
     * @param count - given amount of comments.
     * @return main page.
     */
    public final MainPage selectInactiveCommentsgetManePage(final int count) {
        selectInactiveComments(count);
        return new MainPage();
    }
    /**
     * This method searches and saves for a specified amount of active comments.
     * @param count - given amount of comments.
     * @return main page.
     */
    public final MainPage selectActiveCommentsgetManePage(final int count) {
        selectActiveComments(count);
        return new MainPage();
    }
    /**
     * @param list - List of CommentItemLine objects for check.
     * @return result of check, is list sorted by active column in ascending
     * order.
     */
    public final boolean isActiveColumnSortedByAscendingOrder(
            final List<CommentItemLine> list) {
        List<Boolean> allList = new ArrayList<Boolean>();
        for (CommentItemLine line : list) {
            allList.add(line.getComment().getActive());
        }
        List<Boolean> inactive = new ArrayList<Boolean>();

        if (allList.indexOf(false) != -1) {
            inactive = allList.subList(allList.indexOf(false), allList.size());
        }

        if (inactive.contains(true)) {
            return false;
        }
        return true;

    }
    /**
     * @param list - List of CommentItemLine objects for check.
     * @return result of check, is list sorted by active column in descending
     * order.
     */
    public final boolean isActiveColumnSortedByDescendingOrder(
            final List<CommentItemLine> list) {
        List<Boolean> allList = new ArrayList<Boolean>();
        for (CommentItemLine line : list) {
            allList.add(line.getComment().getActive());
        }
        List<Boolean> active = new ArrayList<Boolean>();

        if (allList.indexOf(false) != -1) {
            active = allList.subList(0, allList.indexOf(false));
        }

        if (active.contains(false)) {
            return false;
        }
        return true;

    }
}
