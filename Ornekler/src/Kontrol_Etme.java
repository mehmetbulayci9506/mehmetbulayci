import java.util.Scanner;
public class Kontrol_Etme {
	public static void main(String []args) {
		Scanner oku = new Scanner(System.in);
		String name ="mert", surname="bulayci";
		String Ad,soyad;
		System.out.println("Ad�m� Giriniz:");
		Ad = oku.nextLine();
		System.out.println("Soyad�m� Giriniz:");
		soyad = oku.nextLine();
		
		if(name.equals(Ad) && surname.equals(soyad)) {
			System.out.println("�smim ve Soyad�m Dogru");
		}
		else
		System.out.println("�smin ve soyad�m yanl��");
		
	}
	
}
