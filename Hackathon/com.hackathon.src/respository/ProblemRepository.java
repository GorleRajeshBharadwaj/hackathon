package respository;

import model.Problem;
import util.Difficulty;
import util.Tag;

import java.util.*;

public class ProblemRepository {

    private Map<Integer, Problem> allProblems;
    int autoIncrementId;

    public ProblemRepository() {
        this.allProblems = new HashMap<>();
        this.autoIncrementId = 1;
    }

    public void addProblem(String description, int score, Difficulty level, Set<Tag> tags) {
        Problem newProblem = new Problem(autoIncrementId, description, score, level, tags);
        allProblems.put(autoIncrementId, newProblem);
        autoIncrementId++;
    }

    public void updateProblemAvgTime(int problemId, double averageTime) throws Exception {
        if(!allProblems.containsKey(problemId)) throw new Exception("Problem does not exits with id " + problemId);
        Problem prob = allProblems.get(problemId);
        prob.setAverageTime(averageTime);
        allProblems.put(problemId, prob);
    }

    public List<Problem> getProblems() {
        return new ArrayList<>(allProblems.values());
    }

    public List<Problem> getProblems(List<Integer> problemIdList) {
        List<Problem> problemList = new ArrayList<>();
        for(Integer problemId: problemIdList) {
            if(allProblems.containsKey(problemId))problemList.add(allProblems.get(problemId));
        }
        return problemList;
    }

    public Problem getProblem(int problemId) throws Exception {
        if(!allProblems.containsKey(problemId)) throw new Exception("Problem not found!");
        return allProblems.get(problemId);
    }

    public void updateAvgTime(int problemId, Double time) throws Exception {
        if(!allProblems.containsKey(problemId)) throw new Exception("Problem not found!");
        Problem problem = allProblems.get(problemId);
        problem.updateNewAvgTimeAndUserCount(time);
    }
}
