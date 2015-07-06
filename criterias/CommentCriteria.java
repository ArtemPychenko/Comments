package com.softserveinc.ita.commentstests.criterias;

import com.softserveinc.ita.commentstests.domain.models.Category;
import com.softserveinc.ita.commentstests.domain.models.Comment;

/**
 * @author Dp-076 ATQC This class is criteria for comments.
 */
public final class CommentCriteria implements ISpecification {
    /**
     * identify of comment field as Comment model.
     */
    private Comment comment;
    /**
     * identify of specification field.
     */
    private Specification specification;

    /**
     * Constructor.
     * @param theComment
     *            - IButton object
     * @param theSpecification
     *            - Specification object
     */
    private CommentCriteria(final Comment theComment,
            final Specification theSpecification) {
        comment = theComment;
        specification = theSpecification;
    }

    /**
     * @param comment
     *            - Comment object
     * @param specification
     *            - Specification object
     * @return new criteria for comment.
     */
    public static CommentCriteria get(final Comment comment,
            final Specification specification) {
        return new CommentCriteria(comment, specification);
    }

    /**
     * Check is comment matches with another comment.
     * @param expectedComment
     *            - expected comment for comparison
     * @return specification.
     */
    public CommentCriteria commentMatch(final Comment expectedComment) {
        this.specification.add(this.comment.equals(expectedComment),
                "Object Comment doesn't match.");
        return this;
    }

    /**
     * Check is comment status matches with another comment status.
     * @param expectedResult
     *            - expected result for comparison
     * @return specification.
     */
    public CommentCriteria statusMatch(final boolean expectedResult) {
        this.specification.add(this.comment.getActive() == expectedResult,
                "Comment status doesn't match. ");
        return this;
    }

    /**
     * Check is comment number matches with another comment number.
     * @param expectedNumber
     *            - expected number for comparison
     * @return specification.
     */
    public CommentCriteria numberMatch(final Short expectedNumber) {
        this.specification.add(
                this.comment.getCommentNumber() == expectedNumber,
                "Comment number doesn't match. Expect:" + expectedNumber
                + "Actual:" + this.comment.getCommentNumber());
        return this;
    }

    /**
     * Check is comment text matches with another comment text.
     * @param expectedResult
     *            - expected text for comparison
     * @return specification.
     */
    public CommentCriteria commentTextMatch(final String expectedResult) {
        this.specification.add(
                this.comment.getCommentText().equals(expectedResult),
                "Comment text doesn't match. Expect:" + expectedResult
                + "Actual:" +  this.comment.getCommentText());
        return this;
    }

    /**
     * Check is array of categories matches with another array of categories.
     * @param expectedCategories
     *            - array of categories for comparison
     * @return specification.
     */
    public CommentCriteria categoriesMatch(final Category[]
            expectedCategories) {
        Category[] thisCategories = this.comment.getCategories();
        this.specification.add(
                isCategoriesEquals(expectedCategories, thisCategories),
                "Comment categories don't match. ");
        return this;
    }

    /**
     * Check is array of categories doesn't match with another array of
     * categories.
     * @param expectedCategories
     *            - array of categories for comparison
     * @return specification.
     */
    public CommentCriteria categoriesNotMatch(final Category[]
            expectedCategories) {
        Category[] thisCategories = this.comment.getCategories();
        this.specification.add(
                !isCategoriesEquals(expectedCategories, thisCategories),
                "Comment categories should not match! ");
        return this;
    }
    /**
     * Check is category match with another category.
     * @param expectedCategory
     *            - category for comparison
     * @return specification.
     */
    public CommentCriteria oneCategoryMatch(final Category expectedCategory) {
        this.specification.add(this.comment.containsCategory(expectedCategory),
                "Comment doesn't contain category. ");
        return this;
    }
    /**
     * Check is category doeasn't match with another category.
     * @param expectedCategory
     *            - category for comparison
     * @return specification.
     */
    public CommentCriteria oneCategoryNotMatch(final Category
            expectedCategory) {
        this.specification.add(
                !this.comment.doesNotContainsCategory(expectedCategory),
                "Comment should not contain category! ");
        return this;
    }

    /**
     * This method compare two array of categories.
     * @param expectedCategories
     *            - categories array.
     * @param thisCategories
     *            - categories array.
     * @return true if arrays of categories is equal.
     */
    private boolean isCategoriesEquals(final Category[] expectedCategories,
            final Category[] thisCategories) {
        if (expectedCategories.length != thisCategories.length) {
            return false;
        }
        for (int i = 0; i < expectedCategories.length; i++) {
            if (!expectedCategories[i].equals(thisCategories[i])) {
                return false;
            }
        }
        return true;
    }
    /**
     * Next specification.
     * @return specification.
     */
    public Specification next() {
        return this.specification;
    }

}
