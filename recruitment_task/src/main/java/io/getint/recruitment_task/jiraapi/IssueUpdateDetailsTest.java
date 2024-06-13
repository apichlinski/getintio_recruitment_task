package io.getint.recruitment_task.jiraapi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.phpembeddedsystems.jira.model.EntityPropertyDto;
import com.phpembeddedsystems.jira.model.FieldUpdateOperationDto;
import com.phpembeddedsystems.jira.model.HistoryMetadataDto;
import com.phpembeddedsystems.jira.model.IssueTransitionDto;

import java.util.*;

public class IssueUpdateDetailsTest {
    public static final String JSON_PROPERTY_FIELDS = "fields";
    private Map<String, Object> fields = new HashMap<>();

    public static final String JSON_PROPERTY_HISTORY_METADATA = "historyMetadata";
    private HistoryMetadataDto historyMetadata;

    public static final String JSON_PROPERTY_PROPERTIES = "properties";
    private List<EntityPropertyDto> properties = new ArrayList<>();

    public static final String JSON_PROPERTY_TRANSITION = "transition";
    private IssueTransitionDto transition;

    public static final String JSON_PROPERTY_UPDATE = "update";
    private Map<String, List<FieldUpdateOperationDto>> update = new HashMap<>();

    public IssueUpdateDetailsTest() {

    }

    public IssueUpdateDetailsTest fields(Map<String, Object> fields) {

        this.fields = fields;
        return this;
    }

    public IssueUpdateDetailsTest putFieldsItem(String key, Object fieldsItem) {
        if (this.fields == null) {
            this.fields = new HashMap<>();
        }
        this.fields.put(key, fieldsItem);
        return this;
    }

    /**
     * List of issue screen fields to update, specifying the sub-field to update and its value for each field. This field provides a straightforward option when setting a sub-field. When multiple sub-fields or other operations are required, use &#x60;update&#x60;. Fields included in here cannot be included in &#x60;update&#x60;.
     *
     * @return fields
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FIELDS)
    @JsonInclude(content = JsonInclude.Include.ALWAYS, value = JsonInclude.Include.USE_DEFAULTS)

    public Map<String, Object> getFields() {
        return fields;
    }


    @JsonProperty(JSON_PROPERTY_FIELDS)
    @JsonInclude(content = JsonInclude.Include.ALWAYS, value = JsonInclude.Include.USE_DEFAULTS)
    public void setFields(Map<String, Object> fields) {
        this.fields = fields;
    }


    public IssueUpdateDetailsTest historyMetadata(HistoryMetadataDto historyMetadata) {

        this.historyMetadata = historyMetadata;
        return this;
    }

    /**
     * Additional issue history details.
     *
     * @return historyMetadata
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_HISTORY_METADATA)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public HistoryMetadataDto getHistoryMetadata() {
        return historyMetadata;
    }


    @JsonProperty(JSON_PROPERTY_HISTORY_METADATA)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setHistoryMetadata(HistoryMetadataDto historyMetadata) {
        this.historyMetadata = historyMetadata;
    }


    public IssueUpdateDetailsTest properties(List<EntityPropertyDto> properties) {

        this.properties = properties;
        return this;
    }

    public IssueUpdateDetailsTest addPropertiesItem(EntityPropertyDto propertiesItem) {
        if (this.properties == null) {
            this.properties = new ArrayList<>();
        }
        this.properties.add(propertiesItem);
        return this;
    }

    /**
     * Details of issue properties to be add or update.
     *
     * @return properties
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PROPERTIES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<EntityPropertyDto> getProperties() {
        return properties;
    }


    @JsonProperty(JSON_PROPERTY_PROPERTIES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setProperties(List<EntityPropertyDto> properties) {
        this.properties = properties;
    }


    public IssueUpdateDetailsTest transition(IssueTransitionDto transition) {

        this.transition = transition;
        return this;
    }

    /**
     * Details of a transition. Required when performing a transition, optional when creating or editing an issue.
     *
     * @return transition
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TRANSITION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public IssueTransitionDto getTransition() {
        return transition;
    }


    @JsonProperty(JSON_PROPERTY_TRANSITION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTransition(IssueTransitionDto transition) {
        this.transition = transition;
    }


    public IssueUpdateDetailsTest update(Map<String, List<FieldUpdateOperationDto>> update) {

        this.update = update;
        return this;
    }

    public IssueUpdateDetailsTest putUpdateItem(String key, List<FieldUpdateOperationDto> updateItem) {
        if (this.update == null) {
            this.update = new HashMap<>();
        }
        this.update.put(key, updateItem);
        return this;
    }

    /**
     * A Map containing the field field name and a list of operations to perform on the issue screen field. Note that fields included in here cannot be included in &#x60;fields&#x60;.
     *
     * @return update
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_UPDATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Map<String, List<FieldUpdateOperationDto>> getUpdate() {
        return update;
    }


    @JsonProperty(JSON_PROPERTY_UPDATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUpdate(Map<String, List<FieldUpdateOperationDto>> update) {
        this.update = update;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IssueUpdateDetailsTest issueUpdateDetails = (IssueUpdateDetailsTest) o;
        return Objects.equals(this.fields, issueUpdateDetails.fields) &&
                Objects.equals(this.historyMetadata, issueUpdateDetails.historyMetadata) &&
                Objects.equals(this.properties, issueUpdateDetails.properties) &&
                Objects.equals(this.transition, issueUpdateDetails.transition) &&
                Objects.equals(this.update, issueUpdateDetails.update) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fields, historyMetadata, properties, transition, update, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class IssueUpdateDetailsDto {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
        sb.append("    historyMetadata: ").append(toIndentedString(historyMetadata)).append("\n");
        sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
        sb.append("    transition: ").append(toIndentedString(transition)).append("\n");
        sb.append("    update: ").append(toIndentedString(update)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

