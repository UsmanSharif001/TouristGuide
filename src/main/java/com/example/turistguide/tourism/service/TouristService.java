package com.example.turistguide.tourism.service;


import com.example.turistguide.tourism.model.TouristAttraction;
import com.example.turistguide.tourism.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {

    private TouristRepository touristRepository;

    public TouristService() {
        touristRepository = new TouristRepository();
    }

    public List<TouristAttraction> getTouristAttractionList() {
        return touristRepository.getTouristAttractionList();
    }

    public TouristAttraction getTouristAttraction(String name) {
        return touristRepository.getTouristAttractionList(name);
    }

    public String getDeleteTouristAttraction(String toBeDeleted) {
        return touristRepository.deleteTouristAttraction(toBeDeleted);
    }

    public TouristAttraction addTouristAttraction(TouristAttraction touristAttraction) {
        return touristRepository.addTouristAttraction(touristAttraction);
    }
    
    public String editTouristAttraction(String name, String description) {
        return touristRepository.editTouristAttraction(name, description);
    }



}
