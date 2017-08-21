package Simulator;

public class Ram
{
  final int length = 65536;
  String[][] mem = new String [65536][2];
  boolean changed = false;

  Ram() {
    for (int i = 0; i < 65536; i++)
      this.mem[i][1] = "NIL";
    this.mem[0][1]="11110000";
  }

  public void ram_write(String binary,String tag, int pos) {
      if(binary.length()>8)
          binary=binary.substring(binary.length()-8);
      while(binary.length()<8)
          binary='0'+binary;
      	this.mem[pos][0] = tag;
    this.mem[pos][1] = binary;
  }

  public String read_oprand(int pos) {
    return this.mem[pos][1];
  }


  public String read_tag(int pos) {
    return this.mem[pos][0];
  }
  
  String[][] getMemoryArray() {
    return this.mem;
  }

  void setUnchanged() {
    this.changed = false;
  }

  boolean isChanged() {
    return this.changed;
  }
  public StringBuffer showMem(int reference){
      StringBuffer content=new StringBuffer();
     content.append("Memory Location\t\t\tHex\n");
     // System.out.println(content.toString());
      System.out.println("Memory Location\t\t\tTAG\t\t\tHex");
      int i;
      for(i=reference;i<reference+20;i++){
              content.append(Integer.toHexString(i));content.append("\t\t\t\t");content.append(this.mem[i][1]);content.append("\n");
         System.out.println(Integer.toHexString(i)+"\t\t\t\t"+this.mem[i][0]+"\t\t\t"+this.mem[i][1]); 
      }
      return content;
  }
  public void reset(){
      for (int i = 0; i < 65536; i++)
      this.mem[i][1] = "NIL";
  }
}