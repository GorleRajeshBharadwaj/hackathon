package service;

import model.Contestant;

import java.util.List;

public interface IContestantService {

    public void addUser(String name, String description);

    public List<Contestant> getContestants();

    public void updateTotalScore(int userId, int score);

    public List<Contestant> displayLeaderShipBoard(int size);

    public List<String> displayLeadShipBoardDepartmants(int size);
}
