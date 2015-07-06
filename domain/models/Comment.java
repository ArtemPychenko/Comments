package com.softserveinc.ita.commentstests.domain.models;

import java.util.Arrays;

/***This class describe comment essence.
 * @author DP-076ATQC
 */
public class Comment {
    /**Comment text.*/
    private String commentText;
    /**Comment number.*/
    private Short commentNumber;
    /**Comment status(active/inactive).*/
    private boolean active;
    /**Comment category array.*/
    private Category[] categories;
    /**Default constructor.*/
    public Comment() {
    }
    /**Parametric constructor for create comment instance.
     * @param commentTextIn - string comment text
     * @param commentNumberIn - short comment number
     * @param activeIn - boolean comment status
     * @param categoriesIn - category array categories
     */
    public Comment(final String commentTextIn, final Short commentNumberIn
            , final boolean activeIn, final Category[] categoriesIn) {
        this.commentText = commentTextIn;
        this.commentNumber = commentNumberIn;
        this.active = activeIn;
        this.categories = categoriesIn;
    }
    /**Getter for comment text variable.
     * @return string comment text
     */
    public final String getCommentText() {
        return commentText;
    }
    /**Getter for comment number variable.
     * @return short comment number
     */
    public final Short getCommentNumber() {
        return commentNumber;
    }
    /**Getter for comment status variable.
     * @return boolean comment status
     */
    public final boolean getActive() {
        return active;
    }
    /**Getter for comment categories array.
     * @return categories array
     */
    public final Category[] getCategories() {
        return categories;
    }
    /**Setter for comment text variable.
     * @param commentTextIn - string comment text
     * @return this instance
     */
    public final Comment setCommentText(final String commentTextIn) {
        this.commentText = commentTextIn;
        return this;
    }
    /**Setter for comment number variable.
     * @param commentNumberIn - short comment number
     * @return this instance
     */
    public final Comment setCommentNumber(final Short commentNumberIn) {
        this.commentNumber = commentNumberIn;
        return this;
    }
    /**Setter for comment status variable.
     * @param activeIn - boolean comment status
     * @return this instance
     */
    public final Comment setActive(final boolean activeIn) {
        this.active = activeIn;
        return this;
    }
    /**Setter for categories array.
     * @param categoriesIn - categories array
     * @return this instance
     */
    public final Comment setCategories(final Category[] categoriesIn) {
        this.categories = categoriesIn;
        return this;
    }
    /**Create status string.
     * @return - string active or inactive
     */
    public final String commentStatusToStringActiveOrInactive() {
        boolean activeStatus = true;
        if (this.getActive() == activeStatus) {
            return "Active";
        }
        return "Inactive";
    }
    /**Check is comments contain category.
     * @param catIn - category array
     * @return boolean true if contain all category, false if don't contain.
     */
    public final boolean containsCategory(final Category catIn) {
        Category[] categoriesLocal = this.getCategories();
        for (Category category : categoriesLocal) {
            if (category.equals(catIn)) {
                return true;
            }
        }
        return false;
    }
    /**Check is comment doesn't contain category.
     * @param catIn - category array
     * @return boolean true if contain all category, false if don't contain.
     */
    public final boolean doesNotContainsCategory(final Category catIn) {
        Category[] categoriesLocal = this.getCategories();
        for (Category category : categoriesLocal) {
            if (category.equals(catIn)) {
                return false;
            }
        }
        return true;
    }
    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (active ? 1231 : 1237);
        result = prime * result + Arrays.hashCode(categories);
        result = prime * result
                + ((commentNumber == null) ? 0 : commentNumber.hashCode());
        result = prime * result
                + ((commentText == null) ? 0 : commentText.hashCode());
        return result;
    }

    @Override
    public final boolean equals(final Object comment) {
        if (this == comment) {
            return true;
        }
        if (comment == null) {
            return false;
        }
        if (getClass() != comment.getClass()) {
            return false;
        }
        Comment other = (Comment) comment;
        if (!this.commentText.equals(other.getCommentText())) {
            return false;
        }
        if (this.commentNumber != other.getCommentNumber()) {
            return false;
        }
        if (this.active != other.getActive()) {
            return false;
        }
        if (this.categories.length != other.getCategories().length) {
            return false;
        }
        for (int i = 0; i < this.categories.length; i++) {
            if (!categories[i].equals(other.getCategories()[i])) {
                return false;
            }
        }
        return true;
    }
}
