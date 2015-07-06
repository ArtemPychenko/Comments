package com.softserveinc.ita.commentstests.tests;

import com.softserveinc.ita.commentstests.domain.models.Category;
import com.softserveinc
        .ita.commentstests.domain.repositories.CategoriesRepository;

public final class TestsConstants {

    public TestsConstants() { 
        
    }
    public static final String URL_FOR_TEST
            = "http://comments.azurewebsites.net/";
    public static final String ERROR_ALERT_LABEL
            = "Please select at least one comment";
    public static final String ERROR_ALERT_LABEL_SELECT_CATEGORY 
            = "Please, select category using filter";
    public static final String CONFIRM_ALERT_LABEL_REMOVE_CATEGORY 
            = "Do you realy want to remove comments from category";
    public static final String DUPLICATE_ERROR_ALERT_LABEL 
            = "Please select one comment";
    public static final String CONFIRM_ALERT_LABEL 
            = "Are you sure you want to delete the selected item(s)?";
    public static final String OK_BUTTON_LABEL = "Ok";
    public static final String YES_BUTTON_LABEL = "Yes";
    public static final String NO_BUTTON_LABEL = "No";
    public static final int NUM_OF_ACTIV_COMMENTS_FOR_TEST_DELETE = 1;
    public static final int NUM_OF_INACTIV_COMMENTS_FOR_TEST_DELETE = 2;
    public static final String ACTIVE = "Active";
    public static final String INACTIVE = "Inactive";
    public static final String ALL_STATUSES = "All";
    public static final short NUM_OF_FIRST_COMMENT = 1;
    public static final short NUM_OF_SECOND_COMMENT = 2;
    public static final Category CATEGORY_FOR_COMPARING 
            = CategoriesRepository.getAllValidCategories()[0];
    public static final String ALL_CATEGORIES = "All";
    public static final String CAT0_CATEGORY = "Cat0";
    public static final String CAT2_CATEGORY = "Cat2";
    public static final String CAT3_CATEGORY = "Cat3";
    public static final String NUMBER_FIELD_LABEL = "Number:";
    public static final String TEXT_FIELD_LABEL = "Comment Text*:";
    
}
