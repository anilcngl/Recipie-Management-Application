
public class TarifEslestirme {
    private String tarifAdi;
    private double eslesmeYuzdesi;
    private double eksikMalzemeMaliyeti; // Yeni eklenen alan

    // Güncellenmiş constructor
    public TarifEslestirme(String tarifAdi, double eslesmeYuzdesi, double eksikMalzemeMaliyeti) {
        this.tarifAdi = tarifAdi;
        this.eslesmeYuzdesi = eslesmeYuzdesi;
        this.eksikMalzemeMaliyeti = eksikMalzemeMaliyeti;
    }

    public String getTarifAdi() {
        return tarifAdi;
    }

    public double getEslesmeYuzdesi() {
        return eslesmeYuzdesi;
    }

    public double getEksikMalzemeMaliyeti() {
        return eksikMalzemeMaliyeti;
    }
}
