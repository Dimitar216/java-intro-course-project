import SquareTypes.*;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static int randomNumberOne = 0;

    public static int randomNumberTwo = 0;

    public static int randomNumberThree = 0;

    public static String selectCompany = "";

    public static double investMoneyPlayerOne = 0;

    public static double investMoneyPlayerTwo = 0;

    public static double playerOneBalanceInitial = 1000;

    public static double playerTwoBalanceInitial = 1000;

    public static final int size = 20;

    public static final Trap trap = new Trap();

    public static final Invest invest = new Invest();

    public static final PartyHard partyHard = new PartyHard();

    public static final Chance chance = new Chance();

    public static final Steal steal = new Steal();

    public static final Object[] board = new Object[size];

    public static void main(String[] args) throws IOException {
        squareStringSetters();
        double playerOneBalance = playerOneBalanceInitial;
        double playerTwoBalance = playerTwoBalanceInitial;
        while(playerOneBalanceInitial > 0 && playerTwoBalanceInitial > 0){
            boardSetUpOne(board);
            playerOneTurn(board,playerOneBalance);
            playerTwoTurn(board,playerTwoBalance);
            Invest.investPayOffPlayerOne(playerOneBalance,investMoneyPlayerOne,randomNumberOne,randomNumberTwo,randomNumberThree);
            Invest.investPayOffPlayerTwo(playerTwoBalance,investMoneyPlayerTwo,randomNumberOne,randomNumberTwo,randomNumberThree);
        }
        if(playerOneBalanceInitial<0){
            System.out.println("Играч 2 печели.");
        } else if(playerTwoBalance<0){
            System.out.println("Играч 1 печели.");
        } else {
            System.out.println("Никой не печели.");
        }
    }

    /**
     * Метод който възлага даден текст върху обекти от класове.
     */
    public static void squareStringSetters(){
        trap.setSquareRender("|T|");
        invest.setSquareRender("|I|");
        partyHard.setSquareRender("|P|");
        chance.setSquareRender("|C|");
        steal.setSquareRender("|St|");
    }

    /**
     * Първата част от метода който случайно разпределя обекти по дъската.
     * @param board игралната дъска.
     * @throws IOException
     */
    public static void boardSetUpOne(Object[] board) throws IOException {
        squareStringSetters();
        board[0] = "|S|";
        for(int t = 0; t < Trap.numberOfTraps(); t++){
                int random = ThreadLocalRandom.current().nextInt(0, 20);
                if(board[random] == null){
                    board[random] = trap.getSquareRender();
                } else{
                    t--;
                }
            }
        for(int i = 0; i<Invest.numberOfInvests();i++){
            int random = ThreadLocalRandom.current().nextInt(0, 20);
            if(board[random] == null){
                board[random] = invest.getSquareRender();
            } else{
                i--;
            }
            }
            for(int p =0;p<PartyHard.numberOfPartyHard();p++){
                int random = ThreadLocalRandom.current().nextInt(0, 20);
                if(board[random] == null){
                    board[random] = partyHard.getSquareRender();
                } else{
                    p--;
                }
            }
            boardSetUpTwo(board);
    }

    /**
     * Втората част от метода който случайно разпределя обекти по дъската.
     * @param board игралната дъска.
     * @throws IOException
     */
    public static void boardSetUpTwo(Object[] board) throws IOException {
        for(int c = 0; c<Chance.numberOfChances();c++){
            int random = ThreadLocalRandom.current().nextInt(0, 20);
            if(board[random] == null){
                board[random] = chance.getSquareRender();
            } else{
                c--;
            }
        }
        for(int s=0;s<Steal.numberOfSteals();s++){
            int random = ThreadLocalRandom.current().nextInt(0, 20);
            if(board[random] == null){
                board[random] = steal.getSquareRender();
            } else{
                s--;
            }
        }
    }

    /**
     *  Метод който визуализира игралната дъска.
     * @param board игралната дъска.
     */
    public static void boardRender(Object[] board){
        System.out.println(board[12].toString()+board[13].toString()+board[14].toString()+board[15].toString()+board[16].toString()+board[17].toString()+board[18].toString()+board[19]);
        System.out.println(board[10].toString()+"                    "+board[11].toString());
        System.out.println(board[8].toString()+"                    "+board[9].toString());
        System.out.println(board[7].toString()+board[6].toString()+board[5].toString()+board[4].toString()+board[3].toString()+board[2].toString()+board[1].toString()+board[0]);
    }

    /**
     * Метод който визуализира портфейлите на два играча.
     * @param playerOneBalance броя шп на играч 1.
     * @param playerTwoBalance броя шп на играч 2.
     */
    public static void balanceRender(double playerOneBalance,double playerTwoBalance){
        System.out.println();
        System.out.println("Играч 1 има "+playerOneBalance + " шп");
        System.out.println("Играч 2 има "+playerTwoBalance + " шп");
    }

    /**
     * Метод който генерира случайно число.
     * @return връща случайно число от 1 до 2.
     */
    public static int twoSidedDiceRoll(){
        int random = ThreadLocalRandom.current().nextInt(1, 3);
        return random;
    }

    /**
     * Метод който визуализира текущата позиция на играча.
     * @param position позицията на играча.
     */
    public static void playerPositionRender (int position){
        System.out.println("Играчът се намира на позиция: "+position);
    }

    /**
     * Метод който реализира ходът на играч 1.
     * @param board игралната дъска.
     * @param playerOneBalance броя шп на играч 1.
     */
    public static void playerOneTurn(Object[] board,double playerOneBalance) {
        int position=0;
        do {
            boardRender(board);
            System.out.println();
            balanceRender(playerOneBalance, playerTwoBalanceInitial);
            System.out.println();
            int evilPlan = Steal.evilPlanGenerator();
            Steal.evilPlanRender(evilPlan);
            int result = twoSidedDiceRoll();
            position = position +result;
            if(position > 19){
                position = 19;
                playerTwoTurn(board,playerTwoBalanceInitial);
            }
            System.out.println();
            playerPositionRender(position);
            System.out.println();

            if (board[position].equals("|P|")) {
                PartyHard.partyHard(playerOneBalance);
            } else if(board[position].equals("|C|")){
                if(Trap.getTrappedSetNumberPlayerTwo() == 5 && Trap.isTrapHasBeenActivatedPlayerOne()){
                    Chance.badChanceThrow(playerOneBalance);
                    Trap.setTrappedSetNumberPlayerTwo(0);
                    Trap.setTrapHasBeenActivatedPlayerOne(false);
                }else if(Trap.getTrappedSetNumberPlayerOne() == 5 && Trap.isTrapHasBeenActivatedPlayerOne()){
                    int D10 = ThreadLocalRandom.current().nextInt(1,11);
                    if(D10%3 != 0){
                        Chance.badChanceThrow(playerOneBalance);
                    }
                    Trap.setTrappedSetNumberPlayerOne(0);
                    Trap.setTrapHasBeenActivatedPlayerOne(false);
                } else {
                    Chance.chanceThrow(playerOneBalance);
                }
            } else if (board[position].equals("|St|")){
                if(Trap.isTrapHasBeenActivatedPlayerOne()&&Trap.getTrappedSetNumberPlayerTwo() == 4) {
                    System.out.println("Капанът „Проглеждане“ е във ефект и неможете да реализирате злия си план.");
                } else if (Trap.isTrapHasBeenActivatedPlayerOne() && Trap.getTrappedSetNumberPlayerOne() == 4){
                    int D10 = ThreadLocalRandom.current().nextInt(1,11);
                    if(D10%3 != 0){
                        System.out.println("Бяхте вханати от собствения си капан „Проглеждане“.");
                    }
                    System.out.println("Избегнахте собствения си капан.");
                    Steal.setIsEvilPlanActivePlayerOne(true);
                } else if (!Steal.isIsEvilPlanActivePlayerOne()) {
                    Steal.setIsEvilPlanActivePlayerOne(true);
                }
            } else if(board[position].equals("|T|")){
                if(Trap.getTrappedSetNumberPlayerTwo() != 0){
                    Trap.setTrapHasBeenActivatedPlayerOne(true);
                    if(Trap.getTrappedSetNumberPlayerTwo() == 3){
                        System.out.println("Неможете да слагате капани докато капанът „Пропаганда“ е активен.");
                    }
                } else{
                    Trap.trapRigMenuPlayerOne(playerOneBalance);
                }
            } else if(board[position].equals("|I|")){
                Invest.investMenuNumberGenerator(playerOneBalance,investMoneyPlayerOne,selectCompany,randomNumberOne,randomNumberTwo,randomNumberThree);
                Invest.companyRender(randomNumberOne);
                Invest.companyRender(randomNumberTwo);
                Invest.companyRender(randomNumberThree);
            }

            if(Steal.isIsEvilPlanActivePlayerOne()) {
                Steal.evilPlan(evilPlan, playerOneBalance, board, position);
            }
            playerOneBalanceInitial = playerOneBalance;
        } while(position<19);
    }

    /**
     * Метод който реализира ходът на играч 2.
     * @param board игралната дъска.
     * @param playerTwoBalance броя шп на играч 2.
     */
    public static void playerTwoTurn(Object[] board,double playerTwoBalance) {
        int position=0;
        do {
            boardRender(board);
            System.out.println();
            balanceRender(playerOneBalanceInitial, playerTwoBalance);
            System.out.println();
            int evilPlan = Steal.evilPlanGenerator();
            Steal.evilPlanRender(evilPlan);
            int result = twoSidedDiceRoll();
            position = position +result;
            if(position > 19){
                position = 0;
                playerOneTurn(board,playerOneBalanceInitial);
            }
            System.out.println();
            playerPositionRender(position);
            System.out.println();

            if (board[position].equals(partyHard)) {
                PartyHard.partyHard(playerTwoBalance);
            } else if(board[position].equals(chance)){
                if(Trap.getTrappedSetNumberPlayerOne() == 5 && Trap.isTrapHasBeenActivatedPlayerTwo()){
                    Chance.badChanceThrow(playerTwoBalance);
                    Trap.setTrappedSetNumberPlayerTwo(0);
                    Trap.setTrapHasBeenActivatedPlayerOne(false);
                }else if(Trap.getTrappedSetNumberPlayerTwo() == 5 && Trap.isTrapHasBeenActivatedPlayerTwo()){
                    int D10 = ThreadLocalRandom.current().nextInt(1,11);
                    if(D10%3 != 0){
                        Chance.badChanceThrow(playerTwoBalance);
                    }
                    Trap.setTrappedSetNumberPlayerOne(0);
                    Trap.setTrapHasBeenActivatedPlayerOne(false);
                } else {
                    Chance.chanceThrow(playerTwoBalance);
                }
            } else if (board[position].equals(steal)){
                if(Trap.isTrapHasBeenActivatedPlayerTwo()&&Trap.getTrappedSetNumberPlayerOne() == 4) {
                    System.out.println("Капанът „Проглеждане“ е във ефект и неможете да реализирате злия си план.");
                } else if (Trap.isTrapHasBeenActivatedPlayerTwo() && Trap.getTrappedSetNumberPlayerTwo() == 4){
                    int D10 = ThreadLocalRandom.current().nextInt(1,11);
                    if(D10%3 != 0){
                        System.out.println("Бяхте вханати от собствения си капан „Проглеждане“.");
                    }
                    System.out.println("You evaded your own trap");
                    Steal.setIsEvilPlanActivePlayerTwo(true);
                } else if (!Steal.isIsEvilPlanActivePlayerTwo()) {
                    Steal.setIsEvilPlanActivePlayerTwo(true);
                }
            } else if(board[position].equals(trap)){
                if(Trap.getTrappedSetNumberPlayerOne() != 0){
                    Trap.setTrapHasBeenActivatedPlayerTwo(true);
                    if(Trap.getTrappedSetNumberPlayerOne() == 3){
                        System.out.println("Неможете да слагате капани докато капанът „Пропаганда“ е активен.");
                    }
                } else{
                    Trap.trapRigMenuRender();
                    Trap.trapRigMenuPlayerTwo(playerTwoBalance);
                }
            } else if(board[position].equals(invest)){
                Invest.investMenuNumberGenerator(playerTwoBalance,investMoneyPlayerTwo,selectCompany,randomNumberOne,randomNumberTwo,randomNumberThree);
                Invest.companyRender(randomNumberOne);
                Invest.companyRender(randomNumberTwo);
                Invest.companyRender(randomNumberThree);
            }

            if(Steal.isIsEvilPlanActivePlayerTwo()) {
                Steal.evilPlan(evilPlan, playerTwoBalance, board, position);
            }
            playerTwoBalanceInitial = playerTwoBalance;
        } while(position<19);
    }
}