package com.smal.api.model.records;


public record EventRecord(String date , String context) {
     public EventRecord(String date , String context){
         this.context = context;
         this.date = date ;

     }
}

