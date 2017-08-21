package Simulator;
public class Decoder {
    private int programCounter;
    private Register reg= new Register();
    private Ram ram;
    private Ports ports=new Ports();
    String error=new String();
    public void decode(Ram mem){
        ram=mem;
        String code=new String();
        String tag=new String();
        
        int line=0;
        int flag;
        System.out.println("Execution Time!!");
        do{
            line++;
            try{
            code=mem.read_oprand(programCounter);
            tag=mem.read_tag(programCounter);
            switch(Integer.parseInt(tag)){
                case 2: if(code.substring(0,2).equalsIgnoreCase("01"))
                            { 
                                programCounter+=1;
                                mov(code);
                            }
                        else if(code.substring(0,2).equalsIgnoreCase("00"))
                            {
                                programCounter+=2;
                                System.out.println("In MVI");
                                mvi(code);
                            }
                        break;
                case 5: if(code.substring(0,5).equalsIgnoreCase("10000")|| code.substring(0,5).equalsIgnoreCase("11000"))
                            {
                                if(code.substring(0,5).equalsIgnoreCase("10000"))
                                    programCounter+=1;
                                else
                                    programCounter+=2;
                                add(code);
                            
                            }
                        else if(code.substring(0,5).equalsIgnoreCase("10010")||code.substring(0,5).equalsIgnoreCase("11010"))
                            {
                                if(code.substring(0,5).equalsIgnoreCase("10010"))
                                    programCounter+=1;
                                else
                                    programCounter+=2;
                                sub(code);
                                System.out.println("In sub");
                            
                            }
                        else if(code.substring(0,5).equalsIgnoreCase("10001")||code.substring(0,5).equalsIgnoreCase("11001"))
                            {
                                if(code.substring(0,5).equalsIgnoreCase("10001"))
                                    programCounter+=1;
                                else
                                    programCounter+=2;
                                adc(code);
                                System.out.println("In adc");
                            
                            }
                        else if(code.substring(0,5).equalsIgnoreCase("10011")||code.substring(0,5).equalsIgnoreCase("11011"))
                            {
                                if(code.substring(0,5).equalsIgnoreCase("10011"))
                                    programCounter+=1;
                                else
                                    programCounter+=2;
                                sbb(code);
                                System.out.println("In sbb");
                            
                            }
                        else if(code.substring(0,5).equalsIgnoreCase("10100")||code.substring(0,5).equalsIgnoreCase("11100"))
                            {
                                if(code.substring(0,5).equalsIgnoreCase("10100"))
                                    programCounter+=1;
                                else
                                    programCounter+=2;
                                ana(code);
                                System.out.println("In ana");
                            
                            }
                        else if(code.substring(0,5).equalsIgnoreCase("10101")||code.substring(0,5).equalsIgnoreCase("11101"))
                            {
                                if(code.substring(0,5).equalsIgnoreCase("10101"))
                                    programCounter+=1;
                                else
                                    programCounter+=2;
                                xra(code);
                                System.out.println("In xra");
                            
                            }
                         else if(code.substring(0,5).equalsIgnoreCase("10110")||code.substring(0,5).equalsIgnoreCase("11110"))
                            {
                                if(code.substring(0,5).equalsIgnoreCase("10110"))
                                    programCounter+=1;
                                else
                                    programCounter+=2;
                                ora(code);
                                System.out.println("In ora");
                            
                            }
                        else if(code.substring(0,5).equalsIgnoreCase("10111")||code.substring(0,5).equalsIgnoreCase("11111"))
                            {
                                if(code.substring(0,5).equalsIgnoreCase("10111"))
                                    programCounter+=1;
                                else
                                    programCounter+=2;
                                cmp(code);
                                System.out.println("In cmp");
                            
                            }
                            break;
                case 3:
                        if(code.substring(5).equalsIgnoreCase("100"))
                            {
                                programCounter+=1;
                                inr(code);
                                System.out.println("In INR");
                            
                            }
                        else if(code.substring(5).equalsIgnoreCase("101"))
                            {
                                programCounter+=1;
                                dcr(code);
                                System.out.println("In DCR");
                            
                            }break;
                case 4:
                    if(code.substring(4).equalsIgnoreCase("0011"))
                            {
                                programCounter+=1;
                                inx(code);
                                System.out.println("In INX");
                            
                            }
                        else if(code.substring(4).equalsIgnoreCase("1011"))
                            {
                                programCounter+=1;
                                dcx(code);
                                System.out.println("In DCX");
                            
                            }
                     else if(code.substring(4).equalsIgnoreCase("1001"))
                            {
                                programCounter+=1;
                                dad(code);
                                System.out.println("In DAD");
                            
                            }
                    
                    else if(code.substring(0,2).equalsIgnoreCase("11")&&code.substring(4).equalsIgnoreCase("0001"))
                            {
                                programCounter+=1;
                               pop(code);
                                System.out.println("In POP");
                            
                            }
                    else if(code.substring(0,2).equalsIgnoreCase("11")&&code.substring(4).equalsIgnoreCase("0101"))
                            {
                                programCounter+=1;
                                push(code);
                                System.out.println("In PUSH");
                            
                            }
                    else if(code.substring(4).equalsIgnoreCase("0001"))
                            {
                                programCounter+=3;
                                lxi(code);
                                System.out.println("In LXI");
                            
                            }
                    else if(code.substring(4).equalsIgnoreCase("1010"))
                            {
                                programCounter+=1;
                                ldax(code);
                                System.out.println("In LDAX");
                            
                            }
                    else if(code.substring(4).equalsIgnoreCase("0010"))
                            {
                                programCounter+=1;
                                stax(code);
                                System.out.println("In STAX");
                            
                            }
                    break;
                case 6:
                    if(code.substring(2,5).equalsIgnoreCase("000") && code.substring(7).equalsIgnoreCase("1") ){
                        programCounter+=3;
                        jmp();
                        System.out.println("In JMP");
                    }
                    else if(code.substring(2,5).equalsIgnoreCase("000")){
                        programCounter+=3;
                        jnz();
                        System.out.println("In JNZ");
                    }
                    else if(code.substring(2,5).equalsIgnoreCase("001")){
                        programCounter+=3;
                        jz();
                        System.out.println("In JZ");
                    }
                    else if(code.substring(2,5).equalsIgnoreCase("010")){
                        programCounter+=3;
                        jnc();
                        System.out.println("In JNC");
                    }
                    else if(code.substring(2,5).equalsIgnoreCase("011")){
                        programCounter+=3;
                        jc();
                        System.out.println("In JC");
                    }
                    else if(code.substring(2,5).equalsIgnoreCase("100")){
                        programCounter+=3;
                        jpo();
                        System.out.println("In JPO");
                    }
                    else if(code.substring(2,5).equalsIgnoreCase("101")){
                        programCounter+=3;
                        jpe();
                        System.out.println("In JPE");
                    }
                    else if(code.substring(2,5).equalsIgnoreCase("110")){
                        programCounter+=3;
                        jp();
                        System.out.println("In JP");
                    }
                    else if(code.substring(2,5).equalsIgnoreCase("111")){
                        programCounter+=3;
                        jm();
                        System.out.println("In JM");
                    }
                    
                    break;
                case 8:
                        if(code.equalsIgnoreCase("00000000")){
                           programCounter++; 
                           System.out.println("In NOP");
                        }
                        else if(code.equalsIgnoreCase("11010100")){
                           programCounter+=2; 
                           in();
                        }
                        else if(code.equalsIgnoreCase("11010011")){
                           programCounter+=2; 
                           out();
                        }
                        else if(code.equalsIgnoreCase("00101111")){
                           programCounter+=1; 
                           cma();
                        }
                        else if(code.equalsIgnoreCase("00111111")){
                           programCounter+=1; 
                           cmc();
                        }
                        else if(code.equalsIgnoreCase("00111010")){
                           programCounter+=3; 
                           lda();
                        }
                        else if(code.equalsIgnoreCase("00110010")){
                           programCounter+=3; 
                           sta();
                        }
                            
                //default:
            }
            }
            catch(Exception ex){
                error="Error Found in Line:"+line;
            }
            System.out.println("OK");
        }while(!code.equalsIgnoreCase("01110110"));
        reg.setPC(Integer.toHexString(++programCounter));
        showReg();
    }
    public void setPc(int i){
        programCounter=i;
    }
    public void mov(String opcode){
        String des=opcode.substring(2,5);
        String src=opcode.substring(5);
        String temp=new String();
        String value=new String();
        if(src.equalsIgnoreCase("000"))
            value=reg.getB();
        else if(src.equalsIgnoreCase("001"))
            value=reg.getC();
        else if(src.equalsIgnoreCase("010"))
            value=reg.getD();
        else if(src.equalsIgnoreCase("011"))
            value=reg.getE();
        else if(src.equalsIgnoreCase("100"))
            value=reg.getH();
        else if(src.equalsIgnoreCase("101"))
            value=reg.getL();
        else if(src.equalsIgnoreCase("111"))
            value=reg.getA();
        else if(src.equalsIgnoreCase("110"))
                {
                    value=reg.getHL();
                    value=ram.read_oprand(Integer.parseInt(value, 16));
                    value=Integer.toHexString(Integer.parseInt(value, 2));
                }
            
        if(des.equalsIgnoreCase("000"))
            reg.setB(value);
        else if(des.equalsIgnoreCase("001"))
            reg.setC(value);
        else if(des.equalsIgnoreCase("010"))
            reg.setD(value);
        else if(des.equalsIgnoreCase("011"))
            reg.setE(value);
        else if(des.equalsIgnoreCase("100"))
            reg.setH(value);
        else if(des.equalsIgnoreCase("101"))
            reg.setL(value);
        else if(des.equalsIgnoreCase("111"))
            reg.setA(value);
        else if(des.equalsIgnoreCase("110")){
            temp=reg.getHL();
            ram.ram_write(Integer.toBinaryString(Integer.parseInt(value)), "9", Integer.parseInt(temp, 16));
            
        }
        
    }
    public void mvi(String opcode){
        String des=opcode.substring(2,5);
        String temp=new String();
        String value=Integer.toHexString(Integer.parseInt(ram.read_oprand(programCounter-1), 2));
        if(des.equalsIgnoreCase("000"))
            reg.setB(value);
        else if(des.equalsIgnoreCase("001"))
            reg.setC(value);
        else if(des.equalsIgnoreCase("010"))
            reg.setD(value);
        else if(des.equalsIgnoreCase("011"))
            reg.setE(value);
        else if(des.equalsIgnoreCase("100"))
            reg.setH(value);
        else if(des.equalsIgnoreCase("101"))
            reg.setL(value);
        else if(des.equalsIgnoreCase("111"))
            reg.setA(value);
        else if(des.equalsIgnoreCase("110")){
            temp=reg.getHL();
            ram.ram_write(Integer.toBinaryString(Integer.parseInt(value,16)), "9", Integer.parseInt(temp, 16));
        }
    }
    public void add(String opcode){
       String src=opcode.substring(5);
       int valueA=Integer.parseInt(reg.getA(), 16);
       int res;
       String temp=new String();
       int valueSrc = 0;
       if(opcode.substring(0,5).equalsIgnoreCase("10000")){
            if(src.equalsIgnoreCase("000"))
                valueSrc=Integer.parseInt(reg.getB(), 16);
            else if(src.equalsIgnoreCase("001"))
                valueSrc=Integer.parseInt(reg.getC(), 16);
            else if(src.equalsIgnoreCase("010"))
                valueSrc=Integer.parseInt(reg.getD(), 16);
            else if(src.equalsIgnoreCase("011"))
                valueSrc=Integer.parseInt(reg.getE(), 16);
            else if(src.equalsIgnoreCase("100"))
                valueSrc=Integer.parseInt(reg.getH(), 16);
            else if(src.equalsIgnoreCase("101"))
                valueSrc=Integer.parseInt(reg.getL(), 16);
            else if(src.equalsIgnoreCase("111"))
                valueSrc=Integer.parseInt(reg.getA(), 16);
            else if(src.equalsIgnoreCase("110")){
                temp=reg.getHL();
                valueSrc=Integer.parseInt(ram.read_oprand(Integer.parseInt(temp, 16)), 2);
                
            }
       }else
           valueSrc=Integer.parseInt(ram.read_oprand(programCounter-1), 2);
           
              res=valueA+valueSrc;
              if(res>255){
                  res=res-256;
                  reg.setCarry(1);
                  if(res==0)
                      reg.setZero(1);
              }
              if(res==0)
                  reg.setZero(1);
              System.out.println("res :"+Integer.toBinaryString(res));
                  reg.setSign(checkSign(Integer.toBinaryString(res)));
                  reg.setParity(parityCheck(Integer.toBinaryString(res)));
             
              reg.setA(Integer.toHexString(res));
         }
    public void adc(String opcode){
       String src=opcode.substring(5);
       int valueA=Integer.parseInt(reg.getA(), 16);
       int res;
       String temp=new String();
       int valueSrc = 0;
       if(opcode.substring(0,5).equalsIgnoreCase("10001")){
            if(src.equalsIgnoreCase("000"))
                valueSrc=Integer.parseInt(reg.getB(), 16);
            else if(src.equalsIgnoreCase("001"))
                valueSrc=Integer.parseInt(reg.getC(), 16);
            else if(src.equalsIgnoreCase("010"))
                valueSrc=Integer.parseInt(reg.getD(), 16);
            else if(src.equalsIgnoreCase("011"))
                valueSrc=Integer.parseInt(reg.getE(), 16);
            else if(src.equalsIgnoreCase("100"))
                valueSrc=Integer.parseInt(reg.getH(), 16);
            else if(src.equalsIgnoreCase("101"))
                valueSrc=Integer.parseInt(reg.getL(), 16);
            else if(src.equalsIgnoreCase("111"))
                valueSrc=Integer.parseInt(reg.getA(), 16);
            else if(src.equalsIgnoreCase("110")){
                temp=reg.getHL();
                valueSrc=Integer.parseInt(ram.read_oprand(Integer.parseInt(temp, 16)), 2);
                
            }
       }else
              valueSrc=Integer.parseInt(ram.read_oprand(programCounter-1), 2);
              
              res=valueA+valueSrc+reg.getCarry();
              if(res>255){
                  res=res-256;
                  reg.setCarry(1);
                  if(res==0)
                      reg.setZero(1);
              }
              if(res==0)
                  reg.setZero(1);
                  reg.setSign(checkSign(Integer.toBinaryString(res)));
                  reg.setParity(parityCheck(Integer.toBinaryString(res)));
              reg.setA(Integer.toHexString(res));
         }
    public void sub(String opcode){
        String src=opcode.substring(5);
       int valueA=Integer.parseInt(reg.getA(), 16);
       int res;
       String temp=new String();
       int valueSrc = 0;
       if(opcode.substring(0,5).equalsIgnoreCase("10010")){
            if(src.equalsIgnoreCase("000"))
                valueSrc=Integer.parseInt(reg.getB(), 16);
            else if(src.equalsIgnoreCase("001"))
                valueSrc=Integer.parseInt(reg.getC(), 16);
            else if(src.equalsIgnoreCase("010"))
                valueSrc=Integer.parseInt(reg.getD(), 16);
            else if(src.equalsIgnoreCase("011"))
                valueSrc=Integer.parseInt(reg.getE(), 16);
            else if(src.equalsIgnoreCase("100"))
                valueSrc=Integer.parseInt(reg.getH(), 16);
            else if(src.equalsIgnoreCase("101"))
                valueSrc=Integer.parseInt(reg.getL(), 16);
            else if(src.equalsIgnoreCase("111"))
                valueSrc=Integer.parseInt(reg.getA(), 16);
            else if(src.equalsIgnoreCase("110")){
                temp=reg.getHL();
                valueSrc=Integer.parseInt(ram.read_oprand(Integer.parseInt(temp, 16)), 2);
                
            }
       }else
           valueSrc=Integer.parseInt(ram.read_oprand(programCounter-1), 2);
            valueSrc=Integer.parseInt(Integer.toBinaryString(-valueSrc).substring(24),2);
            res=valueA+valueSrc;
            if(valueA<valueSrc)
                reg.setCarry(1);
            if(res>255){
                  res=res-256;
                  reg.setCarry(1);
                  if(res==0)
                      reg.setZero(1);
              }
              if(res==0)
                  reg.setZero(1);
                  reg.setSign(checkSign(Integer.toBinaryString(res)));
                  reg.setParity(parityCheck(Integer.toBinaryString(res)));
            
            System.out.println("Result:"+res);
            reg.setA(Integer.toHexString(res));
       }
    public void sbb(String opcode){
        String src=opcode.substring(5);
       int valueA=Integer.parseInt(reg.getA(), 16);
       int res;
       String temp=new String();
       int valueSrc = 0;
       if(opcode.substring(0,5).equalsIgnoreCase("10011")){
            if(src.equalsIgnoreCase("000"))
                valueSrc=Integer.parseInt(reg.getB(), 16)+reg.getCarry();
            else if(src.equalsIgnoreCase("001"))
                valueSrc=Integer.parseInt(reg.getC(), 16)+reg.getCarry();
            else if(src.equalsIgnoreCase("010"))
                valueSrc=Integer.parseInt(reg.getD(), 16)+reg.getCarry();
            else if(src.equalsIgnoreCase("011"))
                valueSrc=Integer.parseInt(reg.getE(), 16)+reg.getCarry();
            else if(src.equalsIgnoreCase("100"))
                valueSrc=Integer.parseInt(reg.getH(), 16)+reg.getCarry();
            else if(src.equalsIgnoreCase("101"))
                valueSrc=Integer.parseInt(reg.getL(), 16)+reg.getCarry();
            else if(src.equalsIgnoreCase("111"))
                valueSrc=Integer.parseInt(reg.getA(), 16)+reg.getCarry();
            else if(src.equalsIgnoreCase("110")){
                temp=reg.getHL();
                reg.setCarry(0);
                valueSrc=Integer.parseInt(ram.read_oprand(Integer.parseInt(temp, 16)), 2);
                
            }
       }else
           valueSrc=Integer.parseInt(ram.read_oprand(programCounter-1), 2);
            if(valueA<valueSrc)
                reg.setCarry(1);
            valueSrc=Integer.parseInt(Integer.toBinaryString(-valueSrc).substring(24),2);
            res=valueA+valueSrc;
            if(res>255){
                  res=res-256;
                  reg.setCarry(1);
                  if(res==0)
                      reg.setZero(1);
              }
              if(res==0)
                  reg.setZero(1);
                  reg.setSign(checkSign(Integer.toBinaryString(res)));
                  reg.setParity(parityCheck(Integer.toBinaryString(res)));
            
            System.out.println("Result:"+res);
            reg.setA(Integer.toHexString(res));
       }
    
