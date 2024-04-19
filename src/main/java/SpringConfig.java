import com.team2_project1.project1.repository.JdbcReservationsRepository;
import com.team2_project1.project1.repository.ReservationsRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }
    @Bean
    public ReservationsRepository reservationsRepository() {
        //return new MemoryMemberRepository();
        return new JdbcReservationsRepository(dataSource);
    }
}
