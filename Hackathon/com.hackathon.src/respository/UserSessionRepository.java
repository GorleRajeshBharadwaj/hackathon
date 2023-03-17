package respository;

import model.UserSession;

import java.util.*;
import java.util.stream.Collectors;

public class UserSessionRepository {

    Map<Integer, UserSession> allUserSessions;
    Map<Integer, Set<Integer>> userIdToSessionId;
    Map<Integer, Set<Integer>> problemToSessionId;
    int autoIncrementId;

    public UserSessionRepository() {
        this.allUserSessions = new HashMap<>();
        this.userIdToSessionId = new HashMap<>();
        this.problemToSessionId = new HashMap<>();
        this.autoIncrementId = 1;
    }

    public void addUserSession(int userId, int problemId) {
        UserSession userSession = new UserSession(autoIncrementId, userId, problemId);
        allUserSessions.put(autoIncrementId, userSession);
        addSessionToUserId(userId, autoIncrementId);
        addSessionToProblemId(problemId, autoIncrementId);
        autoIncrementId++;
    }

    private void addSessionToUserId(int userId, int sessionId) {
        Set<Integer> sessionSet = new HashSet<>();
        if(userIdToSessionId.containsKey(userId)) {
            sessionSet = userIdToSessionId.get(userId);
        }
        sessionSet.add(sessionId);
        userIdToSessionId.put(userId, sessionSet);
    }

    private void addSessionToProblemId(int problemId, int sessionId) {
        Set<Integer> sessionSet = new HashSet<>();
        if(problemToSessionId.containsKey(problemId)) {
            sessionSet = problemToSessionId.get(problemId);
        }
        sessionSet.add(sessionId);
        problemToSessionId.put(problemId, sessionSet);
    }

    public void addEndTime(int userId, int problemId) {
        UserSession session = allUserSessions.values().stream().filter(userSession -> userSession.getUserId() == userId && userSession.getProblemId() == problemId).findAny().get();
        if(session == null) throw new RuntimeException("there is not session with userId "+ userId + " problemId " + problemId);
        session.problemSolved();
    }

    public List<Integer> problemsSolvedByUser(int userId) {
        List<UserSession> sessionList = allUserSessions.values().stream().filter(userSession -> userSession.getUserId() == userId && userSession.getEndTime() != null).collect(Collectors.toList());
        List<Integer> problemList = new ArrayList<>();
        sessionList.stream().forEach(userSession -> problemList.add(userSession.getProblemId()));
        return problemList;
    }

    public UserSession getUserSession(int userId, int problemId) {
        UserSession session = allUserSessions.values().stream().filter(userSession -> userSession.getUserId() == userId && userSession.getProblemId() == problemId).findAny().get();
        if(session == null) throw new RuntimeException("there is not session with userId "+ userId + " problemId " + problemId);
        return session;
    }
}
