package com.example.samyak;

public class db1 {
    String id;
    String task1;
    String emailSelected;

    public db1(String id,String task1, String emailSelected){
        this.emailSelected = emailSelected;
                this.task1 = task1;
                this.id=id;
    }

    public String getTask1()
    {
        return task1;
    }

    public String getEmailSelected()
    {
        return emailSelected;
    }

    public String getId(){

        return id;

    }
}
