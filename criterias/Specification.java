package com.softserveinc.ita.commentstests.criterias;

import org.testng.Assert;

import com.softserveinc.ita.commentstests.domain.models.Comment;
import com.softserveinc.ita.commentstests.pages.CommentsInMainPage;
import com.softserveinc.ita.commentstests.pages.ConfirmDialogPage;
import com.softserveinc.ita.commentstests.pages.EditPage;
import com.softserveinc.ita.commentstests.pages.ErrorDialogPage;
import com.softserveinc.ita.commentstests.pages.MainPage;
import com.softserveinc.ita.commentstests.tools.controls.interfaces.IButton;
import com.softserveinc.ita.commentstests.tools.controls.interfaces.ILabel;
import com.softserveinc.ita.commentstests.tools.controls.interfaces.ITextInput;
import com.softserveinc.ita.commentstests.tools.controls.interfaces
                                                              .IValidationLabel;

/**
 * @author Dp-076 ATQC
 *         This class realizes soft assert.
 */
public final class Specification {

    /**
     * Is test at summary passed?
     * This variable contain answer.
     */
    private boolean summaryResult;

    /**
     * This variable contain failed tests report.
     */
    private StringBuilder summaryDescription;

    /**
     * Class constructor.
     */
    private Specification() {
        this.summaryResult = true;
        this.summaryDescription = new StringBuilder();
    }

    /**
     * Static method for create new Specification.
     *
     * @return new Specification.
     */
    public static Specification get() {
        return new Specification();
    }

    /**
     * Getter for summaryResult.
     *
     * @return boolean answer. Is test at summary passed?
     */
    public boolean getPassed() {
        return summaryResult;
    }

    /**
     * Getter for summaryDescription.
     *
     * @return failed tests report.
     */
    public String getDescription() {
        return summaryDescription.toString();
    }

    /**
     * This method add new log in failed tests report.
     *
     * @param pass - is current test passed?
     * @param errorText - text for error log.
     */
    public void add(final boolean pass, final String errorText) {
        summaryResult = summaryResult && pass;
        if (!pass) {
            summaryDescription.append(errorText + "\n");
        }
    }

    /**
     * Assert method for finish check test results.
     */
    public void check() {
        Assert.assertTrue(summaryResult, summaryDescription.toString());
    }

    /**
     * Fluent API method for resume test with new test criteria.
     *
     * @param label - test criteria input object.
     * @return new LabelCriteria for input object.
     */
    public LabelCriteria For(final ILabel label) {
        return LabelCriteria.get(label, this);
    }

    /**
     * Fluent API method for resume test with new test criteria.
     *
     * @param page - test criteria input object.
     * @return new ErrorDialogCriteria for input object.
     */
    public ErrorDialogCriteria For(final ErrorDialogPage page) {
        return ErrorDialogCriteria.get(page, this);
    }

    /**
     * Fluent API method for resume test with new test criteria.
     *
     * @param page - test criteria input object.
     * @return new ConfirmDialogCriteria for input object.
     */
    public ConfirmDialogCriteria For(final ConfirmDialogPage page) {
        return ConfirmDialogCriteria.get(page, this);
    }

    /**
     * Fluent API method for resume test with new test criteria.
     *
     * @param page - test criteria input object.
     * @return new MainPageCriteria for input object.
     */
    public MainPageCriteria For(final MainPage page) {
        return MainPageCriteria.get(page, this);
    }

    /**
     * Fluent API method for resume test with new test criteria.
     *
     * @param page - test criteria input object.
     * @return new EditPageCriteria for input object.
     */
    public EditPageCriteria For(final EditPage page) {
        return EditPageCriteria.get(page, this);
    }

    /**
     * Fluent API method for resume test with new test criteria.
     *
     * @param comments - test criteria input object.
     * @return new CommentListCriteria for input object.
     */
    public CommentListCriteria For(final CommentsInMainPage comments) {
        return CommentListCriteria.get(comments, this);
    }

    /**
     * Fluent API method for resume test with new test criteria.
     *
     * @param comment - test criteria input object.
     * @return new CommentCriteria for input object.
     */
    public CommentCriteria For(final Comment comment) {
        return CommentCriteria.get(comment, this);
    }

    /**
     * Fluent API method for resume test with new test criteria.
     *
     * @param button - test criteria input object.
     * @return new ButtonCriteria for input object.
     */
    public ButtonCriteria For(final IButton button) {
        return ButtonCriteria.get(button, this);
    }

    /**
     * Fluent API method for resume test with new test criteria.
     *
     * @param validationLabel - test criteria input object.
     * @return new ValidationLabelCriteria for input object.
     */
    public ValidationLabelCriteria For(final IValidationLabel validationLabel) {
        return ValidationLabelCriteria.get(validationLabel, this);
    }

    /**
     * Fluent API method for resume test with new test criteria.
     *
     * @param textInput - test criteria input object.
     * @return new TextInputCriteria for input object.
     */
    public TextInputCriteria For(final ITextInput textInput) {
        return TextInputCriteria.get(textInput, this);
    }
}
