package io.getint.recruitment_task;

import com.phpembeddedsystems.jira.model.IssueBeanDto;
import io.getint.recruitment_task.jiraapi.JiraApiFacade;

import java.util.List;

public class JiraSynchronizer {
    /**
     * Search for 5 tickets in one project, and move them
     * to the other project within same Jira instance.
     * When moving tickets, please move following fields:
     * - summary (title)
     * - description
     * - priority
     * Bonus points for syncing comments.
     */
    public void moveTasksToOtherProject() throws Exception {
        JiraApiFacade jiraApiFacade = new JiraApiFacade();
        String projectSourceId = "KAN";
        String projectDestinationId = "WSPAR";
        List<IssueBeanDto> issuesList = jiraApiFacade.fetchIssues(projectSourceId);
        jiraApiFacade.addIssues(projectDestinationId, issuesList);
    }
}
