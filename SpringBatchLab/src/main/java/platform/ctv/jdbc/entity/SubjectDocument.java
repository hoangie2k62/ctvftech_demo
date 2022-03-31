package platform.ctv.jdbc.entity;

import javax.security.auth.Subject;

public class SubjectDocument {

    private String name;

    private String pin;

    private String describe;

    public SubjectDocument(String name, String pin, String describe){

        this.name = name;
        this.pin = pin;
        this.describe = describe;
    }

    public String getName(){
        return this.name;
    }

    public String getPin(){
        return this.pin;
    }

    public String getDescribe(){
        return this.describe;
    }

    @Override
    public String toString(){

        return String.format("%s,%s,%s", name, pin, describe);
    }
}
