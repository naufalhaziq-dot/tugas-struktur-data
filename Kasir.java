import java.util.*;

class Node {
    String kode, nama;
    int total;
    Node next;

    Node(String kode, String nama, int total) {
        this.kode = kode;
        this.nama = nama;
        this.total = total;
        this.next = null;
    }
}

// QUEUE
class Queue {
    Node front, rear;

    void enqueue(String kode, String nama, int total) {
        Node baru = new Node(kode, nama, total);
        if (rear == null) {
            front = rear = baru;
        } else {
            rear.next = baru;
            rear = baru;
        }
        System.out.println("Ditambahkan ke antrian.");
    }

    Node dequeue() {
        if (front == null) return null;

        Node temp = front;
        front = front.next;
        if (front == null) rear = null;

        return temp;
    }

    void tampil() {
        Node temp = front;
        while (temp != null) {
            System.out.println(temp.kode + " - " + temp.nama);
            temp = temp.next;
        }
    }
}

// STACK
class Stack {
    Node top;

    void push(Node data) {
        data.next = top;
        top = data;
    }

    void tampil() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.kode + " - " + temp.nama + " - " + temp.total);
            temp = temp.next;
        }
    }
}

public class Kasir {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue q = new Queue();
        Stack s = new Stack();
        int pilih;

        do {
            System.out.println("\n=== SISTEM KASIR ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Riwayat");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("Kode: ");
                    String k = sc.nextLine();
                    System.out.print("Nama: ");
                    String n = sc.nextLine();
                    System.out.print("Total: ");
                    int t = sc.nextInt();
                    q.enqueue(k, n, t);
                    break;

                case 2:
                    Node p = q.dequeue();
                    if (p != null) {
                        System.out.println("Melayani " + p.nama);
                        s.push(p);
                    } else {
                        System.out.println("Antrian kosong.");
                    }
                    break;

                case 3:
                    q.tampil();
                    break;

                case 4:
                    s.tampil();
                    break;
            }

        } while (pilih != 5);
    }
}
