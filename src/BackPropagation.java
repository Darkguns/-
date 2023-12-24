import  java.lang.Math;
public class BackPropagation//класс созданный для обучения нейронной сети.
{

    private static double lerningRate=0.000000001;//параметр отвечающий  за скорость обучения
    public static double makeNewWaight(double Waight, double vihod, double whish, double sumvhod, double yi)//метод рачитывающий новые веса для выходного нейрона
    {

        double delta=-lerningRate*matematic.sigmoidDX(sumvhod)*yi*(vihod-whish);
        double newWaight=Waight+delta;
        return newWaight;
    }

    public static double makeError(double vihod, double whish, double sumvhod)//метод созданный для расчета ошикбки
    {
        double error=matematic.sigmoidDX(sumvhod)*(vihod-whish);
        return error;
    }

    public static double makeNewWaight1(double Waight, double Waight1, double Waight2, double error1, double error2, double sumvhod, double yi)//метод рачитывающий новые веса относительно ошибки
    {

        double delta=-lerningRate*((error1*Waight1+error2*Waight2)/2)*matematic.sigmoidDX(sumvhod)*yi;
        double newWaight=Waight+delta;
        return newWaight;
    }
}
