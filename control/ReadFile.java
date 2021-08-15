package control;

import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {

    List<String> lines;
    DataOlympic dataOlympic;

    public ReadFile() {
        lines = new ArrayList<>();
        dataOlympic = new DataOlympic();
    }

    public DataOlympic getDataOlympic(){
        return dataOlympic;
    }

    public void readSaveLines(String nameFile) {
        try {
            File file = new File(nameFile);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines.add(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getInformationFirstLine() {
        String[] firstLineInfo = lines.get(0).split(" ");
        if (firstLineInfo.length == 2) {
            dataOlympic.setSportName(firstLineInfo[0]);
            if (firstLineInfo[1].equals("(M)")) {
                dataOlympic.setGender(DataOlympic.Gender.MALE);
            } else if (firstLineInfo[1].equals("(F)")) {
                dataOlympic.setGender(DataOlympic.Gender.FEMININE);
            }
        }
    }

    public void getInformationNextLine() {
        lines.remove(0);
        for (String l : lines) {
            DataSport dataSport = new DataSport();
            String[] info = l.split(";");
            Golden golden = new Golden();
            Silver silver = new Silver();
            Bronze bronze = new Bronze();
            dataSport.setModality(info[0]);
            golden.setMedalWinner(info[1]);
            golden.setCountryOrigin(info[2]);
            golden.setTime(timeToMs(info[3]));
            silver.setMedalWinner(info[4]);
            silver.setCountryOrigin(info[5]);
            silver.setTime(timeToMs(info[6]));
            bronze.setMedalWinner(info[7]);
            bronze.setCountryOrigin(info[8]);
            bronze.setTime(timeToMs(info[9]));
            dataSport.setGolden(golden);
            dataSport.setSilver(silver);
            dataSport.setBronze(bronze);
            dataOlympic.addDataSport(dataSport);
        }
    }

    public double timeToMs(String t){
        double timer_ms = 0;
        if (t.contains(":")){
            String[] t1 = t.split(":");
            timer_ms = Double.parseDouble(t1[0]) * 60 * 1_000;
            if (t1[1].contains("\\.")){
                String[] t2 = t1[1].split("\\.");
                timer_ms += (Double.parseDouble(t2[0]) * 1_000) + Double.parseDouble(t2[1]);
            } else {
                timer_ms += Double.parseDouble(t1[1]) * 1_000;
            }
        }
        return timer_ms;
    }
}
