import model.Contestant;
import respository.ContestantRepository;
import respository.ProblemRepository;
import respository.UserSessionRepository;
import service.ContestantService;
import service.ProblemService;
import service.UserSessionService;
import util.Difficulty;
import util.Tag;

import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {
        ContestantRepository contestantRepository = new ContestantRepository();
        ContestantService contestantService = new ContestantService(contestantRepository);

        contestantService.addUser("rajesh", "ECE");
        contestantService.addUser("abhishek", "ECE");
        contestantService.addUser("rajeev", "CSE");
        contestantService.addUser("pramod", "CSE");


        ProblemRepository problemRepository = new ProblemRepository();
        ProblemService problemService = new ProblemService(problemRepository);

        problemService.addProblem("DP problem", 100, Difficulty.HARD, new HashSet<>(Arrays.asList(Tag.DP)));
        problemService.addProblem("BFS problem", 75, Difficulty.MEDIUM, new HashSet<>(Arrays.asList(Tag.Graph, Tag.BFS)));
        problemService.addProblem("DFS problem", 60, Difficulty.MEDIUM, new HashSet<>(Arrays.asList(Tag.Graph, Tag.DFS)));
        problemService.addProblem("Tree problem", 40, Difficulty.EASY, new HashSet<>(Arrays.asList(Tag.BST, Tag.BinarySearch)));

        UserSessionRepository userSessionRepository = new UserSessionRepository();
        UserSessionService userSessionService = new UserSessionService(userSessionRepository, problemService, contestantService);

        userSessionService.addUserSession(1, 1);
        userSessionService.solve(1, 1);
        userSessionService.addUserSession(1, 4);
        userSessionService.addUserSession(2, 1);
        userSessionService.addUserSession(3, 4);
        userSessionService.addUserSession(3, 1);
        userSessionService.solve(3, 4);
        userSessionService.solve(3, 1);
        userSessionService.solve(2, 1);
        userSessionService.solve(1, 4);

        System.out.println(userSessionService.fetchSolvedProblems(1));
        System.out.println(contestantService.getContestants());
        System.out.println(problemService.getProblems());

        System.out.println(contestantService.displayLeaderShipBoard(4));
        System.out.println(contestantService.displayLeadShipBoardDepartmants(4));
    }
}
