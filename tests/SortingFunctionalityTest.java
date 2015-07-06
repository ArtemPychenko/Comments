package com.softserveinc.ita.commentstests.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.softserveinc.ita.commentstests.criterias.Specification;
import com.softserveinc.ita.commentstests.pages.MainPage;
import com.softserveinc.ita.commentstests.tools.WebDriverUtils;

/**
 *@author Alla Prykhodchenko
 *              This test-case for checking sorting functionality
 *              of the Comments application http://comments.azurewebsites.net/
 */
public class SortingFunctionalityTest {
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
     *This test check sorting by number in ascending and descending order.
     *functionality.
     */
    @Test(dependsOnMethods = {"sortingByCommentTextTest"}, alwaysRun = true)
    public final void sortingByNumberTest() {
        mainPage = new MainPage();
        specification.For(mainPage
                .commentNumberColumnHeaderClick()
                .getCommentsInMainPage())
                .listSortedByNumberInAscendingOrder()
                .next()
                .For(new MainPage()
                        .commentNumberColumnHeaderClick()
                        .getCommentsInMainPage())
                        .listSortedByNumberInDescendingOrder();
        specification.check();
    }
    /**
     *This test check sorting by comment text in ascending and descending order
     *functionality.
     */
    @Test
    public final void sortingByCommentTextTest() {
        mainPage = new MainPage();
        specification.For(mainPage
                .getCommentsInMainPage())
                .listSortedByCommentTextInAscendingOrder()
                .next()
                .For(new MainPage()
                        .commentTextColumnHeaderClick()
                        .getCommentsInMainPage())
                        .listSortedByCommentTextInDescendingOrder();
        specification.check();
    }
    /**
     *This method performs the operations necessary after the test execution.
     */
    @AfterClass
    public final void tearDown() {
        //WebDriverUtils.stop();
        System.out.println(specification.getDescription());
    }
}
