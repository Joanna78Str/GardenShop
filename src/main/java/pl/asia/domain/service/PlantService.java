package pl.asia.domain.service;

import pl.asia.infrastructure.db.client.ClientRepository;
import pl.asia.infrastructure.db.client.ClientRepositoryInMemory;
import pl.asia.infrastructure.db.plant.PlantRepository;
import pl.asia.infrastructure.db.plant.PlantRepositoryInMemory;
import pl.asia.infrastructure.entity.Client;
import pl.asia.infrastructure.entity.Plant;

import java.time.LocalDate;
import java.util.List;

public class PlantService {

    private final PlantRepository plantRepository;

    public PlantService(PlantRepository plantRepository){this.plantRepository = plantRepository;}

    public Plant savePlant(String name, String type, String producer, double price, String specification){
        return plantRepository.savePlant(new Plant(name, type,producer, price, specification));
    }

    public List<Plant> getPlants() { return plantRepository.getPlants();}

    public Plant getPlant(Long id) {return plantRepository.getPlant(id);}

    public void removePlant(Long id) {plantRepository.removePlant(id);}

    public void updatePlant(String producer, double price, Long id) {
        Plant plantFromDB = plantRepository.getPlant(id);
        Plant plantToUpdate = new Plant(
                plantFromDB.getId(),
                plantFromDB.getName(),
                plantFromDB.getType(),
                producer, price,
                plantFromDB.getSpecification()
                );
        plantRepository.updatePlant(plantToUpdate);
    }
}
