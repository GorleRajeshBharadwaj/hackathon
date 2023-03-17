package service;

import model.Problem;
import util.Difficulty;
import util.Tag;

import java.util.List;
import java.util.Set;

public interface IProblemService {

    public void addProblem(String description, int score, Difficulty level, Set<Tag> tags);

    public Problem getProblem(int problemId);

    public List<Problem> getProblems();

    public List<Problem> getProblems(List<Integer> problemIdList);

    public List<Problem> fetchProblems(List<Tag> tagFilters, int sortingCriteria);

    public void updateAvgTime(int problemId, Double time);
}
