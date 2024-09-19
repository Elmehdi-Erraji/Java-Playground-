package repository;

import entities.Tree;
import config.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TreeRepository {

    private Connection conn;

    public TreeRepository() {
        this.conn = Database.getInstance().getConnection();
    }

    public boolean save(Tree tree) {
        String query = "INSERT INTO trees (id, type, forest_id) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, tree.getId());
            stmt.setString(2, tree.getType());
            stmt.setString(3, tree.getForest().getId());  // Use the forest ID to link the tree
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Tree> getTreesByForestId(String forestId) {
        String query = "SELECT * FROM trees WHERE forest_id = ?";
        List<Tree> trees = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, forestId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Tree tree = new Tree();
                tree.setId(rs.getString("id"));
                tree.setType(rs.getString("type"));
                trees.add(tree);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trees;
    }

    public List<Tree> getAll() {
        String query = "SELECT * FROM trees";
        List<Tree> trees = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Tree tree = new Tree();
                tree.setId(rs.getString("id"));
                tree.setType(rs.getString("type"));
                trees.add(tree);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trees;
    }

    public String getMostDominantTreeType() {
        String query = "SELECT type, COUNT(*) as count FROM trees GROUP BY type ORDER BY count DESC LIMIT 1";
        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getString("type");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
