package com.example.MasAirlineBookingManagementSystem.Config;

import com.example.MasAirlineBookingManagementSystem.Model.Booking;
import com.example.MasAirlineBookingManagementSystem.Model.Flight;
import com.example.MasAirlineBookingManagementSystem.Model.User;
import com.example.MasAirlineBookingManagementSystem.Repository.BookingRepository;
import com.example.MasAirlineBookingManagementSystem.Repository.FlightRepository;
import com.example.MasAirlineBookingManagementSystem.Repository.UserRepository;
import com.example.MasAirlineBookingManagementSystem.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Configuration
public class DataLoader {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private UserRepository userRepository;
    private final BookingService bookingService;

    @Autowired
    public DataLoader(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            loadFlights();
            loadUsers();
            loadBookings();
        };
    }

    private void loadFlights() {
        flightRepository.save(new Flight(null, "MH100", "Kuala Lumpur", "Singapore", LocalDateTime.of(2024, 7, 1, 8, 0), LocalDateTime.of(2024, 7, 1, 10, 0), 180, 150,"https://focusmalaysia.my/wp-content/uploads/Singapore-AFP-Getty-Images.jpg"));
        flightRepository.save(new Flight(null, "MH101", "Kuala Lumpur", "Bangkok", LocalDateTime.of(2024, 7, 1, 9, 0), LocalDateTime.of(2024, 7, 1, 11, 0), 200, 180,"https://cdn.britannica.com/57/20057-004-404C9F85/Grand-Palace-Bangkok-Thailand.jpg"));
        flightRepository.save(new Flight(null, "MH102", "Kuala Lumpur", "Jakarta", LocalDateTime.of(2024, 7, 1, 10, 0), LocalDateTime.of(2024, 7, 1, 12, 0), 220, 200,"https://upload.wikimedia.org/wikipedia/commons/thumb/b/bf/Busway_in_Bundaran_HI.jpg/1200px-Busway_in_Bundaran_HI.jpg"));
        flightRepository.save(new Flight(null, "MH103", "Kuala Lumpur", "Manila", LocalDateTime.of(2024, 7, 1, 11, 0), LocalDateTime.of(2024, 7, 1, 14, 0), 180, 150,"https://cdn.britannica.com/81/196781-050-CA29F2C8/Manila.jpg"));
        flightRepository.save(new Flight(null, "MH104", "Kuala Lumpur", "Hanoi", LocalDateTime.of(2024, 7, 1, 12, 0), LocalDateTime.of(2024, 7, 1, 14, 0), 200, 180,"https://content.r9cdn.net/rimg/dimg/9f/f9/b80f2b97-city-34211-1648f9bdee7.jpg?width=1366&height=768&xhint=1744&yhint=910&crop=true"));
        flightRepository.save(new Flight(null, "MH105", "Kuala Lumpur", "Ho Chi Minh City", LocalDateTime.of(2024, 7, 1, 13, 0), LocalDateTime.of(2024, 7, 1, 15, 0), 220, 200,"https://authentiktravel.com/media/blog/visit-ho-chi-minh-city-in-1-2-or-3-days-guide.jpg"));
        flightRepository.save(new Flight(null, "MH106", "Kuala Lumpur", "Phnom Penh", LocalDateTime.of(2024, 7, 1, 14, 0), LocalDateTime.of(2024, 7, 1, 16, 0), 180, 150,"https://media-cdn.tripadvisor.com/media/photo-c/1280x250/10/e4/ce/b1/20171006-093816-01-largejpg.jpg"));
        flightRepository.save(new Flight(null, "MH107", "Kuala Lumpur", "Siem Reap", LocalDateTime.of(2024, 7, 1, 15, 0), LocalDateTime.of(2024, 7, 1, 17, 0), 200, 180,"https://i.natgeofe.com/n/fdbadebb-1db9-41a9-9ac6-e7ee41f199aa/ta-prohm-siem-reap-cambodia_4x3.jpg"));
        flightRepository.save(new Flight(null, "MH108", "Kuala Lumpur", "Yangon", LocalDateTime.of(2024, 7, 1, 16, 0), LocalDateTime.of(2024, 7, 1, 18, 0), 220, 200,"https://cdn.i-scmp.com/sites/default/files/d8/images/methode/2019/07/12/7780b5d8-a15b-11e9-9a3c-98259c87fba2_image_hires_173133.jpg"));
        flightRepository.save(new Flight(null, "MH109", "Kuala Lumpur", "Vientiane", LocalDateTime.of(2024, 7, 1, 17, 0), LocalDateTime.of(2024, 7, 1, 19, 0), 180, 150,"https://upload.wikimedia.org/wikipedia/commons/thumb/2/28/Vientiane_-_Patuxai_-_0003.jpg/800px-Vientiane_-_Patuxai_-_0003.jpg"));
    }

    private void loadUsers() {
        userRepository.save(new User(null, "John Lee", "john@gmail.com", "01234567890", "testpass"));
        userRepository.save(new User(null, "Emily Chen", "emily@gmail.com", "01234567890", "testpass"));
        userRepository.save(new User(null, "Ahmed Khan", "ahmed@gmail.com", "01234567890", "testpass"));
        userRepository.save(new User(null, "Priya Patel", "priya@gmail.com","01234567890" ,"testpass"));
        userRepository.save(new User(null, "Muhammad Ali", "ali@gmail.com", "01234567890", "testpass"));
        userRepository.save(new User(null, "Mei Lin", "mei@gmail.com", "01234567890", "testpass"));
        userRepository.save(new User(null, "Omar Abdullah", "omar@gmail.com", "01234567890", "testpass"));
        userRepository.save(new User(null, "Natasha Singh", "natasha@gmail.com", "01234567890", "testpass"));
        userRepository.save(new User(null, "David Nguyen", "david@gmail.com", "01234567890", "testpass"));
        userRepository.save(new User(null, "Aisha Rahman", "aisha@gmail.com", "01234567890", "testpass"));
        userRepository.save(new User(null, "Michael Kim", "michael@gmail.com", "01234567890", "testpass"));
        userRepository.save(new User(null, "Sana Ahmed", "sana@gmail.com", "01234567890", "testpass"));
        userRepository.save(new User(null, "Jason Tan", "jason@gmail.com", "01234567890", "testpass"));
        userRepository.save(new User(null, "Leila Mansour", "leila@gmail.com", "01234567890", "testpass"));
        userRepository.save(new User(null, "Ryan Wong", "ryan@gmail.com", "01234567890", "testpass"));
        userRepository.save(new User(null, "Fatima Abbas", "fatima@gmail.com", "01234567890", "testpass"));
        userRepository.save(new User(null, "Daniel Wu", "daniel@gmail.com", "01234567890", "testpass"));
        userRepository.save(new User(null, "Layla Said", "layla@gmail.com", "01234567890", "testpass"));
        userRepository.save(new User(null, "Peter Zhao", "peter@gmail.com", "01234567890", "testpass"));
        userRepository.save(new User(null, "Sarah Malik", "sarah@gmail.com", "01234567890", "testpass"));
    }

    private void loadBookings() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            Booking booking = new Booking();
            booking.setFlightId((long) i); // Assuming flights have IDs from 1 to 10
            booking.setUserId((long) i);   // Assuming users have IDs from 1 to 10
            booking.setBookingDate(LocalDateTime.now().minusDays(i)); // Booking dates for last 10 days
            booking.setStatus("CONFIRMED");
            booking.setSeatNumber(generateRandomSeatNumber());
            booking.setAisleSeat(new Random().nextBoolean());

            bookingService.createBooking(booking);
        });
    }

    private String generateRandomSeatNumber() {
        Random random = new Random();
        int row = random.nextInt(30) + 1; // Random row number from 1 to 30
        char seat = (char) (random.nextInt(6) + 'A'); // Random seat letter from A to F
        return row + String.valueOf(seat);
    }

}
