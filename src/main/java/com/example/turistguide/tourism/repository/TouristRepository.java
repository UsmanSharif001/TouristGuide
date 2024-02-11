package com.example.turistguide.tourism.repository;

import com.example.turistguide.tourism.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {

    TouristAttraction touristAttraction;
    List<TouristAttraction> touristAttractionList = new ArrayList<>(List.of(new TouristAttraction("Tivoli", "En forlystelsespark"), (new TouristAttraction("Havfruen", "En statue v. nordhavn"))));

    public TouristAttraction getSpecificAttraction(String name) {
        for (TouristAttraction touristAttraction : touristAttractionList) {
            if (touristAttraction.getName().equalsIgnoreCase(name));
            return touristAttraction;
        }
        return null;
    }

    public List<TouristAttraction> getAttractionsList() {
        return touristAttractionList;
    }


    public TouristAttraction addTouristAttraction(TouristAttraction touristAttraction) {
        touristAttractionList.add(touristAttraction);
        return touristAttraction;
    }

    public TouristAttraction deleteTouristAttraction(String touristAttractionToBeDeleted) {
        for (TouristAttraction attraction : touristAttractionList) {
            if (attraction.getName().equals(touristAttractionToBeDeleted)) {
                touristAttractionList.remove(attraction);
                return attraction;
            }
        }
        return null;
    }

    public TouristAttraction editTouristAttraction(TouristAttraction touristAttraction) {
        for (TouristAttraction attraction : touristAttractionList) {
            if (attraction.getName().equalsIgnoreCase(touristAttraction.getName())) {
                attraction.setDescription(touristAttraction.getDescription());
                return attraction;
            }
        }
        return null;
    }



}