    public void ana(String opcode){
       String src=opcode.substring(5);
       int valueA=Integer.parseInt(reg.getA(), 16);
       int res;
       String temp=new String();
       int valueSrc = 0;
       if(opcode.substring(0,5).equalsIgnoreCase("10100")){
            if(src.equalsIgnoreCase("000"))
                valueSrc=Integer.parseInt(reg.getB(), 16);
            else if(src.equalsIgnoreCase("001"))
                valueSrc=Integer.parseInt(reg.getC(), 16);
            else if(src.equalsIgnoreCase("010"))
                valueSrc=Integer.parseInt(reg.getD(), 16);
            else if(src.equalsIgnoreCase("011"))
                valueSrc=Integer.parseInt(reg.getE(), 16);
            else if(src.equalsIgnoreCase("100"))
                valueSrc=Integer.parseInt(reg.getH(), 16);
            else if(src.equalsIgnoreCase("101"))
                valueSrc=Integer.parseInt(reg.getL(), 16);
            else if(src.equalsIgnoreCase("111"))
                valueSrc=Integer.parseInt(reg.getA(), 16);
            else if(src.equalsIgnoreCase("110")){
                temp=reg.getHL();
                valueSrc=Integer.parseInt(ram.read_oprand(Integer.parseInt(temp, 16)), 2);
                
            }
       }else
           valueSrc=Integer.parseInt(ram.read_oprand(programCounter-1), 2);
              res=valueA & valueSrc;
              if(res==0)
                  reg.setZero(1);
              else
                  reg.setZero(0);
              reg.setCarry(0);
              reg.setAuxCarry(1);
                  reg.setSign(checkSign(Integer.toBinaryString(res)));
                  reg.setParity(parityCheck(Integer.toBinaryString(res)));
             
              reg.setA(Integer.toHexString(res));
         }
    public void xra(String opcode){
       String src=opcode.substring(5);
       int valueA=Integer.parseInt(reg.getA(), 16);
       int res;
       String temp=new String();
       int valueSrc = 0;
       if(opcode.substring(0,5).equalsIgnoreCase("10101")){
            if(src.equalsIgnoreCase("000"))
                valueSrc=Integer.parseInt(reg.getB(), 16);
            else if(src.equalsIgnoreCase("001"))
                valueSrc=Integer.parseInt(reg.getC(), 16);
            else if(src.equalsIgnoreCase("010"))
                valueSrc=Integer.parseInt(reg.getD(), 16);
            else if(src.equalsIgnoreCase("011"))
                valueSrc=Integer.parseInt(reg.getE(), 16);
            else if(src.equalsIgnoreCase("100"))
                valueSrc=Integer.parseInt(reg.getH(), 16);
            else if(src.equalsIgnoreCase("101"))
                valueSrc=Integer.parseInt(reg.getL(), 16);
            else if(src.equalsIgnoreCase("111"))
                valueSrc=Integer.parseInt(reg.getA(), 16);
            else if(src.equalsIgnoreCase("110")){
                temp=reg.getHL();
                valueSrc=Integer.parseInt(ram.read_oprand(Integer.parseInt(temp, 16)), 2);
                
            }
       }else
           valueSrc=Integer.parseInt(ram.read_oprand(programCounter-1), 2);
              res=valueA ^ valueSrc;
              if(res==0)
                  reg.setZero(1);
              else
                  reg.setZero(0);
              reg.setCarry(0);
              reg.setAuxCarry(0);
                  reg.setSign(checkSign(Integer.toBinaryString(res)));
                  reg.setParity(parityCheck(Integer.toBinaryString(res)));
             
              reg.setA(Integer.toHexString(res));
         }
    public void ora(String opcode){
       String src=opcode.substring(5);
       int valueA=Integer.parseInt(reg.getA(), 16);
       int res;
       String temp=new String();
       int valueSrc = 0;
       if(opcode.substring(0,5).equalsIgnoreCase("10110")){
            if(src.equalsIgnoreCase("000"))
                valueSrc=Integer.parseInt(reg.getB(), 16);
            else if(src.equalsIgnoreCase("001"))
                valueSrc=Integer.parseInt(reg.getC(), 16);
            else if(src.equalsIgnoreCase("010"))
                valueSrc=Integer.parseInt(reg.getD(), 16);
            else if(src.equalsIgnoreCase("011"))
                valueSrc=Integer.parseInt(reg.getE(), 16);
            else if(src.equalsIgnoreCase("100"))
                valueSrc=Integer.parseInt(reg.getH(), 16);
            else if(src.equalsIgnoreCase("101"))
                valueSrc=Integer.parseInt(reg.getL(), 16);
            else if(src.equalsIgnoreCase("111"))
                valueSrc=Integer.parseInt(reg.getA(), 16);
            else if(src.equalsIgnoreCase("110")){
                temp=reg.getHL();
                valueSrc=Integer.parseInt(ram.read_oprand(Integer.parseInt(temp, 16)), 2);
                
            }
       }else
           valueSrc=Integer.parseInt(ram.read_oprand(programCounter-1), 2);
              res=valueA | valueSrc;
              if(res==0)
                  reg.setZero(1);
              else
                  reg.setZero(0);
              reg.setCarry(0);
              reg.setAuxCarry(0);
                  reg.setSign(checkSign(Integer.toBinaryString(res)));
                  reg.setParity(parityCheck(Integer.toBinaryString(res)));
             
              reg.setA(Integer.toHexString(res));
         }
    public void cmp(String opcode){
       String src=opcode.substring(5);
       int valueA=Integer.parseInt(reg.getA(), 16);
       int res;
       String temp=new String();
       int valueSrc = 0;
       if(opcode.substring(0,5).equalsIgnoreCase("10111")){
            if(src.equalsIgnoreCase("000"))
                valueSrc=Integer.parseInt(reg.getB(), 16);
            else if(src.equalsIgnoreCase("001"))
                valueSrc=Integer.parseInt(reg.getC(), 16);
            else if(src.equalsIgnoreCase("010"))
                valueSrc=Integer.parseInt(reg.getD(), 16);
            else if(src.equalsIgnoreCase("011"))
                valueSrc=Integer.parseInt(reg.getE(), 16);
            else if(src.equalsIgnoreCase("100"))
                valueSrc=Integer.parseInt(reg.getH(), 16);
            else if(src.equalsIgnoreCase("101"))
                valueSrc=Integer.parseInt(reg.getL(), 16);
            else if(src.equalsIgnoreCase("111"))
                valueSrc=Integer.parseInt(reg.getA(), 16);
            else if(src.equalsIgnoreCase("110")){
                temp=reg.getHL();
                valueSrc=Integer.parseInt(ram.read_oprand(Integer.parseInt(temp, 16)), 2);
                
            }
       }else
           valueSrc=Integer.parseInt(ram.read_oprand(programCounter-1), 2);
           
                
              if(valueA < valueSrc){
                  reg.setCarry(1);
                  reg.setZero(0);
              }
              else if(valueA == valueSrc){
                  reg.setZero(1);
                  reg.setCarry(0);
              }
               else if(valueA > valueSrc){
                  reg.setZero(0);
                  reg.setCarry(0);
              }
              valueSrc=Integer.parseInt(Integer.toBinaryString(-valueSrc).substring(24),2);
              res=valueA+valueSrc;
              
              System.out.println("res:"+Integer.toBinaryString(res));
                  reg.setSign(checkSign(Integer.toBinaryString(res)));
                  reg.setParity(parityCheck(Integer.toBinaryString(res)));
             
   }
    public void inr(String opcode){
       String src=opcode.substring(2,5);
       int res;
       int flag = 0;
       String temp=new String();
       int valueSrc = 0;
            if(src.equalsIgnoreCase("000"))
            {valueSrc=Integer.parseInt(reg.getB(), 16);flag=0;}
            else if(src.equalsIgnoreCase("001"))
            {valueSrc=Integer.parseInt(reg.getC(), 16);flag=1;}
            else if(src.equalsIgnoreCase("010"))
            {valueSrc=Integer.parseInt(reg.getD(), 16);flag=2;}
            else if(src.equalsIgnoreCase("011"))
            {valueSrc=Integer.parseInt(reg.getE(), 16);flag=3;}
            else if(src.equalsIgnoreCase("100"))
            {valueSrc=Integer.parseInt(reg.getH(), 16);flag=4;}
            else if(src.equalsIgnoreCase("101"))
            {valueSrc=Integer.parseInt(reg.getL(), 16);flag=5;}
            else if(src.equalsIgnoreCase("111"))
            {valueSrc=Integer.parseInt(reg.getA(), 16);flag=7;}
            else if(src.equalsIgnoreCase("110")){
                temp=reg.getHL();
                valueSrc=Integer.parseInt(ram.read_oprand(Integer.parseInt(temp, 16)), 2);flag=6;
                
            }
              res=valueSrc+1;
              if(flag==0)
                  reg.setB(Integer.toHexString(res));
              else if(flag==1)
                  reg.setC(Integer.toHexString(res));
              else if(flag==2)
                  reg.setD(Integer.toHexString(res));
              else if(flag==3)
                  reg.setE(Integer.toHexString(res));
              else if(flag==4)
                  reg.setH(Integer.toHexString(res));
              else if(flag==5)
                  reg.setL(Integer.toHexString(res));
              else if(flag==7)
                  reg.setA(Integer.toHexString(res));
              else if(flag==6)
                    ram.ram_write(Integer.toBinaryString(res),"9",Integer.parseInt(temp, 16));
              if(res>255){
                  res=res-256;
                  reg.setCarry(1);
                  if(res==0)
                      reg.setZero(1);
              }
              if(res==0)
                  reg.setZero(1);
                  reg.setSign(checkSign(Integer.toBinaryString(res)));
                  reg.setParity(parityCheck(Integer.toBinaryString(res)));
             
         }
    public void dcr(String opcode){
       String src=opcode.substring(2,5);
       int res;
       int flag = 0;
       String temp=new String();
       int valueSrc = 0;
            if(src.equalsIgnoreCase("000"))
            {valueSrc=Integer.parseInt(reg.getB(), 16);flag=0;}
            else if(src.equalsIgnoreCase("001"))
            {valueSrc=Integer.parseInt(reg.getC(), 16);flag=1;}
            else if(src.equalsIgnoreCase("010"))
            {valueSrc=Integer.parseInt(reg.getD(), 16);flag=2;}
            else if(src.equalsIgnoreCase("011"))
            {valueSrc=Integer.parseInt(reg.getE(), 16);flag=3;}
            else if(src.equalsIgnoreCase("100"))
            {valueSrc=Integer.parseInt(reg.getH(), 16);flag=4;}
            else if(src.equalsIgnoreCase("101"))
            {valueSrc=Integer.parseInt(reg.getL(), 16);flag=5;}
            else if(src.equalsIgnoreCase("111"))
            {valueSrc=Integer.parseInt(reg.getA(), 16);flag=7;}
            else if(src.equalsIgnoreCase("110")){
                temp=reg.getHL();
                valueSrc=Integer.parseInt(ram.read_oprand(Integer.parseInt(temp, 16)), 2);flag=6;
                
            }
              res=valueSrc+255;
              System.err.println("res:"+Integer.toHexString(res));
           if(flag==0)
                  reg.setB(Integer.toHexString(res));
              else if(flag==1)
                  reg.setC(Integer.toHexString(res));
              else if(flag==2)
                  reg.setD(Integer.toHexString(res));
              else if(flag==3)
                  reg.setE(Integer.toHexString(res));
              else if(flag==4)
                  reg.setH(Integer.toHexString(res));
              else if(flag==5)
                  reg.setL(Integer.toHexString(res));
              else if(flag==7)
                  reg.setA(Integer.toHexString(res));
              else if(flag==6)
                    ram.ram_write(Integer.toBinaryString(res),"9",Integer.parseInt(temp, 16));
              
              
           if(res>255){
                  res=res-256;
                  reg.setCarry(1);
                  if(res==0)
                      reg.setZero(1);
              }
              if(res==0)
                  reg.setZero(1);
              
                  reg.setSign(checkSign(Integer.toBinaryString(res)));
                  reg.setParity(parityCheck(Integer.toBinaryString(res)));
         }
    public void inx(String opcode){
       String src=opcode.substring(2,4);
       int res;
       int flag = 0;
       String temp=new String();
       int valueSrc = 0;
            if(src.equalsIgnoreCase("00"))
            {valueSrc=Integer.parseInt(reg.getBC(), 16);flag=0;}
            else if(src.equalsIgnoreCase("01"))
            {valueSrc=Integer.parseInt(reg.getDE(), 16);flag=1;}
            else if(src.equalsIgnoreCase("10"))
            {valueSrc=Integer.parseInt(reg.getHL(), 16);flag=2;}
            else if(src.equalsIgnoreCase("11"))
            {valueSrc=Integer.parseInt(reg.getSP(), 16);flag=3;}
            
              res=valueSrc+1;
              temp=Integer.toHexString(res);
              if(flag==0)
              {
                  reg.setB(temp.substring(0,temp.length()-2));
                  reg.setC(temp.substring(temp.length()-2));
              }
              else if(flag==1)
              {
                  reg.setD(temp.substring(0,temp.length()-2));
                  reg.setE(temp.substring(temp.length()-2));
              }
              else if(flag==2)
              {
                  reg.setH(temp.substring(0,temp.length()-2));
                  reg.setL(temp.substring(temp.length()-2));
              }
              else if(flag==3)
              {     
                  reg.setSP(temp);
                  
              }
              
                          
         }
    
