package control;

import model.DataOlympic;
import model.DataSport;

import java.util.*;

public class Counting {

    public String bestCountryGold(DataOlympic dataOlympic) {
        List<String> countryGolden = new ArrayList<>();
        for (DataSport ds : dataOlympic.getDataSportList()) {
            countryGolden.add(ds.getGolden().getCountryOrigin());
        }
        return getFrequencyName(countryGolden);
    }

    public String countryMostMedal(DataOlympic dataOlympic) {
        List<String> countryMedalList = new ArrayList<>();
        for (DataSport ds : dataOlympic.getDataSportList()) {
            countryMedalList.add(ds.getGolden().getCountryOrigin());
            countryMedalList.add(ds.getSilver().getCountryOrigin());
            countryMedalList.add(ds.getBronze().getCountryOrigin());
        }
        return getFrequencyName(countryMedalList);
    }

    public String athleteMostGoldenMedal(DataOlympic dataOlympic) {
        List<String> athleteMostGoldenMedalList = new ArrayList<>();
        for (DataSport ds : dataOlympic.getDataSportList()) {
            athleteMostGoldenMedalList.add(ds.getGolden().getMedalWinner());
        }
        return getFrequencyName(athleteMostGoldenMedalList);
    }

    public String athleteMostMedal(DataOlympic dataOlympic) {
        List<String> athleteMostMedalList = new ArrayList<>();
        for (DataSport ds : dataOlympic.getDataSportList()) {
            athleteMostMedalList.add(ds.getGolden().getMedalWinner());
            athleteMostMedalList.add(ds.getSilver().getMedalWinner());
            athleteMostMedalList.add(ds.getBronze().getMedalWinner());
        }
        return getFrequencyName(athleteMostMedalList);
    }

    public String athleteSpendMoreTimeCompeting(DataOlympic dataOlympic) {
        Map<String, Double> nameTime = new HashMap<>();
        for (DataSport ds : dataOlympic.getDataSportList()) {
            if (ds.getModality().contains("Revezamento")){
                String[] names_golden = ds.getGolden().getMedalWinner().split("/");
                double t = ds.getGolden().getTime() / names_golden.length;
                for (String n : names_golden) {
                    nameTime.put(n, nameTime.getOrDefault(n, t));
                }

                String[] names_silver = ds.getSilver().getMedalWinner().split("/");
                double t_s = ds.getSilver().getTime() / names_silver.length;
                for (String n : names_silver) {
                    nameTime.put(n, nameTime.getOrDefault(n, t_s));
                }

                String[] names_bronze = ds.getBronze().getMedalWinner().split("/");
                double t_b = ds.getBronze().getTime() / names_bronze.length;
                for (String n : names_bronze) {
                    nameTime.put(n, nameTime.getOrDefault(n, t_b));
                }
            }
            if (!nameTime.containsKey(ds.getGolden().getMedalWinner())) {
                nameTime.put(ds.getGolden().getMedalWinner(), ds.getGolden().getTime());
            } else {
                nameTime.put(ds.getGolden().getMedalWinner(), nameTime.get(ds.getGolden().getMedalWinner())
                        + ds.getGolden().getTime());
            }

            if (!nameTime.containsKey(ds.getSilver().getMedalWinner())) {
                nameTime.put(ds.getSilver().getMedalWinner(), ds.getSilver().getTime());
            } else {
                nameTime.put(ds.getSilver().getMedalWinner(), nameTime.get(ds.getSilver().getMedalWinner())
                        + ds.getSilver().getTime());
            }

            if (!nameTime.containsKey(ds.getBronze().getMedalWinner())) {
                nameTime.put(ds.getBronze().getMedalWinner(), ds.getBronze().getTime());
            } else {
                nameTime.put(ds.getBronze().getMedalWinner(), nameTime.get(ds.getBronze().getMedalWinner())
                        + ds.getBronze().getTime());
            }
        }

        Double i = Collections.max (nameTime.values());
        return nameTime.entrySet()
                .stream()
                .filter(e -> e.getValue().equals(i))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    private String getFrequencyName(List<String> countryMedalList) {
        String countryWithMostMedal = "";
        int max = 0;
        for (String s : countryMedalList) {
            int frequency = Collections.frequency(countryMedalList, s);
            if (frequency > max) {
                max = frequency;
                countryWithMostMedal = s;
            }
        }
        return countryWithMostMedal;
    }
}
