package nomor4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BacaFile {
    public ArrayList<MataKuliah> transkrip = new ArrayList();
    public String namaFile = "transkrip.csv";

    public ArrayList<MataKuliah> open() {
        try {
            File file = new File(namaFile);
            Scanner sc = new Scanner(file);
            String barisLabel = sc.nextLine();
            transkrip = new ArrayList();
            while (sc.hasNextLine()) {
                String baris = sc.nextLine();
                String[] kolom = baris.split(";");
                String kode = kolom[0];
                String nama = kolom[1];
                int sks = Integer.parseInt(kolom[2]);
                String nilai = kolom[3];
                MataKuliah mk = new MataKuliah(kode, nama, sks, nilai);
                transkrip.add(mk);
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return transkrip;
    }

    public String toString() {
        if (transkrip != null) {
            StringBuffer sb = new StringBuffer();
            sb.append("Kode | MataKuliah | SKS | Nilai\n");
            for (MataKuliah mk : transkrip) {
                sb.append(mk.kode + " | " + mk.nama + " | " + mk.sks + " | " + mk.nilai + "\n");
            }
            return sb.toString();
        } else {
            return "[]";
        }
    }

    public void print() {
        System.out.println(toString());
    }

    public boolean print(int index) {
        if (transkrip != null && index >= 0 && index <= transkrip.size()) {
            MataKuliah mk = transkrip.get(index);
            System.out.println(mk.kode + " | " + mk.nama + " | " + mk.sks + " | " + mk.nilai + "\n");
            return true;
        } else {
            System.out.println("Mata Kuliah Index = " + index + " belum ada di transkrip");
            return false;
        }
    }

    public boolean insert(String kode, String nama, int sks, String nilai) {
        boolean result = false;
        try {
            MataKuliah mk = new MataKuliah(kode, nama, sks, nilai);
            transkrip.add(mk);
            result = true;
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    public boolean update(int index, String kode, String nama, int sks, String nilai) {
        boolean result = false;
        try {
            MataKuliah mk = new MataKuliah(kode, nama, sks, nilai);
            transkrip.set(index, mk);
            result = true;
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }
    
    public boolean delete(int index) {
        boolean result = false;
        try {
            transkrip.remove(index);
            result = true;
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    public void setNamaFile(String namaFile) {
        this.namaFile = namaFile;
    }
    
    public boolean seveToFile(){
        boolean result = false;
        try{
            FileWriter fw = new FileWriter(namaFile);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append("Kode MK;MataKuliah;SKS;Nilai\n");
            for(MataKuliah mk : transkrip){
                bw.append(mk.kode+";"+mk.nama+";"+mk.sks+";"+mk.nilai+"\n");
            }
            bw.close();
            fw.close();
            return true;
        }catch(Exception o){
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BacaFile database = new BacaFile();
        while (true) {
            System.out.println("[0] Exit\n[1] insert\n[2] update\n[3] delete\n"
                    + "[4] Print\n[5] setFile\n[6] reset\n[7] open\n[8] saveToFile");
            System.out.print("Pilih menu : ");
            int opsi = sc.nextInt();
            sc.nextLine();
            if (opsi == 0) {
                System.out.println("EXIT");
                database.seveToFile();
                break;
            } else if (opsi == 1) {
                System.out.println("INSERT");
                System.out.print("Kode MataKuliah : ");
                String kode = sc.nextLine();
                System.out.print("Nama MataKuliah : ");
                String nama = sc.nextLine();
                System.out.print("SKS MataKuliah  : ");
                int sks = sc.nextInt();
                sc.nextLine();
                System.out.print("Nilai           : ");
                String nilai = sc.nextLine();
                boolean status = database.insert(kode, nama, sks, nilai);
                if (status == true) {
                    System.out.println("Insert Data Berhasil");
                } else {
                    System.out.println("Insert Data Tidak Berhasil");
                }
            } else if (opsi == 2) {
                System.out.println("UPDATE");
                System.out.print("Index           : ");
                int index = sc.nextInt();
                sc.nextLine();
                System.out.println("Mata Kuliah yang akan di update :");
                boolean status = database.print(index);
                if (status == true) {
                    System.out.print("Kode MataKuliah : ");
                    String kode = sc.nextLine();
                    System.out.print("Nama MataKuliah : ");
                    String nama = sc.nextLine();
                    System.out.print("SKS MataKuliah  : ");
                    int sks = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nilai           : ");
                    String nilai = sc.nextLine();
                    status = database.update(index, kode, nama, sks, nilai);
                    if (status == true) {
                        System.out.println("Update Data Berhasil");
                    } else {
                        System.out.println("Update Data Tidak Berhasil");
                    }
                }
            } else if (opsi == 3) {
                System.out.println("DELETE");
                System.out.print("Index           : ");
                int index = sc.nextInt();
                sc.nextLine();
                System.out.println("Mata Kuliah yang akan di delete :");
                boolean status = database.print(index);
                if (status == true) {
                    status = database.delete(index);
                    if (status == true) {
                        System.out.println("Delete Data Berhasil");
                    } else {
                        System.out.println("Delete Data Tidak Berhasil");
                    }
                }
            } else if (opsi == 4) {
                System.out.println("PRINT");
                database.print();
            } else if (opsi == 5) {
                System.out.println("SET FILE");
                System.out.println("Masukkan nama file data : ");
                String namaFile = sc.nextLine();
                database.setNamaFile(namaFile);
                
            } else if (opsi == 6) {
                System.out.println("RESET");
                database.transkrip = new ArrayList<>();
            } else if (opsi == 7) {
                System.out.println("OPEN");
                database.open();
            } else if (opsi == 8) {
                System.out.println("SAVE TO FILE");
                boolean status = database.seveToFile();
                if (status) {
                    System.out.println("Save To File Berhasil");
                } else {
                    System.out.println("Save To File Tidak Berhasil");
                }
            } else {
                System.out.println("OPSI TIDAK ADA");
            }
        }

    }
}
