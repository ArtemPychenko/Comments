package com.softserveinc.ita.commentstests.criterias;

import com.softserveinc.ita.commentstests.pages.EditPage;

public class EditPageCriteria implements ISpecification{
    private EditPage page;
    private Specification specification;

    private EditPageCriteria(EditPage page, Specification specification) {
        this.page = page;
        this.specification = specification;
    }

    public static EditPageCriteria get(EditPage page,
            Specification specification) {
        return new EditPageCriteria(page, specification);
    }

    public EditPageCriteria pageMatch(EditPage expectedMainPage) {
        this.specification.add(this.page.equals(expectedMainPage),
                "Values doesn't match.");
        return this;
    }

    public Specification next() {
        return this.specification;
    }
}


