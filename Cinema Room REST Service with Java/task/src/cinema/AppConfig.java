package cinema;

import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean
    public CinemaRoom cinemaRoom() {
        return new CinemaRoom(9, 9); // replace with your actual rows and columns
    }
}
