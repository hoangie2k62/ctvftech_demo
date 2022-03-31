package platform.ctv.api.dto;

import java.io.Serializable;

public class SubjectDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private int frequency;

    public SubjectDTO(String name, int frequency){

        this.name = name;
        this.frequency = frequency;
    }

    public String getName(){

        return this.name;
    }

    public int getFrequency(){

        return this.frequency;
    }

    @Override
    public String toString(){

        return this.name + "," + this.frequency;
    }
}
