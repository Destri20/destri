public class Kelas {
    Siswa pertama;
    
    public Kelas(Siswa x) {
        pertama = x;
        
    }
    public Siswa ambilDi(Integer index){
        Siswa sekarang = pertama;
        int hitung = 0;
        while (sekarang != null){
            if(hitung == index){
                return sekarang;
        }
        sekarang = sekarang.berikutnya;
      hitung++;
     
    }
    return null; // index out of bounds
}

     public Integer urutan(String nama){
        Siswa sekarang = pertama;
        int index = 0;
        while (sekarang != null){
            if (sekarang.nama.equals(nama)){
                return index;
            }
            sekarang = sekarang.berikutnya;
            index++;
        }
        return -1;
    }
    public Integer jumlahSiswa(){
        Siswa sekarang = pertama;
        int count = 0;
        while (sekarang != null){
            count++;
            sekarang = sekarang.berikutnya;
        }
        return count;
    }
    public void tambahDidepan(Siswa s){
        s.berikutnya = pertama;
        pertama = s;
        
    }
    public void tambahSetelah(String nama, Siswa s){
        Siswa sekarang = pertama;
        while (sekarang != null){
            if(sekarang.nama.equals(nama)){
                s.berikutnya = sekarang.berikutnya;
                return;
            }
            sekarang = sekarang.berikutnya;
        }
    }
    // If nama not found, do nothing or optionally


    public void hapus(String nama){
        if (pertama == null) return;

        if (pertama.nama.equals(nama)){
            pertama = pertama.berikutnya;
            return;
        }

        Siswa sekarang = pertama;
        while (sekarang.berikutnya != null){


    if(sekarang.berikutnya.nama.equals(nama))
            sekarang.berikutnya =
    sekarang.berikutnya.berikutnya;
    return;

        }
        sekarang = sekarang.berikutnya;
    }
    // If nama not found, do nothing


   public void tambahDiBelakang(Siswa s){
        Siswa terakhir = cariTerakhir();
        terakhir.berikutnya = s;    
   } 

   public void tampilkanSemua(){
    Integer urutan = 0;
    System.out.println("Sekarang urutan ke : "+urutan);

        Siswa sekarang = pertama; //destri
        System.out.println("Siswa sekarang : "+sekarang.nama);

        while(sekarang.berikutnya != null){
            urutan++;
            System.out.println("Sekarang urutan ke : "+urutan);
            // pindah ke record berikutnya
            sekarang = sekarang.berikutnya;
            System.out.println("Siswa sekarang :" +sekarang.nama);
        }
   }
        
   private Siswa cariTerakhir(){
    Siswa sekarang = pertama;
    while(sekarang.berikutnya != null){
        sekarang = sekarang.berikutnya;
    }
    return sekarang;
   }
}