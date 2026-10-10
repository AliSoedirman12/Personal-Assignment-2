// Queue (FIFO) antrian pelanggan berbasis linked list
public class Queue {
    private Node front, rear;
    private int size;
    public static final int MIN_PELANGGAN = 5;

    // Tambah pelanggan di belakang antrian
    public void enqueue(String kode, String nama, long total) {
        Node baru = new Node(kode, nama, total);
        if (rear == null) front = rear = baru;
        else { rear.next = baru; rear = baru; }
        size++;
    }

    // Ambil pelanggan terdepan; null jika kosong
    public Node dequeue() {
        if (front == null) return null;
        Node n = front;
        front = front.next;
        if (front == null) rear = null;
        n.next = null;
        size--;
        return n;
    }

    public boolean kodeSudahAda(String kode) {
        for (Node b = front; b != null; b = b.next)
            if (b.kode.equalsIgnoreCase(kode)) return true;
        return false;
    }

    // Tampilkan antrian dari depan ke belakang
    public void tampil() {
        if (front == null) System.out.println("Antrian kosong.");
        else {
            System.out.println("Antrian Saat Ini:");
            int i = 1;
            for (Node b = front; b != null; b = b.next)
                System.out.println(i++ + ". " + b.kode + " | " + b.nama + " | Rp" + b.total);
        }
        System.out.println("Jumlah antrian: " + size);
        if (size < MIN_PELANGGAN)
            System.out.println("(Catatan: minimal " + MIN_PELANGGAN + " pelanggan dalam antrian)");
    }

    public int getSize() { return size; }
}
