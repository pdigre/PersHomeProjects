package no.esito.genova.io.xtend;

public enum EXPSTATE {
    Output,
    String, 
    Boolean("/B"), 
    Integer("/I");
    private String txt="";
    EXPSTATE(){
        
    }
    EXPSTATE(String txt){
        this.txt=txt;
    }
    public String suffix(){
        return txt;
    }
}