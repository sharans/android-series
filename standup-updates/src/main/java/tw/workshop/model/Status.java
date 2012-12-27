package tw.workshop.model;

import java.io.Serializable;

public class Status implements Serializable {
    private String storyNumber;
    private String storyStatus;


    public Status(String storyNumber, String storyStatus) {
        this.storyNumber = storyNumber;
        this.storyStatus = storyStatus;
    }

    public String getStoryNumber() {
        return storyNumber;
    }

    public void setStoryNumber(String storyNumber) {
        this.storyNumber = storyNumber;
    }

    public String getStoryStatus() {
        return storyStatus;
    }

    public void setStoryStatus(String storyStatus) {
        this.storyStatus = storyStatus;
    }
}
