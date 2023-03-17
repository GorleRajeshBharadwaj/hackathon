package service;

import model.Problem;

import java.util.List;

public interface IUserSessionService {

    public void addUserSession(int userId, int problemId);

    public void solve(int userId, int problemId);

    public List<Problem> fetchSolvedProblems(int userId);
}
