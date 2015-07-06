package com.softserveinc.ita.commentstests.criterias;

import com.softserveinc.ita
        .commentstests.tools.controls.interfaces.IValidationLabel;

public class ValidationLabelCriteria implements ISpecification {
    private IValidationLabel validationLabel;
    private Specification specification;

    private ValidationLabelCriteria(IValidationLabel validationLabel,
            Specification specification) {
        this.validationLabel = validationLabel;
        this.specification = specification;
    }

    public static ValidationLabelCriteria get
        (IValidationLabel validationLabel, Specification specification) {
        return new ValidationLabelCriteria(validationLabel, specification);
    }

    public ValidationLabelCriteria valueMatch(String expectedResult) {
        this.specification.add
            (this.validationLabel.getText().equals(expectedResult),
                "Text of validation label is not valid.");
        return this;
    }
    
    public ValidationLabelCriteria isVisible() {
        this.specification.add(this.validationLabel.isDisplayed()
                , "Validation label is not visible. ");
        return this;
    }

    public Specification next() {
        return this.specification;
    }

}
