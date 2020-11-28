package com.example.binusezyfood;

public class Pilihan {

    private Integer foto;
    private Integer harga;
    private String nama;
    private Integer quantity;

    public Pilihan(Integer foto, Integer harga, String nama, Integer quantity) {
        this.foto = foto;
        this.harga = harga;
        this.nama = nama;
        this.quantity = quantity;
    }

    public Integer getFoto() {
        return foto;
    }

    public void setFoto(Integer foto) {
        this.foto = foto;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
