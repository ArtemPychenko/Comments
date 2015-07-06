package com.softserveinc.ita.commentstests.domain.repositories;

import com.softserveinc.ita.commentstests.domain.models.Category;
import com.softserveinc.ita.commentstests.domain.models.Comment;
import com.softserveinc.ita.commentstests.pages.MainPage;
/***
 * This class contain valid and invalid comments.
 * @author DP-076ATQC
 *
 */
public final class CommentsRepository {
    /**first comment.*/
    private static Short commentNumber1 = 1;
    /**second comment.*/
    private static Short commentNumber2 = 2;
    /**empty comment number.*/
    private static Short commentNumberEmpty = null;
    /**Private constructor.*/
    private CommentsRepository() {
    }
    /**
     * This method create comment with number 1, text, all category.
     * @return valid comment
     */
    public static Comment getCommentNumber1() {
        Category[] categories = CategoriesRepository.getAllValidCategories();
        return new Comment()
            .setCommentText("Comment Text 1")
            .setCommentNumber(commentNumber1)
            .setActive(false)
            .setCategories(categories);
    }
    /**
     * This method create comment with number 2 duplicate comment number 1.
     * @return valid comment with number 2 and other data duplicate comment 1
     */
    public static Comment getComment2DuplicateNumber1() {
        Category[] categories = CategoriesRepository.getAllValidCategories();
        return new Comment()
            .setCommentText("Copy of Comment Text 1")
            .setCommentNumber(commentNumber2)
            .setActive(false)
            .setCategories(categories);
    }
    /***
     * This method duplicate comment number 1.
     * @return new comment duplicate comment number 1
     */
    public static Comment getCommentDataDuplicateNumber1() {
        Category[] categories = CategoriesRepository.getAllValidCategories();
        return new Comment()
            .setCommentText("Copy of Comment Text 1")
            .setCommentNumber(commentNumberEmpty)
            .setActive(false)
            .setCategories(categories);
    }
    /**
     * This method create comment with empty text and number 1.
     * @return inValid comment with empty text field
     */
    public static Comment getCommentNumber1EmptyTextField() {
        Category[] categories = CategoriesRepository.getAllValidCategories();
        return new Comment()
            .setCommentText("")
            .setCommentNumber(commentNumber1)
            .setActive(false)
            .setCategories(categories);
    }
    /**
     *This method create comment with empty fields.
     * @return inValid comment
     */
    public static Comment getCommentEmptyAllFields() {
        Category[] categories = null;
        return new Comment()
            .setCommentText("")
            .setCommentNumber(null)
            .setActive(false)
            .setCategories(categories);
  }
    /**
     * This method create comment with text field contain "a".
     * @return Valid comment
     */
    public static Comment getCommentNumber1AtextField() {
        Category[] categories = CategoriesRepository.getAllValidCategories();
        return new Comment()
            .setCommentText("a")
            .setCommentNumber(commentNumber1)
            .setActive(false)
            .setCategories(categories);
    }
    /**
     * This method create new comment with not valid chars in text field.
     * @return Invalid comment
     */
    public static Comment getCommentNumber1SpecialSymbolsTextField() {
        Category[] categories = CategoriesRepository.getAllValidCategories();
        return new Comment()
            .setCommentText("!@#$%^&*")
            .setCommentNumber(commentNumber1)
            .setActive(false)
            .setCategories(categories);
    }
    /**
     *This method create new comment with 50 chars in text field.
     * @return valid comment
     */
    public static Comment getCommentNumber1_50SymbolsTextField() {
        Category[] categories = CategoriesRepository.getAllValidCategories();
        return new Comment()
            .setCommentText(
                    "qwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiop")
            .setCommentNumber(commentNumber1)
            .setActive(false)
            .setCategories(categories);
    }
    /**
     * This method create new comment with 51 chars in text field.
     * @return inValid comment
     */
    public static Comment getCommentNumber1_51SymbolsTextField() {
        Category[] categories = CategoriesRepository.getAllValidCategories();
        return new Comment()
            .setCommentText(
                    "qwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiop1")
            .setCommentNumber(commentNumber1)
            .setActive(false)
            .setCategories(categories);
    }
    /**
     * This method create valid comment with text1 and number2.
     * @return valid comment
     */
    public static Comment getCommentNumber2WithTextField1() {
        Category[] categories = CategoriesRepository.getAllValidCategories();
        return new Comment()
            .setCommentText("Comment Text 1")
            .setCommentNumber(commentNumber2)
            .setActive(false)
            .setCategories(categories);
    }
    /**
     * This method create valid comment with don't used number.
     * @param mainPage - page content comment grid
     * @return valid comment with don't used number
     */
    public static Comment getCommentWithDontUseNumber(final MainPage mainPage) {
       short maxNumber = FakeDataBase.calculateMaxNumber(mainPage);
       short nextNumber = 1;
       short dontUseNumber = (short) (maxNumber + nextNumber);
       Category[] categories = CategoriesRepository.getAllValidCategories();
       return new Comment()
           .setCommentText("New comment" + String.valueOf(dontUseNumber))
           .setCommentNumber(dontUseNumber)
           .setActive(true)
           .setCategories(categories);
    }
}
