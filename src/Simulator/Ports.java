package Simulator;

/**
 *
 * @author Administrator
 */
public class Ports {
    String[] ports;

  Ports()
  {
    this.ports = new String[256];
    for (int i = 0; i < 256; i++) this.ports[i] = "00"; 
  }

  void setPort(String hex, int pos)
  {      
      this.ports[pos] = hex.toUpperCase();
  }

  String getPort(int pos) {
    String hex = this.ports[pos];
    return hex;
  }

  String getPortBinary(int pos) {
    String hex = this.ports[pos];
    int temp = Integer.parseInt(hex, 16);
    String bin = Integer.toBinaryString(temp);
    while(bin.length()<8)
        bin='0'+bin;
    return bin;
  }
  public void reset(){
     for (int i = 0; i < 256; i++) 
         this.ports[i] = "00";  
  }
  public String [] getPortsArray(){
      return ports;
  }
      
}
