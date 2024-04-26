import com.team2_project1.project1.repository.CheerRepository;
import com.team2_project1.project1.repository.JdbcCheerCommentsRepository;
import com.team2_project1.project1.repository.JdbcReservationsRepository;
import com.team2_project1.project1.repository.ReservationsRepository;

import com.team2_project1.project1.service.CheerCommentService;
import com.team2_project1.project1.service.ReservationsService;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;


import javax.sql.DataSource;

@Configuration
@EntityScan("com.team2_project1.project1.domain")
public class SpringConfig {
    private final DataSource dataSource;
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public ReservationsService reservationService() {
        return new ReservationsService(reservationsRepository());
    }
    @Bean
    public ReservationsRepository reservationsRepository() {
        //return new MemoryMemberRepository();
        return new JdbcReservationsRepository(dataSource);
    }

    @Bean
    public CheerCommentService cheerCommentService() {
        return new CheerCommentService(cheerRepository());
    }
    @Bean
    public CheerRepository cheerRepository() {
        //return new MemoryMemberRepository();
        return new JdbcCheerCommentsRepository(dataSource);
    }
}
