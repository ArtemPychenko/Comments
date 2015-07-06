package com.softserveinc.ita.commentstests.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.softserveinc.ita.commentstests.criterias.CommentListCriteria;
import com.softserveinc.ita.commentstests.criterias.Specification;
import com.softserveinc.ita.commentstests.pages.ConfirmDialogPage;
import com.softserveinc.ita.commentstests.pages.ErrorDialogPage;
import com.softserveinc.ita.commentstests.pages.MainPage;
import com.softserveinc.ita.commentstests.tools.WebDriverUtils;

/**
 * This is Test-case class for Delete functionality.
 * "http://comments.azurewebsites.net/" test.
 *
 * @author Artem Pozdeev
 */
public class DeleteFunctionalityTest {

    /**
     * Main page object of testing Website.
     */
    private MainPage mainPage;

    /**
     * This method initialize global variables.
     */
    @BeforeClass
    public final void setUp() {
        WebDriverUtils.load(TestsConstants.URL_FOR_TEST);
        mainPage = new MainPage();
    }

    /**
     * Method for shutdown WebDriver thread.
     */
    @AfterClass
    public final void tearDown() {
        WebDriverUtils.stop();
    }

    /**
     * Test for Error Message "Select element for delete" appear.
     */
    @Test
    public final void deleteEmptyList() {
        Specification.get()
                .For(mainPage.deleteEmptyButtonClick())
                .textMatch(TestsConstants.ERROR_ALERT_LABEL)
                .buttonOkMatch(TestsConstants.OK_BUTTON_LABEL)
                .next()
                .check();
    }

    /**
     * Test for check, that after unconfirm Delete, comments
     * became unselected. And not deleting in this case.
     */
    @Test(dependsOnMethods = {"deleteEmptyList"}, alwaysRun = true)
    public final void unconfirmDelete() {
        Specification.get()
                .For(new ErrorDialogPage().clickOk()
                        .getCommentsInMainPage()
                        .selectAllComments())
                .allCommentsSelectedMatch()
                .rememberCarrentCommentList()
                .next()
                .For(mainPage.deleteButtonClick())
                .textMatch(TestsConstants.CONFIRM_ALERT_LABEL)
                .buttonYesMatch(TestsConstants.YES_BUTTON_LABEL)
                .buttonNoMatch(TestsConstants.NO_BUTTON_LABEL)
                .next()
                .For(new ConfirmDialogPage().clickNo()
                        .getCommentsInMainPage())
                .allCommentsUnselectedMatch()
                .commentListMatch()
                .rememberCarrentCommentList()
                .next()
                .check();
    }

    /**
     * Test for check deleting one comment in Active state.
     */
    @Test(dependsOnMethods = {"unconfirmDelete"}, alwaysRun = true)
    public final void deleteCommentsInActiveState() {
        Specification.get()
                .For(CommentListCriteria.getPreviousCommentList()
                        .unselectAllComments()
                        .selectActiveComments(TestsConstants
                                .NUM_OF_ACTIV_COMMENTS_FOR_TEST_DELETE))
                .rememberCarrentCommentList()
                .next()
                .For(mainPage
                        .deleteButtonClick()
                        .clickYes()
                        .getCommentsInMainPage())
                .areSelectedCommentsDeletedMatch()
                .rememberCarrentCommentList()
                .next()
                .check();
    }

    /**
     * Test for check deleting two comments in Inactive state.
     */
    @Test(dependsOnMethods = {"deleteCommentsInActiveState"}, alwaysRun = true)
    public final void deleteCommentsInInactiveState() {
        Specification.get()
                .For(CommentListCriteria.getPreviousCommentList()
                        .unselectAllComments()
                        .selectInactiveComments(TestsConstants
                                .NUM_OF_INACTIV_COMMENTS_FOR_TEST_DELETE))
                .next()
                .For(new MainPage()
                        .deleteButtonClick()
                        .clickYes()
                        .getCommentsInMainPage())
                .areSelectedCommentsDeletedMatch()
                .next()
                .check();
    }

}
