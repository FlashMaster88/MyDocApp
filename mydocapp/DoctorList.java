package com.example.mydocapp;

public class DoctorList {

        private String doctorname;
        private String doctoraddress;
        private String time;


        public DoctorList(String doctorname, String doctoraddress, String time){
            this.doctorname = doctorname;
            this.doctoraddress = doctoraddress;
            this.time = time;
        }

        public  String getDoctorname(){ return doctorname; }

        public void setDoctorname(String doctorname) { this.doctorname = doctorname;}

        public  String getdoctoraddress(){ return doctoraddress; }

        public void setdoctoraddress(String doctoraddress) { this.doctoraddress = doctoraddress;}

        public String gettime() { return time; }

        public void settime(String time) { this.time = time;}

}

