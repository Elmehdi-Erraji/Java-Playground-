package service;

import entities.Tree;
import repository.TreeRepository;

import java.util.List;

public class TreeService {

    private final TreeRepository treeRepo;

    public TreeService(TreeRepository treeRepo) {
        this.treeRepo = treeRepo;
    }

    public boolean saveTree(Tree tree) {
        return treeRepo.save(tree);
    }

    public List<Tree> getTreesByForestId(String forestId) {
        return treeRepo.getTreesByForestId(forestId);
    }

    public List<Tree> getAllTrees() {
        return treeRepo.getAll();
    }
}
