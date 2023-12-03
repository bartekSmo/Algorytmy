import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> nazwiska = new ArrayList<>();
        nazwiska.add("aazc");
        nazwiska.add("aafc");
        nazwiska.add("accc");

        Main countingSortObject = new Main();
        countingSortObject.radixSort(nazwiska,122, maxLentgh(nazwiska) );



    }
    public static int maxLentgh(ArrayList<String> nazwiska){
        int max = 0;
        for( String nazwisko : nazwiska){
            if(nazwisko.length()>max){
                max=nazwisko.length();
            }
        }

        return  max;
    }
    public ArrayList<String> countingSort(ArrayList<String>nazwiska,int zakresZ,int ktoraLitera){
        ArrayList<String>tablicaWynikowa = new ArrayList<>();
        ArrayList<Integer>tablicaLicznikow = new ArrayList<>();
        //inicjowanie tablicy 0
        for(int i = 0; i <= zakresZ; i++){
            tablicaLicznikow.add(0);
            tablicaWynikowa.add("");
        }
        //dodawanie ile jest danych liter
        for (String nazwisko : nazwiska){
            int charValue = nazwisko.charAt(ktoraLitera);
//            if (nazwisko.length() <= ktoraLitera) {
//                charValue = 32;
//            } else {
//                charValue = nazwisko.charAt(ktoraLitera);
//            }
            tablicaLicznikow.set(charValue,tablicaLicznikow.get(charValue)+1);
        }
        //prefix dodawanie
        for (int i = 1; i < zakresZ; i++){
            tablicaLicznikow.set(i,tablicaLicznikow.get(i)+tablicaLicznikow.get(i-1));
        }
        //ukladanie
        for (int i = nazwiska.size()-1; i >= 0; i--) {
            int charValue = nazwiska.get(i).charAt(ktoraLitera);
//            if(nazwiska.get(i).length() <= ktoraLitera){//sprawdzimy po prostu dlugosc
//                charValue = 32;
//            }else{
//                charValue = nazwiska.get(i).charAt(ktoraLitera);
//            }
            tablicaWynikowa.add(tablicaLicznikow.get(charValue), nazwiska.get(i)); //tablica wynikowa [index:98,nazwiska[2]:"abc"]
            tablicaLicznikow.set(charValue, tablicaLicznikow.get(charValue) - 1); //
        }
        show(tablicaWynikowa);
        return tablicaWynikowa;
    }

    public void radixSort(ArrayList<String> nazwiska,int zakresZ,int maks){
        for(int i = maks - 1; i > 0; i--){
            System.out.println(i);
            nazwiska = countingSort(nazwiska,zakresZ,i);
        }
        show(nazwiska);
    }
    public void show (ArrayList<String> posortowana){
        for( String slowo : posortowana)
            if ((!slowo.isEmpty()))
                System.out.println(slowo);
    }
}
