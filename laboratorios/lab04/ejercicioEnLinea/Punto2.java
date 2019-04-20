import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class Punto2 {

    public static void main(String[] args) {
        lectura();
    }

    // Necesario?
    private static void sort(String[] a) {

    }

    private static int minimo(int n, int d, int r, String[] a, String[] b, boolean[] v) {
        int horasExtra = 0;
        int saveI = 0;

        for(int index = 0; index < n; index++) {
            boolean exacto = false;
            int menor = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if(!v[i]) {
                    int sum = Integer.parseInt(a[index]) + Integer.parseInt(b[i]);
                    if (sum == d) {
                        v[i] = true;
                        exacto = true;
                        break;
                    } else if(sum > d) {
                        if(menor < d || (menor > d && sum < menor)) {
                            menor = sum;
                            saveI = i;
                        }
                    } else {
                        if(menor < d || menor == Integer.MAX_VALUE) {
                            if(sum > menor) {
                                menor = sum;
                                saveI = i;
                            } else if(menor == Integer.MAX_VALUE) {
                                menor = sum;
                                saveI = i;
                            }
                        }
                    }
                }
            }

            if(!exacto && menor > d) {
                horasExtra += Math.abs(menor - d);
                v[saveI] = true;
            }
        }

        return horasExtra * r;
    }

    private static void lectura() {
        int n, d, r;
        String[] a;
        String[] b;

        try {
            File dataset = new File("dataset.txt");
            FileReader in = new FileReader(dataset);
            BufferedReader br = new BufferedReader(in);

            String linea;
            while((linea=br.readLine()) != "0 0 0") {
                String[] arr = linea.split(" ");
                n = Integer.parseInt(arr[0]);
                d = Integer.parseInt(arr[1]);
                r = Integer.parseInt(arr[2]);

                linea = br.readLine();
                a = linea.split(" ");

                linea = br.readLine();
                b = linea.split(" ");

                System.out.println(minimo(n, d, r, a, b, new boolean[n]));
            }

        } catch (Exception e) {}
    }

}
