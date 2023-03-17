package service;

import model.Contestant;
import model.Problem;
import model.UserSession;
import respository.ProblemRepository;
import respository.UserSessionRepository;

import java.util.List;

public class UserSessionService {

    UserSessionRepository userSessionRepository;
    ProblemService problemService;

    ContestantService contestantService;

    public UserSessionService(UserSessionRepository userSessionRepository, ProblemService problemService, ContestantService contestantService) {
        this.userSessionRepository = userSessionRepository;
        this.problemService = problemService;
        this.contestantService = contestantService;
    }

    public void addUserSession(int userId, int problemId) {
        userSessionRepository.addUserSession(userId, problemId);
    }

    public void solve(int userId, int problemId) throws Exception {
        userSessionRepository.addEndTime(userId, problemId);
        UserSession userSession = userSessionRepository.getUserSession(userId, problemId);

        long avgTime = userSession.getEndTime().getTime() - userSession.getStartTime().getTime();
        problemService.updateAvgTime(problemId, Double.valueOf(avgTime));

        Problem problem = problemService.getProblem(problemId);
        contestantService.updateTotalScore(userId, problem.getScore());
    }

    public List<Problem> fetchSolvedProblems(int userId) {
        List<Integer> problemIdList = userSessionRepository.problemsSolvedByUser(userId);
        return problemService.getProblems(problemIdList);
    }

}
