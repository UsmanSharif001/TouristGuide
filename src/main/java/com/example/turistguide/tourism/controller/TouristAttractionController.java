package com.example.turistguide.tourism.controller;


import com.example.turistguide.tourism.model.TouristAttraction;
import com.example.turistguide.tourism.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/attractions")
public class TouristAttractionController {

    private final TouristService touristService;

    public TouristAttractionController(TouristService touristAttraction) {
        this.touristService = touristAttraction;
    }

    @GetMapping()
    public ResponseEntity<List<TouristAttraction>> getAttractions() {
        List<TouristAttraction> touristAttractionList = touristService.getTouristAttractionList();
        return new ResponseEntity<>(touristAttractionList, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> searchAttractionsByName(@PathVariable String name){
        TouristAttraction touristAttraction = touristService.getSpecificAttraction(name);
        if (touristAttraction == null){
            return new ResponseEntity<> (touristAttraction, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }
    
    @PostMapping(path = "/add")
    public ResponseEntity<TouristAttraction> postAttraction(@RequestBody TouristAttraction attraction) {
        TouristAttraction addAttraction = touristService.addTouristAttraction(attraction);
        return new ResponseEntity<>(addAttraction, HttpStatus.OK);
    }


    @PutMapping(path = "/update")
    public ResponseEntity<TouristAttraction> updateAttraction(@RequestBody TouristAttraction newAttraction) {
        TouristAttraction updatedTouristAttraction = touristService.editTouristAttraction(newAttraction);
        if (updatedTouristAttraction !=null)
            return new ResponseEntity<>(updatedTouristAttraction, HttpStatus.OK);
        else return null;
    }


    @GetMapping(path = "/delete/{name}")
    public ResponseEntity<TouristAttraction> deleteAttraction(@PathVariable String name) {
        TouristAttraction deletedAttraction = touristService.deleteTouristAttraction(name);
        return new ResponseEntity<>(deletedAttraction, HttpStatus.OK);

    }

}

