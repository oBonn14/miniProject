package com.mini.project.constans;

public enum Response {
    SAVE("Save"),
    SUCCESS("Success"),
    UPDATE("Update"),
    FAILLED("Failled");

    private final String status;

    Response(String status){
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }
}
