package nomor4;

public class MataKuliah {
    String kode;
    String nama;
    int sks;
    String nilai;

    public MataKuliah(String kode, String nama, int sks, String nilai) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
        this.nilai = nilai;
    }

    @Override
    public String toString() {
        return "Kode=" + kode + ", MataKuliah=" + nama + ", SKS=" + sks + ", Nilai=" + nilai + ']';
    }
}