import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("chekin date (dd/mm/aaaa): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("chekout date (dd/mm/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println("enter data to update the reservation:");

            System.out.print("chekin date (dd/mm/aaaa): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("chekout date (dd/mm/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);

            System.out.println(reservation);
        }
        catch (ParseException e) {
            System.out.println("invalid date format");
        }
        catch (Domainexception e) {
            System.out.println("error in reservation: " + e.getMessage());
        }
        catch (InputMismatchException e) {
            System.out.println("typin error");
        }

    }
}