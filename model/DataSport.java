package model;

public class DataSport {

    private String modality;
    private Golden golden;
    private Silver silver;
    private Bronze bronze;

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public Golden getGolden() {
        return golden;
    }

    public void setGolden(Golden golden) {
        this.golden = golden;
    }

    public Silver getSilver() {
        return silver;
    }

    public void setSilver(Silver silver) {
        this.silver = silver;
    }

    public Bronze getBronze() {
        return bronze;
    }

    public void setBronze(Bronze bronze) {
        this.bronze = bronze;
    }
}

