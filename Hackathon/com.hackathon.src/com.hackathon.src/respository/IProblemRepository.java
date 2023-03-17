package respository;

import model.Problem;
import util.Difficulty;
import util.Tag;

import java.util.List;
import java.util.Set;

public interface IProblemRepository {

    public void addProblem(String description, int score, Difficulty level, Set<Tag> tags);

    public void updateProblemAvgTime(int problemId, double averageTime);

    public List<Problem> getProblems();

    public List<Problem> getProblems(List<Integer> problemIdList);

    public Problem getProblem(int problemId);
}
