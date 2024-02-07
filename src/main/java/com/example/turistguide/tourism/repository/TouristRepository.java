package com.example.turistguide.tourism.repository;

import com.example.turistguide.tourism.model.TouristAttraction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {

    TouristAttraction touristAttraction;
    List<TouristAttraction> touristAttractionList = new ArrayList<>(List.of(new TouristAttraction("Tivoli", "En forlystelsespark"), (new TouristAttraction("Havfruen", "En statue v. nordhavn"))));

    public TouristAttraction getTouristAttractionList(String name) {
        for (TouristAttraction touristAttraction : touristAttractionList) {
            if (touristAttraction.getName().equalsIgnoreCase(name));
            return touristAttraction;
        }
        return null;
    }


    public TouristAttraction addTouristAttraction(TouristAttraction touristAttraction) {
        touristAttractionList.add(touristAttraction);
        return touristAttraction;
    }

    public String deleteTouristAttraction(String touristAttractionToBeDeleted) {

        if (!touristAttractionList.removeIf(touristAttraction -> touristAttraction.getName().equals(touristAttractionToBeDeleted))) {
            return "Turistattraktion er ikke blevet fundet";
        }
        else touristAttractionList.removeIf(touristAttraction -> touristAttraction.getName().equals(touristAttractionToBeDeleted));
        return "Turistattraktion er blevet slettet";
    }

    public String editTouristAttraction(String name, String newDescription) {
        if (touristAttraction.getName().equals(name)) {
            touristAttraction.setDescription(newDescription);
            return " Has been edited";
        }
        return " Has not been edited";

    }

    public List<TouristAttraction> getTouristAttractionList() {
        return touristAttractionList;
    }
}
