package racingcar.domain;

import racingcar.dto.CarsResponseDto;
import racingcar.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> names) {
        names.forEach(name -> cars.add(new Car(name)));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void moveCars() {
        cars.forEach(car -> car.move(RandomGenerator.generateRandomNumber()));
    }

    public CarsResponseDto findWinners() {
        int maxPosition = getMaxPosition();
        return new CarsResponseDto(cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList()));
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}
