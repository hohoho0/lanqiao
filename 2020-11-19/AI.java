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
	����������
	�﷨���������� �������ƣ���ʶ����;
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
			��������ֵ
			�﷨����������=value;
			*/
			//ת��
			for(int i=0;i<Dimg.length;i++){
				Dimg[i]=Image.createImage("/sayo"+i+"0.png");//��
			}
			for(int i=0;i<Limg.length;i++){
				Limg[i]=Image.createImage("/sayo"+i+"2.png");//��
			}
			for(int i=0;i<Uimg.length;i++){
				Uimg[i]=Image.createImage("/sayo"+i+"4.png");//��
			}
			for(int i=0;i<Rimg.length;i++){
				Rimg[i]=Image.createImage("/sayo"+i+"6.png");//��
			}
			
			//�ƶ�                                     

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
		action��ֵ��UP��DOWN��LEFT��RIGHT
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