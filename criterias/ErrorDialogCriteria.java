package com.softserveinc.ita.commentstests.criterias;

import com.softserveinc.ita.commentstests.pages.ErrorDialogPage;

/**
 * @author Dp-076 ATQC
 * This class contain methods for
 * check Error dialog alert object on different criteria.
 */
public final class ErrorDialogCriteria implements ISpecification {

    /**
     *This variable contain current ErrorDialogCriteria.
     */
    private ErrorDialogPage dialog;

    /**
     * Logger.
     */
    private Specification specification;

    /**
     * Class constructor.
     * @param dialogParam -aim ErrorDialogPage.
     * @param specificationParam - logger.
     */
    private ErrorDialogCriteria(final ErrorDialogPage dialogParam,
            final Specification specificationParam) {
        this.dialog = dialogParam;
        this.specification = specificationParam;
    }

    /**
     * Static method for create new ErrorDialogCriteria.
     * @param dialogParam -aim ErrorDialogPage.
     * @param specificationParam - logger.
     * @return new ErrorDialogCriteria
     */
    public static ErrorDialogCriteria get(final ErrorDialogPage dialogParam,
            final Specification specificationParam) {
        return new ErrorDialogCriteria(dialogParam, specificationParam);
    }

    /**
     * This method compare text label of Error dialog alert
     * and input string.
     * @param expectedResult - String for compare.
     * @return current ErrorDialogCriteria.
     */
    public ErrorDialogCriteria textMatch(final String expectedResult) {
        this.specification.add(this.dialog.getMessage().equals(expectedResult),
                " Text of Error Delete message is not valid;");
        return this;
    }
    /**
     * This method compare text label of Error dialog alert
     * and input string.
     * @param expectedResult - String for compare.
     * @return current ErrorDialogCriteria.
     */
    public ErrorDialogCriteria textRemoveFromCategoryMatch(
            final String expectedResult) {
        this.specification.add(this.dialog.getMessage().equals(expectedResult),
                " Text of Error Remove From Category message is not valid;");
        return this;
    }

    /**
     * This method checks, is "No" button presents on Error dialog alert,
     * and then compare text label of this button with input string.
     * @param expectedResult - String for compare.
     * @return current ErrorDialogCriteria.
     */
    public ErrorDialogCriteria buttonOkMatch(final String expectedResult) {
        this.specification.add(this.dialog.getOkButton().isDisplayed(),
                " Button on Error Delete message is not present;");
        if (this.dialog.getOkButton().isDisplayed()) {
            this.specification.add(
                    this.dialog.getOkButton().getText().equals(expectedResult),
                    " Text on Error Delete message Button is not valid;");
        }

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
