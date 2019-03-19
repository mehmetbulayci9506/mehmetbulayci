import java.util.Scanner;
public class Metotlar1 {
public static void main(String [] args) {
	Scanner oku  = new Scanner(System.in);
	int sayi;
	
	System.out.println("Hangi Sayýnýn Faktöriyeli Girilsin?");
   sayi = oku.nextInt();
	MerhabaDunya(sayi);
	
	
}
public static void MerhabaDunya(int kac) {
	int faktoriyel =1;
	for(int i =1 ;i<=kac;i++)
	faktoriyel = faktoriyel*i;
	System.out.println(faktoriyel);
}

}
