package service;

import model.Contestant;
import respository.IContestantRepository;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.summingInt;

public class ContestantService implements IContestantService {

    IContestantRepository contestantRepository;

    public ContestantService(IContestantRepository contestantRepository) {
        this.contestantRepository = contestantRepository;
    }

    public void addUser(String name, String description) {
        this.contestantRepository.addContestant(name, description);
    }

    public void updateTotalScore(int userId, int score) {
        contestantRepository.updateTotalScore(userId, score);
    }

    public List<Contestant> displayLeaderShipBoard(int size) {
        List<Contestant> contestants = contestantRepository.getContestants();

        Collections.sort(contestants, new Comparator<Contestant>() {
            @Override
            public int compare(Contestant o1, Contestant o2) {
                if(o1.getTotalScore() == o2.getTotalScore()) return o1.getRecentUpdateTime().compareTo(o2.getRecentUpdateTime());
                return o2.getTotalScore()-o1.getTotalScore();
            }
        });
        return contestants.stream().limit(size).collect(Collectors.toList());
    }

    public List<String> displayLeadShipBoardDepartmants(int size) {
        List<Contestant> contestants = contestantRepository.getContestants();

        Map<String, Integer> departmantScore = contestants.stream().collect(Collectors.groupingBy(contestant -> contestant.getDepartment(), summingInt(contestant -> contestant.getTotalScore())));

        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(departmantScore.entrySet());
        Collections.sort(list,(i1, i2) -> i2.getValue().compareTo(i1.getValue()));

        List<String> departmants = new ArrayList<>();
        for (Map.Entry<String, Integer> departmant : list) {
            departmants.add(departmant.getKey());
        }

        return departmants.stream().limit(size).collect(Collectors.toList());
    }

    public List<Contestant> getContestants() {
        return contestantRepository.getContestants();
    }
}
