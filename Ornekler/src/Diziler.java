import java.util.Scanner;
public class Diziler {
	public static void main(String[] args) {
		Scanner oku = new Scanner(System.in);
		
		int array[] = new int [5];
	   int toplam=0;
	   double ortalama;
		for (int i = 0; i < 5; i++) {
			System.out.println(i+1 + ".Sayisini Giriniz:");
			array[i] = oku.nextInt();
			System.out.println();
		}
		for (int i = 0; i < 5; i++) {
			toplam+=array[i]; // toplam = toplam + Array[i]
		}
		 ortalama = (double)toplam/5;
		 System.out.println("Ortalama" + ortalama);
		 
	}
}
