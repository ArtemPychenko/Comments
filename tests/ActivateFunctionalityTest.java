package com.softserveinc.ita.commentstests.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.softserveinc.ita.commentstests.criterias.Specification;
import com.softserveinc.ita.commentstests.pages.CommentsInMainPage;
import com.softserveinc.ita.commentstests.pages.MainPage;
import com.softserveinc.ita.commentstests.tools.WebDriverUtils;

/**
 * This is Test-case class for Activate functionality.
 * @author Aleksandr Zaitsev
 */
public class ActivateFunctionalityTest {
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
                + " activation functionality :");
        System.out.println(specification.getDescription());*/
    }

    /**
     * Test case to verify the functionality of activation.
     */
    @Test
    public final void activateFunction() {
        specification

            /**
             * Test for check, that after activating the inactive comment it
             * became active.
             */
            .For(new CommentsInMainPage()
                    .selectInactiveCommentsAndSave(1))
            .rememberCarrentCommentList()
            .next()
            .For(new MainPage().selectActivateAction()
                    .getCommentsInMainPage())
            .areSelectedCommentsStatusMatch(TestsConstants.ACTIVE)
            .allCommentsUnselectedMatch()
            .next()

            /**
             * Test for check, that after activating the active comment it
             * stays active.
             */
            .For(new CommentsInMainPage()
                    .selectActiveCommentsAndSave(1))
            .rememberCarrentCommentList()
            .next()
            .For(new MainPage().selectActivateAction()
                    .getCommentsInMainPage())
            .areSelectedCommentsStatusMatch(TestsConstants.ACTIVE)
            .allCommentsUnselectedMatch()
            .next()

            /**
             * Test for check, that if select two comments and press activate
             * button - one of them which was active will stay active and
             * another one which was inactive will became active.
             */
            .For(new CommentsInMainPage()
                    .selectActiveCommentsAndSave(1)
                    .selectInactiveCommentsAndSave(1))
            .rememberCarrentCommentList()
            .next()
            .For(new MainPage().selectActivateAction()
                    .getCommentsInMainPage())
            .areSelectedCommentsStatusMatch(TestsConstants.ACTIVE)
            .allCommentsUnselectedMatch()
            .next()

            /**
             * Test for check, that if select two active comments and
             * press activate button - they will stay active.
             */
            .For(new CommentsInMainPage()
                    .selectActiveCommentsAndSave(2))
            .rememberCarrentCommentList()
            .next()
            .For(new MainPage().selectActivateAction()
                    .getCommentsInMainPage())
            .areSelectedCommentsStatusMatch(TestsConstants.ACTIVE)
            .allCommentsUnselectedMatch()
            .next()

            /**
             * Test for check, that if select two inactive comments and
             * press activate button - they will become active.
             */
            .For(new CommentsInMainPage()
                    .selectInactiveCommentsAndSave(2))
            .rememberCarrentCommentList()
            .next()
            .For(new MainPage().selectActivateAction()
                    .getCommentsInMainPage())
            .areSelectedCommentsStatusMatch(TestsConstants.ACTIVE)
            .allCommentsUnselectedMatch()
            .next()
            /**
             * Test for check, that if select all comments and press activate
             * button - they will become active.
             */

            .For(new CommentsInMainPage().selectAllCommentsInMainPage())
            .rememberCarrentCommentList()
            .next()
            .For(new MainPage().selectActivateAction()
                    .getCommentsInMainPage())
            .areSelectedCommentsStatusMatch(TestsConstants.ACTIVE)
            .allCommentsUnselectedMatch()
            .next()
            .check();
    }
}


