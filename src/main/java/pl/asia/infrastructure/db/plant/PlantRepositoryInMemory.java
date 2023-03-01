package pl.asia.infrastructure.db.plant;

import pl.asia.infrastructure.entity.Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

import static java.util.Locale.filter;

public class PlantRepositoryInMemory implements PlantRepository{

    private final List<Plant>plants = new ArrayList<>();

    private long id=1;


    @Override
    public Plant savePlant(Plant plant) {
        plants.add(new Plant(++id, plant.getName(), plant.getType(), plant.getProducer(), plant.getPrice(),
                plant.getSpecification()));
        return plant;
    }

    @Override
    public List<Plant> getPlants() {return plants;}

    @Override
    public Plant getPlant(Long id) {
        return plants.stream()
                .filter(plant -> plant.getId().equals(id))
                .findAny()
                .orElseThrow(() -> {
                    throw new RuntimeException("Roślina o podanym id nie istnieje");
                });
    }

    @Override
    public void removePlant(Long id) {
        Plant plant = getPlant(id);
        plants.remove(plant);
    }

    @Override
    public void updatePlant(Plant plant) {
        removePlant(plant.getId());
        plants.add(plant);
    }
}
