package com.jatin.vjm;

public class Listitem {
    private String docname;
    private String hospname;

    public Listitem(String docname, String hospname) {
        this.docname = docname;
        this.hospname = hospname;
    }

    public String getDocname() {
        return docname;
    }

    public String getHospname() {
        return hospname;
    }

}
