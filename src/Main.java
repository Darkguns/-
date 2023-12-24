import java.nio.file.Files;
import java.nio.file.Path;
import  java.lang.Math;

public class Main
{

    public static void main(String[] args)
    {
        double T, E,F,U; //count=10000;
        double[][][] Waight = new double[2][2][7];
        double[][][] newWaight = new double[2][2][7];
        String SWaight;
        try {

                Path pathT = Path.of("D:\\Учеба\\Диплом\\T.txt");//так как путь прописан не из корневой папки, нужно прописать путь к этим файлам(T.txt, E.txt, U.txt,F.txt, NeuroemulatorWaight.txt")
                Path pathE = Path.of("D:\\Учеба\\Диплом\\E.txt");
                Path pathU = Path.of("D:\\Учеба\\Диплом\\U.txt");
                Path pathF = Path.of("D:\\Учеба\\Диплом\\F.txt");
                Path path = Path.of("D:\\Учеба\\Диплом\\NeuroemulatorWaight.txt");
                String ST = Files.readString(pathT);
                String SE = Files.readString(pathE);
                String SU = Files.readString(pathU);
                String SF = Files.readString(pathF);
                String[] arrayFromStringT = ST.split(" ");//Парсим значения из файлов
                String[] arrayFromStringE = SE.split(" ");
                String[] arrayFromStringU = SU.split(" ");
                String[] arrayFromStringF = SF.split(" ");
                double[] arrayT=new double[arrayFromStringT.length];//Создаем массивы для значений из файлов
                double[] arrayE=new double[arrayFromStringE.length];
                double[] arrayU=new double[arrayFromStringU.length];
                double[] arrayF=new double[arrayFromStringF.length];
                for (int i = 0; i < arrayFromStringT.length; i++)// значения записываем в массивы
                {
                    arrayT[i] = Double.parseDouble(arrayFromStringT[i]);
                }
                for (int i = 0; i < arrayFromStringE.length; i++)
                {
                    arrayE[i] = Double.parseDouble(arrayFromStringE[i]);
                }
                for (int i = 0; i < arrayFromStringU.length; i++)
                {
                    arrayU[i] = Double.parseDouble(arrayFromStringU[i]);
                }
                for (int i = 0; i < arrayFromStringF.length; i++)
                {
                    arrayF[i] = Double.parseDouble(arrayFromStringF[i]);
                }
                double sqrterror=100;
            while ((sqrterror/2>0.02))//Обучение должно производится до того момента, пока среднекватратичная ошибка не станет менее 2%
            {
                sqrterror=0;
                for (int g = 0; g < arrayT.length; g++)//одна эпоха обучения проходит тогда, когда нейрнка пройдет все значения темпиратуры из выборки
                {
                    SWaight = Files.readString(path);//считываются веса из файла
                    T=arrayT[g];//значения соответсвующие параметрам в этой итерации сохраняются
                    E=arrayE[g];
                    U=arrayU[g];
                    F=arrayF[g];
                    F=F/500;
                    U=U/500;
                    String[] arrayFromString = SWaight.split(" ");
                    int n = 0;
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 2; j++) {
                            for (int k = 0; k < 7; k++) {
                                Waight[i][j][k] = Double.parseDouble(arrayFromString[n]);//каждое значение веса сохраняетсяв специальную переменную типа Waight[i][j][k], где i-значения слоя весов, j-номер нейрона из входного слоя с которым соеденен синапс, к которому принадлежит вес, k-номер нейрона выходного слоя соответсвенно.
                                n++;
                            }
                        }
                    }

                    Sinaps s000 = new Sinaps(Waight[0][0][0]);//присваиваем каждому синопсу соответсвующий вес
                    Sinaps s001 = new Sinaps(Waight[0][0][1]);//вариант с нагромождением строк не практичен, поэтому в нейроэмуляторе используются циклы, ОБЯЗАТЕЛЬНО ПОСМОТРИТЕ КАК ЭТО РЕАЛИЗОВАНО ТАМ
                    Sinaps s002 = new Sinaps(Waight[0][0][2]);
                    Sinaps s003 = new Sinaps(Waight[0][0][3]);
                    Sinaps s004 = new Sinaps(Waight[0][0][4]);
                    Sinaps s005 = new Sinaps(Waight[0][0][5]);
                    Sinaps s006 = new Sinaps(Waight[0][0][6]);
                    Sinaps s010 = new Sinaps(Waight[0][1][0]);
                    Sinaps s011 = new Sinaps(Waight[0][1][1]);
                    Sinaps s012 = new Sinaps(Waight[0][1][2]);
                    Sinaps s013 = new Sinaps(Waight[0][1][3]);
                    Sinaps s014 = new Sinaps(Waight[0][1][4]);
                    Sinaps s015 = new Sinaps(Waight[0][1][5]);
                    Sinaps s016 = new Sinaps(Waight[0][1][6]);

                    Neiron n0 = new Neiron(s000.ToNeiron(F)+ s010.ToNeiron(U), 1, 0);//присоединяем к каждому нейрону входные синапсы
                    Neiron n1 = new Neiron(s001.ToNeiron(F)+ s011.ToNeiron(U), 1, 1);
                    Neiron n2 = new Neiron(s002.ToNeiron(F)+ s012.ToNeiron(U), 1, 2);
                    Neiron n3 = new Neiron(s003.ToNeiron(F)+ s013.ToNeiron(U), 1, 3);
                    Neiron n4 = new Neiron(s004.ToNeiron(F)+ s014.ToNeiron(U), 1, 4);
                    Neiron n5 = new Neiron(s005.ToNeiron(F)+ s015.ToNeiron(U), 1, 5);
                    Neiron n6 = new Neiron(s006.ToNeiron(F)+ s016.ToNeiron(U), 1, 6);

                    Sinaps s100 = new Sinaps(Waight[1][0][0]);//присваиваем каждому синопсу соответсвующий вес
                    Sinaps s101 = new Sinaps(Waight[1][0][1]);
                    Sinaps s102 = new Sinaps(Waight[1][0][2]);
                    Sinaps s103 = new Sinaps(Waight[1][0][3]);
                    Sinaps s104 = new Sinaps(Waight[1][0][4]);
                    Sinaps s105 = new Sinaps(Waight[1][0][5]);
                    Sinaps s106 = new Sinaps(Waight[1][0][6]);
                    Sinaps s110 = new Sinaps(Waight[1][1][0]);
                    Sinaps s111 = new Sinaps(Waight[1][1][1]);
                    Sinaps s112 = new Sinaps(Waight[1][1][2]);
                    Sinaps s113 = new Sinaps(Waight[1][1][3]);
                    Sinaps s114 = new Sinaps(Waight[1][1][4]);
                    Sinaps s115 = new Sinaps(Waight[1][1][5]);
                    Sinaps s116 = new Sinaps(Waight[1][1][6]);

                    double sumvhod10x=s100.ToNeiron(n0.out()) + s101.ToNeiron(n1.out()) + s102.ToNeiron(n2.out()) + s103.ToNeiron(n3.out()) + s104.ToNeiron(n4.out())+s105.ToNeiron(n5.out()) + s106.ToNeiron(n6.out());//расчитываем значение суммарных входов в выходные нейроны
                    double sumvhod11x=s110.ToNeiron(n0.out()) + s111.ToNeiron(n1.out()) + s112.ToNeiron(n2.out()) + s113.ToNeiron(n3.out()) + s114.ToNeiron(n4.out())+ s115.ToNeiron(n5.out()) + s116.ToNeiron(n6.out());

                    Neiron outT = new Neiron(sumvhod10x,2, 0);//расчитываем значения выходов из выходных нейронов
                    Neiron outE = new Neiron(sumvhod11x,2, 1);

                    System.out.println("Значение итоговой tempirature: T=" + outT.out());
                    System.out.println("Значение итоговой Napriag: E=" + outE.out());

                    double errorT=BackPropagation.makeError( outT.out(), T, s100.ToNeiron(n0.out()) + s101.ToNeiron(n1.out()) + s102.ToNeiron(n2.out())+ s103.ToNeiron(n3.out()) + s104.ToNeiron(n4.out())+s105.ToNeiron(n5.out()) + s106.ToNeiron(n6.out()));//расчитываем значение ошибки для каждого выходного нейрона
                    double errorE=BackPropagation.makeError( outE.out(), E, s110.ToNeiron(n0.out()) + s111.ToNeiron(n1.out()) + s112.ToNeiron(n2.out())+ s113.ToNeiron(n3.out()) + s114.ToNeiron(n4.out())+ s115.ToNeiron(n5.out()) + s116.ToNeiron(n6.out()));

                    sqrterror=sqrterror+Math.pow((outT.out()-T), 2);//расчитываем значение среднеквадратичной ошибки

                    newWaight[1][1][6] = BackPropagation.makeNewWaight(Waight[1][1][6], outE.out(), E, sumvhod11x, n6.out());//рассчитываем новые веса для каждого синапса относительно ошибки
                    newWaight[1][1][5] = BackPropagation.makeNewWaight(Waight[1][1][5], outE.out(), E, sumvhod11x, n5.out());
                    newWaight[1][1][4] = BackPropagation.makeNewWaight(Waight[1][1][4], outE.out(), E, sumvhod11x, n4.out());
                    newWaight[1][1][3] = BackPropagation.makeNewWaight(Waight[1][1][3], outE.out(), E, sumvhod11x, n3.out());
                    newWaight[1][1][2] = BackPropagation.makeNewWaight(Waight[1][1][2], outE.out(), E, sumvhod11x, n2.out());
                    newWaight[1][1][1] = BackPropagation.makeNewWaight(Waight[1][1][1], outE.out(), E, sumvhod11x, n1.out());
                    newWaight[1][1][0] = BackPropagation.makeNewWaight(Waight[1][1][0], outE.out(), E, sumvhod11x, n0.out());
                    newWaight[1][0][6] = BackPropagation.makeNewWaight(Waight[1][0][6], outT.out(), T, sumvhod10x, n6.out());
                    newWaight[1][0][5] = BackPropagation.makeNewWaight(Waight[1][0][5], outT.out(), T, sumvhod10x, n5.out());
                    newWaight[1][0][4] = BackPropagation.makeNewWaight(Waight[1][0][4], outT.out(), T, sumvhod10x, n4.out());
                    newWaight[1][0][3] = BackPropagation.makeNewWaight(Waight[1][0][3], outT.out(), T, sumvhod10x, n3.out());
                    newWaight[1][0][2] = BackPropagation.makeNewWaight(Waight[1][0][2], outT.out(), T, sumvhod10x, n2.out());
                    newWaight[1][0][1] = BackPropagation.makeNewWaight(Waight[1][0][1], outT.out(), T, sumvhod10x, n1.out());
                    newWaight[1][0][0] = BackPropagation.makeNewWaight(Waight[1][0][0], outT.out(), T, sumvhod10x, n0.out());


                    newWaight[0][1][6] = BackPropagation.makeNewWaight1(Waight[0][1][6], Waight[1][1][6], Waight[1][0][6], errorE, errorT, s006.ToNeiron(F) + s016.ToNeiron(U), U);
                    newWaight[0][1][5] = BackPropagation.makeNewWaight1(Waight[0][1][5], Waight[1][1][5], Waight[1][0][5], errorE, errorT, s005.ToNeiron(F) + s015.ToNeiron(U), U);
                    newWaight[0][1][4] = BackPropagation.makeNewWaight1(Waight[0][1][4], Waight[1][1][4], Waight[1][0][4], errorE, errorT, s004.ToNeiron(F) + s014.ToNeiron(U), U);
                    newWaight[0][1][3] = BackPropagation.makeNewWaight1(Waight[0][1][3], Waight[1][1][3], Waight[1][0][3], errorE, errorT, s003.ToNeiron(F) + s013.ToNeiron(U), U);
                    newWaight[0][1][2] = BackPropagation.makeNewWaight1(Waight[0][1][2], Waight[1][1][2], Waight[1][0][2], errorE, errorT, s002.ToNeiron(F) + s012.ToNeiron(U), U);
                    newWaight[0][1][1] = BackPropagation.makeNewWaight1(Waight[0][1][1], Waight[1][1][1], Waight[1][0][1], errorE, errorT, s001.ToNeiron(F) + s011.ToNeiron(U), U);
                    newWaight[0][1][0] = BackPropagation.makeNewWaight1(Waight[0][1][0], Waight[1][1][0], Waight[1][0][0], errorE, errorT, s000.ToNeiron(F) + s010.ToNeiron(U), U);
                    newWaight[0][0][6] = BackPropagation.makeNewWaight1(Waight[0][0][6], Waight[1][1][6], Waight[1][0][6], errorE, errorT, s006.ToNeiron(F) + s016.ToNeiron(U), F);
                    newWaight[0][0][5] = BackPropagation.makeNewWaight1(Waight[0][0][5], Waight[1][1][5], Waight[1][0][5], errorE, errorT, s005.ToNeiron(F) + s015.ToNeiron(U), F);
                    newWaight[0][0][4] = BackPropagation.makeNewWaight1(Waight[0][0][4], Waight[1][1][4], Waight[1][0][4], errorE, errorT, s004.ToNeiron(F) + s014.ToNeiron(U), F);
                    newWaight[0][0][3] = BackPropagation.makeNewWaight1(Waight[0][0][3], Waight[1][1][3], Waight[1][0][3], errorE, errorT, s003.ToNeiron(F) + s013.ToNeiron(U), F);
                    newWaight[0][0][2] = BackPropagation.makeNewWaight1(Waight[0][0][2], Waight[1][1][2], Waight[1][0][2], errorE, errorT, s002.ToNeiron(F) + s012.ToNeiron(U), F);
                    newWaight[0][0][1] = BackPropagation.makeNewWaight1(Waight[0][0][1], Waight[1][1][1], Waight[1][0][1], errorE, errorT, s001.ToNeiron(F) + s011.ToNeiron(U), F);
                    newWaight[0][0][0] = BackPropagation.makeNewWaight1(Waight[0][0][0], Waight[1][1][0], Waight[1][0][0], errorE, errorT, s000.ToNeiron(F) + s010.ToNeiron(U), F);

                    SWaight = "";//записываем новые веса в файл кранящий веса
                    for (int i = 0; i < 2; i++)
                    {
                        for (int j = 0; j < 2; j++)
                        {
                            for (int k = 0; k < 7; k++)
                            {
                                SWaight = SWaight + newWaight[i][j][k] + " ";
                            }
                        }
                    }
                    Files.writeString(path, SWaight);
                }
                //System.out.println(l);
            }
            //System.out.println("конец");
            }
        catch(Exception e)
            {
                System.out.println("Возникла проблема с чтением данных с файла Waight.txt");
                e.printStackTrace();
            }

    }

}