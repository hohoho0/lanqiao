import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{

	/*
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/
	int x,y,Lflag,Rflag,Uflag,Dflag;
	Image Dimg[]=new Image[3];
	Image Uimg[]=new Image[3];
	Image Limg[]=new Image[3];
	Image Rimg[]=new Image[3];
	Image currentImg;
	public MainCanvas(){
		try
		{
			/*
			给变量赋值
			语法：变量名称=value;
			*/
			//转向
			for(int i=0;i<Dimg.length;i++){
				Dimg[i]=Image.createImage("/sayo"+i+"0.png");//下
			}
			for(int i=0;i<Limg.length;i++){
				Limg[i]=Image.createImage("/sayo"+i+"2.png");//左
			}
			for(int i=0;i<Uimg.length;i++){
				Uimg[i]=Image.createImage("/sayo"+i+"4.png");//上
			}
			for(int i=0;i<Rimg.length;i++){
				Rimg[i]=Image.createImage("/sayo"+i+"6.png");//右
			}
			
			//移动                                     

			currentImg=Dimg[1];
			x=120;
			y=100;
			Lflag=Rflag=Uflag=Dflag=1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(200,180,250);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/
		if(action==LEFT){
			if(Lflag==1){
				currentImg=Limg[0];
				Lflag++;
			}
			else if(Lflag==2){
				currentImg=Limg[2];
				Lflag=1;
			}
			x=x-5;
			repaint();
		}
		else if(action==RIGHT){
			if(Rflag==1){
				currentImg=Rimg[0];
				Rflag++;
			}
			else if(Rflag==2){
				currentImg=Rimg[2];
				Rflag=1;
			}
			x=x+5;
			repaint();
		}
		else if(action==UP){
			if(Uflag==1){
				currentImg=Uimg[0];
				Uflag++;
			}
			else if(Uflag==2){
				currentImg=Uimg[2];
				Uflag=1;
			}
			y=y-5;
			repaint();
		}
		else if(action==DOWN){
			if(Dflag==1){
				currentImg=Dimg[0];
				Dflag++;
			}
			else if(Dflag==2){
				currentImg=Dimg[2];
				Dflag=1;
			}
			y=y+5;
			repaint();
		}
	}
}