package application;

import model.entities.Reservation;
import model.entities.enums.exceptions.services.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.println("Room number: ");
            int number = input.nextInt();

            System.out.println("Check in date (dd/MM/yyyy)");
            Date checkIn = sdf.parse(input.next());

            System.out.println("Chek out date (mm/MM/yyyy)");
            Date checkOut = sdf.parse(input.next());


            System.out.println("Error in reservation, check out date must be after check in date");

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservatiion: " + reservation);


            System.out.println("Update datas: ");
            System.out.println("Check in date (dd/MM/yyyy)");
            checkIn = sdf.parse(input.next());

            System.out.println("Chek out date (mm/MM/yyyy)");
            checkOut = sdf.parse(input.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("reservation: " + reservation);
        } catch (ParseException e) {
            System.out.println("Invalid date format");
        } catch (DomainException e){
            System.out.println("Error in reservation: " + e.getMessage());
        } catch (RuntimeException r){
            System.out.println("Unxpected error");
        }


    }
}