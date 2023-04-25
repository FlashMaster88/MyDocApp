package com.example.mydocapp;

import java.util.ArrayList;

public class SingletonDoc {
    private static SingletonDoc instance = new SingletonDoc();
    ArrayList<DoctorList> doctorLists = new ArrayList<>();
    private SingletonDoc(){

        doctorLists.add(new DoctorList("Dr Amandine FANARA","Aerodrome Medipole\n" +
                "25 Avenue Nungesser et Coli, 40100 Dax", "5:10 pm"));
        doctorLists.add(new DoctorList("Dr Aurélie JULIEN","Maison de Santé Caux-Estuaire La Vieille Route\n"
                +" 76430 Saint-Romain-de-Colbosc", "3:00 pm" ));
        doctorLists.add(new DoctorList("Dr Céline SCHAPMAN","Maison Santé Pluridisciplinaire 6 Rue du Stade\n" +
                "10110 Bar-sur-Seine", "4:30 pm" ));
        doctorLists.add(new DoctorList("Dr Dominique Delahaye","Cabinet de médecine générale de Générac 9 Rue Germain Bournac\n" +
                "30510 Générac", "1:10 pm" ));
        doctorLists.add(new DoctorList("Dr Laurence LAGOUTTE","52 Rue d'Isly, 59000 Lille", "2:30 pm" ));
        doctorLists.add(new DoctorList("Dr Mariama Bah","Cabinet du docteur Amandine Fanara 2 Rue Jeanne d'Arc,|n" +
                "57160 Scy-Chazelles", "4:20 pm" ));
        doctorLists.add(new DoctorList("Dr Nathalie LOREAU COURTHIAL","Cabinet médical\n" +
                "51 Rue Jean-Jacques Rousseau, 75001 Paris", "12:30 pm" ));
        doctorLists.add(new DoctorList("Dr Paul GOULON","Cabinet médical de médecine générale de Saint Jory\n" +
                "11 Chemin de Gagnac, 31790 Saint-Jory", "3:20 pm" ));
        doctorLists.add(new DoctorList("Dr Stephanie PAVAN HUMLER","77 Avenue Henri Delecaux, 59130 Lambersart", "3:00 pm" ));

    }
    public static SingletonDoc getInstance(){
        return instance;
    }
}

