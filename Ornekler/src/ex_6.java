import java.util.Scanner;
public class ex_6 {
	public static void main(String [] args) {
		Scanner oku = new Scanner(System.in);
		int sayi = 0, toplam=0,sayac = 0;
		double ortalama;
		    while(sayi>=0) {
			System.out.println("L�tfen Say�lar� giriniz");
			sayi=oku.nextInt();
			toplam+=sayi;
			sayac++;
			ortalama = toplam/sayac;
			
			
			
		    if (sayi!=+sayi) {
		    	System.out.println("Programdan ��kt�n�z");
			}
		    
		    System.out.println("Sonuc:" +ortalama);
		    
		    }
		
	}
	
}
