package model;

public class BronzeMember extends Member {

    @Override
    public double hitungDiskon(double harga) {
        return harga * 0.05;
    }
}