package repository;

import entities.Forest;
import config.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ForestRepository {

    private Connection conn;

    public ForestRepository() {
        this.conn = Database.getInstance().getConnection();
    }

    public boolean save(Forest forest) {
        String query = "INSERT INTO forests (id, name) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, forest.getId());
            stmt.setString(2, forest.getName());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Forest> getAll() {
        String query = "SELECT * FROM public.forests";
        List<Forest> forests = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Forest forest = new Forest();
                forest.setId(rs.getString("id"));
                forest.setName(rs.getString("name"));
                forests.add(forest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return forests;
    }



}
