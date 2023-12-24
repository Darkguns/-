public class Sinaps//класс созданый для эмитации работы синапса
{
    private double Waight;
    public Sinaps(double Waight)
    {
        this.Waight=Waight;
    }
    public double ToNeiron(double in)
    {
        return in*Waight;
    }//метод созданный для расчета входа в нейрон
}
