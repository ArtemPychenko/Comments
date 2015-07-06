package com.softserveinc.ita.commentstests.criterias;

import com.softserveinc.ita.commentstests.pages.MainPage;

/**
 * @author Dp-076 ATQC
 * This class contains criteria for Main page object.
 */
public final class MainPageCriteria implements ISpecification {
    /**
     * This variable contain current MainPageCriteria.
     */
    private MainPage page;
    /**
     * Logger.
     */
    private Specification specification;

    /**
     * The constructor of the class.
     * @param thePage - aim MainPage.
     * @param theSpecification - logger.
     */
    private MainPageCriteria(final MainPage thePage,
            final Specification theSpecification) {
        this.page = thePage;
        this.specification = theSpecification;
    }

    /**
     * Static method for create new ErrorDialogCriteria.
     * @param page -aim MainPage.
     * @param specification - logger.
     * @return new MainPageCriteria.
     */
    public static MainPageCriteria get(final MainPage page,
            final Specification specification) {
        return new MainPageCriteria(page, specification);
    }

    /**
     * This method compare MainPage object with input MainPage object.
     * @param expectedMainPage - MainPage for compare.
     * @return current MainPageCriteria.
     */
    public MainPageCriteria pageMatch(final MainPage expectedMainPage) {
        this.specification.add(this.page.equals(expectedMainPage),
                "Values doesn't match.");
        return this;
    }
    /**
     * This method compare MainPage object current page number with input page
     * number.
     * @param expectedPageNumber - input number for compare.
     * @return current MainPageCriteria.
     */
    public MainPageCriteria pageNumberMatch(final Short expectedPageNumber) {
        this.specification.add(this.page.getCurrentPageNumber()
                == expectedPageNumber, "Current page number isn't match");
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
