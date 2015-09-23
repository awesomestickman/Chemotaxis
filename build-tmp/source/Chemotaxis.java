import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

//declare bacteria variables here

bacteria [] tons;




public void setup()   
{     
  size(400, 400);
  bacteriamaker();
}   
public void draw()   
{    
  background(225);


  for (int i=0; i<tons.length; i++) {
    tons[i].show();
    tons[i].ai();
  }
}  

public void bacteriamaker() {

  tons=new bacteria[500];
  for (int i =0; i<tons.length; i++) {

    //tons[i]=new bacteria(200,200);
    int k =(int)(Math.random()*400);
    int p = (int)(Math.random()*400);

    tons[i]=new bacteria(k, p);
  }
}
class bacteria    
{   

  int x; 
  int y; 
  int rcolor; 
  int gcolor; 
  int bcolor;

  bacteria(int x, int y) {
    this.x = x;
    this.y =y;
    this.rcolor = (int)(Math.random()*225+1);
    this.gcolor = (int)(Math.random()*225+1);
    this.bcolor = (int)(Math.random()*225+1);
  } 
  public void show() {
    fill(rcolor, gcolor, bcolor);
    ellipse(this.x, this.y, 10, 10);
  }  
  public void ai() {
    float xc=((int)(Math.random()*7)-3);
    float yc=((int)(Math.random()*7)-3);
    //int xbc=1;
    //int ybc=1;
    //int dir=(int)(Math.random()*4+1);


    if (mouseX>this.x) {
      xc+=1;
    }
    if (mouseX<this.x) {
      xc-=1;
    }
    if (mouseY>this.y) {
      yc+=1;
    }
    if (mouseY<this.y) {
      yc-=1;
    }
    if (abs(mouseX-this.x)<abs(mouseY-this.y)) {
      xc=xc/1.8f;
    } else if (abs(mouseY-this.y)<abs(mouseX-this.x)) {
      yc=yc/1.8f;
    }
    if (yc<1.5f&&yc>-1.5f) {
      
       yc=((int)(Math.random()*7)-3);
    }
    if (xc<1.5f&&xc>-1.5f) {
       xc=((int)(Math.random()*7)-3);
    
    }


    /*if(dir==1){
     //this.x+=xc;
     
     }
     if(dir==2){
     //this.x-=xbc;
     
     }
     if(dir==3){
     
     //this.y+=yc;
     }
     if(dir==4){
     
     //this.y-=ybc;
     
     }*/
    this.y+=yc;
    this.x+=xc;
  }
}    
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
