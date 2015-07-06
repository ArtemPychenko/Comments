package com.softserveinc.ita.commentstests.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.softserveinc.ita.commentstests.criterias.Specification;
import com.softserveinc.ita.commentstests.pages.CommentsInMainPage;
import com.softserveinc.ita.commentstests.pages.MainPage;
import com.softserveinc.ita.commentstests.tools.WebDriverUtils;

/**
 * This is Test-case class for Inactivate functionality.
 * @author Aleksandr Zaitsev
 */
public class InactivateFunctionalityTest {
    /**
     * @param specification - Instance of the Specification class to keep
     * the test going (soft assert).
     */
    private Specification specification;

    /**
     * Set up for test page to be loaded
     * instance of Specification class is created.
     */
    @BeforeClass
    public final void setUp() {
        WebDriverUtils.load(TestsConstants.URL_FOR_TEST);
        specification = Specification.get();
    }

    /**
     * Properly finishing the test case execution:
     * close the Web Driver
     * getting the description of test case execution.
     */
    @AfterClass
    public final void tearDown() {
        /*WebDriverUtils.stop();
        System.out.println("Result of test-case execution of verification of"
                + " inactivation functionality :");
        System.out.println(specification.getDescription());*/
    }

    /**
     * Test case to verify the functionality of inactivation.
     */
    @Test
    public final void inactivateFunction() {
        specification

        /**
         * Test for check, that after deactivating the active comment it
         * became inactive.
         */
        .For(new CommentsInMainPage()
                .selectActiveCommentsAndSave(1))
        .rememberCarrentCommentList()
        .next()
        .For(new MainPage().selectInactivateAction()
                .getCommentsInMainPage())
        .areSelectedCommentsStatusMatch(TestsConstants.INACTIVE)
        .allCommentsUnselectedMatch()
        .next()

        /**
         * Test for check, that after deactivating the inactive comment it
         * stays inactive.
         */
         .For(new CommentsInMainPage()
                .selectInactiveCommentsAndSave(1))
         .rememberCarrentCommentList()
         .next()
         .For(new MainPage().selectInactivateAction()
                .getCommentsInMainPage())
         .areSelectedCommentsStatusMatch(TestsConstants.INACTIVE)
         .allCommentsUnselectedMatch()
         .next()

          /**
           * Test for check, that if select two comments and press deactivate
           * button - one of them which was inactive will stay active and
           * another one which was active will became inactive.
           */
           .For(new CommentsInMainPage()
                    .selectActiveCommentsAndSave(1)
                    .selectInactiveCommentsAndSave(1))
           .rememberCarrentCommentList()
           .next()
           .For(new MainPage().selectInactivateAction()
                    .getCommentsInMainPage())
           .areSelectedCommentsStatusMatch(TestsConstants.INACTIVE)
           .allCommentsUnselectedMatch()
           .next()

           /**
            * Test for check, that if select two inactive comments and press
            * deactivate button - they will stay inactive.
            */
           .For(new CommentsInMainPage()
                   .selectInactiveCommentsAndSave(2))
           .rememberCarrentCommentList()
           .next()
           .For(new MainPage().selectInactivateAction()
                   .getCommentsInMainPage())
           .areSelectedCommentsStatusMatch(TestsConstants.INACTIVE)
           .allCommentsUnselectedMatch()
           .next()

           /**
            * Test for check, that if select two active comments and press
            * deactivate button - they will become inactive.
            */
           .For(new CommentsInMainPage()
                .selectActiveCommentsAndSave(2))
           .rememberCarrentCommentList()
           .next()
           .For(new MainPage().selectInactivateAction()
                   .getCommentsInMainPage())
           .areSelectedCommentsStatusMatch(TestsConstants.INACTIVE)
           .allCommentsUnselectedMatch()
           .next()

           /**
           Test for check, that if select all comments and press deactivate
             * button - they will become inactive.
            */
           .For(new CommentsInMainPage().selectAllCommentsInMainPage())
           .rememberCarrentCommentList()
           .next()
           .For(new MainPage().selectInactivateAction()
                   .getCommentsInMainPage())
           .areSelectedCommentsStatusMatch(TestsConstants.INACTIVE)
           .allCommentsUnselectedMatch()
           .next()
           .check();
    }
}


