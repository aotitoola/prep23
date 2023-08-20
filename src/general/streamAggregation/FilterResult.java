package general.streamAggregation;

public class FilterResult {
    private String hotel_area_code;
    private long hotelId;
    private int views;

    public FilterResult(String hotel_area_code, long hotelId, int views) {
        this.hotel_area_code = hotel_area_code;
        this.hotelId = hotelId;
        this.views = views;
    }

    public String getHotel_area_code() {
        return hotel_area_code;
    }

    public void setHotel_area_code(String hotel_area_code) {
        this.hotel_area_code = hotel_area_code;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "FilterResult{" +
                "hotel_area_code='" + hotel_area_code + '\'' +
                ", hotelId=" + hotelId +
                ", views=" + views +
                '}';
    }
}
