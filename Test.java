import java.util.Scanner;
public class Test{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        boolean running = true;
        String output = "scegliere l'opzione da eseguire:\n";
        output += "0)\tper terminare il programma\n";
        output += "1)\tper usare il costruttore che prende come parametro solo il proprietario\n";
        output += "2)\tper usare il costruttore a cui manca solo il parametro del valore\n";
        output += "3)\tper usare il costruttore di copia\n";
        output += "4)\tper cambiare l'appartamento su cui si sta lavorando\n";
        Appartamento[] a = new Appartamento[getInt("quanti sono gli appartamenti totali su cui potrò lavorare?", scan)];
        int i=0;
        while(running){
            switch(getInt(output, scan)) {
                case 0:
                    running = false;
                    break;
                case 1:
                    a[i] = new Appartamento(getString("inserisci il nome del proprietario", scan));
                    break;
                case 2:
                    a[i] = new Appartamento(
                            getDouble("quanti metri quadri ha questo appartamento?", scan),
                            getString("in che città si trova questo appartamento?", scan),
                            getString("inserisci l'indirizzo dell'appartamento", scan),
                            getString("inserisci la classe energetica di questo appartamento", scan),
                            getBoolean("inserisci 1 se questo appartamento è pregiato", scan),
                            getString("inserisci il nome del proprietario", scan),
                            getDouble("inserisci il prezzo al metro quadro di questo appartamento", scan),
                            getInt("inserisci il piano alla quale si trova questo appartamento", scan)
                    );
                    break;
                case 3:
                    a[i] = new Appartamento(
                            a[getInt("inserisci il numero corrispondente all'appartamento della quale si vogliono copiare i dati", scan)],
                            getInt("inserisci il piano alla quale si trova questo appartamento", scan)
                    );
                    break;
                case 4:
                    i = getInt("inserisci il numero di appartamento sulla quale vuoi lavorare", scan);
                    break;
            }
            for(int j=0;j<a.length;j++){
                System.out.println("appartamento " + i + ":");
                if(a[j] != null) System.out.println(a[j].toString());
                else System.out.println("\tquesto appartamento deve ancora essere costruito");
            }
        }
        scan.close();
    }

    public static boolean getBoolean(String stringa, Scanner scan){
        return getInt(stringa, scan) == 1;
    }

    public static String getString(String stringa, Scanner scan){
        System.out.println(stringa);
        return scan.nextLine();
    }

    public static int getInt(String stringa, Scanner scan){
        return (int) getDouble(stringa, scan);
    }

    public static double getDouble(String stringa, Scanner scan){
        System.out.println(stringa);
        double risultato = scan.nextDouble();
        scan.nextLine();
        return risultato;
    }
}