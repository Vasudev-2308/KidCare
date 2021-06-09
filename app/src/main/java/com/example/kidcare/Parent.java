package com.example.kidcare;

public class Parent {

        public String parent_name;
        public String child_std;
        public String child_admisnno;
        public String parent_emailad;
        public Parent(){
        }
        public Parent(String fullname,String std,String admisnno,String emailad){

            this.parent_name=fullname;
            this.child_std=std;
            this.child_admisnno = admisnno;
            this.parent_emailad= emailad;
        }

}
