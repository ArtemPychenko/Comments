package com.softserveinc.ita.commentstests.criterias;

import com.softserveinc.ita.commentstests.tools.controls.interfaces.IDropdown;
/**
 * @author Dp-076 ATQC
 * This class is criteria for all buttons.
 */
public final class DropdownCriteria implements ISpecification {
    /**
     * identify of button field throw IButton interface.
     */
    private IDropdown dropdown;
    /**
     * identify of specification field.
     */
    private Specification specification;
    /**
     * Constructor.
     * @param theDropdown
     *            - IDropdown object
     * @param theSpecification
     *            - Specification object
     */
    private DropdownCriteria(final IDropdown theDropdown,
            final Specification theSpecification) {
        dropdown = theDropdown;
        specification = theSpecification;
    }
    /**
     * @param dropdown
     *            - IDropdown object
     * @param specification
     *            - Specification object
     * @return new criteria for button.
     */
    public static DropdownCriteria get(final IDropdown dropdown,
            final Specification specification) {
        return new DropdownCriteria(dropdown, specification);
    }
    /**
     * Check is selected value matches with expected value.
     * @param expectedResult - expected value for comparison
     * @return specification.
     */
    public DropdownCriteria selectedValueMatch(final String expectedResult) {
        this.specification.add(this.dropdown.getSelectedValuesList().get(0)
                .equals(expectedResult), "Values doesn't match.");
        return this;
    }
    /**
     * Check is dropdown values match with expected values.
     * @return specification.
     */
    public DropdownCriteria valuesMatch() {
        this.specification.add(this.dropdown.isAllCategoriesOnTheirPlaces(),
                "Values doesn't match.");
        return this;
    }

    @Override
    public Specification next() {

        return this.specification;
    }
}
