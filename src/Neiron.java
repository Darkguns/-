import java.lang.Math;
public class Neiron//класс созданый для эмитации работы нейрона
{
    private double  sumvhod;
    private int sloi, neironNumber;


    public Neiron(double sumvhod, int sloi, int neironNumber)
    {
        this.sumvhod = sumvhod;
        this.sloi = sloi;
        this.neironNumber = neironNumber;
    }



    public double out()//метод расчитывающий выход нейрона
    {
        if(sloi!=2)
        {
                return matematic.sigmoid(sumvhod);
        }
        if (neironNumber==0)
        {
            double out =1000* matematic.sigmoid(sumvhod);
            return out;
        }
        else
        {
            double out =750* matematic.sigmoid(sumvhod);
            return out;
        }
    }
}
