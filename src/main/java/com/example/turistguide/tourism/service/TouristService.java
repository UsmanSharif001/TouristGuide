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
            return touristRepository.getAttractionsList();
        }

        public TouristAttraction getSpecificAttraction(String name) {
            return touristRepository.getSpecificAttraction(name);
        }


        public TouristAttraction addTouristAttraction(TouristAttraction touristAttraction) {
            TouristAttraction newTouristAttraction = touristRepository.addTouristAttraction(touristAttraction);
            return newTouristAttraction;
        }

        public TouristAttraction editTouristAttraction(TouristAttraction touristAttraction) {
            TouristAttraction edited = touristRepository.editTouristAttraction(touristAttraction);
                    return edited;
        }
        public TouristAttraction deleteTouristAttraction(String toBeDeleted) {
            TouristAttraction deletedAttraction = touristRepository.deleteTouristAttraction(toBeDeleted);
            if (deletedAttraction != null) {
                return deletedAttraction;
            }
            return new TouristAttraction("Could not delete", " Attraction does not exist");
        }

        }




    }
