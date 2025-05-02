package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Random;

import static racingcar.NameValidater.validateName;

//차가 해야하는 역할 : 전진(조건 만족 시), 이름 검증, -(결과 확인), 거리확인, 이름(우승자 출력용)
public class Car {

    private String name;
    private  int distance;

    Car(String name) {
        validateName(name);
        this.name = name;
    }

    public int validMove() {
        return Randoms.pickNumberInRange(0,9);
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
