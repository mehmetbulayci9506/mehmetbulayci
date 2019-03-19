import java.util.Scanner;



import java.awt.Menu;
import java.util.Random;
public class MetotHesapMak {
public static void main(String [] args) {
	double sayi1,sayi2,sonuc;
	int secim,faktoriyel ;
	
	do {
		
		secim=MenuDegerAl();
		
		switch(secim) {
		case 1:
			sayi1=OndalikSayiAl();
			sayi2=OndalikSayiAl();
			sonuc = Toplama(sayi1,sayi2);
			SonucGoster(sonuc);
			break;
		case 2:
			sayi1=OndalikSayiAl();
			sayi2=OndalikSayiAl();
			sonuc = Çikarma(sayi1,sayi2);
			SonucGoster(sonuc);
			break;
		case 3:
			sayi1=OndalikSayiAl();
			sayi2=OndalikSayiAl();
			sonuc = Carpma(sayi1,sayi2);
			SonucGoster(sonuc);
			break;
		case 4:
			sayi1=OndalikSayiAl();
			sayi2=OndalikSayiAl();
			sonuc = Bolme(sayi1,sayi2);
			SonucGoster(sonuc);
			break;
		case 5:
			faktoriyel=TamSayiAl();
			sonuc = FaktoriyelHesapla(faktoriyel);
			SonucGoster(sonuc);
			
			break;
		case 6:
			faktoriyel = TamSayiAl();
			sonuc = RastgeleSsayiUret(faktoriyel);
			SonucGoster(sonuc);
			
			break;
			default:
			System.out.println("Hesap makinesindi kullandýgýnýz için tþk");
			break;
		}
		
	}while(secim!=7);
	System.out.println("Çýkýþ Yaptýnýz");
}
public static void MenuGoster() {
	System.out.println("1-Toplama/2n-Çýkarma/n3-Çarma/n4-Bölme/n5-Faktöriyel/n6-Rastele Sayý/n7 Çýkýþ");
}
public static int MenuDegerAl() {
	Scanner oku = new Scanner(System.in);
	int sayi;
	MenuGoster();
	sayi=oku.nextInt();
	
	while(sayi <1 || sayi > 7) {
		MenuGoster();
		System.out.println("\nLütfen Menüden GEçerli Secim Yapýnýz!:");
		sayi=oku.nextInt();
	}
	return sayi;
}
public static double OndalikSayiAl(){
	Scanner oku = new Scanner(System.in);
	double sayi;
	System.out.println("Bir Ondalýk Sayi Giriniz:");
	sayi=oku.nextDouble();
	return sayi;
	}
public static double Toplama(double num1,double num2) {
	return num1+num2;
}
public static double Çikarma(double num1,double num2) {
	return num1-num2;
}
public static double Carpma(double num1,double num2) {
	return num1*num2;
}
public static double Bolme(double num1,double num2) {
	return num1/num2;
}
public static int TamSayiAl() {
	Scanner oku = new Scanner(System.in);
	int sayi;
	System.out.println("Lütfen Fak olmasýný istediginiz Sayiyi Giriniz:");
	sayi=oku.nextInt();
	return sayi;
}public static int FaktoriyelHesapla(int num) {
	Scanner oku = new Scanner(System.in);
	int faktoriyel=1;
	for(int i=1;i<=num;i++)
		faktoriyel*=i;
	 
	return faktoriyel;
}
public static int RastgeleSsayiUret(int num) {
	Random randomnum = new Random();
	return randomnum.nextInt(num);
}
public static void SonucGoster(double num) {
	System.out.println("Ýþleminizin Sonucu:" + num);
}

}
