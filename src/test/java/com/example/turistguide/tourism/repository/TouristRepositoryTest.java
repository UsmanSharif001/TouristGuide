package com.example.turistguide.tourism.repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TouristRepositoryTest {

TouristRepository touristRepository = new TouristRepository();

    @Test
    void deleteTouristAttraction() {
        String name = "Tivoli";
        String expected = "Turistattraktion er blevet slettet";

        String delete = touristRepository.deleteTouristAttraction(name);
        assertEquals(expected, delete);
    }
}