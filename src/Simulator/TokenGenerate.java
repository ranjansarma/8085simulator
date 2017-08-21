package Simulator;
//import java.util.*;
public class TokenGenerate
{
  String label;
  String op1;
  String op2;
  String opc;
  String tmp;
  String str;
  int c = 0;
  public TokenGenerate(){
  label = new String();
  op1 = new String();
  op2 = new String();
  opc = new String();
  tmp = new String();
  str = new String();
  }
  /*public static void main(String args[]){
	  TokenGenerate obj=new TokenGenerate();
	  String str=new String();
	  Scanner sc= new Scanner(System.in);
	  System.out.println("Enter a Assembly Statement:");
	 str=sc.nextLine();
	  obj.split(str);
	  System.out.println("Tokenised Statement");
	  if(obj.labelPresent())
		  System.out.print("Label:"+obj.getLabel());
	  else System.out.print("Label Not Present");
	  	System.out.println();
	  if(obj.opcodePresent())
		  System.out.print("Opcode:"+obj.getOpcode());
	  else System.out.print("Opcode Not Present");
	  	System.out.println();
	  if(obj.operand1Present())
		  System.out.print("Operand1:"+obj.getOp1());
	  else System.out.print("Operand1 Not Present");
	  	System.out.println();
	  if(obj.operand2Present())
		  System.out.print("Operand2:"+obj.getOp2());
	  else System.out.print("Operand2 Not Present");
	  	System.out.println();
	 
	  
	  
	  
  }*/

  public void separator()
  {
    int p = 0;
    this.label = null; this.opc = null; this.op1 = null; this.op2 = null;
    boolean labpresent = false;
    int j;
    if (this.str.indexOf(';') >= 0)
    {
      this.c = 1;
      this.str = this.str.substring(0, this.str.indexOf(';'));
    }
    for (int i = 0; i < this.str.length(); i++)
    {
      this.tmp = "";
      for (j = i; j < this.str.length(); j++)
      {
        if ((this.str.charAt(j) != ' ') && (this.str.charAt(j) != ',') && (this.str.charAt(j) != ':'))
        {
          this.tmp += this.str.charAt(j);
         // System.out.println(p);
        }
        else
        {
        	if(this.str.charAt(j)==' ')
        		//System.out.println("Comma Found!");
          if (this.str.charAt(j) != ':') break;
          labpresent = true; break;
        }
      }

      i = j;
      if (!this.tmp.equals(""))
      {
        p++;
        switch (p)
        {
        case 1:
          if (labpresent) { this.label = this.tmp;
          } else {
            this.opc = this.tmp; p++;
          }break;
        case 2:
          this.opc = this.tmp; break;
        case 3:
          this.op1 = this.tmp; break;
        case 4:
          this.op2 = this.tmp;
        }
      }
    }
  }

  public void split(String s)
  {
    this.str = s;
    separator();
  }

  public String getLabel() {
    return this.label;
  }

  public String getOpcode() {
    return this.opc;
  }

  public String getOp1() {
    return this.op1;
  }

  public String getOp2() {
    return this.op2;
  }

  public boolean labelPresent() {
    if (this.label == null) return false;
    return true;
  }

  public int numberOfOperands() {
    if ((this.op1 == null) && (this.op2 == null)) return 0;
    if ((this.op1 != null) && (this.op2 != null)) return 2;
    return 1;
  }

  public boolean opcodePresent() {
    if (this.opc == null) return false;
    return true;
  }

  public boolean operand1Present() {
    if (this.op1 == null) return false;
    return true;
  }

  public boolean operand2Present() {
    if (this.op2 == null) return false;
    return true;
  }

  public boolean commentPresent() {
    if (this.c == 0) return false;
    return true;
  }
}