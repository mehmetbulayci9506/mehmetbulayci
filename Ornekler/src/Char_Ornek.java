import java.util.Scanner;
public class Char_Ornek {
	public static void main (String [] args) {
		Scanner oku = new Scanner(System.in);
	
	String mehmet,kontrol;
	System.out.println("Harf Giriniz:");
	mehmet = oku.nextLine();
	
	if(mehmet!=mehmet.toUpperCase() ) {
		mehmet =mehmet.toUpperCase();
		System.out.println(mehmet);
	}
	}
	
}
