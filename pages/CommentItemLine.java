package com.softserveinc.ita.commentstests.pages;
import com.softserveinc.ita.commentstests.domain.models.Comment;
import com.softserveinc.ita.commentstests.tools.controls.interfaces.ICheckbox;

/**
 *@author Dp-076 ATQC
 * This class allows to create an object,
 * which consist of a comments table line.
 *
 */
public class CommentItemLine {
    /**
     * The comment object.
     */
    private Comment comment;
    /**
     * The checkbox object.
     */
    private ICheckbox checkbox;
    /**
     * The value of the checkbox.
     */
    private boolean isSelectedPrivate;
    /**
     * The constructor of the class.
     * @param aComment - The comment item of this table line.
     * @param aCheckbox - The checkbox item of this table line.
     */
    public CommentItemLine(final Comment aComment, final ICheckbox aCheckbox) {
        this.comment = aComment;
        this.checkbox = aCheckbox;
        this.isSelectedPrivate = checkbox.isSelected();
    }
    /**
     * @return checkbox item of this object.
     */
    public final ICheckbox getCheckbox() {
        return checkbox;
    }
    /**
     * @return Comment item for this object.
     */
    public final Comment getComment() {
        return comment;
    }
    /**
     * @return value of the checkbox of this object.
     */
    public final boolean isSelected() {
        return this.isSelectedPrivate;
    }

    /**
     * @return Main page with selected comment item line.
     */
    public final MainPage commentItemLineClick() {
        this.getCheckbox().click();
        return new MainPage();
    }
    /**
     * @return this comment item line with selected checkbox.
     */
    public final CommentItemLine commentItemLineGetCommentLineClick() {
        this.getCheckbox().click();
        return new CommentItemLine(comment, checkbox);
    }
}