     public void dcx(String opcode){
       String src=opcode.substring(2,4);
       int res;
       int flag = 0;
       String temp=new String();
       int valueSrc = 0;
            if(src.equalsIgnoreCase("00"))
            {valueSrc=Integer.parseInt(reg.getBC(), 16);flag=0;}
            else if(src.equalsIgnoreCase("01"))
            {valueSrc=Integer.parseInt(reg.getDE(), 16);flag=1;}
            else if(src.equalsIgnoreCase("10"))
            {valueSrc=Integer.parseInt(reg.getHL(), 16);flag=2;}
            else if(src.equalsIgnoreCase("11"))
            {valueSrc=Integer.parseInt(reg.getSP(), 16);flag=3;}
            
              res=valueSrc+65535;
              temp=Integer.toHexString(res);
              if(flag==0)
              {
                  reg.setB(temp.substring(0,temp.length()-2));
                  reg.setC(temp.substring(temp.length()-2));
              }
              else if(flag==1)
              {
                  reg.setD(temp.substring(0,temp.length()-2));
                  reg.setE(temp.substring(temp.length()-2));
              }
              else if(flag==2)
              {
                  reg.setH(temp.substring(0,temp.length()-2));
                  reg.setL(temp.substring(temp.length()-2));
              }
              else if(flag==3)
              {     
                  reg.setSP(temp);
                  
              }
              
                          
         }
     public void dad(String opcode){
       String src=opcode.substring(2,4);
       int res;

       String temp=new String();
       int i=Integer.parseInt(reg.getHL(),16);
       int valueSrc = 0;
            if(src.equalsIgnoreCase("00"))
            {valueSrc=Integer.parseInt(reg.getBC(), 16);}
            else if(src.equalsIgnoreCase("01"))
            {valueSrc=Integer.parseInt(reg.getDE(), 16);}
            else if(src.equalsIgnoreCase("10"))
            {valueSrc=Integer.parseInt(reg.getHL(), 16);}
            else if(src.equalsIgnoreCase("11"))
            {valueSrc=Integer.parseInt(reg.getSP(), 16);}
            
              res=valueSrc+i;
              temp=Integer.toHexString(res);
              reg.setH(temp.substring(0,temp.length()-2));
              reg.setL(temp.substring(temp.length()-2));   
                          
         }
     public void cma(){
       int valueA=Integer.parseInt(reg.getA(), 16);
       int res;
       res=~valueA;
       reg.setA(Integer.toHexString(res));               
     }
     public void cmc(){
         
         if(reg.getCarry()==1)
            reg.setCarry(0);
         else
             reg.setCarry(1);
             
     }
     public void lda(){
         String lowerByte=ram.read_oprand(programCounter-2);
         String upperByte=ram.read_oprand(programCounter-1);
         int location=Integer.parseInt(upperByte+lowerByte, 2);
         int valueSrc=Integer.parseInt(ram.read_oprand(location),2);
         reg.setA(Integer.toHexString(valueSrc));
     }
     public void sta(){
         String lowerByte=ram.read_oprand(programCounter-2);
         String upperByte=ram.read_oprand(programCounter-1);
         int location=Integer.parseInt(upperByte+lowerByte, 2);
         int valueSrc=Integer.parseInt(reg.getA(),16);
         ram.ram_write(Integer.toBinaryString(valueSrc),"9",location);
     }
     public void lxi(String opcode){
         String src=opcode.substring(2,4);
         String lowerByte=ram.read_oprand(programCounter-2);
         String upperByte=ram.read_oprand(programCounter-1);
         lowerByte=Integer.toHexString(Integer.parseInt(lowerByte,2));
         upperByte=Integer.toHexString(Integer.parseInt(upperByte,2));
         if(src.equalsIgnoreCase("00"))
              {
                  reg.setB(upperByte);
                  reg.setC(lowerByte);
              }
              else if(src.equalsIgnoreCase("01"))
              {
                  reg.setD(upperByte);
                  reg.setE(lowerByte);
              }
              else if(src.equalsIgnoreCase("10"))
              {
                  reg.setH(upperByte);
                  reg.setL(lowerByte);
              }
              else if(src.equalsIgnoreCase("11"))
              {     
                  reg.setSP(upperByte+lowerByte);
                  
              }
         
     }
     public void push(String opcode){
         String src=opcode.substring(2,4);
         int sp=Integer.parseInt(reg.getSP(),16);
         int lowerByte = 0,upperByte = 0;
         if(src.equalsIgnoreCase("00")){
             upperByte=Integer.parseInt(reg.getB(), 16);
             lowerByte=Integer.parseInt(reg.getC(), 16);
         }
         else if(src.equalsIgnoreCase("01")){
             upperByte=Integer.parseInt(reg.getD(), 16);
             lowerByte=Integer.parseInt(reg.getE(), 16);
         }
         else if(src.equalsIgnoreCase("10")){
             upperByte=Integer.parseInt(reg.getH(), 16);
             lowerByte=Integer.parseInt(reg.getL(), 16);
         }
         else if(src.equalsIgnoreCase("11")){
             upperByte=Integer.parseInt(reg.getA(), 16);
             lowerByte=Integer.parseInt(reg.getF(), 16);
         }
         sp--;
         ram.ram_write(Integer.toBinaryString(upperByte),"9",sp);
         sp--;
         ram.ram_write(Integer.toBinaryString(lowerByte),"9",sp);
         reg.setSP(Integer.toHexString(sp));
         
     }
     public void ldax(String opcode){
         String src=opcode.substring(3, 4);
         String lower=new String();
         String upper=new String();
         String valBin=new String();
         int memLoc,value;
         if(src.equalsIgnoreCase("0")){
             upper=reg.getB();
             lower=reg.getC();
             
         }
         else{
             upper=reg.getD();
             lower=reg.getE();
         }
         memLoc=Integer.parseInt(upper+lower);
         valBin=ram.read_oprand(memLoc);
         value=Integer.parseInt(valBin, 2);
         reg.setA(Integer.toHexString(value));
     }
     public void stax(String opcode){
         String src=opcode.substring(3, 4);
         String lower=new String();
         String upper=new String();
         String val=reg.getA();
         int memLoc,value;
         value=Integer.parseInt(val, 16);
         if(src.equalsIgnoreCase("0")){
             upper=reg.getB();
             lower=reg.getC();
             
         }
         else{
             upper=reg.getD();
             lower=reg.getE();
         }
         memLoc=Integer.parseInt(upper+lower);
         ram.ram_write(Integer.toBinaryString(value), "9", memLoc);
         
         
     }
     public void pchl(){
         
     }
             
