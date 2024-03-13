import java.util.Scanner;
public class barangmain16{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        barang16[] daftarBarang = {
            new barang16("KO1", "Sabun", 1000, 5), 
            new barang16("KO2", "Pasta Gigi", 2000, 10), 
            new barang16("KO3", "Biore", 3000, 23),
            new barang16("KO4", "Shampoo", 4000, 55),
            new barang16("KO5", "Sikat Gigi", 5000, 65)
        };

        barang16 [] belanjaan = new barang16[daftarBarang.length];
        while (true) {
            System.out.println("-----------------------");
            System.out.println("TOKO MAJU MUNDUR CANTIK");
            System.out.println("-----------------------");
            System.out.println("1. Tampil Barang");
            System.out.println("2. Beli");
            System.out.println("3. Tampil pembelian");
            System.out.println("4. Keluar");
            System.out.print("Pilih [1-4]: ");
            int pilihan = sc.nextInt();

            if (pilihan == 1) {
                System.out.println("\nDAFTAR BARANG");
                System.out.printf("%-10s %-10s %s\n", "KODE", "NAMA", "HARGA");
                for (barang16 barang : daftarBarang) {
                    System.out.printf("%-10s %-10s %d\n", barang.kode, barang.nama, barang.harga);
                }
            } else if (pilihan == 2) {
                while (true) {
                    System.out.print("\nMasukkan kode barang : ");
                    String kodeBarang = sc.next();
                    boolean barangDitemukan = false;
                    int index = 0;
                    for (int i = 0; i < daftarBarang.length; i++) {
                        if (kodeBarang.equals(daftarBarang[i].kode)) {
                            barangDitemukan = true;
                            index = i;
                            break;
                        }
                    }
                    if (barangDitemukan) {
                        if (daftarBarang[index].stok > 0) {
                            System.out.print("Masukkan jumlah beli : ");
                            int jumlahBeli = sc.nextInt();
                            belanjaan[index] = daftarBarang[index];
                            belanjaan[index].jumBeli += jumlahBeli;
                            daftarBarang[index].stok -= jumlahBeli;
                            System.out.println("Berhasil membeli " + jumlahBeli + " " + daftarBarang[index].nama);
                            System.out.print("Akan belanja kembali (Y/N) ? ");
                            String jawab = sc.next();
                            if (!jawab.equalsIgnoreCase("Y")) {
                                break;
                            }
                        }
                    } else {
                        System.out.println("Barang tidak ditemukan.");
                    }
                }
            } else if (pilihan == 3) {
                System.out.println("\nDAFTAR PEMBELIAN");
                System.out.printf("%-10s %-10s %-10s\n", "KODE", "NAMA", "JUMLAH BELI");
                for (barang16 barang : belanjaan) {
                    if (barang != null && barang.jumBeli > 0) {
                        System.out.printf("%-10s %-10s %-10d\n", barang.kode, barang.nama, barang.jumBeli);
                    }
                }
            } else if (pilihan == 4) {
                System.out.println("Keluar dari program.");
                break;
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
        sc.close();
    }
}
