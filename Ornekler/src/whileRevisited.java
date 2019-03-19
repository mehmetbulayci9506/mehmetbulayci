import java.util.Scanner;
public class whileRevisited {
public static void main(String [] args) {
	Scanner oku = new Scanner(System.in);
	double ortalama,sayi =0,toplam=0;
	int sayac=0;

	while(sayi!=-1) {
		System.out.print("Bir Sayý Giriniz:");
		sayi = oku.nextDouble();
		toplam += sayi;
		sayac++;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*System.out.print("Bir Sayý Giriniz:");
	sayi = oku.nextDouble();
	sayac++;
	while (sayi !=-1) {
		toplam +=sayi;
		System.out.print("Bir Sayý Giriniz:");
		sayi = oku.nextDouble();
           if(sayi !=-1)
        	   sayac++;
	}
	ortalama = toplam/sayac;
	System.out.println("Ýlk Ortalama =" + ortalama);*/
	
	
}
}
