import java.util.Scanner;
public class PalindromOrnek {
public static void main (String [] args) {
	Scanner oku = new Scanner(System.in);
	String kelime;
	System.out.println("Lütfen Kontrol Ýçin Kelimeyi Giriniz.");
	kelime = oku.nextLine();
	int uzunluk=kelime.length();
	String tersi="";
	
	for(int i=uzunluk-1;i>=0;i--) {
		tersi=tersi+kelime.charAt(i);
		System.out.println("Tersi : "+tersi);
	}
	if(kelime.equals(tersi)) // string ifade birebir eþleþiyormu ?
	{
	    System.out.println("Palindrom");

	}  else
	{
	  System.out.println("Palindrom degil");
	}
	    }
	
}

