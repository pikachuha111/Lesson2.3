package tests.api;

import baseEntities.BaseApiTest;
import models.Case;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CaseTests extends BaseApiTest {
    protected Case caseObjectOne;
    protected Case expectedCase;
    protected Case actualCase;
    protected Case actualCaseTwo;

    @Test
    public void addCase() {
        expectedCase = Case.builder()
                .title("test_case")
                .sectionID(actualSectionOne.getSectionID())
                .build();

        actualCase = caseAdapter.add(expectedCase, actualSectionOne);
        actualCaseTwo = caseAdapter.add(Case.builder()
                .title("test_case2")
                .sectionID(actualSectionOne.getSectionID())
                .build(), actualSectionOne);
    }

    @Test(dependsOnMethods = "addCase")
    public void getCases() {

        actualCase = caseAdapter.get(actualCase.getId());
        Assert.assertEquals(expectedCase, actualCase);

    }

    @Test(dependsOnMethods = "addCase")
    public void updateCases() {
        actualCase.setTitle("name1");
        caseAdapter.update(actualCase);

        Assert.assertNotEquals(expectedCase, actualCase);
    }

    @Test(dependsOnMethods = "addCase")
    public void moveCaseToSection() {
        int suiteID = 1;
        List<Case> cases = List.of(actualCase, actualCaseTwo);
        caseAdapter.moveCases(actualSectionToMove.getSectionID(), suiteID, cases);
    }

    @Test(dependsOnMethods = "addCase")
    public void deleteCase() {
        caseAdapter.delete(actualCaseTwo);
    }

}

