package gestorArchivos;

import contextoProblema.Celular;
import contextoProblema.Sort;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author JonathanLizama
 */
public final class Lectura {

      Sort ordenamiento = new Sort();
      private ArrayList<Celular> celulares = new ArrayList<>();
      private String[] textoExtraido;

      public Lectura(String ruta) throws IOException {
            int numeroDeLineas = contarLineasTexto(ruta);
            leerTexto(ruta, numeroDeLineas);
            crearCelulares(numeroDeLineas);
            mostrarCelulares();
            System.out.println("\nCelulares ordenados por tamaño de pantalla (Selection sort): ");
            ordenamiento.mostrarCelularesOrdenados(ordenamiento.selectionSortTamagno(celulares));

            System.out.println("\nCelulares ordenados por Modelo (Selection sort): ");
            ordenamiento.mostrarCelularesOrdenados(ordenamiento.selectionSortModelo(celulares));

            System.out.println("");
            System.out.println("\nCelulares ordenados por Tamaño (Insertion sort): ");
            ordenamiento.mostrarCelularesOrdenados(ordenamiento.insertionSortTamagno(celulares));
            System.out.println("");
            System.out.println("\nCelulares ordenados por Modelo (Insertion sort): ");
            ordenamiento.mostrarCelularesOrdenados(ordenamiento.insertionSortModelo(celulares));

            System.out.println("");
            System.out.println("\nCelulares ordenados por tamaño de pantalla (Merge sort): ");
            ordenamiento.mostrarCelularesOrdenados(ordenamiento.mergeSortTamaño(celulares));

      }

      /**
       * Metodo que cuenta cantidad de lineas en un texto csv.
       *
       * @param ruta donde se encuentra el texto csv.
       * @return cantLineas.
       * @throws java.io.IOException
       */
      public int contarLineasTexto(String ruta) throws IOException {
            int cantLineas = 0;
            try {
                  FileReader fr = new FileReader(ruta);
                  BufferedReader bf = new BufferedReader(fr);
                  while (bf.readLine() != null) {
                        cantLineas++;
                  }
                  return cantLineas - 1;
            } catch (FileNotFoundException e) {
                  System.out.println(e);
                  System.out.println("La ruta ingresada no existe!!!");
                  return -1;
            }
      }

      /**
       * Metodo que lee un texto en formato csv.
       *
       * @param ruta donde se encuentra el archivo csv.
       * @param cantLineas que contiene el archivo csv.
       * @return textoExtraido.
       */
      private String[] leerTexto(String ruta, int cantLineas) throws FileNotFoundException, IOException {
            try {
                  textoExtraido = new String[cantLineas];
                  File archivo = new File(ruta);
                  if (archivo.exists() && cantLineas >= 0) {
                        FileReader fr = new FileReader(ruta);
                        BufferedReader br = new BufferedReader(fr);
                        while (br.readLine() != null) {
                              for (int i = 0; i < cantLineas; i++) {
                                    textoExtraido[i] = br.readLine();
                              }
                        }
                  }
            } catch (NegativeArraySizeException e) {
                  System.out.println(e);
                  System.out.println("La cantidad de lineas no existe");
            }
            return textoExtraido;
      }

      /**
       * Metodo que separa el texto, siempre y cuando exista una coma(,).
       *
       * @param posicion de las palabras al interior del texto txt almacenada en un array
       * de String .
       * @return particiones resultantes de la línea
       */
      public String[] separador(int posicion) {
            try {
                  return textoExtraido[posicion].split(",");
            } catch (ArrayIndexOutOfBoundsException e) {
                  System.out.println(e);
                  String vacio[] = new String[]{"vacio"};
                  return vacio;
            }catch(NullPointerException e){
                  System.out.println(e);
                  String nullPointer [] = new String[]{"nada"};
                  return nullPointer;   
            }
      }

      /**
       * Metodo que crea los objetos de tipo Celular.
       *
       * @param cantLineas para saber la cantidad de objetos.
       * @return celulares leidos del archivo csv.
       */
      private ArrayList<Celular> crearCelulares(int cantLineas) {
            for (int i = 0; i < cantLineas; i++) {
                  this.celulares.add(new Celular(separador(i)[0], separador(i)[1]));
            }
            return celulares;
      }

      /*
      Este método muestra por consola cada Celular con sus respectivos atributos.
      @return void.
       */
      private void mostrarCelulares() {
            for (int i = 0; i < celulares.size(); i++) {
                  System.out.println("Celular N°" + (i + 1) + " : ");
                  System.out.println(celulares.get(i).toString());
            }
      }
}
