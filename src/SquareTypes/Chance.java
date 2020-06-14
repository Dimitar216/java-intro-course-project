package SquareTypes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

public class Chance {
    protected String squareRender;

    public String getSquareRender() {
        return squareRender;
    }

    public void setSquareRender(String squareRender) {
        this.squareRender = squareRender;
    }

    /**
     * Метод който получава броя на квадратчета от тип Chance от текстов файл.
     * @return броя на квадратчетата Chance.
     * @throws IOException
     */
    public static int numberOfChances() throws IOException {
        String valueChances;
        int numberOfChances;
        String chances = Files.readAllLines(Paths.get("SquareNumbers/Numbers")).get(3);
        String[] chanceSplitter = chances.split("=");
        valueChances = chanceSplitter[1];
        numberOfChances = Integer.parseInt(valueChances);

        return numberOfChances;
    }

    /**
     * Метод който генерира число и определя дали ще се добавят или вадят шп.
     * @param playerBalance текущите шп в портфейла на играча.
     */
    public static void chanceThrow(double playerBalance){
        System.out.println("Шанс");
        int random = ThreadLocalRandom.current().nextInt(1, 11);
        if(random%2==0){
            goodChanceThrow(playerBalance);
        } else {
            badChanceThrow(playerBalance);
        }
    }

    /**
     * Метод който генерира случайно число и определя колко шп ще се добавят.
     * @param playerBalance текущите шп в портфейла на играча.
     */
    public static void goodChanceThrow(double playerBalance){
        int random = ThreadLocalRandom.current().nextInt(1, 101);
        if(random >= 95){
            System.out.println("+250");
            playerBalance = playerBalance+250;
        }
        if(random<=94 && random >= 80){
            System.out.println("+200");
            playerBalance = playerBalance +200;
        }
        if(random<=79 && random >= 65){
            System.out.println("+150");
            playerBalance = playerBalance+150;
        }
        if(random<=64 && random >= 40){
            System.out.println("+100");
            playerBalance = playerBalance+100;
        }
        if(random<= 39){
            System.out.println("+50");
            playerBalance = playerBalance+50;
        }
    }

    /**
     * Метод който генерира случайно число и определя колко шп ще се извадят.
     * @param playerBalance текущите шп в портфейла на играча.
     */
    public static void badChanceThrow(double playerBalance){
        int random = ThreadLocalRandom.current().nextInt(1, 101);
        if(random >= 95){
            System.out.println("-250");
            playerBalance = playerBalance-250;
        }
        if(random<=94 && random >= 80){
            System.out.println("-200");
            playerBalance = playerBalance-200;
        }
        if(random<=79 && random >= 65){
            System.out.println("-150");
            playerBalance = playerBalance-150;
        }
        if(random<=64 && random >= 40){
            System.out.println("-100");
            playerBalance = playerBalance-100;
        }
        if(random<= 39){
            System.out.println("-50");
            playerBalance = playerBalance-50;
        }
    }
}
