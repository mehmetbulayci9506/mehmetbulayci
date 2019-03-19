import java.util.Scanner;
public class Kdv_Hesap {
public static void main(String [] args) {
	Scanner oku = new Scanner(System.in);
	
	int fiyat ,kdv ,secim = 0 ;
	
	System.out.println("Lütfen Seçin yapýnýz.");
	System.out.println("/n1- KDV Hesaplamasý Ýçin/n2 Çýkýþ Ýçin Týklayýnýz");
    secim=oku.nextInt();

	
	if(secim==1) {
		System.out.println("Lütfen Fiyat Giriniz:");
		fiyat=oku.nextInt();
		kdv=fiyat+(fiyat*18)/100;
	     System.out.println("KDV'li Fiyat:" + kdv);
	}
	if(secim==2) {
		System.out.println("Programdan Çýktýnýz.");
	}
	oku.nextLine();
	System.out.println("Lütfen Seçin yapýnýz.");
	System.out.println("/n1- KDV Hesaplamasý Ýçin/n2 Çýkýþ Ýçin Týklayýnýz");
    secim=oku.nextInt();
  
 }
  
}

