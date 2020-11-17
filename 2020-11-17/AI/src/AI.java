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
	int x,y;
	Image img,img1,img2,img3,currentImg;
	public MainCanvas(){
		try
		{
			/*
			给变量赋值
			语法：变量名称=value;
			*/
			//转向
			img=Image.createImage("/sayo10.png");//下
			img1=Image.createImage("/sayo12.png");//左
			img2=Image.createImage("/sayo14.png");//上
			img3=Image.createImage("/sayo16.png");//右
			//移动
			img_1=Image.createImage("/sayo00.png");//下
			img_2=Image.createImage("/sayo20.png");

			currentImg=img;
			x=120;
			y=100;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/
		if(action==LEFT){
			/*
			实现转向代码
			*/
			/*
			给变量重新赋值即可
			*/
			currentImg=img1;
			x=x-5;
			repaint();
		}
		else if(action==RIGHT){
			currentImg=img3;
			x=x+5;
			repaint();
		}
		else if(action==UP){
			currentImg=img2;
			y=y-5;
			repaint();
		}
		else if(action==DOWN){
			currentImg=img;
			y=y+5;
			repaint();
		}
	}
}