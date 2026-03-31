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
                    new Movie(null, "Interstellar", "Sci-Fi", 8.6, "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.", "English", "https://image.tmdb.org/t/p/w500/gEU2QniE6E77NI6lCU6MvrIdYcB.jpg"),
                    new Movie(null, "The Dark Knight", "Action", 9.0, "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham.", "English", "https://image.tmdb.org/t/p/w500/qJ2tW6WMUDux911r6m7haRef0WH.jpg"),
                    new Movie(null, "Avengers: Endgame", "Action", 8.4, "After the devastating events of Infinity War, the universe is in ruins. With the help of remaining allies, the Avengers assemble once more.", "English", "https://image.tmdb.org/t/p/w500/ulzhLuWrPK07P1YkdWQLZnQh1JL.jpg"),
                    
                    // Hindi (Bollywood)
                    new Movie(null, "3 Idiots", "Comedy", 8.4, "Two friends are searching for their long lost companion. They revisit their college days and recall the memories of their friend.", "Hindi", "https://image.tmdb.org/t/p/w500/66A9MqXOyVFCssoloscw79zH0TX.jpg"),
                    new Movie(null, "Dangal", "Biography", 8.3, "Former wrestler Mahavir Singh Phogat and his two wrestler daughters struggle towards glory at the Commonwealth Games.", "Hindi", "https://image.tmdb.org/t/p/w500/jeasoOSwgX1Juw10Xk8GzYlOf3Q.jpg"),
                    new Movie(null, "Sholay", "Action", 8.1, "After his family is murdered by a notorious and ruthless bandit, a former police officer enlists the services of two outlaws to capture the bandit.", "Hindi", "https://image.tmdb.org/t/p/w500/1Xv55r4sQvXfCjV1PtoH5SpxlYf.jpg"),
                    new Movie(null, "Zindagi Na Milegi Dobara", "Drama", 8.2, "Three friends decide to turn their fantasy vacation into reality after one of their friends gets engaged.", "Hindi", "https://image.tmdb.org/t/p/w500/uU0r48H7pD9Kpmg9oZ60bAtr9sM.jpg"),

                    // Telugu (Tollywood)
                    new Movie(null, "Baahubali 2: The Conclusion", "Action", 8.2, "Amarendra Baahubali, the heir apparent to the throne of Mahishmati, finds his life and relationships endangered.", "Telugu", "https://image.tmdb.org/t/p/w500/91wsQJED2NfKxX1s22K0F0D5u3b.jpg"),
                    new Movie(null, "RRR", "Action", 7.8, "A fictitious story about two legendary revolutionaries and their journey away from home before they started fighting for their country in 1920s.", "Telugu", "https://image.tmdb.org/t/p/w500/nEufeZlyAOLqO2brrs0yeF1lgHO.jpg"),
                    new Movie(null, "Pushpa: The Rise", "Action", 7.6, "A labourer rises through the ranks of a red sandalwood smuggling syndicate, making some powerful enemies in the process.", "Telugu", "https://image.tmdb.org/t/p/w500/1LrLLWGKADZ00xH1Kj17dZgXg2H.jpg"),
                    new Movie(null, "Eega", "Fantasy", 7.7, "A murdered man is reincarnated as a housefly and seeks to avenge his death.", "Telugu", "https://image.tmdb.org/t/p/w500/512t9wD7zFwOepx90O08v3SjL7N.jpg"),

                    // Tamil (Kollywood)
                    new Movie(null, "Vikram", "Action", 8.3, "A special agent investigates a murder committed by a masked group of serial killers.", "Tamil", "https://image.tmdb.org/t/p/w500/xXpBQw1k4OovPqM502jEaA0BvjY.jpg"),
                    new Movie(null, "Soorarai Pottru", "Drama", 8.7, "Nedumaaran Rajangam sets out to make the common man fly.", "Tamil", "https://image.tmdb.org/t/p/w500/xI3mS8P3FpP8uV2jZ5Z2kI2F7K0.jpg"),
                    new Movie(null, "Kaithi", "Action", 8.5, "A recently released prisoner becomes involved in a chase between cops and a drug mafia.", "Tamil", "https://image.tmdb.org/t/p/w500/aHmtxOITWeK1f1c7dKhnS02kY.jpg"),
                    new Movie(null, "Master", "Action", 7.7, "An alcoholic professor is sent to a juvenile school, where he clashes with a gangster.", "Tamil", "https://image.tmdb.org/t/p/w500/8wO6mO8u5X2sHh4E4pG7U0iBv0H.jpg"),

                    // Malayalam (Mollywood)
                    new Movie(null, "Drishyam", "Thriller", 8.3, "A man goes to extreme lengths to save his family from punishment after the family commits an accidental crime.", "Malayalam", "https://image.tmdb.org/t/p/w500/gW5J5W7pBc3a8H1xW2m9aWqH1Yy.jpg"),
                    new Movie(null, "Kumbalangi Nights", "Drama", 8.5, "Four brothers who share a love-hate relationship with each other must unite.", "Malayalam", "https://image.tmdb.org/t/p/w500/1Xv55r4sQvXfCjV1PtoH5SpxlYf.jpg"),
                    new Movie(null, "Premam", "Romance", 8.3, "George's journey from a teenager to an adult, experiencing love and heartbreak.", "Malayalam", "https://image.tmdb.org/t/p/w500/2L2H2f1Gf0hC4I6H0Q2v1Kz3K5V.jpg"),
                    new Movie(null, "Minnal Murali", "Action", 7.9, "A tailor gains special powers after being struck by lightning.", "Malayalam", "https://image.tmdb.org/t/p/w500/m1N6bB54PZ7N5T0T8X7R8pG6P8c.jpg"),
                    
                    // Kannada (Sandalwood)
                    new Movie(null, "K.G.F: Chapter 1", "Action", 8.2, "In the 1970s, a gangster goes undercover as a slave to assassinate the owner of a notorious gold mine.", "Kannada", "https://image.tmdb.org/t/p/w500/xYxZJ4P1FpF8U3D1Z1dC3kL2Z3p.jpg"),
                    new Movie(null, "Kantara", "Action", 8.3, "It involves a conflict between nature and humans, where an officer challenges a local hero.", "Kannada", "https://image.tmdb.org/t/p/w500/1m8m5j2T7rYF6rZ4F3H9u2O9D2W.jpg"),
                    
                    // Korean
                    new Movie(null, "Parasite", "Thriller", 8.5, "Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.", "Korean", "https://image.tmdb.org/t/p/w500/7IiTTgloJzvGI1TAYymCfbfl3vT.jpg"),
                    new Movie(null, "Train to Busan", "Horror", 7.6, "While a zombie virus breaks out in South Korea, passengers struggle to survive on the train from Seoul to Busan.", "Korean", "https://image.tmdb.org/t/p/w500/uU0r48H7pD9Kpmg9oZ60bAtr9sM.jpg")
                ));
        };
    }
}
