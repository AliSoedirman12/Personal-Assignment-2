import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList daftar = new LinkedList();
        int pilihan = 0;

        do {
            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            try {
                pilihan = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                pilihan = 0;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Kode Buku: ");
                    String kode = sc.nextLine().trim();
                    // Validasi: kode tidak kosong, maksimal 5 karakter, tidak duplikat
                    if (kode.isEmpty() || kode.length() > 5) {
                        System.out.println("Kode buku harus 1-5 karakter!");
                        break;
                    }
                    if (daftar.kodeSudahAda(kode)) {
                        System.out.println("Kode buku sudah ada!");
                        break;
                    }
                    System.out.print("Masukkan Judul: ");
                    String judul = sc.nextLine().trim();
                    System.out.print("Masukkan Penulis: ");
                    String penulis = sc.nextLine().trim();
                    daftar.tambahAkhir(kode, judul, penulis);
                    System.out.println("Data berhasil ditambahkan!");
                    break;
                case 2:
                    Node dihapus = daftar.hapusAkhir();
                    if (dihapus == null) System.out.println("Tidak ada data untuk dihapus.");
                    else System.out.println("Buku terakhir dihapus: " + dihapus.kodeBuku + " - " + dihapus.judul);
                    break;
                case 3:
                    System.out.print("Masukkan Kode Buku: ");
                    Node hasil = daftar.cari(sc.nextLine().trim());
                    if (hasil == null) System.out.println("Buku tidak ditemukan.");
                    else System.out.println("Ditemukan -> Kode: " + hasil.kodeBuku + " | Judul: "
                            + hasil.judul + " | Penulis: " + hasil.penulis);
                    break;
                case 4:
                    daftar.tampil();
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
