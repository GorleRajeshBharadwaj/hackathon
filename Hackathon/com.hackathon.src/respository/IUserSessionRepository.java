package respository;

import model.UserSession;

import java.util.List;

public interface IUserSessionRepository {

    public void addUserSession(int userId, int problemId);

    public UserSession getUserSession(int userId, int problemId);

    public void addEndTime(int userId, int problemId);

    public List<Integer> problemsSolvedByUser(int userId);
}
