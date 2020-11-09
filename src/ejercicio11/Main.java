package ejercicio11;

public class Main {
    public static void main(String[] args) {
        Comprador hermanoMayor = new Comprador(10);
        Thread hermanoMayorHilo= new Thread(hermanoMayor,"Hermano mayor");
        Thread[] alumnos=  new Thread[5];

        hermanoMayorHilo.start();
        for (int i = 0; i <alumnos.length ; i++) {
            alumnos[i]=new Thread(new Alumno(hermanoMayor),"Alumno "+(i+1));
            alumnos[i].start();
        }
    }
}
