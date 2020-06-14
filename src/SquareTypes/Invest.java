package SquareTypes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Invest{

    protected static Scanner scanner = new Scanner(System.in);

    protected String squareRender;

    public String getSquareRender() {
        return squareRender;
    }

    public void setSquareRender(String squareRender) {
        this.squareRender = squareRender;
    }

    /**
     * Метод който получава броя на квадратчета от тип Invest от текстов файл.
     * @return броя на квадратчетата Invest.
     * @throws IOException
     */
    public static int numberOfInvests() throws IOException {
        String valueInvests;
        int numberOfInvests;
        String invests = Files.readAllLines(Paths.get("SquareNumbers/Numbers")).get(1);
        String[] investSplitter = invests.split("=");
        valueInvests = investSplitter[1];
        numberOfInvests = Integer.parseInt(valueInvests);

        return numberOfInvests;
    }

    /**
     * Метод който генерира 3 случайни компании в които да се инвестира.
     * @param playerBalance бюджета на играча.
     * @param invest неговатя инвестиция.
     * @param selectCompany компанията която ще селектира.
     *@param randomCompanySelectorOne случайно генерирано число.
     *@param randomCompanySelectorTwo случайно генерирано число.
     *@param randomCompanySelectorThree случайно генерирано число.
     */
    public static void investMenuNumberGenerator(double playerBalance,double invest,String selectCompany,int randomCompanySelectorOne,int randomCompanySelectorTwo,int randomCompanySelectorThree){
        boolean selectionIsGoing = true;
        while(selectionIsGoing) {
            randomCompanySelectorOne = ThreadLocalRandom.current().nextInt(1, 7);
            randomCompanySelectorTwo = ThreadLocalRandom.current().nextInt(1, 7);
            randomCompanySelectorThree = ThreadLocalRandom.current().nextInt(1, 7);
            if(randomCompanySelectorOne == randomCompanySelectorTwo){
                continue;
            } else if(randomCompanySelectorOne == randomCompanySelectorThree){
                continue;
            } else if(randomCompanySelectorTwo == randomCompanySelectorThree){
                continue;
            }
            selectionIsGoing = false;
        }
            System.out.print("(1):");
            companyRender(randomCompanySelectorOne);
            System.out.print("(2):");
            companyRender(randomCompanySelectorTwo);
            System.out.print("(3):");
            companyRender(randomCompanySelectorThree);
            System.out.println("(N) Не ми се инвестира повече");
            System.out.println();
            System.out.print("Изберете компанията в която ще инвестирате:");
            selectCompany = scanner.nextLine();
            System.out.print("Иберете сумата която ще инвестирате:");

            switch (selectCompany){
                case "N":
                    System.out.println("Добре");
                    break;
                case "3":
                    investInCompany(playerBalance, randomCompanySelectorThree,selectCompany,randomCompanySelectorOne,randomCompanySelectorTwo,randomCompanySelectorThree);
                    break;
                case "2":
                    investInCompany(playerBalance, randomCompanySelectorTwo,selectCompany,randomCompanySelectorOne,randomCompanySelectorTwo,randomCompanySelectorThree);
                    break;
                case "1":
                    investInCompany(playerBalance, randomCompanySelectorOne,selectCompany,randomCompanySelectorOne,randomCompanySelectorTwo,randomCompanySelectorThree);
                    break;
                default:
                    System.out.println("Invalid input");
                    investMenuNumberGenerator(playerBalance,invest,selectCompany,randomCompanySelectorOne,randomCompanySelectorTwo,randomCompanySelectorThree);
            }
    }

    /**
     * Метод който визуализира компанията чийто индекс е генериран.
     * @param index случайно генериран параметър.
     */
    public static void companyRender(int index){
        if(index == 1){
            System.out.println("Evel Co | min : 500 | risk/reward : 0.2");
        } else if(index == 2){
            System.out.println("Bombs away | min : 400 | risk/reward : 0.5");
        } else if (index == 3){
            System.out.println("Clock work orange | min : 300 | risk/reward : 1.5");
        } else if (index == 4){
            System.out.println("Maroders unated | min : 200 | risk/reward : 2.0");
        } else if(index == 5){
            System.out.println("Fatcat incorporated | min : 100 | risk/reward : 2.5");
        } else {
            System.out.println("Macrosoft incorporated | min : 50 | risk/reward : 5.0");
        }
    }

    /**
     * Метод който проверява дали инвестицията е валидна.
     * @param playerBalance бюджета на играча.
     * @param randomNumber индексът на компанията.
     * @param selectCompany компанията която е селектирана.
     * @param randomCompanySelectorOne случайно генерирано число.
     * @param randomCompanySelectorTwo случайно генерирано число.
     * @param randomCompanySelectorThree случайно генерирано число.
     */
    public static void investInCompany(double playerBalance, int randomNumber, String selectCompany, int randomCompanySelectorOne, int randomCompanySelectorTwo, int randomCompanySelectorThree){
        double invest = scanner.nextInt();
        if(invest >playerBalance){
            System.out.println("Сумата която се опитвате да ивестирате надвишава сегашните ви средства.");
            investMenuNumberGenerator(playerBalance, invest,selectCompany,randomCompanySelectorOne,randomCompanySelectorTwo,randomCompanySelectorThree);
        }
        if(randomNumber == 1){
            if(invest <500){
                System.out.println("Минималната сума за инвестиция е 500шп");
                investMenuNumberGenerator(playerBalance, invest,selectCompany,randomCompanySelectorOne,randomCompanySelectorTwo,randomCompanySelectorThree);
            }
        } else if (randomNumber == 2){
            if(invest <400){
                System.out.println("Минималната сума за инвестиция е 400шп");
                investMenuNumberGenerator(playerBalance, invest,selectCompany,randomCompanySelectorOne,randomCompanySelectorTwo,randomCompanySelectorThree);
            }
        } else if (randomNumber == 3){
            if(invest <300){
                System.out.println("Минималната сума за инвестиция е 300шп");
                investMenuNumberGenerator(playerBalance, invest,selectCompany,randomCompanySelectorOne,randomCompanySelectorTwo,randomCompanySelectorThree);
            }
        } else if (randomNumber == 4){
            if(invest <200){
                System.out.println("Минималната сума за инвестиция е 200шп");
                investMenuNumberGenerator(playerBalance, invest,selectCompany,randomCompanySelectorOne,randomCompanySelectorTwo,randomCompanySelectorThree);
            }
        } else if (randomNumber == 5){
            if(invest <100){
                System.out.println("Минималната сума за инвестиция е 100шп");
                investMenuNumberGenerator(playerBalance, invest,selectCompany,randomCompanySelectorOne,randomCompanySelectorTwo,randomCompanySelectorThree);
            }
        } else if (randomNumber == 6){
            if(invest <50){
                System.out.println("Минималната сума за инвестиция е 50шп");
                investMenuNumberGenerator(playerBalance, invest,selectCompany,randomCompanySelectorOne,randomCompanySelectorTwo,randomCompanySelectorThree);
            }
        }
    }

    /**
     * Метод който калкулира печалбата или загубата на играча и проверява за капан който анулира печалбите на края на всеки вход.
     * @param playerBalance бюджета на играча.
     * @param invest неговатя инвестиция.
     * @param randomNumberOne индексът на първата компания.
     * @param randomNumberTwo индексът на втората компания.
     * @param randomNumberThree индексът на третата компания.
     */
    public static void investPayOffPlayerOne(double playerBalance, double invest,int randomNumberOne,int randomNumberTwo,int randomNumberThree){
        if(randomNumberOne == 1 || randomNumberTwo == 1 || randomNumberThree == 1 ){
            int random = ThreadLocalRandom.current().nextInt(-5,101);
            invest = invest + invest * 0.2;
            if (random < 0){
                playerBalance = playerBalance - invest;
            }else if(Trap.isTrapHasBeenActivatedPlayerOne()&&Trap.getTrappedSetNumberPlayerTwo() == 2){
                int D10 = ThreadLocalRandom.current().nextInt(1,11);
                if(D10 == 2 || D10 == 8){
                    playerBalance = playerBalance + invest;
                } else {
                    System.out.println("Капан номер 2 е активен и няма печалба");
                }
            } else {
                playerBalance = playerBalance + invest;
            }
        } else if (randomNumberOne == 2|| randomNumberTwo == 2 || randomNumberThree == 2){
            int random = ThreadLocalRandom.current().nextInt(-10,51);
            invest = invest + invest*0.5;
            if (random < 0){
                playerBalance = playerBalance - invest;
            } else if(Trap.isTrapHasBeenActivatedPlayerOne()&&Trap.getTrappedSetNumberPlayerTwo() == 2){
                int D10 = ThreadLocalRandom.current().nextInt(1,11);
                if(D10 == 2 || D10 == 8){
                    playerBalance = playerBalance + invest;
                } else {
                    System.out.println("Капан номер 2 е активен и няма печалба");
                }
            }else {
                playerBalance = playerBalance + invest;
            }
        } else if (randomNumberOne == 3|| randomNumberTwo == 3 || randomNumberThree == 3){
            int random = ThreadLocalRandom.current().nextInt(-15,36);
            invest = invest + invest*1.5;
            if (random < 0){
                playerBalance = playerBalance - invest;
            }else if(Trap.isTrapHasBeenActivatedPlayerOne()&&Trap.getTrappedSetNumberPlayerTwo() == 2){
                int D10 = ThreadLocalRandom.current().nextInt(1,11);
                if(D10 == 2 || D10 == 8){
                    playerBalance = playerBalance + invest;
                } else {
                    System.out.println("Капан номер 2 е активен и няма печалба");
                }
            } else {
                playerBalance = playerBalance + invest;
            }
        } else if (randomNumberOne == 4|| randomNumberTwo == 4 || randomNumberThree == 4){
            int random = ThreadLocalRandom.current().nextInt(-18,51);
            invest = invest + invest*2.0;
            if (random < 0){
                playerBalance = playerBalance - invest;
            }else if(Trap.isTrapHasBeenActivatedPlayerOne()&&Trap.getTrappedSetNumberPlayerTwo() == 2){
                int D10 = ThreadLocalRandom.current().nextInt(1,11);
                if(D10 == 2 || D10 == 8){
                    playerBalance = playerBalance + invest;
                } else {
                    System.out.println("Капан номер 2 е активен и няма печалба");
                }
            } else {
                playerBalance = playerBalance + invest;
            }
        } else if (randomNumberOne == 5|| randomNumberTwo == 5 || randomNumberThree == 5){
            int random = ThreadLocalRandom.current().nextInt(-25,101);
            invest = invest + invest*2.5;
            if (random < 0){
                playerBalance = playerBalance - invest;
            }else if(Trap.isTrapHasBeenActivatedPlayerOne()&&Trap.getTrappedSetNumberPlayerTwo() == 2){
                int D10 = ThreadLocalRandom.current().nextInt(1,11);
                if(D10 == 2 || D10 == 8){
                    playerBalance = playerBalance + invest;
                } else {
                    System.out.println("Капан номер 2 е активен и няма печалба");
                }
            } else {
                playerBalance = playerBalance + invest;
            }
        } else if (randomNumberOne == 6|| randomNumberTwo == 6 || randomNumberThree == 6){
            int random = ThreadLocalRandom.current().nextInt(-20,11);
            invest = invest + invest*5.0;
            if (random < 0){
                playerBalance = playerBalance - invest;
            }else if(Trap.isTrapHasBeenActivatedPlayerOne()&&Trap.getTrappedSetNumberPlayerTwo() == 2){
                int D10 = ThreadLocalRandom.current().nextInt(1,11);
                if(D10 == 2 || D10 == 8){
                    playerBalance = playerBalance + invest;
                } else {
                    System.out.println("Капан номер 2 е активен и няма печалба");
                }
            } else {
                playerBalance = playerBalance + invest;
            }
        }
    }

    /**
     * Метод който калкулира печалбата или загубата на играча и проверява за капан който анулира печалбите на края на всеки вход.
     * @param playerBalance бюджета на играча.
     * @param invest неговатя инвестиция.
     * @param randomNumberOne индексът на първата компания.
     * @param randomNumberTwo индексът на втората компания.
     * @param randomNumberThree индексът на третата компания.
     */
    public static void investPayOffPlayerTwo(double playerBalance, double invest,int randomNumberOne,int randomNumberTwo,int randomNumberThree){
        if(randomNumberOne == 1 || randomNumberTwo == 1 || randomNumberThree == 1 ){
            int random = ThreadLocalRandom.current().nextInt(-5,101);
            invest = invest + invest * 0.2;
            if (random < 0){
                playerBalance = playerBalance - invest;
            }else if(Trap.isTrapHasBeenActivatedPlayerTwo()&&Trap.getTrappedSetNumberPlayerOne() == 2){
                int D10 = ThreadLocalRandom.current().nextInt(1,11);
                if(D10 == 2 || D10 == 8){
                    playerBalance = playerBalance + invest;
                } else {
                    System.out.println("Капан номер 2 е активен и няма печалба");
                }
            } else {
                playerBalance = playerBalance + invest;
            }
        } else if (randomNumberOne == 2|| randomNumberTwo == 2 || randomNumberThree == 2){
            int random = ThreadLocalRandom.current().nextInt(-10,51);
            invest = invest + invest*0.5;
            if (random < 0){
                playerBalance = playerBalance - invest;
            } else if(Trap.isTrapHasBeenActivatedPlayerTwo()&&Trap.getTrappedSetNumberPlayerOne() == 2){
                int D10 = ThreadLocalRandom.current().nextInt(1,11);
                if(D10 == 2 || D10 == 8){
                    playerBalance = playerBalance + invest;
                } else {
                    System.out.println("Капан номер 2 е активен и няма печалба");
                }
            }else {
                playerBalance = playerBalance + invest;
            }
        } else if (randomNumberOne == 3|| randomNumberTwo == 3 || randomNumberThree == 3){
            int random = ThreadLocalRandom.current().nextInt(-15,36);
            invest = invest + invest*1.5;
            if (random < 0){
                playerBalance = playerBalance - invest;
            }else if(Trap.isTrapHasBeenActivatedPlayerTwo()&&Trap.getTrappedSetNumberPlayerOne() == 2){
                int D10 = ThreadLocalRandom.current().nextInt(1,11);
                if(D10 == 2 || D10 == 8){
                    playerBalance = playerBalance + invest;
                } else {
                    System.out.println("Капан номер 2 е активен и няма печалба");
                }
            } else {
                playerBalance = playerBalance + invest;
            }
        } else if (randomNumberOne == 4|| randomNumberTwo == 4 || randomNumberThree == 4){
            int random = ThreadLocalRandom.current().nextInt(-18,51);
            invest = invest + invest*2.0;
            if (random < 0){
                playerBalance = playerBalance - invest;
            }else if(Trap.isTrapHasBeenActivatedPlayerTwo()&&Trap.getTrappedSetNumberPlayerOne() == 2){
                int D10 = ThreadLocalRandom.current().nextInt(1,11);
                if(D10 == 2 || D10 == 8){
                    playerBalance = playerBalance + invest;
                } else {
                    System.out.println("Капан номер 2 е активен и няма печалба");
                }
            } else {
                playerBalance = playerBalance + invest;
            }
        } else if (randomNumberOne == 5|| randomNumberTwo == 5 || randomNumberThree == 5){
            int random = ThreadLocalRandom.current().nextInt(-25,101);
            invest = invest + invest*2.5;
            if (random < 0){
                playerBalance = playerBalance - invest;
            }else if(Trap.isTrapHasBeenActivatedPlayerTwo()&&Trap.getTrappedSetNumberPlayerOne() == 2){
                int D10 = ThreadLocalRandom.current().nextInt(1,11);
                if(D10 == 2 || D10 == 8){
                    playerBalance = playerBalance + invest;
                } else {
                    System.out.println("Капан номер 2 е активен и няма печалба");
                }
            } else {
                playerBalance = playerBalance + invest;
            }
        } else if (randomNumberOne == 6|| randomNumberTwo == 6 || randomNumberThree == 6){
            int random = ThreadLocalRandom.current().nextInt(-20,11);
            invest = invest + invest*5.0;
            if (random < 0){
                playerBalance = playerBalance - invest;
            }else if(Trap.isTrapHasBeenActivatedPlayerTwo()&&Trap.getTrappedSetNumberPlayerOne() == 2){
                int D10 = ThreadLocalRandom.current().nextInt(1,11);
                if(D10 == 2 || D10 == 8){
                    playerBalance = playerBalance + invest;
                } else {
                    System.out.println("Капан номер 2 е активен и няма печалба");
                }
            } else {
                playerBalance = playerBalance + invest;
            }
        }
    }
}