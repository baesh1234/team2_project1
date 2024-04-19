package com.team2_project1.project1.repository;
import com.team2_project1.project1.domain.Reservations;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcReservationsRepository implements ReservationsRepository {
    private final DataSource dataSource;
    public JdbcReservationsRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

//    @Override
//    public Reservations save(Reservations Reservations) {
//        String sql = "insert into Reservations(name) values(?)";
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        try {
//            conn = getConnection();
//            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            pstmt.setString(1, Reservations.getName());
//            pstmt.executeUpdate();
//            rs = pstmt.getGeneratedKeys();
//            if (rs.next()) {
//                Reservations.setId(rs.getLong(1));
//            } else {
//                throw new SQLException("id 조회 실패");
//            }
//            return Reservations;
//        } catch (Exception e) {
//            throw new IllegalStateException(e);
//        } finally {
//            close(conn, pstmt, rs);
//        }
//    }
//    @Override
//    public Optional<Reservations> findById(Long id) {
//        String sql = "select * from Reservations where id = ?";
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        try {
//            conn = getConnection();
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setLong(1, id);
//            rs = pstmt.executeQuery();
//            if(rs.next()) {
//                Reservations Reservations = new Reservations();
//                Reservations.setId(rs.getLong("id"));
//                Reservations.setName(rs.getString("name"));
//                return Optional.of(Reservations);
//            } else {
//                return Optional.empty();
//            }
//        } catch (Exception e) {
//            throw new IllegalStateException(e);
//        } finally {
//            close(conn, pstmt, rs);
//        }
//    }

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
//    @Override
//    public Optional<Reservations> findByName(String name) {
//        String sql = "select * from Reservations where name = ?";
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        try {
//            conn = getConnection();
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, name);
//            rs = pstmt.executeQuery();
//            if(rs.next()) {
//                Reservations Reservations = new Reservations();
//                Reservations.setId(rs.getLong("id"));
//                Reservations.setName(rs.getString("name"));
//                return Optional.of(Reservations);
//            }
//            return Optional.empty();
//        } catch (Exception e) {
//            throw new IllegalStateException(e);
//        } finally {
//            close(conn, pstmt, rs);
//        }
//    }
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
