package com.team2_project1.project1.repository;
import com.team2_project1.project1.domain.Reservations;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcReservationsRepository implements ReservationsRepository {
    private final DataSource dataSource;
    public JdbcReservationsRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Reservations> findAll() {
        String sql = "select * from reservations";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            List<Reservations> Reservations = new ArrayList<>();
            while(rs.next()) {
                Reservations Reservation = new Reservations();
                Reservation.setId(rs.getLong("id"));
                Reservation.setAndroid_num(rs.getString("Android_num"));
                Reservations.add(Reservation);
            }
            return Reservations;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
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