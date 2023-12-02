import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> nazwiska = new ArrayList<>();
        nazwiska.add("aac");
        nazwiska.add("acc");
        nazwiska.add("abc");
        Main countingSortObject = new Main();
        ArrayList<String> sortedList = countingSortObject.countingSort(nazwiska,255,1);
        countingSortObject.show(sortedList);


    }
    public ArrayList<String> countingSort(ArrayList<String>nazwiska,int zakresZ,int ktoraLitera){
        ArrayList<String>tablicaWynikowa = new ArrayList<>();
        ArrayList<Integer>tablicaLicznikow = new ArrayList<>();
        //inicjowanie tablicy 0
        for(int i = 0; i < zakresZ; i++){
            tablicaLicznikow.add(0);

        }
        System.out.println("1");
        //dodawanie ile jest danych liter
        for (String nazwisko : nazwiska){
            int charValue = nazwisko.charAt(ktoraLitera);
            tablicaLicznikow.set(charValue,tablicaLicznikow.get(charValue)+1);
        }
        System.out.println("2");
        //prefix dodawanie
        for (int i = 1; i < zakresZ; i++){
            tablicaLicznikow.set(i,tablicaLicznikow.get(i)+tablicaLicznikow.get(i-1));
        }
        System.out.println("3");
        //ukladanie
        for (int i = nazwiska.size() - 1; i >= 0; i--) {
            int charValue = nazwiska.get(i).charAt(ktoraLitera);
            tablicaWynikowa.add(tablicaLicznikow.get(charValue), nazwiska.get(i));
            tablicaLicznikow.set(charValue, tablicaLicznikow.get(charValue) - 1);
        }

        System.out.println("4");
        return tablicaWynikowa;
    }
    public void show (ArrayList<String> posortowana){
        for( String slowo : posortowana){
            System.out.println(slowo);
        }
    }
}