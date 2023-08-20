package general.streamAggregation;

public class Hotel {

    private long hotelId;
    private String hotel_area_code;
    private String unique_user_id;
    private boolean user_logged_in;

    public Hotel(long hotelId, String hotel_area_code, String unique_user_id, boolean user_logged_in) {
        this.hotelId = hotelId;
        this.hotel_area_code = hotel_area_code;
        this.unique_user_id = unique_user_id;
        this.user_logged_in = user_logged_in;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotel_area_code() {
        return hotel_area_code;
    }

    public void setHotel_area_code(String hotel_area_code) {
        this.hotel_area_code = hotel_area_code;
    }

    public String getUnique_user_id() {
        return unique_user_id;
    }

    public void setUnique_user_id(String unique_user_id) {
        this.unique_user_id = unique_user_id;
    }

    public boolean isUser_logged_in() {
        return user_logged_in;
    }

    public void setUser_logged_in(boolean user_logged_in) {
        this.user_logged_in = user_logged_in;
    }
}
