public class antrian{
    pembeli sekarang;
    pembeli terakhir;


    public antrian(){
        this.sekarang = null;
        this.terakhir = null;
    }

    public void tambahPengantri (pembeli p){
        if (habiskah()){
            sekarang = p;
            terakhir = p;
        }else{
            terakhir.next = p;
            terakhir =p;
        }
        System.out.println(p.getNama()+ "di tambahkan");
    }

    public pembeli layani(){
        if (habiskah()){
            System.out.println("antrian kosong, tidak ada pembeli");
        }
        pembeli pembeliDilayani = sekarang;
        sekarang = sekarang.next;

        if (sekarang == null){

            terakhir = null;
        }
        System.out.println( pembeliDilayani.getNama()+ "telah di layani");
        return pembeliDilayani;
    }

    public pembeli terdepan(){
        return null;
    }

    public Boolean habiskah(){
        return false;
    }

    
}