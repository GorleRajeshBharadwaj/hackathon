package service;

import model.Contestant;
import respository.ContestantRepository;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.summingInt;

public class ContestantService {

    ContestantRepository contestantRepository;

    public ContestantService(ContestantRepository contestantRepository) {
        this.contestantRepository = contestantRepository;
    }

    public void addUser(String name, String description) {
        this.contestantRepository.addContestant(name, description);
    }

    public void updateTotalScore(int userId, int score) throws Exception {
        contestantRepository.updateTotalScore(userId, score);
    }

    public List<Contestant> displayLeaderShipBoard(int n) {
        List<Contestant> contestants = contestantRepository.getContestants();

        Collections.sort(contestants, new Comparator<Contestant>() {
            @Override
            public int compare(Contestant o1, Contestant o2) {
                if(o1.getTotalScore() == o2.getTotalScore()) return o1.getRecentUpdateTime().compareTo(o2.getRecentUpdateTime());
                return o1.getTotalScore()-o2.getTotalScore();
            }
        });
        return contestants.stream().limit(n).collect(Collectors.toList());
    }

    public List<String> displayLeadShipBoardDepartmants(int n) {
        List<Contestant> contestants = contestantRepository.getContestants();

        Map<String, Integer> departmantScore = contestants.stream().collect(Collectors.groupingBy(contestant -> contestant.getDepartment(), summingInt(contestant -> contestant.getTotalScore())));

        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(departmantScore.entrySet());
        Collections.sort(list,(i1, i2) -> i2.getValue().compareTo(i1.getValue()));

        List<String> departmants = new ArrayList<>();
        for (Map.Entry<String, Integer> departmant : list) {
            departmants.add(departmant.getKey());
        }

        return departmants.stream().limit(n).collect(Collectors.toList());
    }
}
