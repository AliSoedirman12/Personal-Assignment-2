// Stack (LIFO) riwayat transaksi berbasis linked list
public class Stack {
    private Node top;
    private int size;

    // Simpan transaksi di atas stack
    public void push(String kode, String nama, long total) {
        Node baru = new Node(kode, nama, total);
        baru.next = top;
        top = baru;
        size++;
    }

    // Tampilkan dari transaksi terbaru ke terlama
    public void display() {
        if (top == null) { System.out.println("Belum ada riwayat transaksi."); return; }
        System.out.println("Riwayat Transaksi (terbaru di atas):");
        int i = 1;
        for (Node b = top; b != null; b = b.next)
            System.out.println(i++ + ". " + b.kode + " | " + b.nama + " | Rp" + b.total);
        System.out.println("Total transaksi: " + size);
    }
}
