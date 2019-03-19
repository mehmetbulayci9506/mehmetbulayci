import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

import java.util.Random;
public class SansOyunu {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		/*kullanýlacak deðiþkenler oluþturulmuþtur. kolon 2 boyutlu int türünde bir dizidir bu deðiþken kullanýcýnýn þanslý numaralarý
		saklayacak dizidir. cekilis dizisi ise yapýlacak olan çekiliþte çekilecek olan sayýlarý saklamaktadýr. KolonSayisi ise kullanýcýn 
		kaç kolon oynayacaðý sorusuna karþýlýk alýnan sayýyý saklayacaktýr. ve secim deðiþkeni ise kullanýcýnýn hangi oyunu oynayacaðýný saklayacaktýr.*/
		int kolon[][],cekilis[],KolonSayisi,secim; 
		String OynamaSekli;
		
		/*Menü Yazýlýr ve kullanýcýya hangi oyunu oynayacaðý sorulur.*/
		System.out.println("1-On Numara\n" +
						   "2-Þans Topu\n" +
						   "3-Süper Loto\n" +
						   "4-Sayýsal Loto");
		
		System.out.println("Lütfen menüden oynamak istediðiniz oyunu seçiniz.");
		secim = input.nextInt();
		
		/*Eðer kullanýcý menüden seçim yapmaz ise bu kod çalýþýr ve menüden geçerli bir seçim yapasýya kadar devam eder.*/
		while(secim < 1 || secim > 4)
		{
			System.out.println("Menüden geçerli bir seçim yapýnýz:\n");
		
			System.out.println("1-On Numara\n" +
					   "2-Þans Topu\n" +
					   "3-Süper Loto\n" +
					   "4-Sayýsal Loto");
	
			System.out.println("Lütfen menüden oynamak istediðiniz oyunu seçiniz.");
		
			secim = input.nextInt();
		}
		
		/*Kullanýcýya kaç kolon oynayacaðý sorulur*/
		System.out.println("Kaç kolon oynamak istersiniz.");
		KolonSayisi = input.nextInt();
		
		/*Eðer kolon sayýsý 1 den küçükse kullanýcýya geçerli bir kolon sayýsý girmesi söylenir.*/
		while(KolonSayisi<1)
		{
			System.out.println("Kolon Sayýsý için geçerli bir sayý giriniz:");
			KolonSayisi = input.nextInt();
		}
		/*Kolon dizisi oluþturulur*/
		if(secim == 1)/*on numara için*/
		{
			kolon = new int[KolonSayisi][10];
			cekilis = new int[22];//On numarada 22 sayý çekilir.
		}
		else/*diðer oyunlar için þans topu 5+1 dir ondan dolayý onun içinde burasý kullanýlmýþtýr.*/
		{
			kolon = new int[KolonSayisi][6];
			cekilis = new int[6];// diðer oyunlarýn hepsinde 6 tane sayý çekilir.
		}
		
		/*Kullancýya Nasýl oynamak istediði sorulur*/
		System.out.println("Kendiniz mi oynamak istersiniz?(E/H)");
		OynamaSekli = input.next();
		
		OynamaSekli = OynamaSekli.toUpperCase();//eðer kullanýcý "e" veya "h" girerse diye büyük harfe dönüþtürülür.
		
		/*eðer kullanýcýnýn girdiði deðer geçerli deðilse geçerli bir deðer giresiye kadar while döngüsü çalýþýr*/
		while(!OynamaSekli.equals("E")  && !OynamaSekli.equals("H"))
		{
			System.out.println("Lütfen geçerli bir giriþ yapýnýz! Kendiniz mi oynamak istersiniz?(E/H)");
			OynamaSekli = input.next();
		}
		
		if(OynamaSekli.equals("E"))/*eðer kullanýcý E girerse KendinOyna metodu çaðrýlýr.*/
		{
			kolon = KendinOyna(secim,KolonSayisi);
		}
		else/*Eðer kullanýcý H girerse MakinayaOynat metodu çaðrýlýr.*/
		{
			kolon = MakinayaOynat(secim,KolonSayisi);
		}
		
