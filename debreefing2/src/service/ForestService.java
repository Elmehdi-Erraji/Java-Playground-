package service;

import entities.Forest;
import entities.Tree;
import repository.ForestRepository;
import repository.TreeRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ForestService {

    private final ForestRepository forestRepo;
    private final TreeRepository treeRepo;

    public ForestService(ForestRepository forestRepo, TreeRepository treeRepo) {
        this.forestRepo = forestRepo;
        this.treeRepo = treeRepo;
    }

    public Optional<Forest> saveForestWithTrees(Forest forest) {
        boolean isForestSaved = forestRepo.save(forest);

        if (isForestSaved) {
            for (Tree tree : forest.getTrees()) {
                tree.setForest(forest);
                treeRepo.save(tree);
            }
            return Optional.of(forest);
        } else {
            return Optional.empty();
        }
    }

    public List<Forest> getAllForestsWithTrees() {
        List<Forest> forests = forestRepo.getAll();

        for (Forest forest : forests) {
            List<Tree> trees = treeRepo.getTreesByForestId(forest.getId());
            forest.setTrees(trees);
        }

        return forests;
    }


    public void printForestTreeInfo(Forest forest) {
        for (Tree tree : forest.getTrees()) {
            System.out.println("Tree Type: " + tree.getType());
        }
        System.out.println("Total Trees: " + forest.getTrees().size());
    }

    public List<Forest> filterForestsByTreeCount(int treeCount) {
        return getAllForestsWithTrees().stream()
                .filter(forest -> forest.getTrees().size() == treeCount)
                .collect(Collectors.toList());
    }

    public void printMostDominantTreeType() {
        List<Tree> allTrees = treeRepo.getAll();
        Map<String, Long> treeTypeCount = allTrees.stream()
                .collect(Collectors.groupingBy(Tree::getType, Collectors.counting()));

        treeTypeCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry -> System.out.println("Most Dominant Tree Type: " + entry.getKey() + " with " + entry.getValue() + " occurrences"));
    }

    public Map<String, Map<String, Long>> getTreeTypeCountsForEachForest() {
        Map<String, Map<String, Long>> forestTreeCounts = new HashMap<>();

        getAllForestsWithTrees().forEach(forest -> {
            Map<String, Long> treeTypeCounts = forest.getTrees().stream()
                    .collect(Collectors.groupingBy(Tree::getType, Collectors.counting()));

            forestTreeCounts.put(forest.getName(), treeTypeCounts);

            System.out.println("\nForest: " + forest.getName());
            treeTypeCounts.forEach((type, count) ->
                    System.out.println("Tree Type: " + type + " - Count: " + count));
        });

        return forestTreeCounts;
    }

    public Map<String, Integer> getMostDominantTree () {
        Map<String, Integer> treeTypeCounts = new HashMap<>();

        List<Forest> forests = getAllForestsWithTrees();

        for (Forest forest : forests) {
            for (Tree tree : forest.getTrees()) {
                treeTypeCounts.put(tree.getType(), treeTypeCounts.getOrDefault(tree.getType(), 0) + 1);
            }
        }

        String mostDominantType = null;
        int highestCount = 0;
        for (Map.Entry<String, Integer> entry : treeTypeCounts.entrySet()) {
            if (entry.getValue() > highestCount) {
                highestCount = entry.getValue();
                mostDominantType = entry.getKey();
            }
        }

        Map<String, Integer> result = new HashMap<>();
        if (mostDominantType != null) {
            result.put(mostDominantType, highestCount);
        }
        return result;
    }

}



