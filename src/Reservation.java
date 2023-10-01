import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/aaaa");

    public Reservation() {

    }

    public Reservation(Integer roomNumber, Date checkin, Date checkout) {
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }


    public Date getCheckout() {
        return checkout;
    }

    public long duration() {
        long diff = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public String updateDates(Date checkIn, Date checkOut) {
        Date now = new Date();

        if (checkIn.before(now)) {
            return "reservation date for update must be futures date";
        }
        if (!checkOut.after(checkIn)) {
            return "check-out date must be after check-in date.";
        }
        this.checkin = checkIn;
        this.checkout = checkOut;
        return null;
    }

    @Override
    public String toString() {
        return "Reservation: Room " +
                roomNumber +
                ", check-in: " +
                sdf.format(checkin) +
                ", check-out: " +
                sdf.format(checkout) +
                ", " +
                duration() +
                " nigths";

    }

}
