package com.team2_project1.project1.repository;

import com.team2_project1.project1.domain.CheerComments;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



@Repository
public class JdbcCheerCommentsRepository implements CheerRepository {
    private final DataSource dataSource;
    public JdbcCheerCommentsRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CheerComments saveComment(CheerComments cheerComments) {
        return null;
    }


    @Override
    public List<CheerComments> findAllComment() {
        return List.of();
    }

    private Connection getConnection() {
        return DataSourceUtils.getConnection(dataSource);
    }
    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                close(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void close(Connection conn) throws SQLException {
        DataSourceUtils.releaseConnection(conn, dataSource);
    }
}
