import java.util.Scanner;
public class En_buyuk_sayi {
	public static void main (String [] args) {
		Scanner oku = new Scanner(System.in);
		
		int a,b,c,en_b�y�k = 0 ,secim;
		System.out.println("1-En B�y�k Se�im/n2-En K���k Se�im");
        secim = oku.nextInt();
		
        System.out.println("L�tfen 3 Say� Giriniz.");
		a=oku.nextInt();
		b=oku.nextInt();
		c=oku.nextInt();
        
		if(secim==1) {
		if (a>b && a>c) {
			en_b�y�k=a;
		}
		else if (b>a && b>c) {
			en_b�y�k=b;
		}
		else if (c>b && c>a) {
			en_b�y�k=c;
		}
		System.out.println("En B�y�k Say�:"+en_b�y�k);
		}
		if(secim==2) {
			if (a<b && a<c) {
				en_b�y�k=a;
			}
			else if (b<a && b<c) {
				en_b�y�k=b;
			}
			else if (c<b && c<a) {
				en_b�y�k=c;
			}
			System.out.println("En K���k Say�:"+en_b�y�k);
			}
	}
}
