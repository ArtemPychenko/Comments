package com.softserveinc.ita.commentstests.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.softserveinc.ita.commentstests.criterias.Specification;
import com.softserveinc.ita.commentstests.domain.repositories.
CategoriesRepository;
import com.softserveinc.ita.commentstests.pages.MainPage;
import com.softserveinc.ita.commentstests.tools.WebDriverUtils;

/**
 *@author Alla Prykhodchenko
 *              This test-case for checking grouping functionality
 *              of the Comments application http://comments.azurewebsites.net/
 */
public class GroupingFunctionalityTest {
    /**
     * Specification object for soft-assert report create.
     */
    private Specification specification;
    /**
     * Main page object of testing Website.
     */
    private MainPage mainPage;
    /**
     * The category object from Categories repository.
     */
    private final int CATEGORY_3 = 3;

    /**
     * This method performs the operations necessary to run the test.
     */
    @BeforeClass
    public final void setUp() {
        WebDriverUtils.load(TestsConstants.URL_FOR_TEST);
        specification = Specification.get();
    }

    /**
     * This test check the Grouping by category functionality.
     */
    @Test
    public final void groupingByCategoryFunctionalityTest() {
        mainPage = new MainPage();
        specification.For(mainPage
                .selectCategoryInDropdown(TestsConstants.CAT3_CATEGORY)
                .selectStatusInDropdown(TestsConstants.ALL_STATUSES)
                .applyButtonClick()
                .getCommentsInMainPage())
                .commentCategoryMatch(
                        CategoriesRepository
                        .getAllValidCategories()[CATEGORY_3]);
        specification.check();
    }

    /**
     * This test check the Grouping by status functionality.
     */
    @Test
    public final void groupingByStatusFunctionalityTest() {
        mainPage = new MainPage();
        specification.For(mainPage
                .selectCategoryInDropdown(TestsConstants.ALL_CATEGORIES)
                .selectStatusInDropdown(TestsConstants.ACTIVE)
                .applyButtonClick().getCommentsInMainPage())
                .commentStatusMatch(TestsConstants.ACTIVE);
        specification.check();
    }

    /**
     * This test check the Grouping by category and status functionality.
     */
    @Test
    public final void groupingByCategoryAndStatusFunctionalityTest() {
        mainPage = new MainPage();
        specification.For(mainPage
                .selectCategoryInDropdown(TestsConstants.CAT0_CATEGORY)
                .selectStatusInDropdown(TestsConstants.INACTIVE)
                .applyButtonClick()
                .getCommentsInMainPage())
                .commentCategoryMatch(
                        CategoriesRepository.getAllValidCategories()[0])
                .commentStatusMatch(TestsConstants.INACTIVE);
        specification.check();
    }

    /**
     * This method performs the operations necessary after the test execution.
     */
    @AfterClass
    public final void tearDown() {
        //WebDriverUtils.stop();
        System.out.println(specification.getDescription());
    }

}
