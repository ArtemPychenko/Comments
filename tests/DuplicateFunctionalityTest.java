package com.softserveinc.ita.commentstests.tests;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.softserveinc.ita.commentstests.criterias.Specification;
import com.softserveinc.ita.commentstests
        .domain.repositories.CommentsRepository;
import com.softserveinc.ita.commentstests.pages.EditPage;
import com.softserveinc.ita.commentstests.pages.ErrorDialogPage;
import com.softserveinc.ita.commentstests.pages.MainPage;
import com.softserveinc.ita.commentstests.tools.WebDriverUtils;

/**
 * This class makes tests "Duplicate" functionality of Comments.
 * @author Andriy Lantukh
 *
 */
public class DuplicateFunctionalityTest {
    /**
     * Specification object for soft-assert report create.
     */
    private Specification specification;
    /**
     * Main page object of Comments WebSite.
     */
    private MainPage mainPage;
    /**
     * Edit page object of Comments WebSite.
     */
    private EditPage editPage;
    /**
     * Error dialog window object of Comments WebSite.
     */
    private ErrorDialogPage errorDialogPage;

    /**
     * This method runs before test and
     * initialize global variables.
     */
    @BeforeClass
    public final void setUp() {
        WebDriverUtils.load(TestsConstants.URL_FOR_TEST);
        specification = Specification.get();
        mainPage = new MainPage();

        /* Preconditions */
        /* This section find and delete comment 1 */
        mainPage
            .findComment(TestsConstants.NUM_OF_FIRST_COMMENT)
            .commentItemLineClick()
            .deleteButtonClick()
            .clickYes()
        /* This section find, delete comment 2 end click "New" button */
            .findComment(TestsConstants.NUM_OF_SECOND_COMMENT)
            .commentItemLineClick()
            .deleteButtonClick()
            .clickYes()
            .createNewCommentButtonClick()
        /* This section store data to fields from CommentRepository*/
            .setCommentData(CommentsRepository.getCommentNumber1())
        /* This section click "SaveReturn" button*/
            .successfulSaveReturn();
    }
    /**
     * This method runs after test.
     */
    @AfterClass
    public final void tearDown() {
        //WebDriverUtils.stop();
        //System.out.println("Result of test-case execution:");
     //   System.out.println(specification.getDescription());
    }

    /**
     * This method is test for duplicate functionality of comments.
     */
    @Test
    public final void duplicateFunctionalityCheck() {

        /* This section check is present validates error message  */
        specification
            .For(errorDialogPage = mainPage.duplicateEmptyButtonClick())
            .textMatch(TestsConstants.DUPLICATE_ERROR_ALERT_LABEL)
            .buttonOkMatch(TestsConstants.OK_BUTTON_LABEL)
            .next()
            .For(mainPage = errorDialogPage.clickOk())
            .next()

            /* This section makes choose comment number 1
             *  and click "Duplicate" */
            .For(editPage = mainPage
            .findComment(TestsConstants.NUM_OF_FIRST_COMMENT)
            .commentItemLineClick()
            .duplicateButtonClick())
            .next()

            /* This section makes validation Data in EditPage's fields */
            .For(editPage.getCommentData())
            .commentTextMatch(CommentsRepository
                    .getCommentDataDuplicateNumber1().getCommentText())
            .numberMatch(CommentsRepository
                    .getCommentDataDuplicateNumber1().getCommentNumber())
            .statusMatch(CommentsRepository
                    .getCommentDataDuplicateNumber1().getActive())
            .categoriesMatch(CommentsRepository
                    .getCommentDataDuplicateNumber1().getCategories())
            .next()

            /* This section refill fields from repository
             * repository - getComment2DuplicateNumber1
             * and click "SaveReturn"
             */
            .For(mainPage = editPage.setCommentData(CommentsRepository
                    .getComment2DuplicateNumber1()).successfulSaveReturn())
            .next()

             /* This section find and compare created comment */
            .For(mainPage.findComment(TestsConstants.NUM_OF_SECOND_COMMENT)
                    .getComment())
            .commentMatch(CommentsRepository.getComment2DuplicateNumber1())
            .next()
            .check();
    }
}
