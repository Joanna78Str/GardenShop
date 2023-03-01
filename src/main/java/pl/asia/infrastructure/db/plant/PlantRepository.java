package pl.asia.infrastructure.db.plant;

import pl.asia.infrastructure.entity.Plant;

import java.util.List;

public interface PlantRepository {

    Plant savePlant(Plant plant);

    List<Plant>getPlants();

    Plant getPlant(Long id);

    void removePlant(Long id);

    void updatePlant(Plant plant);
}
