package com.softserveinc.ita.commentstests.criterias;

import com.softserveinc.ita.commentstests.domain.models.Category;
import com.softserveinc.ita.commentstests.pages.CommentItemLine;
import com.softserveinc.ita.commentstests.pages.CommentsInMainPage;

/**
 * @author Dp-076 ATQC
 * This class contain methods for
 * check CommentsInMainPage object on different criteria.
 */
public final class CommentListCriteria implements ISpecification {

    /**
     * Static variable for save current CommentListInMainPage for next test.
     */
    private static CommentsInMainPage previousCommentList;

    /**
     *This variable contain current CommentListInMainPage.
     */
    private CommentsInMainPage commentList;
    /**
     * Logger.
     */
    private Specification specification;

    /**
     * Class constructor.
     * @param commentListParam - aim CommentsInMainPage.
     * @param specificationParam - logger.
     */
    private CommentListCriteria(final CommentsInMainPage commentListParam,
            final Specification specificationParam) {
        this.commentList = commentListParam;
        this.specification = specificationParam;
    }

    /**
     * Static method for create new CommentListCriteria.
     * @param commentList - aim CommentsInMainPage.
     * @param specification - logger.
     * @return new CommentListCriteria
     */
    public static CommentListCriteria get(final CommentsInMainPage commentList,
            final Specification specification) {
        return new CommentListCriteria(commentList, specification);
    }

    /**
     * This method compare current and saved CommentsInMainPage.
     * @return current CommentListCriteria.
     */
    public CommentListCriteria commentListMatch() {
        this.specification.add(this.commentList
                .equals(getPreviousCommentList()),
                "List of comments on Main page isn't valid;");
        return this;
    }

    /**
     * This method checks, is all comments on main page unselected.
     * @return current CommentListCriteria.
     */
    public CommentListCriteria allCommentsUnselectedMatch() {
        this.specification.add(this.commentList.areAllCommentsUnselected(),
                "Comments aren`t unselected;");
        return this;
    }

    /**
     * This method checks, is all comments on main page selected.
     * @return current CommentListCriteria.
     */
    public CommentListCriteria allCommentsSelectedMatch() {
        this.specification.add(this.commentList.areAllCommentsSelected(),
                "All comments aren`t selected;");
        return this;
    }

    /**
     * This method checks, was all selected comments deleted.
     * @return current CommentListCriteria.
     */
    public CommentListCriteria areSelectedCommentsDeletedMatch() {
        this.specification.add(!this.commentList
                .isCommentsPresent(getPreviousCommentList()
                        .getSelectedComments()),
                "Selected comments wasn`t deleted;");
        return this;
    }

    /**
     * This method checks, are all selected comments in expectedStatus.
     * @param expectedStatus  - expected status for comments.
     * @return current CommentListCriteria.
     */
    public CommentListCriteria areSelectedCommentsStatusMatch(
            final String expectedStatus) {
        this.specification.add(
                this.commentList.isCommentsInListContainStatus(
                        CommentListCriteria.getPreviousCommentList()
                        .getSelectedCommentsLine(), expectedStatus),
                "Comment isn't contain this status");
        return this;
    }

    /**
     * This method checks, are all comments on the main page in expectedStatus.
     * @param expectedStatus  - expected status for comments.
     * @return current CommentListCriteria.
     */
    public CommentListCriteria commentStatusMatch(final String expectedStatus) {
        this.specification.add(
                this.commentList.isCommentsInListContainStatus(
                        this.commentList.getCommentList(), expectedStatus),
                "Comment isn't contain this status");
        return this;
    }

    /**
     * Method checks, are all comments on the main page have expectedCategory.
     * @param expectedCategory  - expected category for comments.
     * @return current CommentListCriteria.
     */
    public CommentListCriteria commentCategoryMatch(
            final Category expectedCategory) {
        this.specification.add(this.commentList
                .isCommentsInListContainCategory(
                        this.commentList.getCommentList(), expectedCategory),
                "Comment isn't contain this category");
        return this;
    }

