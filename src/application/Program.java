package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			System.out.print("Room number");
			int number = sc.nextInt();
			System.out.print("Check-in date dd/MM/yyyy");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date dd/MM/yyyy");
			Date checkOut = sdf.parse(sc.next());
			
			
			Reservation reservetion = new Reservation(number, checkIn, checkOut);
			System.out.println("reservation : " + reservetion);
			
			System.out.println();
			System.out.println("enter data to update");
			System.out.print("Check-in date dd/MM/yyyy");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date dd/MM/yyyy");
			checkOut = sdf.parse(sc.next());
			
			reservetion.updateDates(checkIn, checkOut);
			System.out.println("reservation : " + reservetion);
		}
		catch(ParseException e) {
			System.out.println("Invalid date format");
		}
		catch (DomainException e) {
			System.out.println("error in reservation: " + e.getMessage());
		}
		sc.close();
		}
}
