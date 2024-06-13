package io.getint.recruitment_task.jiraapi;

import com.phpembeddedsystems.jira.ApiClient;
import com.phpembeddedsystems.jira.api.IssueSearchApi;
import com.phpembeddedsystems.jira.api.IssuesApi;
import com.phpembeddedsystems.jira.model.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JiraApiFacade {
    private final static List<String> FIELDS_TO_COPY = List.of("summary", "description", "priority");
    private final static List<String> PROPERTIES_TO_COPY = List.of("*");
    private final static String ISSUE_DESTINATION_TYPE = "10010";
    private final static boolean DEBUG = false;
    private final static String JIRA_BASE_PATH = "https://xxxx.atlassian.net";
    private final static String JITA_USERNAME = "xxxx@xxxx.com";
    private final static String JIRA_APIKEY = "xxxxxxx";
    private final IssuesApi issuesApi;
    private final IssueSearchApi issueSearchApi;

    public JiraApiFacade() {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(JIRA_BASE_PATH);
        apiClient.setUsername(JITA_USERNAME);
        apiClient.setPassword(JIRA_APIKEY);
        apiClient.setDebugging(DEBUG);
        this.issuesApi = new IssuesApi(apiClient);
        this.issueSearchApi = new IssueSearchApi(apiClient);
    }

    public List<IssueBeanDto> fetchIssues(String projectID) {
        return issueSearchApi.searchForIssuesUsingJql("project=%s".formatted(projectID), 0, 5, "strict", FIELDS_TO_COPY, null, PROPERTIES_TO_COPY, null).getIssues();
    }

    public CreatedIssuesDto addIssues(String projectId, List<IssueBeanDto> issueBeanDtoList) {
        List<IssueUpdateDetailsDto> issueUpdates = issueBeanDtoList.stream().map(issue -> this.toIssueUpdateDetailsDto(projectId, issue)).collect(Collectors.toList());
        IssuesUpdateBeanDto issuesUpdateBeanDto = new IssuesUpdateBeanDto();
        issuesUpdateBeanDto.setIssueUpdates(issueUpdates);
        return issuesApi.createIssues(issuesUpdateBeanDto);
    }

    private IssueUpdateDetailsDto toIssueUpdateDetailsDto(String projectId, IssueBeanDto issueBeanDto) {
        ProjectDto project = new ProjectDto();
        project.setKey(projectId);
        Map<String, Object> fields = issueBeanDto.getFields();
        fields.put("project", project);
        IssueTypeDetailsDto issueTypeDetailsDto = new IssueTypeDetailsDto();
        issueTypeDetailsDto.setId(ISSUE_DESTINATION_TYPE);
        fields.put("issuetype", issueTypeDetailsDto);
        IssueUpdateDetailsDto issueUpdateDetailsDto = new IssueUpdateDetailsDto();
        issueUpdateDetailsDto.setFields(fields);
        return issueUpdateDetailsDto;
    }
}
