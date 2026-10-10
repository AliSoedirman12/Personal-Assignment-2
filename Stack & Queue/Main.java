import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue antrian = new Queue();
        Stack riwayat = new Stack();
        int pilihan = 0;

        do {
            System.out.println("\n=== SISTEM KASIR TOKO ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            try {
                pilihan = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                pilihan = 0;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nomor Antrian: ");
                    String kode = sc.nextLine().trim();
                    if (kode.isEmpty() || antrian.kodeSudahAda(kode)) {
                        System.out.println("Nomor antrian kosong atau sudah ada!");
                        break;
                    }
                    System.out.print("Masukkan Nama Pelanggan: ");
                    String nama = sc.nextLine().trim();
                    System.out.print("Masukkan Total Belanja: ");
                    long total;
                    try {
                        total = Long.parseLong(sc.nextLine().trim());
                        if (total < 0) throw new NumberFormatException();
                    } catch (NumberFormatException e) {
                        System.out.println("Total belanja harus berupa angka positif!");
                        break;
                    }
                    antrian.enqueue(kode, nama, total);
                    System.out.println("Data pelanggan ditambahkan ke antrian!");
                    break;
                case 2:
                    Node n = antrian.dequeue(); // keluar dari antrian
                    if (n == null) {
                        System.out.println("Tidak ada pelanggan dalam antrian.");
                    } else {
                        System.out.println("Melayani pelanggan " + n.kode + " (" + n.nama + ")");
                        riwayat.push(n.kode, n.nama, n.total); // simpan ke stack
                        System.out.println("Transaksi disimpan ke riwayat.");
                    }
                    break;
                case 3:
                    antrian.tampil();
                    break;
                case 4:
                    riwayat.display();
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Menu tidak valid!");
            }
        } while (pilihan != 5);
        sc.close();
    }
}
