import java.util.Scanner;
public class Kontrol_Etme {
	public static void main(String []args) {
		Scanner oku = new Scanner(System.in);
		String name ="mert", surname="bulayci";
		String Ad,soyad;
		System.out.println("Adýmý Giriniz:");
		Ad = oku.nextLine();
		System.out.println("Soyadýmý Giriniz:");
		soyad = oku.nextLine();
		
		if(name.equals(Ad) && surname.equals(soyad)) {
			System.out.println("Ýsmim ve Soyadým Dogru");
		}
		else
		System.out.println("Ýsmin ve soyadým yanlýþ");
		
	}
	
}
