package Simulator;

public class Register
{
  String a;
  String b;
  String c;
  String d;
  String e;
  String h;
  String l;
  String sp;
  String pc;
  String f;
  int cy;
  int p;
  int ac;
  int z;
  int s;
  
  Register()
  {
    this.a = "00"; this.f = "00";
    this.b = "00"; this.c = "00";
    this.d = "00"; this.e = "00";
    this.h = "00"; this.l = "00";
    this.sp = "ffff";
    this.pc = "0000";
  }

 
 

 
  String getA()
  {
    return this.a;
  }

  String getF()
  {
    String fstring = Integer.toString(this.s) + Integer.toString(this.z) + "0" + Integer.toString(this.ac) + "0" + Integer.toString(this.p) + "0" + Integer.toString(this.cy);
    this.f = Integer.toHexString(Integer.parseInt(fstring, 2));
    return this.f;
  }

  String getB()
  {
    return this.b;
  }

  String getC()
  {
    return this.c;
  }

  String getD()
  {
    return this.d;
  }

  String getE()
  {
    return this.e;
  }

  String getH()
  {
    return this.h;
  }

  String getL()
  {
    return this.l;
  }

  String getSP()
  {
    return this.sp;
  }

  String getPC()
  {
    return this.pc;
  }

  String getBC()
  {
    return this.b + this.c;
  }

  String getDE()
  {
    return this.d + this.e;
  }

  String getHL()
  {
    return this.h + this.l;
  }

  int getSign()
  {
    return this.s;
  }

  int getZero()
  {
    return this.z;
  }

  int getAuxCarry()
  {
    return this.ac;
  }

  int getParity()
  {
    return this.p;
  }

  int getCarry()
  {
    return this.cy;
  }

  void setA(String A)
  {
      if(A.length()>2)
          A=A.substring(A.length()-2);
      while(A.length()<2)
          A='0'+A;
      this.a=A;
  }

  void setF(String F)
  {
      this.f = Integer.toHexString(Integer.parseInt(F, 2));
      while(F.length()<8)
          F='0'+F;

    setSign(Integer.parseInt(F.substring(0, 1)));
    setZero(Integer.parseInt(F.substring(1, 2)));
    setAuxCarry(Integer.parseInt(F.substring(3, 4)));
    setParity(Integer.parseInt(F.substring(5, 6)));
    setCarry(Integer.parseInt(F.substring(7, 8)));

  }

  void setB(String B)
  {
      if(B.length()>2)
          B=B.substring(B.length()-2);
      while(B.length()<2)
          B='0'+B;
      this.b=B;
  }

  void setC(String C)
  {
      if(C.length()>2)
          C=C.substring(C.length()-2);
      while(C.length()<2)
          C='0'+C;
      this.c=C;

  }

  void setD(String D)
  {
      if(D.length()>2)
          D=D.substring(D.length()-2);
      while(D.length()<2)
          D='0'+D;
      this.d=D;
  }

  void setE(String E)
  {
      if(E.length()>2)
          E=E.substring(E.length()-2);
      while(E.length()<2)
          E='0'+E;
      this.e=E;
  }

  void setH(String H)
  {
      if(H.length()>2)
          H=H.substring(H.length()-2);
      while(H.length()<2)
          H='0'+H;
      this.h=H;
  }

  void setL(String L)
  {
      if(L.length()>2)
          L=L.substring(L.length()-2);
      while(L.length()<2)
          L='0'+L;
      this.l=L;
  }

  void setSP(String SP)
  {
    if(SP.length()>4)
          SP=SP.substring(SP.length()-4);
      while(SP.length()<4)
          SP='0'+SP;
      this.sp=SP;
  }

  void setPC(String PC)
  {
      if(PC.length()>4)
          PC=PC.substring(PC.length()-4);
      while(PC.length()<4)
          PC='0'+PC;
      this.pc=PC;
  }

  void setSign(int signbit)
  {
    this.s=signbit;
  }

  void setZero(int zerobit)
  {
    this.z=zerobit;
  }

  void setAuxCarry(int ACbit)
  {
      this.ac=ACbit;
  }

  void setParity(int paritybit)
  {
    this.p = paritybit;
  }

  void setCarry(int carrybit)
  {
      this.cy=carrybit;
  }
  void reset(){
    this.a = "00"; this.f = "00";
    this.b = "00"; this.c = "00";
    this.d = "00"; this.e = "00";
    this.h = "00"; this.l = "00";
    this.sp = "ffff";
    this.pc = "0000";
      
  }
}

