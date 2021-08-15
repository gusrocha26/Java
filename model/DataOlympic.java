package model;

import java.util.ArrayList;
import java.util.List;

public class DataOlympic {

    public enum Gender {
        MALE,
        FEMININE
    }

    private String sportName;
    private Gender gender;

    private List<DataSport> dataSportList = new ArrayList<>();

    public void addDataSport(DataSport dataSport) {
        dataSportList.add(dataSport);
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<DataSport> getDataSportList() {
        return dataSportList;
    }

}
