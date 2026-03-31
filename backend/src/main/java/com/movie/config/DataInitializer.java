package com.movie.config;

import com.movie.entity.Movie;
import com.movie.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(MovieRepository repository) {
        return args -> {
            repository.deleteAll(); // Force refresh to get the new language data
            repository.saveAll(Arrays.asList(
                    // English (Hollywood)
                    new Movie(null, "Inception", "Sci-Fi", 8.8, "A thief who steals corporate secrets through the use of dream-sharing technology.", "English", "https://image.tmdb.org/t/p/w500/9gk7adHYeDvHkCSEqAvQNLV5Uge.jpg"),
                    new Movie(null, "Interstellar", "Sci-Fi", 8.6, "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.", "English", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9oW0XQlu1lo1G_49M-YwGzKR6rUg-CtflZj07HfbT8d2GwKWg"),
                    new Movie(null, "The Dark Knight", "Action", 9.0, "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham.", "English", "https://image.tmdb.org/t/p/w500/qJ2tW6WMUDux911r6m7haRef0WH.jpg"),
                    new Movie(null, "Avengers: Endgame", "Action", 8.4, "After the devastating events of Infinity War, the universe is in ruins. With the help of remaining allies, the Avengers assemble once more.", "English", "https://image.tmdb.org/t/p/w500/ulzhLuWrPK07P1YkdWQLZnQh1JL.jpg"),
                    
                    // Hindi (Bollywood)
                    new Movie(null, "3 Idiots", "Comedy", 8.4, "Two friends are searching for their long lost companion. They revisit their college days and recall the memories of their friend.", "Hindi", "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQV7sONOx4fl1xq9CbdWUmcTamWwzrPMzqKhZOGHh-V0zHpn0Ly"),
                    new Movie(null, "Dangal", "Biography", 8.3, "Former wrestler Mahavir Singh Phogat and his two wrestler daughters struggle towards glory at the Commonwealth Games.", "Hindi", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQIXnFlBKGWT1ByyIu3qfxX6opQX6BmeeU_qsiE3X8rX9ZRr63r"),
                    new Movie(null, "Sholay", "Action", 8.1, "After his family is murdered by a notorious and ruthless bandit, a former police officer enlists the services of two outlaws to capture the bandit.", "Hindi", "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTKIwgOIThq5Dn0AjjgzOVfeQGCN3lLpBQfQ918cbBp4neuu4Uq"),
                    new Movie(null, "Zindagi Na Milegi Dobara", "Drama", 8.2, "Three friends decide to turn their fantasy vacation into reality after one of their friends gets engaged.", "Hindi", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQqOb7SYCekBWHrdqpplOSANdbjx-tff4WH6_-wxTtFY9viR4UU"),

                    // Telugu (Tollywood)
                    new Movie(null, "Baahubali 2: The Conclusion", "Action", 8.2, "Amarendra Baahubali, the heir apparent to the throne of Mahishmati, finds his life and relationships endangered.", "Telugu", "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTnMA16Y55ki6WxoLTdTmxNnKwYCZiNwi0DvCakttCRBQgZyJpJ"),
                    new Movie(null, "RRR", "Action", 7.8, "A fictitious story about two legendary revolutionaries and their journey away from home before they started fighting for their country in 1920s.", "Telugu", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRx0wTDoneV8OuMM6hNfD7vfibB_jt6FcCL-u8H2DljlRXgGCoG"),
                    new Movie(null, "Pushpa: The Rise", "Action", 7.6, "A labourer rises through the ranks of a red sandalwood smuggling syndicate, making some powerful enemies in the process.", "Telugu", "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTEBj8p-ynRkaIk4luHnF02ahyCJ6epbBOt_6dTS5fBWs7rqC-E"),
                    new Movie(null, "Eega", "Fantasy", 7.7, "A murdered man is reincarnated as a housefly and seeks to avenge his death.", "Telugu", "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQPo6YUQbjXGjCF92s4zL5ishjRlHO5NqNHcosFSHPmSKB4NRav"),

                    // Tamil (Kollywood)
                    new Movie(null, "Vikram", "Action", 8.3, "A special agent investigates a murder committed by a masked group of serial killers.", "Tamil", "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQePndb2bpcl_w5Gmz1o2HYpcpuAALl_jJ-XvYz-IvbdDUr5K1i"),
                    new Movie(null, "Soorarai Pottru", "Drama", 8.7, "Nedumaaran Rajangam sets out to make the common man fly.", "Tamil", "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTCXOxUOCiYN2CYVeh4xkeU-o0BlKPp42zFAaauf3rYrAfo3qsR"),
                    new Movie(null, "Kaithi", "Action", 8.5, "A recently released prisoner becomes involved in a chase between cops and a drug mafia.", "Tamil", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRaauWiZuruTucstvUcmukhacDvpkNJPeZ2PmGonViczV83byDs"),
                    new Movie(null, "Master", "Action", 7.7, "An alcoholic professor is sent to a juvenile school, where he clashes with a gangster.", "Tamil", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSYQfIvAL9hPymsSd5nyOo7raJ-Gp0IGwikhGrecXP5Hc6B2EL-"),

                    // Malayalam (Mollywood)
                    new Movie(null, "Drishyam", "Thriller", 8.3, "A man goes to extreme lengths to save his family from punishment after the family commits an accidental crime.", "Malayalam", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQpJ2vdy5Gn124nCuvPL79MDDKxuff-wNLrtq-AGcMIP6CarDY3"),
                    new Movie(null, "Kumbalangi Nights", "Drama", 8.5, "Four brothers who share a love-hate relationship with each other must unite.", "Malayalam", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRlGAq9jCw7NdBX3qUHEUmtM8b6pf9u_Tcs00qiSlcZeNKl54YURdHFUGoMiJWheFTmBZAahQ&s=10"),
                    new Movie(null, "Premam", "Romance", 8.3, "George's journey from a teenager to an adult, experiencing love and heartbreak.", "Malayalam", "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSTwRIznTUqSpQReY6jg0nBxlW76nctczpbufx5O8Eu74YjXzPC"),
                    new Movie(null, "Minnal Murali", "Action", 7.9, "A tailor gains special powers after being struck by lightning.", "Malayalam", "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcR6N0z2F0vIVNraTfZI9lgj6f4g11H932UxMDyMFfljmdpb0V0S"),
                    
                    // Kannada (Sandalwood)
                    new Movie(null, "K.G.F: Chapter 1", "Action", 8.2, "In the 1970s, a gangster goes undercover as a slave to assassinate the owner of a notorious gold mine.", "Kannada", "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSwnvIM5-xGRB34_8cEbXfzD_Ih9s0SY7yHxXBhExwGh1pETEVq"),
                    new Movie(null, "Kantara", "Action", 8.3, "It involves a conflict between nature and humans, where an officer challenges a local hero.", "Kannada", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSr-WKnsOp7YBra7WsdhX8TyXV3Xdz2tTaMbCFzcTx_0C82U4go"),
                    
                    // Korean
                    new Movie(null, "Parasite", "Thriller", 8.5, "Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.", "Korean", "https://image.tmdb.org/t/p/w500/7IiTTgloJzvGI1TAYymCfbfl3vT.jpg"),
                    new Movie(null, "Train to Busan", "Horror", 7.6, "While a zombie virus breaks out in South Korea, passengers struggle to survive on the train from Seoul to Busan.", "Korean", "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSVaw1oTjoq8oLTFmJahCLt1jrIKRb9Atm2p-PPfROO4zXeo7gB")
                ));
        };
    }
}