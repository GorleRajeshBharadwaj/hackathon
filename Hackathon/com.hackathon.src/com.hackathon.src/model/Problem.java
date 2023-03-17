package model;

import util.Difficulty;
import util.Tag;

import java.util.Set;

public class Problem {
    private int problemId;
    private String description;
    private Set<Tag> problemTags;
    private int score;
    private Difficulty level;
    private int countUsersSolvedProblem;
    private Double averageTime;

    public Problem(int problemId, String description, int score, Difficulty level, Set<Tag> tags) {
        this.problemId = problemId;
        this.description = description;
        this.score = score;
        this.level = level;
        problemTags = tags;
        this.averageTime = 0.0;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Tag> getProblemTags() {
        return problemTags;
    }

    public void addProblemTags(Set<Tag> problemTags) {
        this.problemTags.addAll(problemTags);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Difficulty getLevel() {
        return level;
    }

    public void setLevel(Difficulty level) {
        this.level = level;
    }

    public int getCountUsersSolvedProblem() {
        return countUsersSolvedProblem;
    }

    public void setCountUsersSolvedProblem(int countUsersSolvedProblem) {
        this.countUsersSolvedProblem = countUsersSolvedProblem;
    }

    public Double getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(Double averageTime) {
        this.averageTime = averageTime;
    }

    public void updateNewAvgTimeAndUserCount(Double timeTaken) {
        this.countUsersSolvedProblem++;
        this.averageTime = (this.averageTime*(this.countUsersSolvedProblem-1) + timeTaken)/this.countUsersSolvedProblem;
    }

    public int getProblemId() {
        return problemId;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "problemId=" + problemId +
                ", description='" + description + '\'' +
                ", problemTags=" + problemTags +
                ", score=" + score +
                ", level=" + level +
                ", countUsersSolvedProblem=" + countUsersSolvedProblem +
                ", averageTime=" + averageTime +
                '}';
    }
}
