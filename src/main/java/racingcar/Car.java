package racingcar;

import java.util.Random;

import static racingcar.NameValidater.validateName;


public class Car {

    private String name;
    private  int distance;

    Car(String name) {

        validateName(name);
        this.name = name;
    }

    public int validMove() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public void move() {
        if(validMove() >= 4) {
            distance ++;
        }
        System.out.println(getName() + " : " + getResult());

    }

    public String getResult() {
        String result = "-".repeat(distance);
        return result;
    }

    public  int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }


}
