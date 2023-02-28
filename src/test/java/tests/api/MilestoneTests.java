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
                .projectID(actualProject.getId())
                .build();

        actualMilestone = milestoneAdapter.add(actualProject, expectedMilestone);
        milestonesTable.addMilestone(actualMilestone);
    }

    @Test(dependsOnMethods = "addMilestone", priority = 1)
    public void getMilestone() {
        milestoneAdapter.get(actualMilestone);
        milestonesTable.getMilestoneById(actualMilestone.getId());
    }

    @Test(dependsOnMethods = "addMilestone", priority = 2)
    public void getMilestones() {
        milestoneAdapter.getMilestones(actualProject.getId());
        milestonesTable.getMilestones();
    }

    @Test(dependsOnMethods = "addMilestone", priority = 3)
    public void updateMilestone() {
        actualMilestone.setName("name1");
        milestoneAdapter.update(actualMilestone.getId(), actualMilestone);
        milestonesTable.updateName(actualMilestone);
    }

    @Test(dependsOnMethods = "addMilestone", priority = 4)
    public void deleteMilestone() {
        milestoneAdapter.delete(actualMilestone.getId(), actualMilestone);
        milestonesTable.delete(actualMilestone);
    }

}