     public void pop(String opcode){
          String src=opcode.substring(2,4);
         int sp=Integer.parseInt(reg.getSP(),16);
         String lowerByte = new String();
         String upperByte = new String();
         lowerByte=ram.read_oprand(sp++);
         upperByte=ram.read_oprand(sp++);
         if(src.equalsIgnoreCase("00")){
             reg.setB(Integer.toHexString(Integer.parseInt(upperByte, 2)));
             reg.setC(Integer.toHexString(Integer.parseInt(lowerByte, 2)));
         }
         else if(src.equalsIgnoreCase("01")){
             reg.setD(Integer.toHexString(Integer.parseInt(upperByte, 2)));
             reg.setE(Integer.toHexString(Integer.parseInt(lowerByte, 2)));            
             
         }
         else if(src.equalsIgnoreCase("10")){
             reg.setH(Integer.toHexString(Integer.parseInt(upperByte, 2)));
             reg.setL(Integer.toHexString(Integer.parseInt(lowerByte, 2)));            
             
         }
         else if(src.equalsIgnoreCase("11")){
             reg.setA(Integer.toHexString(Integer.parseInt(upperByte, 2)));
             reg.setF(lowerByte);             
         }
         reg.setSP(Integer.toHexString(sp));
         
     }
     public void jmp(){
         String lowerByte = ram.read_oprand(programCounter-2);
         String upperByte = ram.read_oprand(programCounter-1);
         programCounter=Integer.parseInt(upperByte+lowerByte,2);
         
         
     }
      public void jc(){
          if(reg.getCarry()==1)
              jmp();
    }
      public void jnc(){
          if(reg.getCarry()==0)
              jmp();
    }
      public void jp(){
          if(reg.getSign()==0)
              jmp();
    }
      
