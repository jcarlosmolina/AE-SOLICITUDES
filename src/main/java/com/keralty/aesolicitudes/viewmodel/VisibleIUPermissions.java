package com.keralty.aesolicitudes.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class VisibleIUPermissions {

    private String id;

    private List<String> visibleAttributes;

    private List<String> visibleActions;

    private List<String> visibleNavigations;

    private List<String> visibleDetails;

    public VisibleIUPermissions() {
        this.id = "";
        this.visibleAttributes = new ArrayList<>();
        this.visibleActions = new ArrayList<>();
        this.visibleNavigations = new ArrayList<>();
        this.visibleDetails = new ArrayList<>();
    }

    public VisibleIUPermissions(String id) {
        this.id = id;
        this.visibleAttributes = new ArrayList<>();
        this.visibleActions = new ArrayList<>();
        this.visibleNavigations = new ArrayList<>();
        this.visibleDetails = new ArrayList<>();
    }

    public VisibleIUPermissions(String id, List<String> visibleAttributes, List<String> visibleActions,
            List<String> visibleNavigations) {
        this.id = id;
        this.visibleAttributes = visibleAttributes;
        this.visibleActions = visibleActions;
        this.visibleNavigations = visibleNavigations;
        this.visibleDetails = new ArrayList<>();
    }

    public VisibleIUPermissions(String id, List<String> visibleDetails) {
        this.id = id;
        this.visibleAttributes = new ArrayList<>();
        this.visibleActions = new ArrayList<>();
        this.visibleNavigations = new ArrayList<>();
        this.visibleDetails = visibleDetails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getVisibleAttributes() {
        return visibleAttributes;
    }

    public void setVisibleAttributes(List<String> visibleAttributes) {
        this.visibleAttributes = visibleAttributes;
    }

    public List<String> getVisibleActions() {
        return visibleActions;
    }

    public void setVisibleActions(List<String> visibleActions) {
        this.visibleActions = visibleActions;
    }

    public List<String> getVisibleNavigations() {
        return visibleNavigations;
    }

    public void setVisibleNavigations(List<String> visibleNavigations) {
        this.visibleNavigations = visibleNavigations;
    }

    public List<String> getVisibleDetails() {
        return visibleDetails;
    }

    public void setVisibleDetails(List<String> visibleDetails) {
        this.visibleDetails = visibleDetails;
    }

}
