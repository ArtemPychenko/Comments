package com.softserveinc.ita.commentstests.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.softserveinc.ita.commentstests.criterias.Specification;
import com.softserveinc.ita.commentstests.pages.CommentsInMainPage;
import com.softserveinc.ita.commentstests.pages.ConfirmDialogPage;
import com.softserveinc.ita.commentstests.pages.ErrorDialogPage;
import com.softserveinc.ita.commentstests.pages.MainPage;
import com.softserveinc.ita.commentstests.tools.WebDriverUtils;

/**
 * This is Test-case class for Remove From Category functionality.
 * @author Aleksandr Zaitsev
 */
public class RemoveFromCategoryFunctionalityTest {

    /**
     * @param specification - instance of the Specification class to keep
     * the test going (soft assert).
     */
    private Specification specification;

    /**
     * @param mainPage - instance of main page. according to the Page Object
     * pattern.
     */
    private MainPage mainPage;

    /**
     * @param errDialog - instance of main error dialog page.
     */
    private ErrorDialogPage errDialog;

    /**
     * @param confirmDialog - instance of main confirm dialog.
     */
    private ConfirmDialogPage confirmDialog;

    /**
     * @param commentsInMainPage - instance of commentsInMainPage.
     */
    private CommentsInMainPage commentsInMainPage;

