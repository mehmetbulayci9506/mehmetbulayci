import java.util.Scanner;
public class Kdv_Hesap {
public static void main(String [] args) {
	Scanner oku = new Scanner(System.in);
	
	int fiyat ,kdv ,secim = 0 ;
	
	System.out.println("L�tfen Se�in yap�n�z.");
	System.out.println("/n1- KDV Hesaplamas� ��in/n2 ��k�� ��in T�klay�n�z");
    secim=oku.nextInt();

	
	if(secim==1) {
		System.out.println("L�tfen Fiyat Giriniz:");
		fiyat=oku.nextInt();
		kdv=fiyat+(fiyat*18)/100;
	     System.out.println("KDV'li Fiyat:" + kdv);
	}
	if(secim==2) {
		System.out.println("Programdan ��kt�n�z.");
	}
	oku.nextLine();
	System.out.println("L�tfen Se�in yap�n�z.");
	System.out.println("/n1- KDV Hesaplamas� ��in/n2 ��k�� ��in T�klay�n�z");
    secim=oku.nextInt();
  
 }
  
}

