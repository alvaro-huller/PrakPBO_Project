package model;

public abstract class Member implements Discountable {

    protected String nama;

    public abstract double hitungDiskon(double harga);
}