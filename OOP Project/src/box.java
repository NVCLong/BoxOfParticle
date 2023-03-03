import java.util.ArrayList;
import java.util.Random;

public class box {
    private int height;
    private int width;
    ArrayList<particle> list;
    private int position[][];

    public box(int W, int H) {
        list= new ArrayList<particle>();
        position= new int[100][100];
        this.width=W;
        this.height= H;
        spond();
    }
    public void setvalueforposition(int arr[][]){
        arr= new int[100][100];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j]=0;
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setPosisition(){
        for (particle p:list) {
            int x= p.getX();
            int y= p.getY();
            position[x][y]=1;
        }
    }

    enum direction{
        North,
        North_east,
        Esat,
        South_east,
        South,
        South_west,
        West,
        North_west;

    }
    public int getRandomNum(int max, int min){
        Random i= new Random();
        return (int)(i.nextInt((max-min)+1))+min;
    }
    public direction getRandomDirection(){
        int rd= this.getRandomNum(7,0);
        return direction.values()[rd];
    }
    public void spond(){
        for (int i = 0; i < 3; i++) {
            addParticle();
        }
    }
    public void addParticle(){
        int x= getRandomNum(width,1);
        int y= getRandomNum(height,1);
        particle p1= new particle(x,y);
        list.add(p1);
    }
    public int numberOfParticle(){
        return list.size();
    }
    public void move(particle p){
        direction d1= getRandomDirection();
        int x= p.getX();
        int y= p.getY();
        switch (d1){
            case North:
                if(y>0) {
                    p.setY(y - 1);
                }
                break;
            case North_east:
                if(y>0) p.setY(y-1);
                if(x<width) p.setX(x++);
                break;
            case Esat:
                if(x<width) p.setX(x++);
                break;
            case South_east:
                if(y<height) p.setY(y++);
                if(x<width)  p.setX(x++);
            case South:
                if(y<height) p.setY(y++);
                break;
            case South_west:
                if(y<height) p.setY(y++);
                if(x>0) p.setX(x--);
                break;
            case West:
                if(x>0) p.setX(x--);
                break;
            case North_west:
                if(y>0) p.setY(y--);
                if(x>0) p.setX(x--);
        }
    }

    public boolean checkcollisionP(particle p){
        int x= p.getX();
        int y= p.getY();
        for (int i = 0; i < list.size(); i++) {
            if(x== list.get(i).getX() && y==list.get(i).getX()){
                return  true;
            }
        }
        return false;
    }
    public boolean checkcollisionALl(){
        for (int i = 0; i < list.size(); i++) {
            particle p= list.get(i);
            int x= p.getX();
            int y= p.getY();
            if(position[x][y]==1) return  true;

        }
        return false;
    }
    public void draw(){
        setvalueforposition(position);
        for (particle p:list) {
            setPosisition();
        }
        System.out.print(" ");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println();
        for(int i=0; i<height;i++) {
            System.out.print("|");
            for (int j = 0; j < width; j++) {
                if(position[j][i]==1){
                    System.out.print("*");
                }else System.out.print(" ");
            }
            System.out.println("|");
        }
        System.out.print(" ");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
    }
    public void moveAll(){
        for (int i = 0; i < list.size(); i++) {
            move(list.get(i));
        }
    }

    public ArrayList<particle> getList() {
        return list;
    }

    public void setList(ArrayList<particle> list) {
        this.list = list;
    }

    public void print(){
        for (particle p:list       ) {
            System.out.println(list.toString());
        }
    }
    public  void printPosition(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(position[i][j]);
            }
            System.out.println();
        }
    }
}

