package io.github.agusprayogi02.latihan2.models;

public class NegaraModel {
    private String nama;
    private String ibuKota;
    private String imageUrl;

    public NegaraModel(String nama, String ibuKota, String imageUrl) {
        this.nama = nama;
        this.ibuKota = ibuKota;
        this.imageUrl = imageUrl;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getIbuKota() {
        return ibuKota;
    }

    public void setIbuKota(String ibuKota) {
        this.ibuKota = ibuKota;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
