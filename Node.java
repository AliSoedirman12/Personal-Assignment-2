// Node untuk menyimpan data pelanggan/transaksi
public class Node {
    String kode;
    String nama;
    long total;
    Node next;

    public Node(String kode, String nama, long total) {
        this.kode = kode;
        this.nama = nama;
        this.total = total;
        this.next = null;
    }
}