		/*CekilisYap metodu çaðrýlr ve dönen deðer cekilis deðiþkenine atanýr*/
		cekilis = CekilisYap(secim);
		
		
		/*Kullanýcýn enter girmesi beklenir.*/
		System.out.println("Sonuclarý görmek için ENTER'a basýnýz!");
		input.nextLine();
		input.nextLine();
		
		/*Ve çekiliþ kontrol edilmesi CekilisKontrol metodu çaðrýlýr.*/ 
		CekilisKontrol(kolon,cekilis,secim);
		
	}
	
	/*kullanýcýnýn oynamak istediði oyunu bilmek için secim parametresi gerekmektedir. Ve kolon sayýsý alýnmýþtýr.*/
	public static int[][] MakinayaOynat(int secim, int kolon)
	{
		Random randomNum = new Random(); //rastgele sayýlar üretilmesi için randomNum nesnesi oluþturulmuþtur.
		
		/*iki boyutlu kolonlar dizisi ve rasgetele üretilen sayýyý tutmak için sayi dðiþkeni oluþturulmuþtur.*/
		int kolonlar [][],sayi; 
		/*rastgele üretilen sayýyýnýn aynýsýnýn bir kolonda olmamamsý için KontrolKolon metodunun döndürdüðü deðeri tutmak için kullanýlacaktýr.*/
		boolean kontrol;
		
		/*Kullanýcýnýn secimine ve oynamak istediði kolon sayýsýna göre kolonlar deðiþkenin boyutlarý belirlenmiþtir.*/
		if(secim == 1)
		{
			kolonlar = new int[kolon][10];
		}
		else
		{
			kolonlar = new int[kolon][6];
		}
		
		/*kolonlar dizisinin her bir elemaný sýfýra eþitlenir. Sýfýra eþitlenmesindeki mantýk þudur. KontrolKolon metodunu çaðýrdýðýmýz zaman.
		Kolonun tamanýný tarayacaðý için bir elemanýn içinde deðer yoksa program çalþýrken hata verecektir. Onu engellemek için bu iþlem yapýlmaktadýr.*/
		for(int i = 0; i<kolon; i++)		
			for(int j = 0; j<kolonlar[0].length; j++)
				kolonlar [i][j] = 0;
		
		/*Kolonlar oluþturulmaktadýr.*/
		for(int i = 0; i<kolon; i++)
		{
			//her kolon doldurulmadan önce j = 0 yapýlmýþtýrki o kolonun elemanlarý oluþturulabilsin.
			int j = 0;
			/*Ýki for yerine bir for ve bir while oluþturulmuþtur.*/
			while(j<kolonlar[0].length)
			{
				/*Secime göre üretilecek sayý belirlenmiþtir*/
				if(secim == 1 )
				{
					sayi = randomNum.nextInt(80)+1;
				}
				else if(secim == 2 && j == 5)/*Þans topu oyunu için ayrýca bir else if eklenmiþtir +1 sayýyý üretebilemk için.*/
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
				
				/* her sayý üretildikten sonra KontrolKolon medtodu çaðrýlýr ve üretilen sayý önceden üretildiyse true döndürür üretilmediyse false.*/
				
				if(!(secim == 2 && j == 5))/*Þans topu oyunu için ayrýca bir else if eklenmiþtir +1 sayýyý üretebilemk için.*/
				{
					kontrol = KontrolKolon(kolonlar[i],sayi);
				}
				else
				{
					kontrol = false;
				}
				
				/*Eðer sayi daha önceden üretilmediyse kolonlar deðiþkeninin atanmasý gereken elemanýna sayi atanor ve j bir arttýrýlýr.
				eðer üretilen sayý daha önce varsa bu if'in içine girilmez ve sayi tekrardan üretilir.*/
				if(!kontrol)
				{
					kolonlar[i][j] = sayi;
					j++;
				}
			}	
		}
		
		/*Ve kolonlar tamamen oluþturulduktan sonra, metodun çaðrýldýðý yere iletilirler.*/
		return kolonlar;
	}
	
	/*kullanýcýnýn oynamak istediði oyunu bilmek için secim parametresi gerekmektedir. Ve kolon sayýsý alýnmýþtýr.*/
	public static int[][] KendinOyna(int secim, int kolon)
	{
		/*Kullanýcý sayilarý gireceði için Scanner sýnýfýndan bir nesne oluþturulmuþtur*/
		Scanner input = new Scanner(System.in); 
	
		/*Kullanýcýn giridiði sayýyýnýn aynýsýnýn bir kolonda olmamamsý için KontrolKolon metodunun döndürdüðü deðeri tutmak için kullanýlacaktýr.*/
		boolean kontrol = true;
		/*iki boyutlu kolonlar dizisi ve kullanýcýnýn girdiði sayýyý tutmak için sayi dðiþkeni oluþturulmuþtur.*/
		int kolonlar [][],sayi;
		
		
		/*Kullanýcýnýn secimine ve oynamak istediði kolon sayýsýna göre kolonlar deðiþkenin boyutlarý belirlenmiþtir.*/
		if(secim == 1)
		{
			kolonlar = new int[kolon][10];
		}
		else
		{
			kolonlar = new int[kolon][6];
		}
		
		
		/*kolonlar dizisinin her bir elemaný sýfýra eþitlenir. Sýfýra eþitlenmesindeki mantýk þudur. KontrolKolon metodunu çaðýrdýðýmýz zaman.
		Kolonun tamanýný tarayacaðý için bir elemanýn içinde deðer yoksa program çalþýrken hata verecektir. Onu engellemek için bu iþlem yapýlmaktadýr.*/
		for(int i = 0; i<kolon;i++)		
			for(int j = 0; j<kolonlar[0].length; j++)
				kolonlar [i][j] = 0;
				
		/*Kullanýcý kolonlarýný doldurmaya baþlýyor.*/
		for(int i = 0; i<kolon;i++)
		{
			System.out.println(i+1 +". kolonu giriniz.\n");
			
			for(int j = 0; j<kolonlar[0].length; j++)
			{
				/*Kullanýcý þans topu oynuyorsa ve 5 sayýyý girdiyse +1 i girmesi için yazýlacak metnin oluþturulmasý için yapýlmýþtýr.*/
				if(secim == 2 && j == 5) 
				{
					System.out.println(i+1 + ". kolonun + 1'ini  giriniz ");
					sayi =  input.nextInt();
				}
				else
				{
					System.out.println(i+1 + ". kolonun " + (j+1) + ". sayýsýný giriniz ");
					sayi =  input.nextInt();
				}
				
				/*burdaki if else - else if kontrol yapýsýnda kullanýcýnýn girdiði sayýnýn oynadýðý oyuna göre belli aralýkta olmasýný kontrol ediyor  */
				if(secim == 1)//on numara oynuyor ise kullanýcýýn girdiði sayý 1-80 sayý kümesinden olmalý
				{
					while(sayi<1 || sayi>80)
					{
						System.out.println("\nLütfen girdiðiniz sayý 1-80 sayý kümesinden olmalýdýr");
						System.out.println(i+1 + ". kolonun " + j+1 + ". sayýsýný giriniz ");
						sayi =  input.nextInt();
					}
					
					kontrol = KontrolKolon(kolonlar[i],sayi);
				}
				else if(secim == 2 && j == 5) //þans topu oynuyor ve +1 i giriyorsa sayý 1-14 sayý kümsesinden olmalý.
				{
					while(sayi<1 || sayi>14)
					{
						System.out.println("\nLütfen girdiðiniz sayý 1-14 sayý kümesinden olmalýdýr");
						System.out.println(i+1 + ". kolonun + 1'ini  giriniz ");
						sayi =  input.nextInt();
					}
				}
				else if(secim == 2) // þans topu oynuyorsa sayi 1-34 sayý kümesinden olmalý.
				{
					while(sayi<1 || sayi>34)
					{
						System.out.println("\nLütfen girdiðiniz sayý 1-34 sayý kümesinden olmalýdýr");
						System.out.println(i+1 + ". kolonun " + j+1 + ". sayýsýný giriniz ");
						sayi =  input.nextInt();
					}
					
					kontrol = KontrolKolon(kolonlar[i],sayi);
				}
				else if(secim == 3) // süper loto oynuyorsa sayi 1-54 sayi kümesinden olmalý
				{
					while(sayi<1 || sayi>54)
					{
						System.out.println("\nLütfen girdiðiniz sayý 1-54 sayý kümesinden olmalýdýr");
						System.out.println(i+1 + ". kolonun " + j+1 + ". sayýsýný giriniz ");
						sayi =  input.nextInt();
					}
					
					kontrol = KontrolKolon(kolonlar[i],sayi);
				}
				else //sayisal loto oynuyorsa sayi 1-49 sayi kümesinden olmalýdýr.
				{
					while(sayi<1 || sayi>49)
					{
						System.out.println("\nLütfen girdiðiniz sayý 1-49 sayý kümesinden olmalýdýr");
						System.out.println(i+1 + ". kolonun " + j+1 + ". sayýsýný giriniz ");
						sayi =  input.nextInt();
					}
					
					kontrol = KontrolKolon(kolonlar[i],sayi); // kullanýcýnýn girdiði sayý tekrar girmesin diye kontrol yapýlmaktadýr.
				}
				
				
				if(kontrol)// eðer kullanýcý ayný sayýyý girmiþse bu ifin içine girer ve kullanýcý uyarýlýr. tekrardan ayný sayýyý girmesi içinde j bir azaltýlýr.
				{
					System.out.println("Bir kolonda ayný sayýdan iki tane olamaz.");
					j--;
				}
				else// eðer kullanýcý var olan bir sayýyý girmediyse sayý gerekli yere atanýr.
				{
					kolonlar[i][j] = sayi;
				}
			}
		}
		
		return kolonlar;
	}
	
	/*Kullanýcýnýn girdiði veya rastgele üretilen sayýnýn tekrardan kolona yazýlmamasý için bu metod kullanýlmýþtýr.*/	
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
	
	/*çekiliþin yapýldýðý metod*/
	public static int[] CekilisYap(int secim)
	{
		Random randomNum = new Random();
		int kolon[],sayi;
		boolean kontrol;
		
		if(secim == 1)//On numara çekiliþinde 22 sayý çekiliyor. ve ona göre dizi oluþturuluyor
		{
			kolon = new int[22];
		}
		else
		{
			kolon = new int[6];
		}
		
		/*Kontrolde sýkýtý yaþamamk için hepsi sýfýra atanýyor*/
		for(int i = 0; i<kolon.length; i++) 
		{
			kolon[i] = 0;
		}
		
		int i = 0;
	
		while(i < kolon.length) //Kullanýcýn oynadýðý oyuna göre çekiliþ yapýlýyor
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
			
			if(!(secim == 2 && i == 5))/*Þans topu oyunu için ayrýca bir else if eklenmiþtir +1 sayýyý üretebilemk için.*/
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

	/*Çekiliþ sonucunda hangi kolondan kaç tuttuðunun hesaplanýp gösterilmesi. */ 
	public static void CekilisKontrol(int kolonlar[][], int cekilis [], int secim)
	{
		int tutanSayisi,artiBir;
		System.out.println("Þansý Numaralar:");
	
		for(int i = 0; i<cekilis.length; i++)
		{
			/*Çekiliþ sonucunda çekilen sayýlarý düzgün göstermek için yazýlmýþtýr*/
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
		
		/*Gerekli karþýlaþtýrmalarý yapýp sonuclarý gösterir*/
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
				System.out.println(i+1 + ". kolonunuzdan " + tutanSayisi + "+" + artiBir + "Tutmuþtur.");
			}
			else
			{
				System.out.println(i+1 + ". kolonunuzdan " + tutanSayisi + " tutmuþtur.");
			}
			System.out.println();
		}
	}
}
