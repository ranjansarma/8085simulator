package Simulator;

import java.util.Scanner;

/**
 *
 * @author Ranjan
 */
public class Assembler {
    private String assemblyProgram;
    private TokenGenerate stmt;
    private int line;
    private Scanner scan;
    private Ram ram;
    private Hexcode hex;
    private SymbolTable sTable;
    private int locationCounter;
    public Assembler(){
    assemblyProgram=new String();
    stmt = new TokenGenerate();
    ram = new Ram();
    hex = new Hexcode();
    sTable=new SymbolTable();
    //locationCounter=2000;
    }
    public void resolveLabel(String pgm){
        Scanner scanner=new Scanner(pgm);
        String str=new String();
        int n;
        int lc=locationCounter;
        do{
             str = scanner.nextLine();
             this.stmt.split(str);
               if(this.stmt.str.equalsIgnoreCase(""))
                   continue;
               if(this.stmt.labelPresent())
               {
                   if(sTable.labelEntry(this.stmt.getLabel(), lc))
                       System.out.println("label entered!");
                   else
                       System.out.println("Error!!! Multiple Lables of same FOund!");
               }
               n=hex.numberOfByte(this.stmt.opc);
               lc+=n;
               
             
        }while(!str.equalsIgnoreCase("HLT"));
       sTable.showTable();
    }
    public Ram loadMemory(String pgm){
        assemblyProgram = new String();
        String str = new String();
        String tmp = new String();
        String tmp1 = new String();
        String lowerByte = new String();
        String upperByte = new String();
        String addressLc = new String();
        int n;
        this.assemblyProgram=pgm;
        scan=new Scanner(pgm);

        
       do{
               str = scan.nextLine();
               
               //System.out.println(str);
               this.stmt.split(str);
               if(this.stmt.str.equalsIgnoreCase(""))
                   continue;
               //System.out.println(this.stmt.opc);
               n=hex.numberOfByte(this.stmt.opc);
               switch(n){
                   case 1://System.out.print("One Byte Instuction!\n Hex Value:");
                         // System.out.println(Integer.toHexString(hex.getHex(this.stmt.str)));
                       if(!this.stmt.labelPresent())
                          ram.ram_write(Integer.toBinaryString(hex.getHex(this.stmt.str)).toUpperCase(),Integer.toString(hex.getTag()), locationCounter++);
                       else
                           ram.ram_write(Integer.toBinaryString(hex.getHex(this.stmt.str.substring(this.stmt.str.indexOf(':')+1).trim())).toUpperCase(),Integer.toString(hex.getTag()), locationCounter++);
                          //locationCounter++;
                       break;
                   case 2://System.out.println("Two Byte Instuction!");
                            if(!this.stmt.opc.equalsIgnoreCase("MVI")){
                               // System.out.println("not mvi");
                                //System.out.println(Integer.toHexString(hex.getHex(this.stmt.opc)));
                                //System.out.println(this.stmt.op1);
                                ram.ram_write(Integer.toBinaryString(hex.getHex(this.stmt.opc)).toUpperCase(),Integer.toString(hex.getTag()), locationCounter++);
                                ram.ram_write(convert(this.stmt.op1),Integer.toString(hex.getTag()), locationCounter++);
                            }
                            else{
                                //System.out.println(Integer.toHexString(hex.getHex(this.stmt.opc + ' ' +this.stmt.op1)));
                                //System.out.println(this.stmt.op2);
                                ram.ram_write(Integer.toBinaryString(hex.getHex(this.stmt.opc + ' ' +this.stmt.op1)).toUpperCase(),Integer.toString(hex.getTag()), locationCounter++);
                                ram.ram_write(convert(this.stmt.op2),Integer.toString(hex.getTag()), locationCounter++);
                                
                            }
                            break;
                   case 3://System.out.println("Three Byte Instuction!");
                            if(!this.stmt.opc.equalsIgnoreCase("LXI")){
                               tmp1=this.stmt.getOp1();
                                while(tmp1.length()<5)
                                  tmp1='0'+tmp1;
                                if(hexBinaryCheck(tmp1)){
                                   addressLc=convert(this.stmt.getOp1());
                                   while(addressLc.length()<16)
                                        addressLc='0'+addressLc;
                                }
                                else{
                                    addressLc=sTable.getLc(this.stmt.getOp1());
                                    
                                }
                                System.out.print("AddreddLc"+addressLc);
                                lowerByte=addressLc.substring(8);
                                upperByte=addressLc.substring(0,8);
                                /*lowerByte=this.stmt.op1.substring(2);
                                upperByte=this.stmt.op1.substring(0,2);*/
                                //System.out.println(this.stmt.op1);
                                //System.out.println(lowerByte);
                                //System.out.println(upperByte);
                                ram.ram_write(Integer.toBinaryString(hex.getHex(this.stmt.opc)).toUpperCase(),Integer.toString(hex.getTag()), locationCounter++);
                                ram.ram_write(lowerByte,Integer.toString(hex.getTag()), locationCounter++);
                                ram.ram_write(upperByte,Integer.toString(hex.getTag()), locationCounter++);
                            }
                            else{
                                tmp=convert(this.stmt.op2);
                                System.out.println("tmp:"+tmp);
                                if(tmp.length()>16)
                                    tmp=tmp.substring(tmp.length()-16);
                                while(tmp.length()<16){
                                    tmp='0'+tmp;
                                }
                               // System.out.println(Integer.toHexString(hex.getHex(this.stmt.opc + ' ' +this.stmt.op1)));
                                
                                lowerByte=tmp.substring(8);
                                upperByte=tmp.substring(0,8);
                               // System.out.println(lowerByte);
                               // System.out.println(upperByte);
                                ram.ram_write(Integer.toHexString(hex.getHex(this.stmt.opc + ' ' +this.stmt.op1)).toUpperCase(),Integer.toString(hex.getTag()), locationCounter++);
                                ram.ram_write(lowerByte,Integer.toString(hex.getTag()), locationCounter++);
                                ram.ram_write(upperByte,Integer.toString(hex.getTag()), locationCounter++);
                                //System.out.println(this.stmt.op2);
                            }
                            break;
               }
               if(str.equalsIgnoreCase("HLT")){
                   continue;
               }
               line+=1;
        }while(!str.equalsIgnoreCase("HLT"));
       System.out.println("Program Loaded to Memory Successfully!"); 
       System.out.println("**************************************************************************************");
      // ram.showMem(2000);
        
       return ram; 
       
       
        
    }
    public String convert(String oparand){
        if(oparand.endsWith("h"))
            return Integer.toBinaryString(Integer.parseInt(oparand.substring(0,oparand.indexOf('h')), 16));
        else
            return Integer.toBinaryString(Integer.parseInt(oparand));
    }
    public void setLc(int i){
           locationCounter=i;
       }
    public boolean hexBinaryCheck(String oparand){
        if((oparand.matches("[0-9a-f]{4}[h]")||oparand.matches("[0-9]{5}"))&&oparand.length()==5)
            return true;
        else 
            return false;
    }
    
}
