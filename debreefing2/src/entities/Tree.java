package entities;

import java.util.UUID;

public class Tree {
    private String id;
    private String type;
    private Forest forest;

    public Tree() {
        this.id = UUID.randomUUID().toString().split("-")[0];
    }

    public Tree(String type, Forest forest) {
        this.id = UUID.randomUUID().toString().split("-")[0];
        this.type = type;
        this.forest = forest;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Forest getForest() {
        return forest;
    }

    public void setForest(Forest forest) {
        this.forest = forest;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", forest=" + forest +
                '}';
    }
}