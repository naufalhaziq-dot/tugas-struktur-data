import java.util.Scanner;

class Node {
    String kode, judul, penulis;
    Node next;

    Node(String kode, String judul, String penulis) {
        this.kode = kode;
        this.judul = judul;
        this.penulis = penulis;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    void tambah(String kode, String judul, String penulis) {
        Node baru = new Node(kode, judul, penulis);

        if (head == null) {
            head = baru;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = baru;
        }
        System.out.println("Data berhasil ditambahkan!");
    }

    void hapus() {
        if (head == null) {
            System.out.println("Tidak ada data untuk dihapus.");
            return;
        }

        if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
        System.out.println("Data terakhir berhasil dihapus.");
    }

    void cari(String kode) {
        Node temp = head;
        while (temp != null) {
            if (temp.kode.equals(kode)) {
                System.out.println("Ditemukan: " + temp.judul + " - " + temp.penulis);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Buku tidak ditemukan.");
    }

    void tampil() {
        Node temp = head;
        int count = 0;

        while (temp != null) {
            System.out.println("Kode: " + temp.kode + " | Judul: " + temp.judul + " | Penulis: " + temp.penulis);
            temp = temp.next;
            count++;
        }
        System.out.println("Total Buku: " + count);
    }
}

public class MainLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int pilih;

        do {
            System.out.println("\n=== SISTEM DATA BUKU ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("Kode: ");
                    String kode = sc.nextLine();
                    System.out.print("Judul: ");
                    String judul = sc.nextLine();
                    System.out.print("Penulis: ");
                    String penulis = sc.nextLine();
                    list.tambah(kode, judul, penulis);
                    break;

                case 2:
                    list.hapus();
                    break;

                case 3:
                    System.out.print("Masukkan kode: ");
                    String cari = sc.nextLine();
                    list.cari(cari);
                    break;

                case 4:
                    list.tampil();
                    break;
            }
        } while (pilih != 5);
    }
}
