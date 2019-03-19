import java.util.Scanner;
public class En_buyuk_sayi {
	public static void main (String [] args) {
		Scanner oku = new Scanner(System.in);
		
		int a,b,c,en_büyük = 0 ,secim;
		System.out.println("1-En Büyük Seçim/n2-En Küçük Seçim");
        secim = oku.nextInt();
		
        System.out.println("Lütfen 3 Sayý Giriniz.");
		a=oku.nextInt();
		b=oku.nextInt();
		c=oku.nextInt();
        
		if(secim==1) {
		if (a>b && a>c) {
			en_büyük=a;
		}
		else if (b>a && b>c) {
			en_büyük=b;
		}
		else if (c>b && c>a) {
			en_büyük=c;
		}
		System.out.println("En Büyük Sayý:"+en_büyük);
		}
		if(secim==2) {
			if (a<b && a<c) {
				en_büyük=a;
			}
			else if (b<a && b<c) {
				en_büyük=b;
			}
			else if (c<b && c<a) {
				en_büyük=c;
			}
			System.out.println("En Küçük Sayý:"+en_büyük);
			}
	}
}
