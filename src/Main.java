import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("chekin date (dd/mm/aaaa): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("chekout date (dd/mm/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation : check-out date must be after check-in date.");
        }
        else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println("enter data to update the reservation:");

            System.out.print("chekin date (dd/mm/aaaa): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("chekout date (dd/mm/yyyy): ");
            checkOut = sdf.parse(sc.next());

            String error = reservation.updateDates(checkIn, checkOut);
            if (error != null) {
                System.out.println("error in reservation: " + error);
            }
            else {
                System.out.println(reservation);
            }
        }

    }
}