/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_automata;

/**
 *
 * @author koclock
 */
public class mesin {
    private String inputan;
    private String[] log;
    private Boolean output;
    public void setInput(String string){
               this.inputan=string;
    }

    public String[] getLog() {
        return log;
    }

    public Boolean getOutput() {
        return output;
    }
    
    public void jalankan(){
        String pointer = "S"; int a;
        String[] state = new String[this.inputan.length()];
        for(a=0;a<this.inputan.length();a++){
            if(pointer.equals("S")){
                    if(this.inputan.charAt(a)=='a'||this.inputan.charAt(a)=='b'){
                        if(this.inputan.charAt(a)=='b'){
                            pointer="S";
                        }else if(this.inputan.charAt(a)=='a'){
                            pointer="M";
                        }
                        state[a]="State(S,"+inputan.charAt(a)+")\t=> "+pointer;
                    }else{
                        pointer="error";
                        state[a]="State(S,"+inputan.charAt(a)+")\t=> not identified";
                        a++;
                        break;
                    }
            }else if(pointer.equals("M")){
                    if(this.inputan.charAt(a)=='a'||this.inputan.charAt(a)=='b'){
                        if(this.inputan.charAt(a)=='a'){
                            pointer="F";
                        }else if(this.inputan.charAt(a)=='b'){
                            pointer="M";
                        }
                        state[a]="State(M,"+inputan.charAt(a)+")\t=> "+pointer;
                    }else{
                        pointer="error";
                        state[a]="State(M,"+inputan.charAt(a)+")\t=> not identified";
                        a++;
                        break;
                    }
            }else if(pointer.equals("F")){
                     if(this.inputan.charAt(a)=='a'||this.inputan.charAt(a)=='b'){
                        if(this.inputan.charAt(a)=='a'){
                            if(a!=(this.inputan.length()-1)){
                                if(this.inputan.charAt(a+1)=='a'||this.inputan.charAt(a+1)=='b'){
                                    pointer="M";
                                }
                            }else
                            pointer="+";
                        }else if(this.inputan.charAt(a)=='b'){
                            pointer="F";
                        }
                        state[a]="State(F,"+inputan.charAt(a)+")\t=> "+pointer;
                    }else{
                        pointer="error";
                        state[a]="State(F,"+inputan.charAt(a)+")\t=> not identified";
                        a++;
                        break;
                    }    
         }}    
        if(pointer.equals("+")){
            this.output=true;
        }else{
           this.output=false;
        }
        this.log=state;
    }
    
    
    
}