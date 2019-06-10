
package contextoProblema;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author JonathanLizama
 */
public class Sort {
      
             
      /**
       * Metodo que realiza un ordenamiento de los celulares por tamaño mediante selectionSort.
       * @param lista son los objetos del tipo celular.
       * @return celulares ordenados por tamaño de pantalla.
       */
      public ArrayList<Celular> selectionSortTamagno(ArrayList<Celular> lista) {

            int minimo;
            for (int i = 0; i < lista.size(); i++) {
                  minimo = i;
                  for (int j = i; j < lista.size(); j++) {
                        if (lista.get(j).compareToTamagno(lista.get(minimo)) < 0) {
                              minimo = j;
                        }
                  }

                  Celular temp = lista.get(minimo);
                  lista.set(minimo, lista.get(i));
                  lista.set(i, temp);

            }
            return lista;
      }
      
      /**
       * Metodo que realiza un ordenamiento de los celulares por modelo mediante selectionSort.
       * @param lista son los objetos del tipo celular.
       * @return celulares ordenados por modelo.
       */
      public ArrayList<Celular> selectionSortModelo(ArrayList<Celular> lista) {

            int minimo;
            for (int i = 0; i < lista.size(); i++) {
                  minimo = i;
                  for (int j = i; j < lista.size(); j++) {
                        if (lista.get(j).compareToModelo(lista.get(minimo)) < 0) {
                              minimo = j;

                        }

                  }
                  Celular temp = lista.get(minimo);
                  lista.set(minimo, lista.get(i));
                  lista.set(i, temp);

            }
            return lista;
      }
      
       /**
       * Metodo que realiza un ordenamiento de los celulares por modelo mediante insertionSort.
       * @param lista son los objetos del tipo celular.
       * @return celulares ordenados por modelo.
       */
      public ArrayList<Celular> insertionSortModelo(ArrayList<Celular> lista) {
            Celular temp;
            for (int i = 1; i < lista.size(); i++) {
                  for (int j = i; j > 0; j--) {
                        if (lista.get(j).compareToModelo(lista.get(j - 1)) < 0) {
                              temp = lista.get(j);
                              lista.set(j, lista.get(j - 1));
                              lista.set(j - 1, temp);

                        }

                  }

            }

            return lista;
      }
      
        /**
       * Metodo que realiza un ordenamiento de los celulares por tamaño mediante selectionSort.
       * @param lista son los objetos del tipo celular.
       * @return celulares ordenados por tamaño.
       */

      public ArrayList<Celular> insertionSortTamagno(ArrayList<Celular> lista) {
            Celular temp;
            for (int i = 1; i < lista.size(); i++) {
                  for (int j = i; j > 0; j--) {
                        if (lista.get(j).compareToTamagno(lista.get(j - 1)) < 0) {
                              temp = lista.get(j);
                              lista.set(j, lista.get(j - 1));
                              lista.set(j - 1, temp);

                        }

                  }

            }

            return lista;
      }
      
       /**
       * Metodo que realiza un ordenamiento de los celulares por tamaño mediante mergeSort.
       * @param celulares son los objetos del tipo celular.
       * @return celulares ordenados por tamaño.
       */
      public ArrayList<Celular> mergeSortTamaño(ArrayList<Celular> celulares) {
            Collections.sort(celulares);
            return celulares;
      }
      
       /*
      Este método muestra por consola cada Celular ordenado con sus respectivos atributos.
      @return void.
      */
      public void mostrarCelularesOrdenados(ArrayList<Celular> lista) {
            for (int i = 0; i < lista.size(); i++) {
                  System.out.println(lista.get(i).toString());
            }
      }
      
      
}
