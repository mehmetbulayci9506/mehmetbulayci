import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

import java.util.Random;
public class SansOyunu {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		/*kullan�lacak de�i�kenler olu�turulmu�tur. kolon 2 boyutlu int t�r�nde bir dizidir bu de�i�ken kullan�c�n�n �ansl� numaralar�
		saklayacak dizidir. cekilis dizisi ise yap�lacak olan �ekili�te �ekilecek olan say�lar� saklamaktad�r. KolonSayisi ise kullan�c�n 
		ka� kolon oynayaca�� sorusuna kar��l�k al�nan say�y� saklayacakt�r. ve secim de�i�keni ise kullan�c�n�n hangi oyunu oynayaca��n� saklayacakt�r.*/
		int kolon[][],cekilis[],KolonSayisi,secim; 
		String OynamaSekli;
		
		/*Men� Yaz�l�r ve kullan�c�ya hangi oyunu oynayaca�� sorulur.*/
		System.out.println("1-On Numara\n" +
						   "2-�ans Topu\n" +
						   "3-S�per Loto\n" +
						   "4-Say�sal Loto");
		
		System.out.println("L�tfen men�den oynamak istedi�iniz oyunu se�iniz.");
		secim = input.nextInt();
		
		/*E�er kullan�c� men�den se�im yapmaz ise bu kod �al���r ve men�den ge�erli bir se�im yapas�ya kadar devam eder.*/
		while(secim < 1 || secim > 4)
		{
			System.out.println("Men�den ge�erli bir se�im yap�n�z:\n");
		
			System.out.println("1-On Numara\n" +
					   "2-�ans Topu\n" +
					   "3-S�per Loto\n" +
					   "4-Say�sal Loto");
	
			System.out.println("L�tfen men�den oynamak istedi�iniz oyunu se�iniz.");
		
			secim = input.nextInt();
		}
		
		/*Kullan�c�ya ka� kolon oynayaca�� sorulur*/
		System.out.println("Ka� kolon oynamak istersiniz.");
		KolonSayisi = input.nextInt();
		
		/*E�er kolon say�s� 1 den k���kse kullan�c�ya ge�erli bir kolon say�s� girmesi s�ylenir.*/
		while(KolonSayisi<1)
		{
			System.out.println("Kolon Say�s� i�in ge�erli bir say� giriniz:");
			KolonSayisi = input.nextInt();
		}
		/*Kolon dizisi olu�turulur*/
		if(secim == 1)/*on numara i�in*/
		{
			kolon = new int[KolonSayisi][10];
			cekilis = new int[22];//On numarada 22 say� �ekilir.
		}
		else/*di�er oyunlar i�in �ans topu 5+1 dir ondan dolay� onun i�inde buras� kullan�lm��t�r.*/
		{
			kolon = new int[KolonSayisi][6];
			cekilis = new int[6];// di�er oyunlar�n hepsinde 6 tane say� �ekilir.
		}
		
		/*Kullanc�ya Nas�l oynamak istedi�i sorulur*/
		System.out.println("Kendiniz mi oynamak istersiniz?(E/H)");
		OynamaSekli = input.next();
		
		OynamaSekli = OynamaSekli.toUpperCase();//e�er kullan�c� "e" veya "h" girerse diye b�y�k harfe d�n��t�r�l�r.
		
		/*e�er kullan�c�n�n girdi�i de�er ge�erli de�ilse ge�erli bir de�er giresiye kadar while d�ng�s� �al���r*/
		while(!OynamaSekli.equals("E")  && !OynamaSekli.equals("H"))
		{
			System.out.println("L�tfen ge�erli bir giri� yap�n�z! Kendiniz mi oynamak istersiniz?(E/H)");
			OynamaSekli = input.next();
		}
		
		if(OynamaSekli.equals("E"))/*e�er kullan�c� E girerse KendinOyna metodu �a�r�l�r.*/
		{
			kolon = KendinOyna(secim,KolonSayisi);
		}
		else/*E�er kullan�c� H girerse MakinayaOynat metodu �a�r�l�r.*/
		{
			kolon = MakinayaOynat(secim,KolonSayisi);
		}
		
		/*CekilisYap metodu �a�r�lr ve d�nen de�er cekilis de�i�kenine atan�r*/
		cekilis = CekilisYap(secim);
		
		
		/*Kullan�c�n enter girmesi beklenir.*/
		System.out.println("Sonuclar� g�rmek i�in ENTER'a bas�n�z!");
		input.nextLine();
		input.nextLine();
		
