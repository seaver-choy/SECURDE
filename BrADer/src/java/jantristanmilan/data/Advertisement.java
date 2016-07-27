package jantristanmilan.data;

public class Advertisement {
    private String title;
    private AdvertisementType type;
    private int numPortions;
    private float portionCost;
    private float portionSize;

    public Advertisement() {

    }

    public Advertisement(String title, AdvertisementType type,
                         int numPortions, float portionCost) {
        this.title = title;
        this.type = type;
        this.numPortions = numPortions;
        this.portionCost = portionCost;
    }

    public float getPortionCost() {
        return portionCost;
    }

    public void setPortionCost(float portionCost) {
        this.portionCost = portionCost;
    }

    public float getPortionSize() {
        return portionSize;
    }

    public void setPortionSize(float portionSize) {
        this.portionSize = portionSize;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AdvertisementType getType() {
        return type;
    }

    public void setType(AdvertisementType type) {
        this.type = type;
    }

    public int getNumPortions() {
        return numPortions;
    }

    public void setNumPortions(int numPortions) {
        this.numPortions = numPortions;
    }

}
