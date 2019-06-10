
import contextoProblema.Celular;
import contextoProblema.Sort;
import gestorArchivos.Lectura;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JonathanLizama
 */
public class testCelular {

      ArrayList<Celular> obtenido = new ArrayList();
      ArrayList<Celular> esperado = new ArrayList();
      ArrayList<Celular> insertionSort = new ArrayList<>();
      ArrayList<Celular> mergeSort = new ArrayList<>();
      ArrayList<Celular> decimalInsertion = new ArrayList<>();
      ArrayList<Celular> decimalSelection = new ArrayList<>();
      Lectura lectura;
      Sort ordenamiento;

      public testCelular() {
      }

      @Before
      public void setUp() throws IOException {
            lectura = new Lectura("src\\gestorArchivos\\celulares.csv");
            ordenamiento = new Sort();
      }

      /*
        Este metodo Test prueba un archivo que no existe, o que no se encuentra en la ruta especificada.
       */
      @Test
      public void testContarLineasTexto() throws IOException {
            assertEquals(lectura.contarLineasTexto("src\\gestorArchivos\\moviles.csv"), -1);
      }

      /*
        Este metodo Test prueba un archivo de texto en una posicion que no existe.
       */
      @Test
      public void testSepararLineas() {
            String resultadoObtenido[] = lectura.separador(-3);
            String resultadoEsperado[] = {"nada"};

            Assert.assertArrayEquals(resultadoEsperado, resultadoObtenido);
      }

      /*
        Este metodo Test prueba un modelo de celular, distinguiendo entre minuscula y mayusculas, dando preferencia a las mayusculas.
       */
      @Test
      public void testSelectionSortModelo() {
            ArrayList<Celular> moviles = new ArrayList<>();
            moviles.add(new Celular("Experia **", "6.8"));
            moviles.add(new Celular("experia **", "6.8"));
            obtenido = ordenamiento.selectionSortModelo(moviles);
            esperado = moviles;

            assertEquals(esperado, obtenido);
      }

      /*
        Este metodo Test compara entre el ordenamiento insertionSort y mergeSort para comprobar que ambos metodos llegan al mismo resultado.
       */
      @Test
      public void testComparacionMetodosSort() {
            ArrayList<Celular> moviles = new ArrayList<>();
            moviles.add(new Celular("Experia", "6.8"));
            moviles.add(new Celular("Lg ", "6.2"));
            moviles.add(new Celular("Sony", "7.0"));
            insertionSort = ordenamiento.insertionSortModelo(moviles);
            mergeSort = ordenamiento.mergeSortTamaño(moviles);

            assertEquals(insertionSort, mergeSort);
      }

      /*
        Este metodo Test compara entre el ordenamiento insertionSort y selectionSort para comprobar el tamaño con varios decimales y que en ambos metodos llegan al mismo resultado.
       */
      @Test
      public void testTamañoVariosDecimales() {
            ArrayList<Celular> moviles = new ArrayList<>();
            moviles.add(new Celular("Experia", "6.8888801"));
            moviles.add(new Celular("Lg ", "6.888881"));
            moviles.add(new Celular("Sony", "6.8888802"));
            decimalInsertion = ordenamiento.insertionSortTamagno(moviles);
            decimalSelection = ordenamiento.selectionSortTamagno(moviles);

            assertEquals(decimalInsertion, decimalSelection);
      }

      @After
      public void tearDown() {
      }
}
