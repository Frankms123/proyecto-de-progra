package models;

public class mdl_Avion {
   private int ID_Avion;
   private string Modelo;
   private int Capacidad_pasajeros;
   private int Capacidad_Carga;
   private int Peso;

   package models;

   public class MdlAvion {
      private int idAvion;
      private String modelo;
      private int capacidadPasajeros;
      private int capacidadCarga;
      private int peso;

      // Constructor con parámetros
      public MdlAvion(int idAvion, String modelo, int capacidadPasajeros, int capacidadCarga, int peso) {
         this.idAvion = idAvion;
         this.modelo = modelo;
         this.capacidadPasajeros = capacidadPasajeros;
         this.capacidadCarga = capacidadCarga;
         this.peso = peso;
      }

      // Constructor sin parámetros
      public MdlAvion() {
      }

      // Métodos getter y setter
      public int getIdAvion() {
         return idAvion;
      }

      public void setIdAvion(int idAvion) {
         this.idAvion = idAvion;
      }

      public String getModelo() {
         return modelo;
      }

      public void setModelo(String modelo) {
         this.modelo = modelo;
      }

      public int getCapacidadPasajeros() {
         return capacidadPasajeros;
      }

      public void setCapacidadPasajeros(int capacidadPasajeros) {
         this.capacidadPasajeros = capacidadPasajeros;
      }

      public int getCapacidadCarga() {
         return capacidadCarga;
      }

      public void setCapacidadCarga(int capacidadCarga) {
         this.capacidadCarga = capacidadCarga;
      }

      public int getPeso() {
         return peso;
      }

      public void setPeso(int peso) {
         this.peso = peso;
      }
   }