package model;

public class SilverMember extends Member {

    @Override
    public double hitungDiskon(double harga) {
        return harga * 0.10;
    }
}