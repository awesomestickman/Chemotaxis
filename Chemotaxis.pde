 //declare bacteria variables here

bacteria [] tons;




 void setup()   
 {     
size(400,400);
bacteriamaker();
 	 
 }   
 void draw()   
 {    
 	background(225);

 	
 	for(int i=0;i<tons.length;i++){
 		tons[i].show();
 		tons[i].ai();
 	}
 }  

 void bacteriamaker(){

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
 	void show(){
     fill(rcolor,gcolor,bcolor);
     ellipse(this.x,this.y,10,10);
      
 	}  
 	void ai(){

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