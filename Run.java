import control.Counting;
import control.ReadFile;
import model.DataOlympic;

import java.sql.SQLOutput;

public class Run {
    public static void main(String[] args) {
        DataOlympic dataOlympic;

        ReadFile readFile = new ReadFile();
        readFile.readSaveLines("file.txt");
        readFile.getInformationFirstLine();
        readFile.getInformationNextLine();

        dataOlympic = readFile.getDataOlympic();

        Counting counting = new Counting();
        String c1 = counting.bestCountryGold(dataOlympic);
        String c2 = counting.countryMostMedal(dataOlympic);
        String c3 = counting.athleteMostGoldenMedal(dataOlympic);
        String c4 = counting.athleteMostMedal(dataOlympic);
        String c5 = counting.athleteSpendMoreTimeCompeting(dataOlympic);

        System.out.println("País com mais medalhas de ouro " + c1);
        System.out.println("País com mais medalhas " + c2);
        System.out.println("atleta com mais medalhas de ouro " + c3);
        System.out.println("atleta com mais medalhas " + c4);
        System.out.println("atleta que gastou mais tempo competindo " + c5);
    }
}