      public void jm(){
          if(reg.getSign()==1)
              jmp();
    }
      public void jpe(){
          if(reg.getParity()==1)
              jmp();
    }
      public void jpo(){
          if(reg.getParity()==0)
              jmp();
    }
      public void jz(){
          if(reg.getZero()==1)
              jmp();
    }
       public void jnz(){
          if(reg.getZero()==0)
              jmp();
    }
       public void in(){
           int val=Integer.parseInt(ram.read_oprand(programCounter-1),2);
           reg.setA(ports.getPort(val));
       }
       public void out(){
           int val=Integer.parseInt(ram.read_oprand(programCounter-1),2);
           ports.setPort(reg.getA(),val);
           
           
       }
    public int parityCheck(String by){
        if(by.length()<8)
            while(by.length()!=8)
                by='0'+by;
        by=by.substring(by.length()-8);
    int count=0,i=0;
    while(i!=by.length()){
        if(by.charAt(i)=='1')
                count++;
        i++;
      }
    count%=2;
        if(count==0)
            return 1;
        else
            return 0;
}
    
    public int checkSign(String by){
        if(by.length()<8)
            while(by.length()!=8)
                by='0'+by;
        by=by.substring(by.length()-8);
        if(by.charAt(0)=='1')
            return 1;
        else
            return 0;
    }
    public void showReg(){
        System.out.println("*************REGISTERS************");
        System.out.println("A :"+reg.getA());
        System.out.println("B :"+reg.getB()+"  C :"+reg.getC());
        System.out.println("D :"+reg.getD()+"  E :"+reg.getE());
        System.out.println("H :"+reg.getH()+"  L :"+reg.getL());
        System.out.println("***************FLAG**************");
        System.out.println("S :"+reg.getSign()+"  Z: "+reg.getZero()+"  P :"+reg.getParity()+"  AC: "+reg.getAuxCarry()+"  C :"+reg.getCarry());
        System.out.println("\n***********************************");
    }
    public String getError(){
        return this.error;
    }
    public Ports getPorts(){
        return ports;
    }
    public Register getRegisterSet(){
        return reg;
    }
    
}
