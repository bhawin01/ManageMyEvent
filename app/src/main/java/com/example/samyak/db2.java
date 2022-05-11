package com.example.samyak;

public class db2 {


    String id;
    String autocomplete1;
    String et1;



    public db2(String id,String autocomplete1, String et1){
        this.autocomplete1 = autocomplete1;
        this.et1 = et1;
        this.id=id;
    }
    public String getAutocomplete1()
    {
        return autocomplete1;
    }

    public String getEt1()
    {
        return et1;
    }

    public String getId(){

        return id;

    }
}