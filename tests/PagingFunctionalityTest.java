package com.softserveinc.ita.commentstests.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.softserveinc.ita.commentstests.criterias.Specification;
import com.softserveinc.ita.commentstests.pages.MainPage;
import com.softserveinc.ita.commentstests.tools.WebDriverUtils;

/**
 *@author Alla Prykhodchenko
 *              This test-case for checking paging functionality
 *              of the Comments application http://comments.azurewebsites.net/
 */
public class PagingFunctionalityTest {
    /**
     * Specification object for soft-assert report create.
     */
    private Specification specification;

    /**
     * This method performs the operations necessary to run the test.
     */
    @BeforeClass
    public final void setUp() {
        WebDriverUtils.load(TestsConstants.URL_FOR_TEST);
        specification = Specification.get();
    }

    /**
     * This test check the paging functionality.
     */
    @Test
    public final void pagingFunctionalityTest() {
        specification.For(new MainPage()
                .switchPage((short) 2))
                .pageNumberMatch((short) 2)
                .next()
                .For(new MainPage()
                        .switchPageByLeftArrow())
                        .pageNumberMatch((short) 1)
                        .next()
                        .For(new MainPage()
                                .switchPageByRightArrow())
                                .pageNumberMatch((short) 2);
        specification.check();
    }

    /**
     * This method performs the operations necessary after the test execution.
     */
    @AfterClass
    public final void tearDown() {
        //WebDriverUtils.stop();
        //System.out.println(specification.getDescription());
    }
}
