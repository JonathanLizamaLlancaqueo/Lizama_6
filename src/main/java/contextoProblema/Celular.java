package contextoProblema;

/**
 *
 * @author JonathanLizama
 */
public class Celular implements Comparable<Celular> {

      //Atributos de la clase "Celular".
      private String modelo;
      private String tamagno;

      //Constructor con parametros.
      public Celular(String modelo, String tamagno) {
            this.modelo = modelo;
            this.tamagno = tamagno;
      }

      //Constructor por defecto.
      public Celular() {
      }

      //Metodos get "nos sirve para mostrar el valor de los atributos de la clase"
      public String getModelo() {
            return modelo;
      }

      public String getTamaño() {
            return tamagno;
      }

      //Metodos set "nos sirve para modificar el valor de los atributos de la clase"
      public void setModelo(String modelo) {
            this.modelo = modelo;
      }

      public void setTamaño(String tamaño) {
            this.tamagno = tamaño;
      }
      
      // Metodos compareTo nos sirven para comparar los respectivos atributos de una clase.
      public int compareToModelo(Celular celularComparable) {
            return this.modelo.compareTo(celularComparable.getModelo());
      }

      public int compareToTamagno(Celular celularComparable) {
            return this.tamagno.compareTo(celularComparable.getTamaño());
      }
      @Override
      public int compareTo(Celular tamaño) {
            return this.tamagno.compareTo(tamaño.getTamaño());
      }

      //Metodo toString nos sirve para mostrar los atributos de la clase "Celular".
      @Override
      public String toString() {
            return "Modelo: " + this.modelo + "\n"
                    + "Tamaño: " + this.tamagno + "\n";

      }

}
