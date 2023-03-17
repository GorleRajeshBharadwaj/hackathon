package model;

import java.util.Date;

public class Contestant {

    private int userId;
    private String name;
    private String department;
    private int totalScore = 0;
    private Date recentUpdateTime = null;

    public Contestant(int userId, String name, String department) {
        this.userId = userId;
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public Date getRecentUpdateTime() {
        return recentUpdateTime;
    }

    public void setRecentUpdateTime(Date recentUpdateTime) {
        this.recentUpdateTime = recentUpdateTime;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Contestant{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", totalScore=" + totalScore +
                ", recentUpdateTime=" + recentUpdateTime +
                '}';
    }
}
