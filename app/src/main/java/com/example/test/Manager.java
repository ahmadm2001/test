package com.example.test;
public class Manager {
    private String name, Phone, numberDrivinig,numbercar, Pic;
    public Manager(String Fullname, String phone, String numbercar, String numberDrivinig , String pic) {
        this.name=Fullname;
        this.Pic=Pic;
        this.Phone=phone;
        this.numberDrivinig=numberDrivinig;
        this.numbercar=numbercar;

    }



    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhone(){
        return Phone;
    }
    public void setPhone(String phone) {
        this.Phone = phone;
    }

    public String getNumbercar(){
        return numbercar;
    }
    public void setNumbercar(String email) {
        this.numbercar = numbercar;
    }

    public String getnumberDrivinig(){
        return numberDrivinig;
    }
    public void setnumberDrivinig(String numberDrivinig) {
        this.numberDrivinig = numberDrivinig;
    }
    public String getpic(){
        return Pic;
    }
    public void setpic(String pic) {
        this.Pic = pic;
    }






}