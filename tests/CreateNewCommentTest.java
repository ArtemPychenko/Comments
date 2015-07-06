package com.softserveinc.ita.commentstests.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.softserveinc.ita.commentstests.criterias.Specification;
import com.softserveinc.ita.commentstests.domain.models.Comment;
import com.softserveinc.ita.commentstests
       .domain.repositories.CommentsRepository;
import com.softserveinc.ita.commentstests.domain.repositories.FakeDataBase;
import com.softserveinc.ita.commentstests.pages.EditPage;
import com.softserveinc.ita.commentstests.pages.MainPage;
import com.softserveinc.ita.commentstests.tools.WebDriverUtils;
/***
 * This test check function create new comment.
 * @author DP-076 ATQC
 *
 */
public class CreateNewCommentTest {
    /**Specification instance.*/
    private Specification specification;
    /**Main page instance.*/
    private MainPage mainPage;
    /**New comment instance.*/
    private Comment newComment;
    /**edit page instance.*/
    private EditPage editPage;
    /***
     * Pre-condition class.
     * Start WebDriver and create specification instance.
     */
    @BeforeClass
    public final void setUp() {
        WebDriverUtils.load(TestsConstants.URL_FOR_TEST);
        specification = Specification.get();

    }
    /***
     * This test check function create new comment.
     */
    @Test
    public final void createNewComment() {
        mainPage = new MainPage();
        newComment = CommentsRepository.getCommentWithDontUseNumber(mainPage);
        specification
                .For(mainPage.createNewCommentButton())
                .isVisible()
                .next()
                .For(editPage = mainPage.createNewCommentButtonClick())
                .next()
                .For(editPage.getNumberInputLabel())
                .isVisible()
                .valueMatch(TestsConstants.NUMBER_FIELD_LABEL)
                .next()
                .For(editPage.setCommentNumberField(newComment))
                .next()
                .For(editPage.getTextInputLabel())
                .isVisible()
                .valueMatch(TestsConstants.TEXT_FIELD_LABEL)
                .next()
                .For(editPage.setCommentTextField(newComment))
                .next()
                .For(editPage.clickSelectAllCategoriesButton())
                .next()
                .For(editPage.getSaveReturnButton())
                .isVisible()
                .next()
                .For(mainPage = editPage.successfulSaveReturn())
                .next()
                .For(newComment)
                .commentMatch(
                        FakeDataBase.searchComment(mainPage,
                                newComment.getCommentNumber()));
        specification.check();

    }
    /**
     * After class use after test class.
     * Stop driver and print specification
     */
    @AfterClass
    public final void tearDown() {
        //WebDriverUtils.stop();
        //System.out.println("Result of test-case execution:");
        //System.out.println(specification.getDescription());
    }
}
