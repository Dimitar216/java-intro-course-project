package SquareTypes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PartyHard {
    protected String squareRender;

    public String getSquareRender() {
        return squareRender;
    }

    public void setSquareRender(String squareRender) {
        this.squareRender = squareRender;
    }

    /**
     * Метод който получава броя на квадратчета от тип PartyHard от текстов файл.
     * @return броя на квадратчетата PartyHard.
     * @throws IOException
     */
    public static int numberOfPartyHard() throws IOException {
        String valuePartyHard;
        int numberOfPartyHard;
        String partyHard = Files.readAllLines(Paths.get("SquareNumbers/Numbers")).get(2);
        String[] partyHardSplitter = partyHard.split("=");
        valuePartyHard = partyHardSplitter[1];
        numberOfPartyHard = Integer.parseInt(valuePartyHard);

        return numberOfPartyHard;
    }

    /**
     * Метод който изважда определен брой шп от портфейла на играчя
     * @param playerBalance балансът на играче след транзакцията
     */
    public static void partyHard(double playerBalance){
        playerBalance = playerBalance-25;
    }
}
