
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;

/**
 * Final
 *
 * @author Keyvan Derakhshan Nik
 */
@ManagedBean
@SessionScoped
public class Utilities {
    String path="c:/Users/keyva/Documents/NetBeansProjects/MasterCSProjectWEB_15/web/resources/files/";
    //String path="../../../../../../../../../../Users/keyva/Documents/NetBeansProjects/MasterCSProjectWEB_15/web/resources/files/";
    // n =7 q=43 q1=41 q2=43 d=2 //n=157 q1=269 q2=271 d=52
    private int n ;
    private int p =3;
    private int q ;
    private int q1;
    private int q2;
    private int d;
    double[] zero = {0};
    double[] one = {1};
    // Zero polynomial
    PolynomialFunction zeros=new PolynomialFunction(zero);
    // One PolyNomial
     PolynomialFunction ones=new PolynomialFunction(one);
    // z= x^7-1
    PolynomialFunction z=new PolynomialFunction(zero);
    // p must be in polynomial to multiply
    PolynomialFunction pp=new PolynomialFunction(zero);
    //q must be in polynomial to multiply
    PolynomialFunction pq=new PolynomialFunction(zero);
    //q must be in polynomial to multiply
    PolynomialFunction pq1=new PolynomialFunction(zero);
    //q must be in polynomial to multiply
    PolynomialFunction pq2=new PolynomialFunction(zero);
    //Polynomial F
    PolynomialFunction f=new PolynomialFunction(zero);
    //Polynomial G
    PolynomialFunction g=new PolynomialFunction(zero);
    //Polynomial R or Ro 
    PolynomialFunction r=new PolynomialFunction(zero);
    //Polynomial R1 or Ro 
    PolynomialFunction r1=new PolynomialFunction(zero);
    //Polynomial R2 or Ro in Rq2
    PolynomialFunction r2=new PolynomialFunction(zero);
    //Polynomial R1 or Ro 
    PolynomialFunction newr1=new PolynomialFunction(zero);
    //Polynomial R2 or Ro in Rq2
    PolynomialFunction newr2=new PolynomialFunction(zero);
    //polynomial f_inv_q;
    PolynomialFunction f_inv_q=new PolynomialFunction(zero);
    //polynomial f_inv_q1;
    PolynomialFunction f_inv_q1=new PolynomialFunction(zero);   
    //polynomial f_inv_p;
    PolynomialFunction f_inv_p=new PolynomialFunction(zero);
    //polynomial g_inv_q1;
    PolynomialFunction g_inv_q1=new PolynomialFunction(zero);
    //polynomial p_inv_q1;
    PolynomialFunction p_inv_q1=new PolynomialFunction(zero);    
    //polynomial H
    PolynomialFunction h=new PolynomialFunction(zero);
    //polynomial H1 for D-NTRU
    PolynomialFunction h1=new PolynomialFunction(zero);
    //polynomial H2 for D-NTRU
    PolynomialFunction h2=new PolynomialFunction(zero);
    //polynomial G for D-NTRU
    PolynomialFunction dg=new PolynomialFunction(zero);   
    //polynomial Message
    PolynomialFunction m=new PolynomialFunction(zero);
    //Polynomial NTRU Encryption
    PolynomialFunction NTRU_EN=new PolynomialFunction(zero);
    //Polynomial NTRU Decryption
    PolynomialFunction NTRU_DE=new PolynomialFunction(zero);
    //Polynomial NTRU Encryption
    PolynomialFunction DNTRU_EN1=new PolynomialFunction(zero);
    //Polynomial NTRU Encryption
    PolynomialFunction DNTRU_EN2=new PolynomialFunction(zero);
    //Polynomial NTRU Decryption
    PolynomialFunction DNTRU_DE=new PolynomialFunction(zero);
    //String input as plaintext
    String plain;
    //String output as cipher text NTRU
    String encryptedNTRU;
    //String output as decrypted NTUR text
    String decryptedNTRU;
    //String output as cipher text NTRU
    String encryptedDNTRU;
    //String output as decrypted NTUR text
    String decryptedDNTRU;
    //message
    private String message;
    public String getPlain() {
        return plain;
    }
    public void setPlain(String plain) {
        this.plain = plain;
    }
    public String getEncryptedNTRU() {
        return encryptedNTRU;
    }
    public void setEncryptedNTRU(String encryptedNTRU) {
        this.encryptedNTRU = encryptedNTRU;
    }
    public String getDecryptedNTRU() {
        return decryptedNTRU;
    }
    public void setDecryptedNTRU(String decryptedNTRU) {
        this.decryptedNTRU = decryptedNTRU;
    }
    public String getEncryptedDNTRU() {
        return encryptedDNTRU;
    }
    public void setEncryptedDNTRU(String encryptedDNTRU) {
        this.encryptedDNTRU = encryptedDNTRU;
    }
    public String getDecryptedDNTRU() {
        return decryptedDNTRU;
    }
    public void setDecryptedDNTRU(String decryptedDNTRU) {
        this.decryptedDNTRU = decryptedDNTRU;
    }
    public String getMessage() {
        return message;
    }
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    public int getP() {
        return p;
    }
    public void setP(int p) {
        setPp(p);
        this.p = p;
    }
    public int getQ() {
        return q;
    }
    public void setQ(int q) {        
        setPq(q);
        this.q = q;
    }
    public int getQ1() {
        return q1;
    }
    public void setQ1(int q1) {        
        setPq1(q1);
        this.q1 = q1;
    }
    public int getQ2() {
        return q2;
    }
    public void setQ2(int q2) {                
        setPq2(q2);
        this.q2 = q2;
    }
    public int getD() {
        return d;
    }
    public void setD(int d) {
        this.d = d;
    }
    public String getP_inv_q1() {
        return mirrorPolynomial(p_inv_q1);
    }
    public void setP_inv_q1() {        
        double []coef={intEucldean(this.q1, this.p,0,1)};
        this.p_inv_q1 = new PolynomialFunction(coef);
    }
    public String getZ() {
        return mirrorPolynomial(this.z);        
    }
    public void setZ() {
        setN(this.n);
        //coefficients of z=x^N-1 
        ArrayList<Double> z_c = new ArrayList();
        z_c.add(-1.0);
        for (int i=0;i<this.n-1;i++)
            z_c.add(0.0);
        z_c.add(1.0);
        double[] z_co = new double[z_c.size()];
        for (int i=0;i<z_co.length;i++)
            z_co[i]=z_c.get(i);
        //Polynomial Z        
        this.z = new PolynomialFunction(z_co);
    }
    public void setPp(int p) {
        double[] p_co = {p};
        this.pp = new PolynomialFunction(p_co);
    }
    public void setPq(int q) {
        double[] q_co = {q};
        this.pq = new PolynomialFunction(q_co);
    }
    public void setPq1(int q1) {
        double[] q1_co = {q1};
        this.pq1 = new PolynomialFunction(q1_co);
    }
    public void setPq2(int q2) {
        double[] q2_co = {q2};
        this.pq2 = new PolynomialFunction(q2_co);
    }
    public String getF() {
        return mirrorPolynomial(f);
    }
    public String getF_inv_q() {
        return mirrorPolynomial(this.f_inv_q);
    }
    public String getF_inv_q1() {
        return mirrorPolynomial(this.f_inv_q1);
    }
    public String getF_inv_p() {
        return mirrorPolynomial(this.f_inv_p);
    }
    public String getNewr1() {
        return mirrorPolynomial(newr1);
    }
    public String getNewr2() {
        return mirrorPolynomial(newr2);
    }
    public String getG_inv_q1() {
        return mirrorPolynomial(this.g_inv_q1);
    }
    public void setF() {        
        //coefficients f=("x^6-x^4+x^3+x^2-x^0");
        //double[] f_co = {-1, 0, 1, 1, -1, 0, 1};
        double[] f_co =randomCoef(this.n,this.z,d,d-1,q,p);
        //polynomial f
        PolynomialFunction f = new PolynomialFunction(f_co);
        //coefficients f_inv_q=("8x^6+26x^5+31x^4+21x^3+40X^2+2x^1+37x^0");
        //double[] f_inv_q_co = {37, 2, 40, 21, 31, 26, 8};
        //this.f_inv_q = new PolynomialFunction(f_inv_q_co);
        this.f_inv_q=polynomialEucldean(this.z, f, zeros,ones,this.q);
        this.f_inv_q1=polynomialEucldean(this.z, f, zeros,ones,this.q1);
        //coefficients f_inv_p=("x^6+2x^5+x^3+x^2+x^1+x^0");
        //double[] f_inv_p_co = {1, 1, 1, 1, 0, 2, 1};
        //this.f_inv_p = new PolynomialFunction(f_inv_p_co);
        this.f_inv_p=polynomialEucldean(this.z, f, zeros,ones,this.p);
        this.f = f;
    }
    public String getG() {
        return mirrorPolynomial(g);
    }
    public void setG() {
        
        //coefficients g=("x^6+x^4-x^2-x^1");
        //double[] g_co = {0, -1, -1, 0, 1, 0, 1};        
        double[] g_co =randomCoef(n,this.z,d,d-1,q,0);
        //polynomial g
        PolynomialFunction g = new PolynomialFunction(g_co);
        this.g_inv_q1=polynomialEucldean(this.z, g, zeros,ones,this.q1);
        this.g = g;
    }
    public String getH() {
        return mirrorPolynomial(this.h);
    }
    public void setH() {
        this.h = intMod(polynomialMode(this.f_inv_q.multiply(this.g).multiply(this.pp), this.z, this.q), this.q);
    }
    public String getH1() {
        return mirrorPolynomial(this.h1);
    }
    public void setH1() {
        PolynomialFunction tmpH1=intMod(polynomialMode(this.f_inv_q1.multiply(this.g), this.z, this.q1), this.q1);
        this.h1=intMod(polynomialMode(tmpH1.multiply(this.pp), this.z, this.q1), this.q1);
     //   this.h1 = intMod(polynomialMode(this.f_inv_q1.multiply(this.g).multiply(this.pp), this.z, this.q1), this.q1);
    }
    public String getH2() {
        return mirrorPolynomial(this.h2);
    }
    public void setH2() {
         //  this.h2=new PolynomialFunction(randomCoef(n,z,d,d,0,0));
        this.h2 =randomGenerator(this.n,this.q2) ;
    }
    public String getDg() {
        return mirrorPolynomial(dg);
    }
    public String getR() {
        return mirrorPolynomial(r);
    }
    public void setR() {
        //coefficients r=("x^6-x^5+x^1-x^0");
        //double[] r_co = {-1, 1, 0, 0, 0, -1, 1};
        double[] r_co =randomCoef(this.n,this.z,d,d,0,0);
        //polynomial r;
        PolynomialFunction r = new PolynomialFunction(r_co);
        this.r = r;
    }
    public String getR1() {
        return mirrorPolynomial(r1);
    }
    public void setR1() {
        double[] r1_co =randomCoef(this.n,this.z,d,d,0,0);
        PolynomialFunction r1 = new PolynomialFunction(r1_co);
        //our changes --> r1 mode P 
        //this.r1 = randomGenerator(this.n,this.p) ;
        this.r1 = r1;
//    this.r1 = randomGenerator(this.n,this.q1) ;
    }
    public String getR2() {
        return mirrorPolynomial(r2);
    }
    public void setR2() {
//       this.r2 = randomGenerator(this.n,this.q2) ;
    this.r2 = randomGenerator(this.n,this.p) ;
    }
    public void setDg() {
        setP_inv_q1();
        this.dg = intMod(polynomialMode(this.g_inv_q1.multiply(this.p_inv_q1),this.z,this.q1),this.q1);
    }
    public String getM() {
        return mirrorPolynomial(m);
    }
    public void setM(double[] mes) {
        setPlain(this.plain);
        //coefficients m=("-x^5+x^3+x^2-x+1");
        message=getPlain();
        double[] m_co = {0};
        if (mes.length==0)
            m_co[0]=0.0;
        else        
            m_co=mes;
        //polynomial m;
        PolynomialFunction m = new PolynomialFunction(m_co);
        //message = mirrorPolynomial(m);
        this.m = m;
    }
    public String getNTRU_EN() {
        return mirrorPolynomial(this.NTRU_EN);
    }
    public void setNTRU_EN() {
        this.NTRU_EN = NTRUEncryption(this.r, this.h, this.m, this.z, this.q);
    }
    public String getNTRU_DE() {
        return mirrorPolynomial(this.NTRU_DE);
    }
    public void setNTRU_DE() {
        //setNTRU_EN();
        this.NTRU_DE = NTRUDecryption(this.NTRU_EN, this.f, this.f_inv_p, this.z, this.p, this.q);
    }
    public String getDNTRU_EN1() {
        return mirrorPolynomial(this.DNTRU_EN1);
    }
    public void setDNTRU_EN1() {
        this.DNTRU_EN1 = DNTRUEncryption(this.r1, this.h1, this.r2, this.z, this.q1);
    }
    public String getDNTRU_EN2() {
        return mirrorPolynomial(this.DNTRU_EN2);
    }
    public void setDNTRU_EN2() {
        this.DNTRU_EN2 = DNTRUEncryption(this.r1, this.h2, this.r2.add(this.m), this.z, this.q2);
    }
    public String getDNTRU_DE() {
        return mirrorPolynomial(this.DNTRU_DE);
    }
    public void setDNTRU_DE() {
        //setNTRU_EN();
        this.DNTRU_DE = DNTRUDecryption(this.DNTRU_EN1,this.DNTRU_EN2,this.f,this.f_inv_p,this.dg,this.h2,this.z,this.q1,this.q2, this.p);
    }
    
//NTRU Encryption    
    public PolynomialFunction NTRUEncryption(PolynomialFunction r, PolynomialFunction h, PolynomialFunction m, PolynomialFunction z, int q) {
        //PolynomialFunction encrypt = intMod(polynomialMode(m.add(r.multiply(h)), z, q), q);
        PolynomialFunction encrypt = intMod(polynomialMode(m.add(polynomialMode((r.multiply(h)),z,q)), z, q), q);
        System.out.println("Encryption is: " + mirrorPolynomial(encrypt));
        return encrypt;
    }
//NTRU Decryption
    public PolynomialFunction NTRUDecryption(PolynomialFunction e, PolynomialFunction f, PolynomialFunction f_inv_p, PolynomialFunction z, int p, int q) {
        PolynomialFunction s = intMod2(polynomialMode((f.multiply(e)), z, q), q);
        System.out.println("S in Decryption: " + mirrorPolynomial(s));
        PolynomialFunction dec = intMod(polynomialMode((f_inv_p.multiply(s)), z, p), p);
        System.out.println("Final Decryption: " + mirrorPolynomial(dec));
        return dec;
    }
//D-NTRU Encryption which is called twice for c1 , c2
  public PolynomialFunction DNTRUEncryption(PolynomialFunction a,PolynomialFunction x,PolynomialFunction b,PolynomialFunction z, int q){
  return intMod(polynomialMode(b.add(polynomialMode((a.multiply(x)),z,q)),z,q),q);
  }  
//D-NTRU Decryption c2
  public PolynomialFunction DNTRUDecryption(PolynomialFunction c1,PolynomialFunction c2,PolynomialFunction f,PolynomialFunction f_inv_p,PolynomialFunction dg,PolynomialFunction h2,PolynomialFunction z, int q1,int q2,int p){
  PolynomialFunction s=intMod2(polynomialMode(f.multiply(c1),z,q1),q1);
  PolynomialFunction r2=intMod(polynomialMode(s.multiply(f_inv_p),z,p),p);
  this.newr2=r2;
  PolynomialFunction r1=intMod2(polynomialMode(dg.multiply(s.subtract(polynomialMode(f.multiply(r2),z,q1))),z,q1),q1);
  //PolynomialFunction r1=intMod(polynomialMode(dg.multiply(s.subtract(f.multiply(r2))),z,q1),q1);
  this.newr1=r1;
  PolynomialFunction mul=intMod(polynomialMode(r1.multiply(h2),z,q2),q2);
  PolynomialFunction tmp=intMod(r2.add(mul),q2);
  PolynomialFunction result= intMod(c2.subtract(tmp),q2);
  //PolynomialFunction result= intMod(polynomialMode(c2.subtract(r2.subtract(r1.multiply(h2))),z,q2),q2);
  return result;
  }
//MirrorPolynomial to Switch .toString function and make readable String     
    public String mirrorPolynomial(PolynomialFunction pf) {
        String temp = new String();
        double[] coeff = pf.getCoefficients();
        for (int i = (coeff.length - 1); i >= 0; i--) {
            if ((i != 0) & (i != 1)) {
                if (coeff[i] < -1) {
                    temp = temp + " " + (int) coeff[i] + " x^" + i;
                } else if (coeff[i] == -1) {
                    temp = temp + " -" + " x^" + i;
                } else if (coeff[i] == 1) {
                    temp = temp + " +" + " x^" + i;
                } else if (coeff[i] > 1) {
                    temp = temp + " +" + (int) coeff[i] + " x^" + i;
                }
            } else if (i == 0) {
                if (coeff[i] < 0) {
                    temp = temp + " " + (int) coeff[i];
                } else if (coeff[i] > 0) {
                    temp = temp + " +" + (int) coeff[i];
                }
            } else if (i == 1) {
                if (coeff[i] < -1) {
                    temp = temp + " " + (int) coeff[i] + " x";
                } else if (coeff[i] == -1) {
                    temp = temp + " -" + " x";
                } else if (coeff[i] == 1) {
                    temp = temp + " +" + " x";
                } else if (coeff[i] > 1) {
                    temp = temp + " +" + (int) coeff[i] + " x";
                }
            }
        }
        return temp;
    }
//Random Polynomial Generator in Rq2
    public PolynomialFunction randomGenerator(int n, int q2) {
        double[] rand = new double[n];        
        for (int i = 0; i < rand.length; i++) {
            rand[i] = (int) (Math.random() * 50) % q2;           
        }
        return new PolynomialFunction(rand);
    }
//Random Array Generator
    public double[] randomArray(int n, int ones, int negones) {
        double[] rand = new double[n];
        int one = 0, negone = 0;
        for (int i = 0; i < rand.length; i++) {
            rand[i] = (int) (Math.random() * 50) % 3 - 1;
        };
        for (int i = 0; i < rand.length; i++) {
            if (rand[i] == 1) {
                one++;
            }
            if (rand[i] == -1) {
                negone++;
            }
        }
        if (one == ones && negone == negones) {
            return rand;
        } else {
            return randomArray(n, ones, negones);
        }
    }
//Random coef Generator
    public double[] randomCoef(int n, PolynomialFunction z, int d1, int d2, int q, int p) {
        double[] temp = randomArray(n, d1, d2);
        PolynomialFunction pf = new PolynomialFunction(temp);
        double[] zero = {0};
        double[] one = {1};
        // Zero polynomial
        PolynomialFunction zeros = new PolynomialFunction(zero);
        // One PolyNomial
        PolynomialFunction ones = new PolynomialFunction(one);
        
        //random for R or Ro
        if ((q == 0) && (p == 0)) {
            return temp;
            //raandom for g
        } else if ((q != 0) && (p == 0)) {
            while (polynomialEucldean(z, pf, zeros, ones, q).equals(zeros)) {
                temp = randomArray(n, d1, d2);
                pf = new PolynomialFunction(temp);   
                System.out.println("Test" +mirrorPolynomial(pf)+ " Multiply : "+ mirrorPolynomial(polynomialMode(pf.multiply(polynomialEucldean(z, pf, zeros, ones, q)),z,q)));
            }
            System.out.println("Final: "+mirrorPolynomial(pf)+ "Inverse : "+ mirrorPolynomial(polynomialEucldean(z, pf, zeros, ones, q)));
            System.out.println("Multiply : "+ mirrorPolynomial(polynomialMode(pf.multiply(polynomialEucldean(z, pf, zeros, ones, q)),z,q)));
            return temp;
        } else {
            while (polynomialEucldean(z, pf, zeros, ones, q).equals(zeros) || polynomialEucldean(z, pf, zeros, ones, p).equals(zeros)) {
                temp = randomArray(n, d1, d2);
                pf = new PolynomialFunction(temp);
            }
            return temp;
        }
    }
// Polynomial (mod int) (-b/2 b/2]
    public PolynomialFunction intMod2(PolynomialFunction a, int b) {
        double[] temp_coeff = a.getCoefficients();
        for (int i = 0; i < temp_coeff.length; i++) {
            if (temp_coeff[i] % b > b / 2) {
                temp_coeff[i] = temp_coeff[i] % b - b;
            } else if (temp_coeff[i] % b <= -b / 2) {
                temp_coeff[i] = temp_coeff[i] % b + b;
            } else {
                temp_coeff[i] = temp_coeff[i] % b;
            }
        }
        return new PolynomialFunction(temp_coeff);
    }
// Polynomial (mod int) 0 - b
    public PolynomialFunction intMod(PolynomialFunction a, int b) {
        double[] temp_coeff = a.getCoefficients();
        for (int i = 0; i < temp_coeff.length; i++) {
            if (temp_coeff[i] >= 0) {
                temp_coeff[i] = temp_coeff[i] % b;
            } else {
                while (temp_coeff[i] < 0) {
                    temp_coeff[i] = temp_coeff[i] + b;
                }
            }
        }
        return new PolynomialFunction(temp_coeff);
    }
//Polynomial (mode Polynomial with coeffecient of degree is 1)
    public PolynomialFunction polynomialMode(PolynomialFunction a, PolynomialFunction b, int base) {        
        a=intMod(a,base);
        b=intMod(b,base);
        //a is dividend
        double[] a_coeff = a.getCoefficients();
        //b is denominator
        double[] b_coeff = b.getCoefficients();
        double[] zero = {0};
        PolynomialFunction zeros = new PolynomialFunction(zero);
        if (a.degree() < b.degree()) {
            return a;
        } else {
            //r is reminder
            double[] r_coeff;
            PolynomialFunction r = new PolynomialFunction(a_coeff);
             r_coeff = r.getCoefficients();
            while ((r.degree() >= b.degree())&&(!b.equals(zeros))&&((!r.equals(zeros)))) {
               ArrayList<Integer> tmp = new ArrayList<Integer>();
                for (int i = 0; i < r.degree() - b.degree(); i++) {
                    tmp.add(0);
                }
                if (b_coeff[b_coeff.length - 1] != 0) {
                    int inv = intEucldean((int) base, (int) b_coeff[b_coeff.length - 1], 0, 1);
                    tmp.add(inv*(int)r_coeff[r_coeff.length-1]);
                    double[] temp_coeff = new double[r.degree() - b.degree() + 1];
                    for (int j = 0; j < tmp.size(); j++) {
                        temp_coeff[j] = tmp.get(j);
                    }
                    PolynomialFunction temp = new PolynomialFunction(temp_coeff);
                    PolynomialFunction temp_reminder = r;
                    //r = intMod((temp_reminder.subtract(temp.multiply(b))), base);
                    r = intMod((temp_reminder.subtract(intMod((temp.multiply(b)),base))), base);
                    //r = (temp_reminder.subtract(intMod((temp.multiply(b)),base)));
                    r_coeff = r.getCoefficients();
                } else {
                    return zeros;
                }
            }
            //return intMod(r,base);
            return r;
        }
    }
//Polynomial division Function to make inverse
    public PolynomialFunction polynomialDivision(PolynomialFunction a, PolynomialFunction b, int base) {        
        a=intMod(a,base);
        b=intMod(b,base);
     //a is dividend
        double[] a_coeff = a.getCoefficients();
        //b is denominator
        double[] b_coeff = b.getCoefficients();
        double[] zero = {0};
        PolynomialFunction zeros = new PolynomialFunction(zero);
        if (a.degree() < b.degree()) {
            return zeros;
        } else {
            //r is reminder
            double[] r_coeff;
            PolynomialFunction r = new PolynomialFunction(a_coeff);
             r_coeff = r.getCoefficients();
            //qou is qoutient
            double[] q_coeff = new double[a.degree() - b.degree() + 1];
            PolynomialFunction qou = new PolynomialFunction(q_coeff);
             while ((r.degree() >= b.degree())&&(!b.equals(zeros))&&((!r.equals(zeros)))) {
                 
                 ArrayList<Integer> tmp = new ArrayList<Integer>();
                for (int i = 0; i < r.degree() - b.degree(); i++) {
                    tmp.add(0);
                }
                if (b_coeff[b_coeff.length - 1] != 0) {
                    int inv = intEucldean((int) base, (int) b_coeff[b_coeff.length - 1], 0, 1);
                    tmp.add(inv*(int) r_coeff[r_coeff.length-1]);
                    double[] temp_coeff = new double[r.degree() - b.degree() + 1];
                    for (int j = 0; j < tmp.size(); j++) {
                        temp_coeff[j] = tmp.get(j);
                    }
                    PolynomialFunction temp = new PolynomialFunction(temp_coeff);
                    qou = qou.add(temp);
                    PolynomialFunction temp_reminder = r;
                    //r = intMod((temp_reminder.subtract(temp.multiply(b))), base);
                    r = intMod((temp_reminder.subtract(intMod((temp.multiply(b)),base))), base);
                    //r = (temp_reminder.subtract(intMod((temp.multiply(b)),base)));
                    r_coeff = r.getCoefficients();
                } else {
                     return zeros;
                }
            }
            //return intMod(qou,base);
            return qou;
        }
    }
//Polynomial Eucldean Function to make inverse
    public PolynomialFunction polynomialEucldean(PolynomialFunction a, PolynomialFunction b, PolynomialFunction t0, PolynomialFunction t1, int c) {
        a=intMod(a,c);
        b=intMod(b,c);
         //a is dividend
        double[] a_coeff = a.getCoefficients();
        //b is denominator
        double[] b_coeff = b.getCoefficients();
        double[] zero = {0};
        PolynomialFunction zeros = new PolynomialFunction(zero);
        double[] one = {1};
        PolynomialFunction ones = new PolynomialFunction(one);
        if (a.degree() < b.degree()) {
            return zeros;
        } else if (intMod(polynomialMode(a, b, c), c).equals(zeros)) {
           
           if (b.degree()==0){
                double[] inv_co = {intEucldean((int) c, (int) b_coeff[b_coeff.length - 1], 0, 1)};                
                PolynomialFunction invert = new PolynomialFunction(inv_co);
                return intMod(t1.multiply(invert),c);
            }else{
                return zeros;
           }
        } else {
            PolynomialFunction t2 = intMod(t0.subtract(t1.multiply(polynomialDivision(a, b, c))), c);
            //System.out.println(" a = " + mirrorPolynomial(a) + "   b= " + mirrorPolynomial(b) + "   reminder= " + mirrorPolynomial(intMod(polynomialMode(a, b, c),c)) +" Q: "+ mirrorPolynomial(intMod(polynomialDivision(a, b, c),c)) + "   t1=  " + mirrorPolynomial(t1));
            //return polynomialEucldean(b, intMod(polynomialMode(a, b, c), c), t1, t2, c);
            PolynomialFunction temp=intMod(polynomialMode(a, b, c),c);
             return polynomialEucldean(b, temp, t1, t2, c);
        }
    }
// Int Eucldean    
    public int intEucldean(int a, int b, int t0, int t1) {
        if (b == 1 && a % b == 0) {
            return t1;
        } else if (b != 1 && a % b == 0) {
            return 0;
        } else {             
            return intEucldean(b, a % b, t1, t0 - ((a / b) * t1));
        }
    }
//Parse String to Polynomial to read plaintext m    
    public double[] parsePolynomialString(String x) {
        double[] co;
        ArrayList<String> text = new ArrayList();
        //trim X to remove spaces
        x = x.replaceAll("\\s", "");
        String origx = x;
        while (countPlusMinus(x) > 1) {
            text.add(x.substring(0, minimum(x.indexOf('+', 1), x.indexOf('-', 1))));
            x = x.substring(minimum(x.indexOf('+', 1), x.indexOf('-', 1)));
        }
        text.add(x);
        System.out.println("***************** :"+text.toString());
        if (origx.contains("^")) {
            co = new double[Integer.parseInt(text.get(0).substring(text.get(0).indexOf("x^") + 2)) + 1];
            // System.out.println(text.get(0).substring(text.get(0).indexOf("x^")+2));
        } else if (origx.contains("x")) {
            co = new double[2];
        } else {
            co = new double[1];
        }
        for (int i = 0; i < text.size(); i++) {
            if (text.get(i).contains("x^")) {
                if ((text.get(i).substring(0, text.get(i).indexOf("x"))).length() == 1) {
                    if ((text.get(i).substring(0, text.get(i).indexOf("x"))).equals("+")) {
                        //co[Integer.parseInt(text.get(i).substring(text.get(i).indexOf("x^") + 2))] = +1.0;
                        co[Integer.parseInt(text.get(i).substring(text.get(i).indexOf("^")+1))]=+1.0;
                        
                    } else if ((text.get(i).substring(0, text.get(i).indexOf("x"))).equals("-")) {
                        //co[Integer.parseInt(text.get(i).substring(text.get(i).indexOf("x^") + 2))] = -1.0;
                        co[Integer.parseInt(text.get(i).substring(text.get(i).indexOf("^")+1))]=-1.0;
                    }
                } else {
                    //co[Integer.parseInt(text.get(0).substring(text.get(0).indexOf("x^") + 2))] = Double.parseDouble(text.get(i).substring(0, text.get(i).indexOf("x^")));
                    co[Integer.parseInt(text.get(i).substring(text.get(i).indexOf("^")+1))]= Double.parseDouble(text.get(i).substring(0, text.get(i).indexOf("x")));                    
                }
            } else if ((!text.get(i).contains("x^")) && (text.get(i).contains("x"))) {
                if ((text.get(i).substring(0, text.get(i).indexOf("x"))).length() == 1) {
                    if ((text.get(i).substring(0, text.get(i).indexOf("x"))).equals("+")) {
                        co[1] = +1.0;
                    } else if ((text.get(i).substring(0, text.get(i).indexOf("x"))).equals("-")) {
                        co[1] = -1.0;
                    }
                } else {
                    co[1] = Double.parseDouble(text.get(i).substring(0, text.get(i).indexOf("x")));
                }
            } else if ((!text.get(i).contains("x^")) && !(text.get(i).contains("x"))) {
                co[0] = Double.parseDouble(text.get(i));
            }
        }
        return co;
    }
//to find minimum index for + and -
    public int minimum(int a, int b) {
        if (a == -1) {
            return b;
        } else if (b == -1) {
            return a;
        } else if (a < b) {
            return a;
        } else {
            return b;
        }
    }
//count number of + and - in a string
    public int countPlusMinus(String text) {
        int count = 0;
        char[] chr = text.toCharArray();
        for (int i = 0; i < chr.length; i++) {
            if ((chr[i] == '+') || (chr[i] == '-')) {
                count++;
            }
        }
        return count;
    }
//read a char and find its polynomial
    public double[] readChar(char ch){
        double[] temp=new double[8];
        String s=Character.toString(ch);
        byte[] bytes = s.getBytes();
        StringBuilder binary = new StringBuilder();
        for (int j = 0; j < bytes.length; j++) {
            int val = bytes[j];
            for (int i = 0; i < 7; i++) {
                val <<= 1;
                binary.append((val & 128) == 0 ? 0 : 1);
            }
        }
        for(int i=0;i<7;i++){
            temp[i]=binary.charAt(6-i)-48;            
        }        
        temp[7]=0;
        return temp;
    }
//read chars takes some chars and returns their polynomial coefficient
    public double[] readChars(char[] chs){
    double[] result= new double[(7*chs.length)-1];
    for (int i=0;i<chs.length;i++)
        result=concat(readChar(chs[i]),result);
    return result;
    }
//write a char or string from polynomial
    public String writePolynomial(double[] coef){
        String result;       
        byte[] bytes=new byte[coef.length];       
        for (int i=0;i<coef.length;i++){
            if (coef[i]==1.0)              
              bytes=setBit(bytes, 7-i,1);              
            else
                bytes=setBit(bytes,7-i,0);
        }       
        try { 
            result = new String(bytes,"UTF-8");  // Best way to decode using "UTF-8"	    
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}
        result = new String(bytes);        
       return result;
    }
//write polinomials to gether
    public String writePolynomials(double[] coef){
        String result=new String();
        int length;
        int index=0;
        if (coef.length<8){
            length=1;
        }else{
            if ((coef.length%8)==0)
                length=coef.length/8;
            else
                length=(coef.length/8) +1;
        }for(int i=0;i<length;i++){
            
            double[] tempCoef=new double[8];
//            System.arraycopy(coef,index,tempCoef,0,8);
            tempCoef=copyArr(coef,index);
            index=index+8;
            result=writePolynomial(tempCoef)+result;
        }   
            
        return result;
    }
// Copy array with specific length=7
    public double[] copyArr(double[] coef,int index){
        int count=coef.length;
//        int temp;
//        temp=count;
//        while((temp%8)!=0)
//            temp++;
        double[] result=new double[8];
        if ((index+8)<=count){
            for(int i=0;i<8;i++){
                result[i]=coef[i+index];
            }
        }else{
            for(int j=0;j<(count-index);j++){
                result[j]=coef[j+index];
            }
        }
        return result;
    }
//set bit in a byte
    public byte[] setBit(byte[] data, int pos, int val) {
      int posByte = pos/8; 
      int posBit = pos%8;
      byte oldByte = data[posByte];
      oldByte = (byte) (((0xFF7F>>posBit) & oldByte) & 0x00FF);
      byte newByte = (byte) ((val<<(8-(posBit+1))) | oldByte);
      data[posByte] = newByte;
      return data;
   }
// To Concatenate two arrays
    private double[] concat(double[] a, double[] b) {
    final int alen = a.length;
    final int blen = b.length;
    if (alen == 0) {
        return b;
    }
    if (blen == 0) {
        return a;
    }
    final double[] result = (double[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), alen + blen);
    System.arraycopy(a, 0, result, 0, alen);
    System.arraycopy(b, 0, result, alen, blen);
    return result;
}
// take sub char from char array
    public char[] subChars(ArrayList<Character> source,int start,int len){
    char [] temp=new char [len];
    String s1=new String();
    String s2=new String();
    for(int i=0;i<source.size();i++)
        s1=s1+source.get(i);
    while (s2.isEmpty()){
    if (source.size()>=(start+len))
        if (len!=0)
            s2=s1.substring(start,start+len);
        else
            s2=s1.substring(start,start+1);
    else
        len=len-1;
    }
    temp=s2.toCharArray();
    return temp;
    }
// when click this function is fired
    public void check() {        
        ArrayList <String> cipherTextNTRU=new ArrayList();
        ArrayList <String> decipherTextNTRU=new ArrayList();
        ArrayList <String> cipherTextDNTRU=new ArrayList();
        ArrayList <String> decipherTextDNTRU=new ArrayList();  
        int lengthOfSample;
        int totalSample;
        //keyGenerate();
        fillVariables();      
        
        //setP_inv_q1();
        setR();
        setR1();
        setR2();    
        String words = getPlain();
        ArrayList<Character> chars = new ArrayList<Character>();
        for(int i = 0; i<words.length(); i++){
           chars.add(words.charAt(i));
           }
        lengthOfSample=(((int)n+1)/(int)8);
        if (chars.size()%lengthOfSample ==0)
            totalSample=(int)chars.size()/(int)lengthOfSample;
        else 
            totalSample=((int)chars.size()/(int)lengthOfSample)+1;
       System.out.println("Length of sample : "+lengthOfSample+ "Number of sampleing : "+totalSample);
       int index=0;
       for(int i=0;i<totalSample;i++){ 
            char[] tempChars=new char[lengthOfSample]; 
            
            tempChars=subChars(chars,index,lengthOfSample);
            //System.arraycopy(chars,index,tempChars,0,lengthOfSample);
            index=index+lengthOfSample;
            setM(readChars(tempChars));
            setNTRU_EN();
            //cipherTextNTRU.add(writePolynomial(this.NTRU_EN.getCoefficients()));
            setNTRU_DE();            
            decipherTextNTRU.add(writePolynomials(this.NTRU_DE.getCoefficients()));
            setDNTRU_EN1();
            
            setDNTRU_EN2();
            //cipherTextDNTRU.add(writePolynomial(this.DNTRU_EN2.getCoefficients()));
            setDNTRU_DE();
            decipherTextDNTRU.add(writePolynomials(this.DNTRU_DE.getCoefficients()));
        }        
        setEncryptedNTRU(cipherTextNTRU.toString());
        setDecryptedNTRU(decipherTextNTRU.toString());
        setEncryptedDNTRU(cipherTextDNTRU.toString());
        setDecryptedDNTRU(decipherTextDNTRU.toString());
    }
    public void keyGenerate(){
        setZ();
        setP(this.p);
        setQ(this.q);
        setQ1(this.q1);
        setQ2(this.q2);        
        setD(this.d);
        setF();
        setG();
        setH();
        setH1();
        setH2();
        setDg();
        createAndUpdateFiles();
        
    }
//create and update 4 files for NTRU D-NTRU , Private and Public files.
    public void createAndUpdateFiles(){
//        Path currentRelativePath = Paths.get("");
//        String s = currentRelativePath.toAbsolutePath().toString();
//        System.out.println("Current relative path is: " + s);
// Create NTRU Private key file or update it
        String name="NTRUpri.txt";
        String filePath=path+name;
        File f = new File(filePath);
        try {
            if(!f.exists()){
                f.createNewFile();
                PrintWriter writer1 = new PrintWriter(filePath);                
                writer1.println(getN());
                writer1.println(getP());
                writer1.println(getQ());
                writer1.println(getD());
                writer1.println(getF());
                writer1.println(getF_inv_p());
                writer1.flush();
                writer1.close();
                
            }else{
                //System.out.println("File already exists: "+ f.getAbsolutePath());
                f.delete();
                f.createNewFile();
                PrintWriter writer1 = new PrintWriter(filePath);                
                writer1.println(getN());
                writer1.println(getP());
                writer1.println(getQ());
                writer1.println(getD());
                writer1.println(getF());
                writer1.println(getF_inv_p());
                writer1.flush();
                writer1.close(); 
            }
        } catch (IOException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
// Create NTRU Public key file or update it
        name="NTRUpub.txt";
        filePath=path+name;
        f = new File(filePath);
        try {
            if(!f.exists()){
                f.createNewFile();
                PrintWriter writer2 = new PrintWriter(filePath);                
                writer2.println(getN());
                writer2.println(getP());
                writer2.println(getQ());
                writer2.println(getD());
                writer2.println(getH());
                writer2.flush();
                writer2.close();                
            }else{
                //System.out.println("File already exists: "+ f.getAbsolutePath());
                f.delete();
                f.createNewFile();
                PrintWriter writer2 = new PrintWriter(filePath);                
                writer2.println(getN());
                writer2.println(getP());
                writer2.println(getQ());
                writer2.println(getD());
                writer2.println(getH());
                writer2.flush();
                writer2.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
// Create DNTRU Private key file or update it
        name="DNTRUpri.txt";
        filePath=path+name;
        f = new File(filePath);
        try {
            if(!f.exists()){
                f.createNewFile();
                PrintWriter writer3 = new PrintWriter(filePath);                
                writer3.println(getN());
                writer3.println(getP());
                writer3.println(getQ1());
                writer3.println(getQ2());
                writer3.println(getD());
                writer3.println(getF());
                writer3.println(getF_inv_p());
                writer3.println(getDg());
                writer3.flush();
                writer3.close();                
            }else{
                //System.out.println("File already exists: "+ f.getAbsolutePath());
                f.delete();
                f.createNewFile();
                PrintWriter writer3 = new PrintWriter(filePath);                
                writer3.println(getN());
                writer3.println(getP());
                writer3.println(getQ1());
                writer3.println(getQ2());
                writer3.println(getD());
                writer3.println(getF());
                writer3.println(getF_inv_p());
                writer3.println(getDg());
                writer3.flush();
                writer3.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
// Create DNTRU Public key file or update it
        name="DNTRUpub.txt";
        filePath=path+name;
        f = new File(filePath);
        try {
            if(!f.exists()){
                f.createNewFile();
                PrintWriter writer4 = new PrintWriter(filePath);                
                writer4.println(getN());
                writer4.println(getP());
                writer4.println(getQ1());
                writer4.println(getQ2());
                writer4.println(getD());
                writer4.println(getH1());
                writer4.println(getH2());
                writer4.flush();
                writer4.close();                        
            }else{
                //System.out.println("File already exists: "+ f.getAbsolutePath());
                f.delete();
                PrintWriter writer4 = new PrintWriter(filePath);                
                writer4.println(getN());
                writer4.println(getP());
                writer4.println(getQ1());
                writer4.println(getQ2());
                writer4.println(getD());
                writer4.println(getH1());
                writer4.println(getH2());
                writer4.flush();
                writer4.close();
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//fill variables
    public void fillVariables(){
        String name1=path+"NTRUpri.txt";
        String name2=path+"NTRUpub.txt";
        String name3=path+"DNTRUpri.txt";
        String name4=path+"DNTRUpub.txt";
        File NTRUpri = new File(name1);
        File NTRUpub = new File(name2);
        File DNTRUpri = new File(name3);
        File DNTRUpub = new File(name4);
        String line;
        int i=0;
        try{
            if((!NTRUpri.exists())||(!NTRUpub.exists())||(!DNTRUpri.exists())||(!DNTRUpub.exists())){
                keyGenerate();
            }else{                
                BufferedReader br1 = new BufferedReader(new FileReader(NTRUpri));
                while ((line = br1.readLine()) != null) {
                    switch (i){
                        case 0:
                            setN(Integer.parseInt(line));
                            setZ();
                            i++;
                            break;
                        case 1:
                            setP(Integer.parseInt(line));
                            i++;
                            break;
                        case 2:
                            setQ(Integer.parseInt(line));
                            i++;
                            break;
                        case 3:
                            setD(Integer.parseInt(line));
                            i++;
                            break;
                        case 4:
                            double[] f_co =parsePolynomialString(line);
                            PolynomialFunction f = new PolynomialFunction(f_co);
                            this.f=f;
                            i++;
                            break;
                        case 5:
                            double[] f_inv_p_co =parsePolynomialString(line);
                            PolynomialFunction f_inv_p = new PolynomialFunction(f_inv_p_co);
                            this.f_inv_p=f_inv_p;
                            i++;
                            break;
                        default:
                    }                            
                }
                i=0;
                br1.close();
                BufferedReader br2 = new BufferedReader(new FileReader(NTRUpub));
                while ((line = br2.readLine()) != null) {
                    switch (i){
                        case 0:
                            i++;
                            break;
                        case 1:
                            i++;
                            break;
                        case 2:
                            i++;
                            break;
                        case 3:
                            i++;
                            break;
                        case 4:
                            double[] h_co =parsePolynomialString(line);
                            PolynomialFunction h = new PolynomialFunction(h_co);
                            this.h=h;
                            i++;
                            break;
                        default:
                    }                            
                }
                i=0;
                br2.close();
                BufferedReader br3 = new BufferedReader(new FileReader(DNTRUpri));
                while ((line = br3.readLine()) != null) {
                    switch (i){
                        case 0:
                            i++;
                            break;
                        case 1:
                            i++;
                            break;
                        case 2:
                            setQ1(Integer.parseInt(line));
                            i++;
                            break;
                        case 3:
                            setQ2(Integer.parseInt(line));
                            i++;
                            break;
                        case 4:
                            i++;
                            break;
                        case 5:
                            i++;
                            break;
                        case 6:
                            i++;
                            break;
                        case 7:
                            double[] dg_co =parsePolynomialString(line);
                            PolynomialFunction dg = new PolynomialFunction(dg_co);
                            this.dg=dg;
                            i++;
                            break;
                        default:
                    }                            
                }
                i=0;
                br3.close();
                BufferedReader br4 = new BufferedReader(new FileReader(DNTRUpub));
                while ((line = br4.readLine()) != null) {
                    switch (i){
                        case 0:
                            i++;
                            break;
                        case 1:
                            i++;
                            break;
                        case 2:
                            i++;
                            break;
                        case 3:
                            i++;
                            break;
                        case 4:
                            i++;
                            break;
                        case 5:
                            double[] h1_co =parsePolynomialString(line);
                            PolynomialFunction h1 = new PolynomialFunction(h1_co);
                            this.h1=h1;                            
                            i++;
                            break;
                        case 6:
                            double[] h2_co =parsePolynomialString(line);
                            PolynomialFunction h2 = new PolynomialFunction(h2_co);
                            this.h2=h2;
                            i++;
                            break;
                        default:
                    }                            
                
                }
                br4.close();
                i=0;
            }
        }catch(IOException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
