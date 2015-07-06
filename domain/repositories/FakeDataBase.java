package com.softserveinc.ita.commentstests.domain.repositories;

import java.util.ArrayList;
import java.util.List;

import com.softserveinc.ita.commentstests.pages.MainPage;
import com.softserveinc.ita.commentstests.domain.models.Comment;

/**
 * This class emulate data base.
 * used for search comment in all pages in main page.
 * @author DP-076ATQC
 *
 */
public final class FakeDataBase {
    /**private constructor.*/
    private FakeDataBase() { }
    /**
     * This method calculate comment max number.
     * @param mainPage - general page with comments.
     * @return short comment max number
     */
    public static short calculateMaxNumber(MainPage mainPage) {
        
        List<Comment> commentsOnPage = new ArrayList<Comment>();
        short maxNumber = 0;
        short secondPage = 2;
        for (short i = secondPage; i <= mainPage.getPageQuantity() + 1; i++) {
        commentsOnPage = mainPage.getCommentListWithOutChekbox();
        for (Comment com: commentsOnPage) {
            if (maxNumber < com.getCommentNumber()) {
                maxNumber = com.getCommentNumber();
            }
        }
        if (i <= mainPage.getPageQuantity()) {
        mainPage = mainPage.switchPage(i);
        }
        }
        return maxNumber;
    }
    /**
     *This class search comment use number.
     * @param mainPage - general page with comments.
     * @param number - short search number
     * @return search comment
     */
    public static Comment searchComment(MainPage mainPage, final short number){
        List<Comment> commentsOnPage = new ArrayList<Comment>();
        Comment newComment = null;
        for (short i = 2; i <= mainPage.getPageQuantity() + 1; i++) {
        commentsOnPage = mainPage.getCommentListWithOutChekbox();
        for (Comment com: commentsOnPage) {
            if (number == com.getCommentNumber()) {
                newComment = com;
            }
        }
        if (i <= mainPage.getPageQuantity() && newComment == null) {
        mainPage = mainPage.switchPage(i);
        }
        }
        return newComment;
    }

}
