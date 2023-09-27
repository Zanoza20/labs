package com.company;

class Phone {
    private int id;
    private String Prisvishe;
    private String Imya;
    private String Pobatkovi;
    private String nomerRaxynky;
    private int chasMistksixRosmov;
    private int chasMishmistskixRosmov;

    public Phone(int id, String Prisvishe, String Imya, String Pobatkovi, String nomerRahynky, int Chasmistskixrosmov, int Chasmishmistskixrosmov) {
        this.id = id;
        this.Prisvishe = Prisvishe;
        this.Imya = Imya;
        this.Pobatkovi = Pobatkovi;
        this.nomerRaxynky = nomerRahynky;
        this.chasMistksixRosmov = Chasmistskixrosmov;
        this.chasMishmistskixRosmov = Chasmishmistskixrosmov;
    }

    public int getId() {
        return id;
    }

    public String getPrisvishe() {
        return Prisvishe;
    }

    public String getImya() {
        return Imya;
    }

    public String getPobatkovi() {
        return Pobatkovi;
    }

    public String getnomerRaxynky() {
        return nomerRaxynky;
    }

    public double getChasMistksixRosmov() {
        return chasMistksixRosmov;
    }

    public double getChasMishmistskixRosmov() {
        return chasMishmistskixRosmov;
    }
}