package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class User {

    private List<Car> cars;
    private int count;

    public void Start() {

        Scanner scanner = new Scanner(System.in);


        System.out.print("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분) : ");
        String[] name = scanner.nextLine().split(",");
        System.out.print("시도할 횟수 : ");
        int count = scanner.nextInt();

        List<Car> cars = new ArrayList<>();
        for(String names : name) {
            cars.add(new Car(names));
        }

        for(int i=0; i<count; i++) {
            Play(cars);
            System.out.println();
        }
        printWinners(cars);
    }
    public void Play(List<Car> cars) {
        for(Car car : cars) {
            car.move();
        }
    }
    public static void printWinners(List<Car> cars) {

        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        List<String> winners = cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());

        // 3. 출력
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

}
