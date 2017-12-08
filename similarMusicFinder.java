/*
Sanatçı - Parça İsmi (Varsa Skit-İntro-Remix vs) ft featMC-featMC2.uzantı
Sanatçı - Parça İsmi (Varsa Skit-İntro-Remix vs).uzantı

Seklinde isimlendirilmiş şarkı dosyalarının bulunduğu dizin adresini alarak
içerisinde aynı Parça İsimlerini bulup,ekrana yazdıran program
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class similarMusicFinder{
	
	public static void main(String [] args) 
	{
		try
		{
			Scanner okuyucu = new Scanner(System.in);
			String dizinAdresi;
			System.out.print("Sarkilarin bulundugu dizin adresini yaziniz: ");
			dizinAdresi = okuyucu.next();
			File anaDizin = new File(dizinAdresi); //Dizin adresi ile dosya oluşturma
			String[] anaDizinData = anaDizin.list(); //Dizin içerisindeki dosya isimlerinin diziye alınması
			ArrayList <String> karsilastirilicak = new ArrayList<String>(); //Dinamik string dizisi

			for(String temp : anaDizinData)  //Dizin içerisindeki tüm dosya isimlerini gezen döngü
			{
				int baslangicKonum,sonKonum;	
				baslangicKonum = temp.indexOf(" - "); //" - " ifadesinin başlangıç indexsini döndürüyoruz
				baslangicKonum += 3;  //Başlangıç adresine " - " ifadesinin uzunluğunu(3) ekliyoruz ve şarkının başlangıç indexsini buluyoruz

				if(temp.indexOf("ft") == -1)  //Eğer "ft" ifadesi bulunamazsa
				{
					sonKonum = temp.lastIndexOf(".");  //"." ifadesi sondan başa doğru aranır
				}else
				{
					sonKonum = temp.indexOf("ft");   //Bulunursa "ft" başlangıç indexsinden bir önceki index alınır
					sonKonum -= 1;
				}
				//Dinamik listeye bulunan tüm şarkı isimleri eklenir
				karsilastirilicak.add( temp.substring(baslangicKonum,sonKonum) ); 
			}

			//Sarkı isimlerinin tutulduğu listede şarkılar karşılaştırılır,aynı olanlar ekrana basılır
			int gezici;
			for(int secilen=0; secilen < karsilastirilicak.size(); secilen++)
			{
				gezici = secilen + 1;
				for(; gezici < karsilastirilicak.size(); gezici++)
				{
					if( karsilastirilicak.get(secilen).equalsIgnoreCase( karsilastirilicak.get(gezici) ) )
					{
						System.out.println( karsilastirilicak.get(secilen) );
					}
				}
			}
		}
		catch(Exception durum)
		{
			System.out.println("Hata");
		}
	}
}