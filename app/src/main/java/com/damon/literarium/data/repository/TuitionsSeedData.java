package com.damon.literarium.data.repository;

import com.damon.literarium.data.Tuition;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TuitionsSeedData {

    public static ArrayList<Tuition> getUpcomingTuitions() {
        ArrayList<Tuition> tuitions = new ArrayList<Tuition>();
        tuitions.add(
                new Tuition(
                        "Maths",
                        4,
                        "13/01/2020",
                        "Trikona Park",
                        12,
                        "Madhu",
                        "120 - 160"
                )
        );
        tuitions.add(
                new Tuition(
                        "Chemistry",
                        4,
                        "13/01/2020",
                        "Manyasar",
                        16,
                        "Krishna",
                        "140 - 180"
                )
        );
        tuitions.add(
                new Tuition(
                        "Pol.Science",
                        5,
                        "15/01/2020",
                        "Haritej Shop",
                        5,
                        "Hamit",
                        "70-96"
                )
        );
        tuitions.add(
                new Tuition(
                        "English",
                        3,
                        "19/01/2020",
                        "Mata Mandir",
                        4,
                        "Hardik",
                        "40-78"
                )
        );
        tuitions.add(
                new Tuition(
                        "Japanese",
                        5,
                        "21/01/2020",
                        "Tipu Sultan's Back",
                        2,
                        "Yang",
                        "170-210"
                )
        );
        tuitions.add(
                new Tuition(
                        "Biology",
                        2,
                        "16/01/2020",
                        "Yumahu Hinj",
                        8,
                        "Bikaner",
                        "80-160"
                )
        );
        return tuitions;
    }

    public static ArrayList<Tuition> getTuitionRequests() {
        ArrayList<Tuition> tuitions = new ArrayList<Tuition>();
        tuitions.add(
                new Tuition(
                        "Physics",
                        5,
                        "22/01/2020",
                        "Batli Ki Shop",
                        12,
                        "Ajay",
                        "120-190"
                )
        );
        tuitions.add(
                new Tuition(
                        "Value Education",
                        4,
                        "13/02/2020",
                        "Panchayat ke pass",
                        10,
                        "Akansh",
                        "70-180"
                )
        );
        tuitions.add(
                new Tuition(
                        "Geography",
                        3,
                        "17/02/2020",
                        "Teesra Cinema",
                        5,
                        "Sundari",
                        "30-80"
                )
        );
        tuitions.add(
                new Tuition(
                        "Hindi",
                        3,
                        "21/01/2020",
                        "Kali Maidan",
                        18,
                        "Kumar",
                        "280-340"
                )
        );
        tuitions.add(
                new Tuition(
                        "CSE",
                        5,
                        "28/01/2020",
                        "Hagdambe",
                        12,
                        "Vijay",
                        "70-170"
                )
        );
        return tuitions;
    }

    public static ArrayList<Tuition> getTuitionSuggestions() {
        ArrayList<Tuition> tuitions = new ArrayList<Tuition>();
        tuitions.add(
                new Tuition(
                        "Games",
                        5,
                        "22/01/2021",
                        "Sports Ground",
                        20,
                        "Amit",
                        "380 - 450"
                )
        );
        tuitions.add(
                new Tuition(
                        "S.S.T.",
                        4,
                        "28/02/2021",
                        "Amritsari",
                        16,
                        "Anand",
                        "120-160"
                )
        );
        tuitions.add(
                new Tuition(
                        "History",
                        3,
                        "28/02/2021",
                        "Pehla Mandir",
                        10,
                        "Harsh",
                        "70-150"
                )
        );
        tuitions.add(
                new Tuition(
                        "Hindi",
                        3,
                        "04/03/2021",
                        "Panchyati Maidan",
                        14,
                        "Tapu",
                        "160-340"
                )
        );
        tuitions.add(
                new Tuition(
                        "CSE",
                        5,
                        "08/03/2021",
                        "Photocopy Shop",
                        17,
                        "Jaya",
                        "270-290"
                )
        );
        return tuitions;
    }

}
