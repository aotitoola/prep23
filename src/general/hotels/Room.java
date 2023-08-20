package general.hotels;

import java.util.Arrays;
import java.util.Set;

public class Room {

    private int price;
    private Set<String> features;
    private int availability;

    public Room(int price, Set<String> features, int availability) {
        this.price = price;
        this.features = features;
        this.availability = availability;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Set<String> getFeatures() {
        return features;
    }

    public void setFeatures(Set<String> features) {
        this.features = features;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Room{" +
                "price=" + price +
                ", features=" + features +
                ", availability=" + availability +
                '}';
    }
}