		/*Ve �ekili� kontrol edilmesi CekilisKontrol metodu �a�r�l�r.*/ 
		CekilisKontrol(kolon,cekilis,secim);
		
	}
	
	/*kullan�c�n�n oynamak istedi�i oyunu bilmek i�in secim parametresi gerekmektedir. Ve kolon say�s� al�nm��t�r.*/
	public static int[][] MakinayaOynat(int secim, int kolon)
	{
		Random randomNum = new Random(); //rastgele say�lar �retilmesi i�in randomNum nesnesi olu�turulmu�tur.
		
		/*iki boyutlu kolonlar dizisi ve rasgetele �retilen say�y� tutmak i�in sayi d�i�keni olu�turulmu�tur.*/
		int kolonlar [][],sayi; 
		/*rastgele �retilen say�y�n�n ayn�s�n�n bir kolonda olmamams� i�in KontrolKolon metodunun d�nd�rd��� de�eri tutmak i�in kullan�lacakt�r.*/
		boolean kontrol;
		
		/*Kullan�c�n�n secimine ve oynamak istedi�i kolon say�s�na g�re kolonlar de�i�kenin boyutlar� belirlenmi�tir.*/
		if(secim == 1)
		{
			kolonlar = new int[kolon][10];
		}
		else
		{
			kolonlar = new int[kolon][6];
		}
		
		/*kolonlar dizisinin her bir eleman� s�f�ra e�itlenir. S�f�ra e�itlenmesindeki mant�k �udur. KontrolKolon metodunu �a��rd���m�z zaman.
		Kolonun taman�n� tarayaca�� i�in bir eleman�n i�inde de�er yoksa program �al��rken hata verecektir. Onu engellemek i�in bu i�lem yap�lmaktad�r.*/
		for(int i = 0; i<kolon; i++)		
			for(int j = 0; j<kolonlar[0].length; j++)
				kolonlar [i][j] = 0;
		
		/*Kolonlar olu�turulmaktad�r.*/
		for(int i = 0; i<kolon; i++)
		{
			//her kolon doldurulmadan �nce j = 0 yap�lm��t�rki o kolonun elemanlar� olu�turulabilsin.
			int j = 0;
			/*�ki for yerine bir for ve bir while olu�turulmu�tur.*/
			while(j<kolonlar[0].length)
			{
				/*Secime g�re �retilecek say� belirlenmi�tir*/
				if(secim == 1 )
				{
					sayi = randomNum.nextInt(80)+1;
				}
				else if(secim == 2 && j == 5)/*�ans topu oyunu i�in ayr�ca bir else if eklenmi�tir +1 say�y� �retebilemk i�in.*/
				{
					sayi = randomNum.nextInt(14)+1;
				}
				else if(secim == 2)
				{
					sayi = randomNum.nextInt(34)+1;
				}
				else if(secim == 3)
				{
					sayi = randomNum.nextInt(54)+1;
				}
				else
				{
					sayi = randomNum.nextInt(49)+1;
				}
				
				/* her say� �retildikten sonra KontrolKolon medtodu �a�r�l�r ve �retilen say� �nceden �retildiyse true d�nd�r�r �retilmediyse false.*/
				
				if(!(secim == 2 && j == 5))/*�ans topu oyunu i�in ayr�ca bir else if eklenmi�tir +1 say�y� �retebilemk i�in.*/
				{
					kontrol = KontrolKolon(kolonlar[i],sayi);
				}
				else
				{
					kontrol = false;
				}
				
				/*E�er sayi daha �nceden �retilmediyse kolonlar de�i�keninin atanmas� gereken eleman�na sayi atanor ve j bir artt�r�l�r.
				e�er �retilen say� daha �nce varsa bu if'in i�ine girilmez ve sayi tekrardan �retilir.*/
				if(!kontrol)
				{
					kolonlar[i][j] = sayi;
					j++;
				}
			}	
		}
		
		/*Ve kolonlar tamamen olu�turulduktan sonra, metodun �a�r�ld��� yere iletilirler.*/
		return kolonlar;
	}
	
	/*kullan�c�n�n oynamak istedi�i oyunu bilmek i�in secim parametresi gerekmektedir. Ve kolon say�s� al�nm��t�r.*/
	public static int[][] KendinOyna(int secim, int kolon)
	{
		/*Kullan�c� sayilar� girece�i i�in Scanner s�n�f�ndan bir nesne olu�turulmu�tur*/
		Scanner input = new Scanner(System.in); 
	
		/*Kullan�c�n giridi�i say�y�n�n ayn�s�n�n bir kolonda olmamams� i�in KontrolKolon metodunun d�nd�rd��� de�eri tutmak i�in kullan�lacakt�r.*/
		boolean kontrol = true;
		/*iki boyutlu kolonlar dizisi ve kullan�c�n�n girdi�i say�y� tutmak i�in sayi d�i�keni olu�turulmu�tur.*/
		int kolonlar [][],sayi;
		
		
		/*Kullan�c�n�n secimine ve oynamak istedi�i kolon say�s�na g�re kolonlar de�i�kenin boyutlar� belirlenmi�tir.*/
		if(secim == 1)
		{
			kolonlar = new int[kolon][10];
		}
		else
		{
			kolonlar = new int[kolon][6];
		}
		
		
		/*kolonlar dizisinin her bir eleman� s�f�ra e�itlenir. S�f�ra e�itlenmesindeki mant�k �udur. KontrolKolon metodunu �a��rd���m�z zaman.
		Kolonun taman�n� tarayaca�� i�in bir eleman�n i�inde de�er yoksa program �al��rken hata verecektir. Onu engellemek i�in bu i�lem yap�lmaktad�r.*/
		for(int i = 0; i<kolon;i++)		
			for(int j = 0; j<kolonlar[0].length; j++)
				kolonlar [i][j] = 0;
				
		/*Kullan�c� kolonlar�n� doldurmaya ba�l�yor.*/
		for(int i = 0; i<kolon;i++)
		{
			System.out.println(i+1 +". kolonu giriniz.\n");
			
			for(int j = 0; j<kolonlar[0].length; j++)
			{
				/*Kullan�c� �ans topu oynuyorsa ve 5 say�y� girdiyse +1 i girmesi i�in yaz�lacak metnin olu�turulmas� i�in yap�lm��t�r.*/
				if(secim == 2 && j == 5) 
				{
					System.out.println(i+1 + ". kolonun + 1'ini  giriniz ");
					sayi =  input.nextInt();
				}
				else
				{
					System.out.println(i+1 + ". kolonun " + (j+1) + ". say�s�n� giriniz ");
					sayi =  input.nextInt();
				}
				
				/*burdaki if else - else if kontrol yap�s�nda kullan�c�n�n girdi�i say�n�n oynad��� oyuna g�re belli aral�kta olmas�n� kontrol ediyor  */
				if(secim == 1)//on numara oynuyor ise kullan�c��n girdi�i say� 1-80 say� k�mesinden olmal�
				{
					while(sayi<1 || sayi>80)
					{
						System.out.println("\nL�tfen girdi�iniz say� 1-80 say� k�mesinden olmal�d�r");
						System.out.println(i+1 + ". kolonun " + j+1 + ". say�s�n� giriniz ");
						sayi =  input.nextInt();
					}
					
					kontrol = KontrolKolon(kolonlar[i],sayi);
				}
				else if(secim == 2 && j == 5) //�ans topu oynuyor ve +1 i giriyorsa say� 1-14 say� k�msesinden olmal�.
				{
					while(sayi<1 || sayi>14)
					{
						System.out.println("\nL�tfen girdi�iniz say� 1-14 say� k�mesinden olmal�d�r");
						System.out.println(i+1 + ". kolonun + 1'ini  giriniz ");
						sayi =  input.nextInt();
					}
				}
				else if(secim == 2) // �ans topu oynuyorsa sayi 1-34 say� k�mesinden olmal�.
				{
					while(sayi<1 || sayi>34)
					{
						System.out.println("\nL�tfen girdi�iniz say� 1-34 say� k�mesinden olmal�d�r");
						System.out.println(i+1 + ". kolonun " + j+1 + ". say�s�n� giriniz ");
						sayi =  input.nextInt();
					}
					
					kontrol = KontrolKolon(kolonlar[i],sayi);
				}
				else if(secim == 3) // s�per loto oynuyorsa sayi 1-54 sayi k�mesinden olmal�
				{
					while(sayi<1 || sayi>54)
					{
						System.out.println("\nL�tfen girdi�iniz say� 1-54 say� k�mesinden olmal�d�r");
						System.out.println(i+1 + ". kolonun " + j+1 + ". say�s�n� giriniz ");
						sayi =  input.nextInt();
					}
					
					kontrol = KontrolKolon(kolonlar[i],sayi);
				}
				else //sayisal loto oynuyorsa sayi 1-49 sayi k�mesinden olmal�d�r.
				{
					while(sayi<1 || sayi>49)
					{
						System.out.println("\nL�tfen girdi�iniz say� 1-49 say� k�mesinden olmal�d�r");
						System.out.println(i+1 + ". kolonun " + j+1 + ". say�s�n� giriniz ");
						sayi =  input.nextInt();
					}
					
					kontrol = KontrolKolon(kolonlar[i],sayi); // kullan�c�n�n girdi�i say� tekrar girmesin diye kontrol yap�lmaktad�r.
				}
				
				
				if(kontrol)// e�er kullan�c� ayn� say�y� girmi�se bu ifin i�ine girer ve kullan�c� uyar�l�r. tekrardan ayn� say�y� girmesi i�inde j bir azalt�l�r.
				{
					System.out.println("Bir kolonda ayn� say�dan iki tane olamaz.");
					j--;
				}
				else// e�er kullan�c� var olan bir say�y� girmediyse say� gerekli yere atan�r.
				{
					kolonlar[i][j] = sayi;
				}
			}
		}
		
		return kolonlar;
	}
	
	/*Kullan�c�n�n girdi�i veya rastgele �retilen say�n�n tekrardan kolona yaz�lmamas� i�in bu metod kullan�lm��t�r.*/	
	public static boolean KontrolKolon(int kolon[], int kontrolSayi)
	{
		boolean kontrol = false;
		
		for(int i = 0; i< kolon.length;i++)
		{
			if(kolon[i] == kontrolSayi)
				kontrol = true;
		}
		
		return kontrol;		
	}
	
	/*�ekili�in yap�ld��� metod*/
	public static int[] CekilisYap(int secim)
	{
		Random randomNum = new Random();
		int kolon[],sayi;
		boolean kontrol;
		
		if(secim == 1)//On numara �ekili�inde 22 say� �ekiliyor. ve ona g�re dizi olu�turuluyor
		{
			kolon = new int[22];
		}
		else
		{
			kolon = new int[6];
		}
		
		/*Kontrolde s�k�t� ya�amamk i�in hepsi s�f�ra atan�yor*/
		for(int i = 0; i<kolon.length; i++) 
		{
			kolon[i] = 0;
		}
		
		int i = 0;
	
		while(i < kolon.length) //Kullan�c�n oynad��� oyuna g�re �ekili� yap�l�yor
		{
			if(secim == 1 )
			{
				sayi = randomNum.nextInt(80)+1;
			}
			else if(secim == 2 && i == 5)
			{
				sayi = randomNum.nextInt(14)+1;
			}
			else if(secim == 2)
			{
				sayi = randomNum.nextInt(34)+1;
			}
			else if(secim == 3)
			{
				sayi = randomNum.nextInt(54)+1;
			}
			else
			{
				sayi = randomNum.nextInt(49)+1;
			}
			
			if(!(secim == 2 && i == 5))/*�ans topu oyunu i�in ayr�ca bir else if eklenmi�tir +1 say�y� �retebilemk i�in.*/
			{
				kontrol = KontrolKolon(kolon,sayi);
			}
			else
			{
				kontrol = false;
			}
			
			if(!kontrol)
			{
				kolon[i] = sayi;
				i++;
			}
		}
	
		return kolon;
	}

	/*�ekili� sonucunda hangi kolondan ka� tuttu�unun hesaplan�p g�sterilmesi. */ 
	public static void CekilisKontrol(int kolonlar[][], int cekilis [], int secim)
	{
		int tutanSayisi,artiBir;
		System.out.println("�ans� Numaralar:");
	
		for(int i = 0; i<cekilis.length; i++)
		{
			/*�ekili� sonucunda �ekilen say�lar� d�zg�n g�stermek i�in yaz�lm��t�r*/
			if(secim == 2 && i == 5)
			{
				System.out.print(" + " + cekilis[i]);
			}
			else
			{
				if(i != 0)
				{
					System.out.print("-" + cekilis[i]);
				}
				else{
					
					System.out.print( cekilis[i]);
					
				}
				
			}
		}
		
		System.out.println("\n");
		
		/*Gerekli kar��la�t�rmalar� yap�p sonuclar� g�sterir*/
		for(int i = 0; i<kolonlar.length; i++)
		{
			tutanSayisi = 0;
			artiBir = 0;
			System.out.print(i+1 + ". Kolon = ");
			
			for(int j = 0; j<kolonlar[0].length; j++)
			{
				System.out.print(kolonlar[i][j] + "-");
				
				if(secim == 2 && j == 5)
				{
					if(kolonlar[i][j] == cekilis[j])
						artiBir++;
				}
				else
				{
					for(int k = 0; k<cekilis.length; k++)
					{
						if(kolonlar[i][j] == cekilis[k])
							tutanSayisi++;
					}
				}
			}
			System.out.println();
			if(secim == 2)
			{
				System.out.println(i+1 + ". kolonunuzdan " + tutanSayisi + "+" + artiBir + "Tutmu�tur.");
			}
			else
			{
				System.out.println(i+1 + ". kolonunuzdan " + tutanSayisi + " tutmu�tur.");
			}
			System.out.println();
		}
	}
}
