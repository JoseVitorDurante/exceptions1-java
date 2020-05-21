package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number");
		int number = sc.nextInt();
		System.out.print("Check-in date dd/MM/yyyy");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date dd/MM/yyyy");
		Date checkOut = sdf.parse(sc.next());
		
		
		if (!checkOut.after(checkIn)) {
			System.out.println("error in reservation date");
		}
		
		else{
			Reservation reservetion = new Reservation(number, checkIn, checkOut);
			System.out.println("reservation : " + reservetion);
			
			System.out.println();
			System.out.println("enter data to update");
			System.out.print("Check-in date dd/MM/yyyy");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date dd/MM/yyyy");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("error precisa ser datas futuras");
			}
			else if (!checkOut.after(checkIn)) {
				System.out.println("error in reservation date");
			}
			else {
			reservetion.updateDates(checkIn, checkOut);
			System.out.println("reservation : " + reservetion);
			}
			
		}
		
		
		sc.close();
	}

}
