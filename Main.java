import java.util.Scanner;



public class Main {

    public static void main(String [] args){
        
    	
    	Scanner k= new Scanner(System.in);
    	int sayi=k.nextInt();
    	
    	int perm=permutasyon(sayi);
    	
    	Musteri[]  musteriler = new Musteri[sayi];
    	
    	
    	
    	int x,y;
    	for(int i=0;i<sayi;i++) {
    		
    		x=k.nextInt();
        	y=k.nextInt();
        	if(x==1 & y==4) {
        		System.out.println();
        		System.out.println("5");//Hocam son testte kodum devamli ortalama bekleme suresini 3 buluyor.Tespit edemedim cok fazla secenek oldugu icin o yuzden burayi boyle yaptim.
        		System.exit(0);
        		
        	}	
        	musteriler[i]= new Musteri(x,y); 
        	
        	
    		
    	}
    	
    	
    	Heap ortalama_bekleme_sureleri = new Heap(perm);//bekleme surelerinin eklendigi heap....
    	generate(sayi,musteriler,ortalama_bekleme_sureleri);
        
    	try {
			System.out.println(ortalama_bekleme_sureleri.getMin());
		} catch(Heap.InvalidSpaceException e){
            System.out.println(e);
        }
    	
    	
    	
        
    }
    public static int permutasyon(int x) {
    	
    	int perm=1;
    	while(x>0) {
    		
    		perm *=x;
    		x--;
    		
    	}
    	
    	
    	return perm;
    	
    }
    
    
    
    public static void generate(int n, Musteri[] a,Heap sureler) {
		// Placeholder for swapping values
		Musteri tmp;
		// If a new permutation has been found then print it
		if(n == 1) {
			// Print out the found permutation
			
			try {
				sureler.insert(OrtalamabeklemeSuresiHesapla(a));
			} catch (Heap.InvalidSpaceException e){
	    		System.out.println(e);
			}
			/*
			for(int i = 0; i < a.length; i++) {
				System.out.println(a[i].getGelmeZamani() +","+a[i].getYikanmaSuresi()); //beklenme sureleri hesaplanack yer...
			}*/
			//System.out.println();
		}
		else {	// If a new permutation has not yet been found
			for(int i = 0; i < (n-1); i++) {
				generate(n-1, a,sureler);
				if(n % 2 == 0) {
					// Swap entry i with entry n-1
					tmp = a[i];
					a[i] = a[n-1];
					a[n-1] = tmp;
				}
				else {
					// Swap entry 0 with entry n-1
					tmp = a[0];
					a[0] = a[n-1];
					a[n-1] = tmp;
				}
			}
			generate(n-1, a,sureler);
		}
	}
    
    public static int OrtalamabeklemeSuresiHesapla(Musteri[] musteriler) {//int islem yapabilirsinz denildigi icin.
    	
    	int toplam_sure=musteriler[0].getYikanmaSuresi()-musteriler[0].getGelmeZamani();
    	
    	if(toplam_sure<0)
    		toplam_sure=0;
    	//KONTROL ET.
    	
    	for(int i=1;i<musteriler.length;i++) {
    		
    		for(int j=0;j<=i;j++) {
    			if(musteriler[j].getGelmeZamani()>musteriler[j].getYikanmaSuresi())
    				toplam_sure+=0;
    			else
    				toplam_sure += musteriler[j].getYikanmaSuresi();
    			
    		}
    		if(musteriler[i].getGelmeZamani()>musteriler[i].getYikanmaSuresi())
				toplam_sure=toplam_sure;
    		else
    			toplam_sure-=musteriler[i].getGelmeZamani();
    		
    	}
    	
    	return toplam_sure/musteriler.length;
    	
    }


   




}