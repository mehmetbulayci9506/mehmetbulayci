import java.util.Scanner;		
public class Saymak {
public static void main(String [] args) {
	Scanner oku = new Scanner(System.in);
	int sayi,sayac;
	System.out.println("L�tfen Ka�a Kadar say�ls�n?");
	sayi = oku.nextInt();
	for (int i = 1; i <= sayi; i++) {
		
		System.out.print(i +"-");
	}
}
}
