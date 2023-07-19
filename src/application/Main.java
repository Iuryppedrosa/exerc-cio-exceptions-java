package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Room number: ");
        int number = input.nextInt();

        System.out.println("Check in date (dd/MM/yyyy)");
        Date checkIn = sdf.parse(input.next());

        System.out.println("Chek out date (mm/MM/yyyy)");
        Date checkOut = sdf.parse(input.next());

        if(!checkOut.after(checkIn)){
            System.out.println("Error in reservation, check out date must be after check in date");
        }else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservatiion: " + reservation);


            System.out.println(

            );

            System.out.println("Update datas: ");
            System.out.println("Check in date (dd/MM/yyyy)");
            checkIn = sdf.parse(input.next());

            System.out.println("Chek out date (mm/MM/yyyy)");
            checkOut = sdf.parse(input.next());

            String error =  reservation.updateDates(checkIn, checkOut);

            if(error != null){
                System.out.println("Error ir reservation: " + error);
            } else {
                System.out.println("Reservation : " + reservation);
            }


        }

    }
}