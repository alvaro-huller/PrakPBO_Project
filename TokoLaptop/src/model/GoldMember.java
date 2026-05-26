package model;

public class GoldMember extends Member {

    @Override
    public double hitungDiskon(double harga) {
        return harga * 0.15;
    }
}