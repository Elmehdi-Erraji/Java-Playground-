import config.Database;
import entities.Forest;
import entities.Tree;
import repository.ForestRepository;
import repository.TreeRepository;
import service.ForestService;
import util.FactoryUtil;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        Database.testConnection();

        ForestRepository forestRepo = new ForestRepository();
        TreeRepository treeRepo = new TreeRepository();
        ForestService forestService = new ForestService(forestRepo, treeRepo);

        List<String> forestNames = new ArrayList<>(
                Arrays.asList(
                        "Amazon Rainforest",
                        "Black Forest",
                        "Daintree Rainforest",
                        "Tongass National",
                        "Monteverde Cloud"));

        List<String> treeTypes = new ArrayList<>(
                Arrays.asList(
                        "Oak",
                        "Redwood",
                        "Cypress",
                        "Pine",
                        "Elm",
                        "Sequoia",
                        "Fir",
                        "Banyan",
                        "Cedar"));

        List<Forest> forests = FactoryUtil.GenerateObjects(Forest.class, 2);
        forests.forEach(forest -> forest.setName(forestNames.get(ThreadLocalRandom.current().nextInt(forestNames.size()))));

        //
        List<Tree> trees = FactoryUtil.GenerateObjects(Tree.class, 20);
        trees.forEach(tree -> tree.setType(treeTypes.get(ThreadLocalRandom.current().nextInt(treeTypes.size()))));

       /* for (Forest forest : forests) {
            int numberOfTrees = ThreadLocalRandom.current().nextInt(5, 10);
            List<Tree> forestTrees = trees.subList(0, numberOfTrees);
            forest.setTrees(forestTrees);

            forestTrees.forEach(tree -> tree.setForest(forest));

            forestService.saveForestWithTrees(forest);

            trees = trees.subList(numberOfTrees, trees.size());
        }*/
        System.out.println("Forests and Trees saved successfully!");

        // get List of forests From DB each with associated trees
        List<Forest> allForests = forestService.getAllForestsWithTrees();
        allForests.forEach(forest -> {
            System.out.println("Forest: " + forest.getName() + " has " + forest.getTrees());
        });

        // Filter the forests with the count of trees
        System.out.println("\nForests with exactly 5 trees:");
        forestService.filterForestsByTreeCount(5).forEach(forest -> {
            System.out.println(forest.getName() + " has " + forest.getTrees().size() + " trees.");
        });


        // For each forest extract the name of each tree and how many samples exists in the forest
        System.out.println("\nTree Types and Their Counts for Each Forest:");
        forestService.getTreeTypeCountsForEachForest();


        // Get the most dominant tree type
        Map<String, Integer> mostDominantTree = forestService.getMostDominantTree();

        // Print the result
        if (!mostDominantTree.isEmpty()) {
            mostDominantTree.forEach((type, count) ->
                    System.out.println("Most Dominant Tree Type: " + type + " - Count: " + count)
            );
        } else {
            System.out.println("No trees found.");
        }

    }
}









// Call services here !

// save forests and trees to DB

// get List of forests From DB each with associated trees

// Filter forests by number of trees

// For each forest extract the name of each tree and how many samples exists in the forest

// Print the most dominant Tree (All forests combined)


