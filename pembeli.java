public class pembeli {
    String nama;
    pembeli next;

    public pembeli (String nama){
        this.nama = nama;
        this.next = null;
    }
    public string getNama(){
        return nama;
    }
    @overide
    public String toString(){
        return nama;
    }
}