    /**
     * Set up for test page to be loaded
     * instance of Specification class is created.
     */
    @BeforeClass
    public final void setUp() {
        WebDriverUtils.load(TestsConstants.URL_FOR_TEST);
        mainPage = new MainPage();
        specification = Specification.get();
        commentsInMainPage = new CommentsInMainPage();
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
                + " remove from category functionality");
        System.out.println(specification.getDescription());*/
    }

    /**
     * Test case to verify the functionality of remove from category.
     */
    @Test
    public final void removeFromCategoryFunction() {
        specification

        /**
         * Test for Error Message is displayed if none of comments are
         * selected.
         */
         .For(errDialog = mainPage
         .selectCategoryInDropdown(TestsConstants.ALL_CATEGORIES)
                 .applyButtonClick()
                 .removeFromCategoryEmptyButtonClick())
         .textRemoveFromCategoryMatch(TestsConstants.ERROR_ALERT_LABEL)
         .buttonOkMatch(TestsConstants.OK_BUTTON_LABEL)
         .next()

        /**
         * Test for check, that ErrorMassage is displayed if specific
         * category is not selected
         */
         .For(errDialog = errDialog.clickOk()
                 .getCommentsInMainPage()
                 .getRandomCommentLine()
                 .commentItemLineClick()
                 .removeFromCategoryNotSpecificCategory())
         .textRemoveFromCategoryMatch(TestsConstants
                 .ERROR_ALERT_LABEL_SELECT_CATEGORY)
         .buttonOkMatch(TestsConstants.OK_BUTTON_LABEL)
         .next()

        /**
         * Test for check, that after not confirm RemoveFromCategory,
         * comments became unselected.
         */
         .For(commentsInMainPage = errDialog.clickOk()
                 .selectCategoryInDropdown(TestsConstants.CAT0_CATEGORY)
                 .applyButtonClick()
                 .getCommentsInMainPage())
         .next()
         .For(confirmDialog = commentsInMainPage.saveCommentLine(
             commentsInMainPage.getCommentLineAssignedNotToOnlyCategory()
             .commentItemLineGetCommentLineClick())
             .removeFromCategoryButtonClick())
         .textRemoveFromCategoryMatch(TestsConstants
                 .CONFIRM_ALERT_LABEL_REMOVE_CATEGORY)
         .buttonYesMatch(TestsConstants.YES_BUTTON_LABEL)
         .buttonNoMatch(TestsConstants.NO_BUTTON_LABEL)
         .next()

         /**
          * Test for check, that after not confirm
          * RemoveFromCategory, comments became unselected category is present
          * in comment.
          */
         .For(confirmDialog.clickNo().getCommentsInMainPage()
                 .findCommentByNumber(commentsInMainPage
                 .commentLineForComparison()
                 .getComment().getCommentNumber()))
         .oneCategoryMatch(TestsConstants.CATEGORY_FOR_COMPARING)
         .next()
         .For(commentsInMainPage = mainPage.getCommentsInMainPage())
         .areCommentsAreSelectedMatch()
         .next()

         /**
          * Test for check, that after confirm RemoveFromCategory,
          * category removed from comment.
          */
         .For(new MainPage().selectCategoryInDropdown(TestsConstants
                 .CAT0_CATEGORY)
                 .applyButtonClick())
         .next()
         .For(commentsInMainPage.saveCommentLine(
                 new CommentsInMainPage()
                 .getCommentLineAssignedNotToOnlyCategory()
                 .commentItemLineGetCommentLineClick())
          .removeFromCategoryButtonClick().clickYes()
          .selectCategoryInDropdown(TestsConstants.ALL_CATEGORIES)
          .applyButtonClick()
          .getCommentsInMainPage().findCommentByNumber(
              commentsInMainPage.commentLineForComparison()
              .getComment().getCommentNumber()))
          .oneCategoryNotMatch(TestsConstants.CATEGORY_FOR_COMPARING)
          .next()
          .For(commentsInMainPage = mainPage.getCommentsInMainPage())
          .allCommentsUnselectedMatch()
          .next()

          /**
           * Test for check, that if RemoveFromCategory from comment
           * is assigned to only one category, category not deleted
           * category removed from comment and if confirm - comment made
           * inactive.
           */
          .For(new MainPage().selectCategoryInDropdown(TestsConstants
                  .CAT0_CATEGORY)
                  .applyButtonClick())
          .next()
          .For(commentsInMainPage.saveCommentLine(
                  new CommentsInMainPage()
                  .getCommentLineAssignedToOnlyCategory()
                  .commentItemLineGetCommentLineClick())
           .removeFromCategoryButtonClick().clickYes()
           .getCommentsInMainPage().findCommentByNumber(
               commentsInMainPage.commentLineForComparison().getComment()
               .getCommentNumber()))
           .oneCategoryMatch(TestsConstants.CATEGORY_FOR_COMPARING)
           .statusMatch(false)
           .next()

           /**
           * Test for check, that if RemoveFromCategory from comment
           * is assigned to only one category, category not deleted
           * category removed from comment and if confirm - comment not
           * made inactive.
           */
          .For(new MainPage().selectCategoryInDropdown(TestsConstants
                  .CAT0_CATEGORY)
                  .applyButtonClick())
          .next()
          .For(commentsInMainPage.saveCommentLine(
                  new CommentsInMainPage()
                  .getActiveCommentLineAssignedToOnlyCategory()
                  .commentItemLineGetCommentLineClick())
           .removeFromCategoryButtonClick().clickNo()
           .getCommentsInMainPage().findCommentByNumber(
           commentsInMainPage.commentLineForComparison()
                   .getComment().getCommentNumber()))
           .oneCategoryMatch(TestsConstants.CATEGORY_FOR_COMPARING)
           .statusMatch(true)
           .next()
           .For(commentsInMainPage = mainPage.getCommentsInMainPage())
           .areCommentsAreSelectedMatch()
           .next()

           /**
            * Test for check, that if first comment is assigned to one category
            * and second one is to more than one, if confirm making first
            * one inactive - it became inactive and if confirm deleting of
            * second - category will be removed from it.
            */
           .For(new MainPage().selectCategoryInDropdown(TestsConstants
                   .CAT0_CATEGORY)
                   .applyButtonClick())
           .next()
           .For(commentsInMainPage.saveCommentLine(
                   new CommentsInMainPage()
                   .getActiveCommentLineAssignedToOnlyCategory()
                   .commentItemLineGetCommentLineClick()))
           .next()
           .For(commentsInMainPage.saveCommentLine(
                   new CommentsInMainPage()
                   .getCommentLineAssignedNotToOnlyCategory()
                   .commentItemLineGetCommentLineClick())
                   .removeFromCategoryButtonClick().clickYes()
                   .getConfirmDialogPage().clickYes()
                   .selectCategoryInDropdown("All").applyButtonClick()
                   .getCommentsInMainPage().findCommentByNumber(
                   commentsInMainPage.commentLineForComparison().getComment()
                   .getCommentNumber()))
           .oneCategoryMatch(TestsConstants.CATEGORY_FOR_COMPARING)
           .statusMatch(false)
           .next()
           .For(commentsInMainPage.findCommentByNumber(
                   commentsInMainPage.commentLineForComparison()
                   .getComment().getCommentNumber()))
           .oneCategoryNotMatch(TestsConstants.CATEGORY_FOR_COMPARING)
           .next()
           .For(commentsInMainPage = mainPage.getCommentsInMainPage())
           .allCommentsUnselectedMatch()
           .next()

           /**
            * Test for check, that if first comment is assigned to one category
            * and second one is to more than one, do not confirm making first
            * one inactive - it stays active and if confirm deleting of
            * second - category will be removed from it.
            */
           .For(new MainPage().selectCategoryInDropdown(TestsConstants
                   .CAT0_CATEGORY)
                   .applyButtonClick())
           .next()
           .For(commentsInMainPage.saveCommentLine(
                   new CommentsInMainPage()
                   .getActiveCommentLineAssignedToOnlyCategory()
                   .commentItemLineGetCommentLineClick()))
           .next()
           .For(commentsInMainPage.saveCommentLine(
                   new CommentsInMainPage()
                   .getCommentLineAssignedNotToOnlyCategory()
                   .commentItemLineGetCommentLineClick())
                   .removeFromCategoryButtonClick().clickNo()
                   .getConfirmDialogPage().clickYes()
                   .selectCategoryInDropdown(TestsConstants.ALL_CATEGORIES)
                   .applyButtonClick()
                   .getCommentsInMainPage().findCommentByNumber(
                   commentsInMainPage.commentLineForComparison().getComment()
                   .getCommentNumber()))
           .oneCategoryMatch(TestsConstants.CATEGORY_FOR_COMPARING)
           .statusMatch(true)
           .next()
           .For(commentsInMainPage.findCommentByNumber(
                   commentsInMainPage
                   .commentLineForComparison().getComment().getCommentNumber()))
           .oneCategoryNotMatch(TestsConstants.CATEGORY_FOR_COMPARING)
           .next()
           .For(commentsInMainPage = mainPage.getCommentsInMainPage())
           .allCommentsUnselectedMatch()
           .next()

           /**
            * Test for check, that if select two comments and select
            * RemoveFromCategory - category will be removed from both of them.
            */
           .For(new MainPage().selectCategoryInDropdown(TestsConstants
                   .CAT0_CATEGORY)
                   .applyButtonClick())
           .next()
           .For(commentsInMainPage.saveCommentLine(
                   new CommentsInMainPage()
                   .getCommentLineAssignedNotToOnlyCategory()
                   .commentItemLineGetCommentLineClick()))
            .next()
            .For(commentsInMainPage.saveCommentLine(
                    new CommentsInMainPage()
                    .getCommentLineAssignedNotToOnlyCategory()
                    .commentItemLineGetCommentLineClick())
                    .removeFromCategoryButtonClick().clickYes()
                    .selectCategoryInDropdown(TestsConstants.ALL_CATEGORIES)
                    .applyButtonClick()
                    .getCommentsInMainPage().findCommentByNumber(
                    commentsInMainPage.commentLineForComparison()
                            .getComment().getCommentNumber()))
            .oneCategoryNotMatch(TestsConstants.CATEGORY_FOR_COMPARING)
            .next()
            .For(commentsInMainPage.findCommentByNumber(commentsInMainPage
                    .commentLineForComparison()
                    .getComment().getCommentNumber()))
            .oneCategoryNotMatch(TestsConstants.CATEGORY_FOR_COMPARING)
            .next()
            .For(commentsInMainPage = mainPage.getCommentsInMainPage())
            .allCommentsUnselectedMatch()
            .next()

            /**
             * Test for check, that if select two comments and select
             * RemoveFromCategory - category will be removed from both of them.
             */
            .For(new MainPage().selectCategoryInDropdown(TestsConstants
                    .CAT0_CATEGORY)
                    .applyButtonClick())
            .next()
            .For(commentsInMainPage.saveCommentLine(
                    new CommentsInMainPage()
                    .getCommentLineAssignedToOnlyCategory()
                    .commentItemLineGetCommentLineClick()))
            .next()
            .For(commentsInMainPage.saveCommentLine(
                    new CommentsInMainPage()
                    .getCommentLineAssignedToOnlyCategory()
                    .commentItemLineGetCommentLineClick())
            .removeFromCategoryButtonClick().clickNo()
            .getCommentsInMainPage().findCommentByNumber(
            commentsInMainPage.commentLineForComparison().getComment()
                 .getCommentNumber()))
            .oneCategoryMatch(TestsConstants.CATEGORY_FOR_COMPARING)
            .next()
            .For(commentsInMainPage.findCommentByNumber(commentsInMainPage
                    .commentLineForComparison()
                    .getComment().getCommentNumber()))
            .oneCategoryMatch(TestsConstants.CATEGORY_FOR_COMPARING)
            .next()
            .For(commentsInMainPage = mainPage.getCommentsInMainPage())
            .areCommentsAreSelectedMatch()
            .next()
            .check();

    }

}
