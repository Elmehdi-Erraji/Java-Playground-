package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Forest {

    private String id;
    private String name;
    List<Tree> trees = new ArrayList<>();

    public Forest() {
        this.id = UUID.randomUUID().toString().split("-")[0];
    }

    public Forest( String name, List<Tree> trees) {
        this.id = UUID.randomUUID().toString().split("-")[0];
        this.name = name;
        this.trees = trees;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tree> getTrees() {
        return trees;
    }

    public void setTrees(List<Tree> trees) {
        this.trees = trees;
    }


    @Override
    public String toString() {
        return "Forest{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", number of trees=" + trees.size() +
                '}';
    }
}
