package tests.api;

import baseEntities.BaseApiTest;
import models.Milestone;
import org.testng.annotations.Test;

public class MilestoneTests extends BaseApiTest {
    private Milestone actualMilestone;

    @Test
    public void addMilestone() {
        Milestone expectedMilestone = Milestone.builder()
                .name("newName")
                .description("description")
                .projectID(3)
                .build();

        actualMilestone = milestoneAdapter.add(actualProject, expectedMilestone);
    }

    @Test(dependsOnMethods = "addMilestone")
    public void getMilestone() {
        milestoneAdapter.get(actualMilestone);
    }

    @Test(dependsOnMethods = "addMilestone")
    public void getMilestones() {
        milestoneAdapter.getMilestones(actualProject.getId());
    }

    @Test(dependsOnMethods = "addMilestone")
    public void updateMilestone() {
        actualMilestone.setName("name1");
        milestoneAdapter.update(actualMilestone.getId(), actualMilestone);
    }

    @Test(dependsOnMethods = "addMilestone")
    public void deleteMilestone() {
        milestoneAdapter.delete(actualMilestone.getId(), actualMilestone);
    }

}
