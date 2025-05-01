package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class User {

    private List<Car> cars;
    private int count;

    public void Start() {

        Scanner scanner = new Scanner(System.in);


        // 쉼표를 (,) 기준으로 이름 나눠서 name이라는 배열에 저장
        System.out.print("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분) : ");
        String[] name = scanner.nextLine().split(",");
        System.out.print("시도할 횟수 : ");
        int count = scanner.nextInt();

        // String형으로, name배열에서 하나씩 꺼내 List에 저장
        List<Car> cars = new ArrayList<>();
        for(String names : name) {
            cars.add(new Car(names));
        }

        //입력한 횟수만큼 play진행
        for(int i=0; i<count; i++) {
            Play(cars);
            System.out.println();
        }
        Winners(cars);
    }
    public void Play(List<Car> cars) {
        for(Car car : cars) {
            car.move();
        }
    }
    public static void Winners(List<Car> cars) {

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
