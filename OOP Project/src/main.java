public class main {
    public static void main(String[] args) {
        box b1= new box(5,5);
        b1.setWidth(10);
        b1.setHeight(7);
        System.out.println("-----Strart a box of particle-------");
        System.out.println(b1.list.size());
        System.out.println(" current number of particle: "+b1.numberOfParticle());
        b1.print();
        for (particle p: b1.list) {
            b1.setPosisition();
        }
        b1.printPosition();
        if(b1.checkcollisionALl()){
            b1.addParticle();
        }
        int step=1;
        while (b1.numberOfParticle()!= b1.getHeight()*b1.getWidth()){
            step+=1;
            System.out.println("Step: "+step);
            b1.moveAll();
            if(b1.checkcollisionALl()) b1.addParticle();
            b1.draw();
            System.out.println(" current number of particle: "+b1.numberOfParticle());
            step++;
        }
    }
}