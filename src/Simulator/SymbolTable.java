package Simulator;


public class SymbolTable {
    private String[][] sTable;
    private int count;
    public SymbolTable(){
     sTable=new String [256][2];
     count = 0;
    }
    boolean labelEntry(String label,int locationCounter){
        int j;
        boolean status=true;
        for(j=0;j<count;j++){
            if(label.equals(sTable[j][0])){
            status=false;
            break;
            }
        
        }
        if(status){
        String sLocation=Integer.toBinaryString(locationCounter);
        if(sLocation.length()>16)
            sLocation=sLocation.substring(sLocation.length()-16);
        while(sLocation.length()<16){
            sLocation='0'+sLocation;
        }
        sTable[count][0]=label;
        sTable[count][1]=sLocation.toUpperCase();
        count++;
        }
       return status; 
    }
     //show symbol table
    void showTable(){
        System.out.println("Label\t\t\tLocation");
         for (int j=0;j<count;j++){
             System.out.println(this.sTable[j][0]+"\t\t"+this.sTable[j][1]);
             
            
        }
       
    }
    public String getLc(String label){
        int j;
        String str=new String();
        for(j=0;j<count;j++){
            if(label.equals(sTable[j][0])){
                str=sTable[j][1];
                System.out.println(str);
                break;
                
            }
       
    }
        return str;
    }
       
        
}
