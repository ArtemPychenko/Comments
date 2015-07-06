package com.softserveinc.ita.commentstests.criterias;

import com.softserveinc.ita.commentstests.tools.controls.interfaces.ITextInput;
/**
 * @author Dp-076 ATQC
 * This class is criteria for all text inputs.
 */
public final class TextInputCriteria implements ISpecification {
    /**
     * identify of fext input field throw ITextInput interface.
     */
    private ITextInput textInput;
    /**
     * identify of specification field.
     */
    private Specification specification;
    /**
     * Constructor.
     * @param theTextInput
     *            - ITextInput object
     * @param theSpecification
     *            - Specification object
     */
    private TextInputCriteria(final ITextInput theTextInput,
            final Specification theSpecification) {
        textInput = theTextInput;
        specification = theSpecification;
    }
    /**
     * @param textInput
     *            - ITextInput object
     * @param specification
     *            - Specification object
     * @return new criteria for text input.
     */
    public static TextInputCriteria get(
            final ITextInput textInput, final Specification specification) {
        return new TextInputCriteria(textInput, specification);
    }
    /**
     * Check is text input color matches with expected text input color.
     * @param expectedResult - expected color for comparison
     * @return specification.
     */
    public TextInputCriteria colorMatch(final String expectedResult) {
        String textInputColor = "";
        if (this.textInput.getAttributeClass()
                .equals("text-box single-line input-validation-error")) {
            textInputColor = "Highlighted";
        }
        this.specification.add(textInputColor.equals(expectedResult),
                "Color of text input is not valid. ");
        return this;
    }
    /**
     * Check is text input visible.
     * @return specification.
     */
    public TextInputCriteria isVisible() {
        this.specification.add(this.textInput.isDisplayed()
                , "Text input is not visible. ");
        return this;
    }
    /**
     * Next specification.
     * @return specification.
     */
    public Specification next() {
        return this.specification;
    }
}



