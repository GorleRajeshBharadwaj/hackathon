package respository;

import model.Contestant;

import java.util.List;

public interface IContestantRepository {

    public void addContestant(String name, String department);

    public void updateTotalScore(int contestantId, int score);

    public List<Contestant> getContestants();
}
