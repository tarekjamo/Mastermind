/**
 * Created by tarekray on 01/01/16.
 */
public class ArrayHelper {
    public static int[] clone(int[] array) {
        int[] copy = new int[array.length] ;
        for(int i = 0 ; i < array.length ; i++)
        {
            copy[i]  = array[i];
        }
        return  copy ;
    }

    public static boolean contains(int[] array, int key) {
         for(int i = 0 ; i < array.length ; i++)
         {
             if(array[i]==key)
             {
                 return  true ;
             }
         }
        return  false ;
    }

    public static void print(int[] array) {
        for(int i = 0 ; i < array.length ; i ++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static int getMax(int[] array) {
        int max = -1;

        for(int i = 0 ; i < array.length ; i++)
        {
            if(array[i]>max)
            {
                max = array[i] ;
            }
        }
        return max;
    }
}
