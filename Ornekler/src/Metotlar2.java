import java.util.Scanner;
public class Metotlar2 {
	public static void main(String [] args) {
		
		/*String merhaba;
		merhaba=MerhabaDunya("Ýsim Giriniz");
		System.out.println("\n\n isimiz:" + merhaba);
		merhaba=MerhabaDunya("Soyisim Giriniz");
		System.out.println("\n\n isimiz:" + merhaba);*/
		
		int sayi1;
		boolean durum;
		sayi1=SayiGir();
		durum = Kontrol(sayi1);
		if (durum) 
			System.out.println("Girdiniz sayi Çifttir");
		else
			System.out.println("Girdiginiz Sayi tektir");
	}
	
	public static int SayiGir() {
		Scanner oku = new Scanner(System.in);
		int sayi;
		System.out.println("Bir sayi giriniz");
		sayi=oku.nextInt();
		return sayi;
	}
	public static boolean Kontrol(int CTSayi) {
		if (CTSayi%2==0) 
			return true;
			else
		      return false;
		
	}
	
	public static String MerhabaDunya(String istenilen) {
		Scanner oku = new Scanner(System.in);
		String isim;
		System.out.println(istenilen);
		isim = oku.next();
		return isim;
	}
}
