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
 * @author Artem Pychenko
 * This test-case for checking sorting functionality of the
 *         Comments application http://comments.azurewebsites.net/
 */
public class RefreshFunctionalityTest {
    /**
     * Specification object for soft-assert report create.
     */
    private Specification specification;

    /**
     * Main page object of testing Website.
     */
    private MainPage mainPage;

    /**
     * This method performs the operations necessary to run the test.
     */
    @BeforeClass
    public final void setUp() {
        WebDriverUtils.load(TestsConstants.URL_FOR_TEST);
        specification = Specification.get();
    }

    /**
     * This test check refresh functionality using sorting tests.
     */
    @Test
    public final void refreshSortingByNumberTest() {
        mainPage = new MainPage();
        specification.For(mainPage
                .commentNumberColumnHeaderClick()
                .getCommentsInMainPage())
                .listSortedByNumberInAscendingOrder()
                .next()
                .For(new MainPage()
                        .refreshLinkClick()
                        .getCommentsInMainPage())
                        .listSortedByCommentTextInAscendingOrder()
                        .next()
                        .check();
    }
    /**
     * This test check refresh functionality using grouping tests.
     */
    @Test
    public final void refreshGroupingByCategoryAndStatusFunctionalityTest() {
        mainPage = new MainPage();
        specification.For(mainPage
                .selectCategoryInDropdown(TestsConstants.CAT2_CATEGORY)
                .selectStatusInDropdown(TestsConstants.ACTIVE)
                .applyButtonClick()
                .getCommentsInMainPage())
                .commentCategoryMatch(
                        CategoriesRepository.getAllValidCategories()[2])
                .commentStatusMatch(TestsConstants.ACTIVE)
                .next()
                .For(new MainPage()
                        .refreshLinkClick()
                        .getCommentsInMainPage())
                        .listSortedByCommentTextInAscendingOrder()
                        .next()
                        .check();
    }
    /**
     * This method performs the operations necessary to stop the test and close
     * browser.
     */
    @AfterClass
    public final void tearDown() {
        //WebDriverUtils.stop();
        //System.out.println("Result of test-case execution:");
        //System.out.println(specification.getDescription());
    }
}
