import java.util.Scanner;
public class String_Ornek {
public static void main(String [] args) {
	Scanner oku = new Scanner(System.in);
	int boy;
	
	System.out.println("Boyunuzu Giriniz Lütfen:");
	boy=oku.nextInt();
	
	if (boy<175) {
		System.out.println("Cüce");
	}
	if (boy>175) {
		System.out.println("Deve");
	}
	
}
}
