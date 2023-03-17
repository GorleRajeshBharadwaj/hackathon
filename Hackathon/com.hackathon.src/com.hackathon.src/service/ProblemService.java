package service;

import model.Problem;
import respository.IProblemRepository;
import util.Difficulty;
import util.Tag;

import java.util.*;
import java.util.stream.Collectors;

public class ProblemService implements IProblemService {

    IProblemRepository problemRepository;

    public ProblemService(IProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    public void addProblem(String description, int score, Difficulty level, Set<Tag> tags) {
        problemRepository.addProblem(description, score, level, tags);
    }

    public List<Problem> fetchProblems(List<Tag> tagFilters, int sortingCriteria) {
        List<Problem> problems = problemRepository.getProblems();
        if(problems.isEmpty()) return problems;

        List<Problem> finalList = new ArrayList<>();
        for(Tag tag: tagFilters) {
            finalList.addAll(problems.stream().filter(problem -> problem.getProblemTags().contains(tag)).collect(Collectors.toList()));
        }

        sortByScore(sortingCriteria, finalList);
        return finalList;
    }

    private void sortByScore(int sortCriteria, List<Problem> list) {
        if(sortCriteria == 0) return;
        Collections.sort(list, new Comparator<Problem>() {
            @Override
            public int compare(Problem o1, Problem o2) {
                if(sortCriteria == -1) return o1.getScore()-o2.getScore();
                else return o2.getScore()-o1.getScore();
            }
        });

    }

    public List<Problem> getProblems(List<Integer> problemIdList) {
        return problemRepository.getProblems(problemIdList);
    }

    public List<Problem> getProblems() {
        return problemRepository.getProblems();
    }

    public Problem getProblem(int problemId) {
        return problemRepository.getProblem(problemId);
    }

    public void updateAvgTime(int problemId, Double time) {
        problemRepository.updateProblemAvgTime(problemId, time);
    }
}
