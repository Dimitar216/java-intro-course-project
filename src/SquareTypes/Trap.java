package SquareTypes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Trap{
    protected static int trappedSetNumberPlayerOne = 0;

    protected static int trappedSetNumberPlayerTwo = 0;

    protected static boolean isTrapRiggedByPlayerOne = false;

    protected static boolean isTrapRiggedByPlayerTwo = false;

    protected static boolean trapHasBeenActivatedPlayerOne = false;

    protected static boolean trapHasBeenActivatedPlayerTwo = false;

    protected String squareRender;

    public static boolean isTrapHasBeenActivatedPlayerOne() { return trapHasBeenActivatedPlayerOne; }

    public static void setTrapHasBeenActivatedPlayerOne(boolean trapHasBeenActivatedPlayerOne) { Trap.trapHasBeenActivatedPlayerOne = trapHasBeenActivatedPlayerOne; }

    public static boolean isTrapHasBeenActivatedPlayerTwo() { return trapHasBeenActivatedPlayerTwo; }

    public static void setTrapHasBeenActivatedPlayerTwo(boolean trapHasBeenActivatedPlayerTwo) { Trap.trapHasBeenActivatedPlayerTwo = trapHasBeenActivatedPlayerTwo; }

    public static int getTrappedSetNumberPlayerTwo() { return trappedSetNumberPlayerTwo; }

    public static void setTrappedSetNumberPlayerTwo(int trappedSetNumberPlayerTwo) { Trap.trappedSetNumberPlayerTwo = trappedSetNumberPlayerTwo; }

    public String getSquareRender() {
        return squareRender;
    }

    public void setSquareRender(String squareRender) {
        this.squareRender = squareRender;
    }

    public boolean isTrappedRiggedByPlayerOne() { return isTrapRiggedByPlayerOne; }

    public void setTrappedRiggedByPlayerOne(boolean trappedRiggedByPlayerOne) { isTrapRiggedByPlayerOne = trappedRiggedByPlayerOne; }

    public boolean isTrappedRiggedByPlayerTwo() { return isTrapRiggedByPlayerTwo; }

    public void setTrappedRiggedByPlayerTwo(boolean trappedRiggedByPlayerTwo) { isTrapRiggedByPlayerTwo = trappedRiggedByPlayerTwo; }

    public static int getTrappedSetNumberPlayerOne() { return trappedSetNumberPlayerOne; }

    public static void setTrappedSetNumberPlayerOne(int trappedSetNumberPlayerOne) { Trap.trappedSetNumberPlayerOne = trappedSetNumberPlayerOne; }


    /**
     * Метод който получава броя на капаните от текстов файл
     * @return броя на капаните
     * @throws IOException
     */
    public static int numberOfTraps() throws IOException {
        String valueTraps;
        int numberOfTraps;
        String traps = Files.readAllLines(Paths.get("SquareNumbers/Numbers")).get(0);
        String[] trapSplitter = traps.split("=");
        valueTraps = trapSplitter[1];
        numberOfTraps = Integer.parseInt(valueTraps);

        return numberOfTraps;
    }

    /**
     * Визуализатор за метода trapRigMenuPlayerOne().
     */
    public static void trapRigMenuRender(){
        System.out.println("(1) : Данъчна ревизия (100 шп)");
        System.out.println("(2) : Развод по котешки (200 шп)");
        System.out.println("(3) : Пропаганда (100 шп)");
        System.out.println("(4) : Проглеждане (50 шп)");
        System.out.println("(5) : Хазартен бос (100 шп)");
        System.out.println("(N) : Не, благодаря, не вярвам в злото");
    }

    /**
     * Чрез подаден текст от конзолата се избира типът на капана и съответната сума бива изваждана от playerBalance.
     * @param playerBalance текущите шп в портфейла на играча.
     */
    public static void trapRigMenuPlayerOne(double playerBalance){
        trapRigMenuRender();
        Scanner scanner = new Scanner(System.in);
        String select = scanner.nextLine();
        switch (select){
            case "N":
                System.out.println("Karma+");
                break;
            case "5":
                int chocolateMoneyCostCaseFive = -100;
                if((playerBalance+=chocolateMoneyCostCaseFive)<0){
                    System.out.println("Нямате достатъчно шп");
                    trapRigMenuPlayerOne(playerBalance);
                } else{
                    playerBalance+= chocolateMoneyCostCaseFive;
                    isTrapRiggedByPlayerOne = true;
                    Trap.setTrappedSetNumberPlayerOne(5);
                }
                break;
            case "4":
                int chocolateMoneyCostCaseFour = -50;
                if((playerBalance+=chocolateMoneyCostCaseFour)<0){
                    System.out.println("Нямате достатъчно шп");
                    trapRigMenuPlayerOne(playerBalance);
                } else{
                    playerBalance+= chocolateMoneyCostCaseFour;
                    isTrapRiggedByPlayerOne = true;
                    Trap.setTrappedSetNumberPlayerOne(4);
                }
                break;
            case "3":
                int chocolateMoneyCostCaseThree = -100;
                if((playerBalance+=chocolateMoneyCostCaseThree)<0){
                    System.out.println("Нямате достатъчно шп");
                    trapRigMenuPlayerOne(playerBalance);
                } else{
                    playerBalance+= chocolateMoneyCostCaseThree;
                    isTrapRiggedByPlayerOne = true;
                    Trap.setTrappedSetNumberPlayerOne(3);
                }
                break;
            case "2":
                int chocolateMoneyCostCaseTwo = -200;
                if((playerBalance+=chocolateMoneyCostCaseTwo)<0){
                    System.out.println("Нямате достатъчно шп");
                    trapRigMenuPlayerOne(playerBalance);
                } else{
                    playerBalance+= chocolateMoneyCostCaseTwo;
                    isTrapRiggedByPlayerOne = true;
                    Trap.setTrappedSetNumberPlayerOne(2);
                }
                break;
            case "1":
                int chocolateMoneyCostCaseOne = -100;
                if((playerBalance+=chocolateMoneyCostCaseOne)<0){
                    System.out.println("Нямате достатъчно шп");
                    trapRigMenuPlayerOne(playerBalance);
                } else{
                    playerBalance= playerBalance + chocolateMoneyCostCaseOne;
                    isTrapRiggedByPlayerOne = true;
                    Trap.setTrappedSetNumberPlayerOne(1);
                }
                break;
            default:
                System.out.println("Невалиден избор");
                trapRigMenuPlayerOne(playerBalance);
        }
    }

    /**
     * Чрез подаден текст от конзолата се избира типът на капана и съответната сума бива изваждана от playerBalance.
     * @param playerBalance текущите шп в портфейла на играча.
     */
    public static void trapRigMenuPlayerTwo(double playerBalance){
        trapRigMenuRender();
        Scanner scanner = new Scanner(System.in);
        String select = scanner.nextLine();
        switch (select){
            case "N":
                System.out.println("Karma+");
                break;
            case "5":
                int chocolateMoneyCostCaseFive = -100;
                if((playerBalance+=chocolateMoneyCostCaseFive)<0){
                    System.out.println("Нямате достатъчно шп");
                    trapRigMenuPlayerTwo(playerBalance);
                } else{
                    playerBalance+= chocolateMoneyCostCaseFive;
                    isTrapRiggedByPlayerTwo = true;
                    Trap.setTrappedSetNumberPlayerTwo(5);
                }
                break;
            case "4":
                int chocolateMoneyCostCaseFour = -50;
                if((playerBalance+=chocolateMoneyCostCaseFour)<0){
                    System.out.println("Нямате достатъчно шп");
                    trapRigMenuPlayerTwo(playerBalance);
                } else{
                    playerBalance+= chocolateMoneyCostCaseFour;
                    isTrapRiggedByPlayerTwo = true;
                    Trap.setTrappedSetNumberPlayerTwo(4);
                }
                break;
            case "3":
                int chocolateMoneyCostCaseThree = -100;
                if((playerBalance+=chocolateMoneyCostCaseThree)<0){
                    System.out.println("Нямате достатъчно шп");
                    trapRigMenuPlayerTwo(playerBalance);
                } else{
                    playerBalance+= chocolateMoneyCostCaseThree;
                    isTrapRiggedByPlayerTwo = true;
                    Trap.setTrappedSetNumberPlayerTwo(3);
                }
                break;
            case "2":
                int chocolateMoneyCostCaseTwo = -200;
                if((playerBalance+=chocolateMoneyCostCaseTwo)<0){
                    System.out.println("Нямате достатъчно шп");
                    trapRigMenuPlayerTwo(playerBalance);
                } else{
                    playerBalance+= chocolateMoneyCostCaseTwo;
                    isTrapRiggedByPlayerTwo = true;
                    Trap.setTrappedSetNumberPlayerTwo(2);
                }
                break;
            case "1":
                int chocolateMoneyCostCaseOne = -100;
                if((playerBalance+=chocolateMoneyCostCaseOne)<0){
                    System.out.println("Нямате достатъчно шп");
                    trapRigMenuPlayerTwo(playerBalance);
                } else{
                    playerBalance= playerBalance + chocolateMoneyCostCaseOne;
                    isTrapRiggedByPlayerTwo = true;
                    Trap.setTrappedSetNumberPlayerTwo(1);
                }
                break;
            default:
                System.out.println("Невалиден избор");
                trapRigMenuPlayerTwo(playerBalance);
        }
    }
}
