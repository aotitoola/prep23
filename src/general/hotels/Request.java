package general.hotels;

import java.util.Set;

public class Request {

    private int checkIn;
    private int checkOut;
    private Set<String> features;
    private int rooms;

    public Request(int checkIn, int checkOut, Set<String> features, int rooms) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.features = features;
        this.rooms = rooms;
    }

    public int getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(int checkIn) {
        this.checkIn = checkIn;
    }

    public int getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(int checkOut) {
        this.checkOut = checkOut;
    }

    public Set<String> getFeatures() {
        return features;
    }

    public void setFeatures(Set<String> features) {
        this.features = features;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }
}
