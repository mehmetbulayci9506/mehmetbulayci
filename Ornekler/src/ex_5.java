import java.util.Scanner;
public class ex_5 {
public static void main(String [] args) {
	Scanner oku = new Scanner(System.in);
	int alinan_not;
	System.out.println("L�tfen Ald�g�n�z Notu Giriniz:");
	alinan_not = oku.nextInt();
	
	while(alinan_not<0 || alinan_not>100) {
		System.out.println("L�tfen Ge�erli Bir Not Giriniz.");
		System.out.println("L�tfen Ald�g�n�z Notu Giriniz:");
		alinan_not = oku.nextInt();
	}
	if (alinan_not<25) {
		System.out.println("Zay�f Not.");
	}
	else if (alinan_not>25 && alinan_not<50) {
		System.out.println("Orta Not.");
	}
	else if (alinan_not>50 && alinan_not<75) {
		System.out.println("�Y� Not.");
	}
	if (alinan_not>75 && alinan_not<=100) {
		System.out.println("Pek iyi Not.");
	}
	
}
}
