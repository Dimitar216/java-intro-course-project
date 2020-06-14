package SquareTypes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

public class Steal {
    protected static boolean isEvilPlanActivePlayerOne = false;

    protected static boolean isEvilPlanActivePlayerTwo = false;

    private static Chance chance = new Chance();

    private static Invest invest = new Invest();

    private static Steal steal = new Steal();

    protected String squareRender;

    public static boolean isIsEvilPlanActivePlayerOne() { return isEvilPlanActivePlayerOne; }

    public static void setIsEvilPlanActivePlayerOne(boolean isEvilPlanActivePlayerOne) { Steal.isEvilPlanActivePlayerOne = isEvilPlanActivePlayerOne; }

    public static boolean isIsEvilPlanActivePlayerTwo() { return isEvilPlanActivePlayerTwo; }

    public static void setIsEvilPlanActivePlayerTwo(boolean isEvilPlanActivePlayerTwo) { Steal.isEvilPlanActivePlayerTwo = isEvilPlanActivePlayerTwo; }

    public String getSquareRender() {
        return squareRender;
    }

    public void setSquareRender(String squareRender) {
        this.squareRender = squareRender;
    }

    /**
     * Метод който получава броя на квадратчета от тип Steal от текстов файл.
     * @return броя на квадратчетата Steal.
     * @throws IOException
     */
    public static int numberOfSteals() throws IOException {
        String valueSteals;
        int numberOfSteals;
        String steals = Files.readAllLines(Paths.get("SquareNumbers/Numbers")).get(1);
        String[] stealSplitter = steals.split("=");
        valueSteals = stealSplitter[1];
        numberOfSteals = Integer.parseInt(valueSteals);

        return numberOfSteals;
    }

    /**
     * Метод който генерира случайно число.
     * @return връща случайно генерирано число от 1 до 3.
     */
    public static int evilPlanGenerator(){
        int random = ThreadLocalRandom.current().nextInt(1, 4);
        return random;
    }

    /**
     * Метод който добавя пари към портфейла на ирграча когато злия план е реализиран и играчът попадне на определено място.
     * @param index номерът по който ще се определи кой зъл план ще се ползва.
     * @param playerBalance текущите шп в портфейла на играча.
     * @param board игралната дъска
     * @param playerCurrentPosition позиция на играча
     */
    public static void evilPlan(int index,double playerBalance,Object[] board,int playerCurrentPosition){
        if (index == 1){
            if(board[playerCurrentPosition] == "|C|"){
                playerBalance = playerBalance + 100;
            }
        }
        if (index == 2){
            if(board[playerCurrentPosition] == "|I|"){
                playerBalance = playerBalance + 100;
            }
        }
        if (index == 3){
            if(board[playerCurrentPosition] == "|St|"){
                playerBalance = playerBalance + 100;
            }
        }
    }

    /**
     * Метод който визуализира злия план и обеснява неговата функция.
     * @param index номерът по който ще се определи кой зъл план ще се ползва.
     */
    public static void evilPlanRender(int index){
        if(index == 1){
            System.out.println("Злият план е завладяване на света.+100 парички всеки път, когато попаднете на квадратче „Шанс“.");
        } else if(index == 2){
            System.out.println("Злият план е заложници.+100 парички всеки път, когатопопаднете на квадратче „Invest“");
        } else {
            System.out.println("Злият план е големия банков обир.+100 парички всеки път, когато попаднем на квадратче „Steal“.");
        }
    }
}
