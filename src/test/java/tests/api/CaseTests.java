package tests.api;

import baseEntities.BaseApiGsonTest;
import models.Case;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CaseTests extends BaseApiGsonTest {
    protected Case caseObjectOne;
    protected Case caseObjectTwo;
    protected Case expectedCase;

    @Test(groups = "Cases")
    public void getCases() {
        expectedCase = Case.builder()
                .title("name1")
                .sectionID(2)
                .build();

        caseObjectOne = caseAdapter.get(194);
        caseObjectTwo = caseAdapter.get(196);
        Assert.assertEquals(expectedCase, caseObjectOne);

    }

    @Test(dependsOnMethods = "getCases", groups = "Cases")
    public void updateCases() {
        caseObjectOne.setTitle("name1");
        caseAdapter.update(caseObjectOne);

        Assert.assertEquals(expectedCase, caseObjectOne);
    }

    @Test(dependsOnMethods = "getCases", groups = "Cases")
    public void moveCaseToSection() {
        int suiteID = 1;
        int sectionID = 2;
        List<Case> cases = List.of(caseObjectOne, caseObjectTwo);
        caseAdapter.moveCases(sectionID, suiteID, cases);
    }

    @Test(dependsOnMethods = "getCases", groups = "Cases")
    public void deleteCase() {
        caseAdapter.delete(caseObjectTwo);
    }

}

