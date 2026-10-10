// Single Linked List untuk daftar buku
public class LinkedList {
    private Node head;
    private Node tail;
    private int size;
    public static final int MIN_BUKU = 5;

    // Tambah buku di akhir daftar (Push)
    public void tambahAkhir(String kode, String judul, String penulis) {
        Node baru = new Node(kode, judul, penulis);
        if (head == null) {
            head = tail = baru;
        } else {
            tail.next = baru;
            tail = baru;
        }
        size++;
    }

    // Hapus buku terakhir (Pop); return null jika kosong
    public Node hapusAkhir() {
        if (head == null) return null;
        Node dihapus;
        if (head == tail) {
            dihapus = head;
            head = tail = null;
        } else {
            Node bantu = head;
            while (bantu.next != tail) bantu = bantu.next; // cari node sebelum tail
            dihapus = tail;
            bantu.next = null;
            tail = bantu;
        }
        size--;
        return dihapus;
    }

    // Cari buku berdasarkan kode (tidak peka huruf besar/kecil)
    public Node cari(String kode) {
        Node bantu = head;
        while (bantu != null) {
            if (bantu.kodeBuku.equalsIgnoreCase(kode)) return bantu;
            bantu = bantu.next;
        }
        return null;
    }

    // Tampilkan semua buku sesuai urutan input
    public void tampil() {
        if (head == null) {
            System.out.println("Daftar buku kosong.");
        } else {
            System.out.println("Daftar Buku:");
            Node bantu = head;
            while (bantu != null) {
                System.out.println("Kode: " + bantu.kodeBuku + " | Judul: " + bantu.judul
                        + " | Penulis: " + bantu.penulis);
                bantu = bantu.next;
            }
        }
        System.out.println("Total Buku: " + size);
        if (size < MIN_BUKU) {
            System.out.println("(Catatan: jumlah data minimal " + MIN_BUKU + " buku, saat ini baru " + size + ")");
        }
    }

    public boolean kodeSudahAda(String kode) { return cari(kode) != null; }
    public int getSize() { return size; }
}
