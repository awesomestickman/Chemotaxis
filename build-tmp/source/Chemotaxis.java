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
size(400,400);
bacteriamaker();
 	 
 }   
 public void draw()   
 {    
 	background(225);

 	
 	for(int i=0;i<tons.length;i++){
 		tons[i].show();
 		tons[i].ai();
 	}
 }  

 public void bacteriamaker(){

tons=new bacteria[1000];
for(int i =0;i<tons.length;i++){

tons[i]=new bacteria(200,200);


}


 }
 class bacteria    
 {   
     
    int x; int y; int rcolor; int gcolor; int bcolor;

 	bacteria(int x,int y){
     this.x = x;
     this.y =y;
     this.rcolor = (int)(Math.random()*225+1);
     this.gcolor = (int)(Math.random()*225+1);
     this.bcolor = (int)(Math.random()*225+1);

 	} 
 	public void show(){
     fill(rcolor,gcolor,bcolor);
     ellipse(this.x,this.y,10,10);
      
 	}  
 	public void ai(){

 		int dir=(int)(Math.random()*4+1);
 		if(dir==1){
 			this.x+=2;
 		}
 		if(dir==2){
 			this.x-=2;
 		}
 		if(dir==3){
 			this.y+=2;
 		}
 		if(dir==4){
 			this.y-=2;
 		}
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
