import java.util.Scanner;
public class Ay_Kontrol {
	public static void main(String []args) {
		Scanner oku = new Scanner(System.in);
		int secim;
		System.out.println("Yılın Kaçıncı Aydındayız?");
		secim=oku.nextInt();
		
		while(1>secim || 12<secim) {
			System.out.println("Yanlış bir rakam Girdiniz:");
			System.out.println("Yılın Kaçıncı Aydındayız?");
			secim=oku.nextInt();
		}
		
		if(secim ==1)
			System.out.println("Ocak");
		else if(secim ==2)
			System.out.println("Şubat");
		else if(secim ==3)
			System.out.println("MArt");
		else if(secim ==4)
			System.out.println("Nisan");
		else if(secim ==5)
			System.out.println("Mayıs");
		else if(secim ==6)
			System.out.println("Haziran");
		else if(secim ==7)
			System.out.println("Temmuz");
		else if(secim ==8)
			System.out.println("Agustos");
		else if(secim ==9)
			System.out.println("Eylül");
		else if(secim ==10)
			System.out.println("Ekim");
		else  if(secim ==11)
			System.out.println("KAsım");
		if(secim ==12)
			System.out.println("Aralık");
		oku.nextLine();
		oku.nextLine();
	
		System.out.println("Yılın Kaçıncı Aydındayız?");
		secim=oku.nextInt();
		
}

}