    /**
     * Method records current CommentListCriteria in static variable.
     * @return current CommentListCriteria.
     */
    public CommentListCriteria rememberCarrentCommentList() {
        CommentListCriteria.previousCommentList = this.commentList;
        return this;
    }

    /**
     * Method get recording CommentListCriteria from static variable.
     * @return static previousCommentList - recording CommentListCriteria.
     */
    public static CommentsInMainPage getPreviousCommentList() {
        return CommentListCriteria.previousCommentList;
    }

    /**
     * This method checks, are all comments on main page selected.
     * @return current CommentListCriteria.
     */
    public CommentListCriteria areCommentsAreSelectedMatch() {
        this.specification.add(this.commentList.areCommentsAreSelected(),
                "Comments isn`t selected;");
        return this;
    }

    /**
     * This method checks, are is comment from input object selected.
     * @param commentLine - aim comment for check.
     * @return current CommentListCriteria.
     */
    public CommentListCriteria isCommentCheboxIsChecked(
            final CommentItemLine commentLine) {
        this.specification.add(
                this.commentList.isCommentCheboxIsChecked(commentLine),
                "Comments isn`t selected;");
        return this;
    }

    /**
     * This method checks, are comments on main page
     *  sorted by "Active" column in ascending order.
     * @return current CommentListCriteria.
     */
    public CommentListCriteria listSortedByActiveInAscendingOrder() {
        this.specification.add(this.commentList
                .isActiveColumnSortedByAscendingOrder(this.commentList
                        .getCommentList()),
                "List isn't sorted by active in ascending order");
        return this;
    }

    /**
     * This method checks, are comments on main page
     *  sorted by "Active" column in descending order.
     * @return current CommentListCriteria.
     */
    public CommentListCriteria listSortedByActiveInDescendingOrder() {
        this.specification.add(this.commentList
                .isActiveColumnSortedByAscendingOrder(this.commentList
                        .getCommentList()),
                "List isn't sorted by active in descending order");
        return this;
    }


    /**
     * This method checks, are comments on main page
     *  sorted by "Number" column in ascending order.
     * @return current CommentListCriteria.
     */
    public CommentListCriteria listSortedByNumberInAscendingOrder() {
        this.specification.add(this.commentList.isListSortedByNumberAscOrder(
                this.commentList.getCommentList()),
                "List isn't sorted by number in ascending order");
        return this;
    }

    /**
     * This method checks, are comments on main page
     *  sorted by "Number" column in descending order.
     * @return current CommentListCriteria.
     */
    public CommentListCriteria listSortedByNumberInDescendingOrder() {
        this.specification.add(this.commentList.isListSortedByNumberDescOrder(
                this.commentList.getCommentList()),
                "List isn't sorted by number in descending order");
        return this;
    }

    /**
     * This method checks, are comments on main page
     *  sorted by "Text" column in ascending order.
     * @return current CommentListCriteria.
     */
    public CommentListCriteria listSortedByCommentTextInAscendingOrder() {
        this.specification.add(this.commentList
                .isListSortedByCommentTextAscOrder(
                this.commentList.getCommentList()),
                "List isn't sorted by comment text in ascending order");
        return this;
    }

    /**
     * This method checks, are comments on main page
     *  sorted by "Text" column in descending order.
     * @return current CommentListCriteria.
     */
    public CommentListCriteria listSortedByCommentTextInDescendingOrder() {
        this.specification.add(this.commentList
                .isListSortedByCommentTextDescOrder(
                this.commentList.getCommentList()),
                "List isn't sorted by comment text in descending order");

        return this;
    }

    /**
     * @see com.softserveinc.ita.commentstests.criterias.ISpecification#next().
     * @return specification
     */
    public Specification next() {
        return this.specification;
    }

}
