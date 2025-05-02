package racingcar;

import java.util.ArrayList;
import java.util.List;

import java.io.*;
import camp.nextstep.edu.missionutils.Console;

public class User {

    private List<Car> cars;

    public void start() {

        // 쉼표를 (,) 기준으로 이름 나눠서 name이라는 배열에 저장
        System.out.print("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분) : ");
        String[] name = Console.readLine().split(",");
        System.out.print("시도할 횟수 : ");
        int count = Integer.parseInt(Console.readLine());

        // String형으로, name배열에서 하나씩 꺼내 List에 저장
        List<Car> cars = new ArrayList<>();
        for(String names : name) {
            cars.add(new Car(names));
        }
        Car car = new Car("dotae");
        Car car1 = new Car("dotae");
        System.out.println(car.hashCode());
        System.out.println(car1.hashCode());

        //입력한 횟수만큼 play진행
        for(int i=0; i<count; i++) {
            play(cars);
            System.out.println();
        }
        findWinners(cars);
    }
    public void play(List<Car> cars) {
        for(Car car : cars) {
            car.move();
        }
    }
    public void findWinners(List<Car> cars) {

        int maxDistance = 0;

        for(Car car : cars) {
            if(maxDistance < car.getDistance()) {
                maxDistance = car.getDistance();
            }
        }
        List<String> winners = new ArrayList<>();

        for(Car car : cars) {
            if(car.getDistance() == maxDistance) {
                winners.add(car.getName());
            }
        }


        System.out.println("최종 우승자 : " +String.join(", ", winners));
    }

}
