package model;

import java.util.Date;

public class UserSession {

    private int userSessionId;
    private int userId;
    private int problemId;
    Date startTime;
    Date endTime = null;

    public UserSession(int userSessionId, int userId, int problemId) {
        this.userSessionId = userSessionId;
        this.userId = userId;
        this.problemId = problemId;
        this.startTime = new Date();
    }

    public void problemSolved() {
        this.endTime = new Date();
    }

    public int getUserSessionId() {
        return userSessionId;
    }

    public int getUserId() {
        return userId;
    }

    public int getProblemId() {
        return problemId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "userSessionId=" + userSessionId +
                ", userId=" + userId +
                ", problemId=" + problemId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
