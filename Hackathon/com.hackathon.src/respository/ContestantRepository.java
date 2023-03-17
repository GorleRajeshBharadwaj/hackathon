package respository;

import model.Contestant;

import java.util.*;

public class ContestantRepository implements IContestantRepository {

    Map<Integer, Contestant> allContestants;
    int autoIncrementId;

    public ContestantRepository() {
        this.allContestants = new HashMap<>();
        this.autoIncrementId = 1;
    }

    public void addContestant(String name, String department) {
        Contestant contestant = new Contestant(autoIncrementId, name, department);
        allContestants.put(autoIncrementId, contestant);
        autoIncrementId++;
    }

    public void updateTotalScore(int contestantId, int score) {
        if(!allContestants.containsKey(contestantId)) {
            //throw new Exception("Contestant does not exits with id " + contestantId);
            System.out.println("Contestant does not exits with id " + contestantId);
        }
        Contestant contestant = allContestants.get(contestantId);
        contestant.setTotalScore(contestant.getTotalScore() + score);
        contestant.setRecentUpdateTime(new Date());
    }

    public List<Contestant> getContestants() {
        return new ArrayList<>(allContestants.values());
    }
}
