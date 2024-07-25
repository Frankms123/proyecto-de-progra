package misc;/*================================================================================================
Study Center....: Universidad Técnica Nacional
Campus..........: Pacífico (JRMP)
College career..: Ingeniería en Tecnologías de Información
Period..........: 2C-2024
Course..........: ITI-221 - Programación I
Document........: class_07 - misc.functions.java
Goals...........: Functions set to create synthetic data for an example database
Professor.......: Jorge Ruiz (york)
Student.........:
================================================================================================*/

// Call external libraries
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class functions {
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    // Refill with zeros on the left side of the expression, only if required
    public String ponCeros(String Expre, int tam){
        String local = "";
        for(int i = 0; i < (tam-Expre.length()); i++){
            local = local.concat("0");
        }
        return local.concat(Expre);
    }

    // Print horizontal line, applying length and custom character
    public void impLinea(int largo, char tipo){
        for(int i = 1; i <= largo; i++){
            System.out.print(tipo);
        }
        System.out.println();
    }

    // Returns a random single first name
    public String Nombre(){
        Random rnd = new Random();
        String nombres[] = {
                "Ana","Alvaro","Adriana","Arturo","Alfonso","Andrea","Andres","Anete","Arelys","Armando","Antonio","Andrey",
                "Alicia","Ariel","Astrid","Aurora","Aldo","Amanda","Alejandro","Ariana","Ariela","Alexander",
                "Bianka","Beverly","Bruno","Braulio","Beatriz","Bernarda","Brenda","Bryan","Boris","Berta","Bartolomé","Baltazar","Brandon","Braylin",
                "Cesar","Carolina","Carmen","Carlos","Cindy","Camilo","Clemencia","Cecilia","Cristina","Cristian","Catalina","Cristobal", "Cristal",
                "Diego","Dunia","David","Debora","Deisi","Diana","Danilo","Damaris","Doris","Daniel","Denis","Dulce","Dayana",
                "Efraín","Elsa","Elena","Ever","Ernesto","Eduardo","Esgardo","Emilio","Eilin","Esteban","Estiven","Elizabeth","Eneida","Edu",
                "Fabiola","Fernando","Francisco","Francini","Félix","Federico","Fabricio","Filomena","Franklin","Fernanda","Fran",
                "Gabriela","Gerardo","Giovanna","German","Grisel","Gabriel","Gustavo","Gilberto","Graciela",
                "Hector","Hellen","Huberth","Humberto","Hilda","Homero","Hernán","Hugo","Hellen",
                "Ignacio","Indira","Irma","Ingrid","Isaías","Ivania","Ileana","Isac","Isidro",
                "Jorge","Joyce","Julia","Jessica","José","Julio","Jacinto","Jaime","Joel","Jairo","Jesenia","Júan","Jesús","Juana","Jael","Josue",
                "Karla","Karen","Katia","Kevin","Kenneth","Katerina","Keylor","Kenyi","Karina","Kamila","Katherine","Kendall","Kendry","Kendrick",
                "Lorena","Lorenzo","Lady","Luis","Laura","Lucía","Lourdes","Leopoldo","Licet","Leticia",
                "Mario","Mauricio","Melania","Marianela","Mercedes","Marcos","Merlina","Morticia","Mauren","Miguel","Mónica","Mauricio","Marienny",
                "Nuria","Nestor","Nazaret","Nidia","Norman","Naomi","Nora",
                "Osvaldo","Orlando","Odir","Olga","Ofelia","Omar","Olger","Oscar","Olivier",
                "Pedro","Pablo","Patricia","Priscila","Paula","Paola","Pericles","Paolo",
                "Raúl", "Roberto", "Rebeca","Rocío","René","Rosaura","Rosalía","Rosa","Romel","Ricardo","Rigoberto",
                "Sabrina", "Sergio", "Sonia","Samuel","Sandra","Silvio","Susana","Sebastían","Sandro","Silvia","Sofía","Santiago","Santos","Saul",
                "Sofonías","Samiel","Simey","Sharon",
                "Tatiana","Teodóro", "Tania","Teresa","Tobías","Tonny",
                "Úrsula", "Uriel", "Ulises",
                "Verónica","Vanesa","Valeria","Victor","Vilma","Vernon","Viviana","Victoria","Valery","Valeska",
                "Walter","Wilfrido","Wendy","William","Wenceslao","Wilgem","Wilberth","Willis",
                "Xiomara", "Ximena", "Xavier",
                "Yirlania","Yolanda","Yonan","Yehúdi","Yvone","Yurielka","Yuri","Yenori",
                "Zaida", "Zulema","Zoe","Zacarías","Zoraida","Zeidy"
        };
        return nombres[rnd.nextInt(nombres.length)];
    }

    // Returns a random last name
    public String Apellido(){
        Random rnd = new Random();
        String apellidos[] = {
                "Alvarado","Almengor","Acevedo","Abarca","Angulo","Acón","Apuy","Alfaro","Artiaga","Alvares","Arias","Aguilar","Aguero","Aguirre",
                "Aguilera","Araya","Alvarado","Aragón",
                "Ballesteros","Barahona","Barboza","Blanco","Bolaños","Bermudez","Barrantes","Brenes","Blandon","Bonilla",
                "Caballero","Céspedes","Campos","Chavarría","Cubero","Cernas","Cubillo","Cambronero","Cabalceta","Cortes","Con","Carranza","Cordero",
                "Cruz","Cascante","Córdoba","Cháves","Conejo","Cerdas","Castro",
                "Duarte","Durán","Domingues","De la O","Díaz",
                "Elizondo","Echandi","Escalante","Espinoza","Esquivel","Estupiñan",
                "Fernández","Fonseca","Fournier","Fajardo","Flores","Fuentes",
                "González","Gaitan","Galan","Gambóa","García",
                "Hernández","Herrera","Hidalgo","Huertas","Hurtado",
                "Ibarra","Ibanéz","Iglesias","Infante","Izaguirre",
                "Jerez","Jaén","Jiménez","Jácamo","Juárez",
                "López","Lamas","Lagos","Labrador","Lara","Lí","Leitón",
                "Madrigal","Molina","Mendez","Manzanares","Monestel","Molinares","Matarrita","Mata","Monge","Mora","Murillo","Mena","Marín","Mendoza","Matamoros",
                "Nuñez","Noguera","Naranjo","Navas","Nicolas",
                "Ocampo","Obregón","Ochoa","Ojeda","Ordoñez",
                "Pacheco","Palacios","Palma","Padilla","Paniagua","Pomares","Picado","Perez","Peraza","Pizarro","Parra",
                "Quirós","Quintero", "Quintana","Quiroga","Quintanilla","Quesada",
                "Ruiz","Ramírez","Roldan","Redondo","Rivera","Rodriguez","Reyes","Rueda",
                "Saborío","Sanchez","Salas","Sáenz","Sancho","Sanabría","Soto","Sequeira","Sibaja","Solano",
                "Talavera","Tenorio","Trujillo","Tijerino","Torres",
                "Ulloa","Ugalde","Ureña","Urbina","Ugarte",
                "Vega","Vargas","Valencia","Vallejo","Varela","Vizcaíno","Valdez","Vindas","Villalobos","Villanueva","Villegas","Villagra",
                "Williams","Wright","Wong","Walker","Watson","Wells","White","Ward","Wheeler","Warren","Wade","Walters","Waltz",
                "Zamora","Zarate","Zumbado"
        };
        return apellidos[rnd.nextInt(apellidos.length)];
    }

    // Creates a cedula or identification number
    public int Cedula() {
        String ced;
        Random rnd = new Random();

        ced = String.valueOf(rnd.nextInt(7) + 1);
        ced = ced.concat(ponCeros(String.valueOf(rnd.nextInt(1000)), 4) + ponCeros(String.valueOf(rnd.nextInt(1000)), 4));

        return Integer.parseInt(ced);
    }

    // Select a random biological sex
    public char Sexo(){
        Random rnd = new Random();
        char Sx[] = {'F','M','O'};
        return Sx[rnd.nextInt(3)];
    }

    // Creates a civil status
    public char estCivil(){
        Random rnd = new Random();
        char Es[] = {'S','C','D','V','U'};
        return Es[rnd.nextInt(5)];
    }

    // Creates a birthdate
    public String fecNac(){
        Random rnd = new Random();

        //Calculate year since 1960 at today
        String expre = String.valueOf(rnd.nextInt(59)+1960)+"-";

        //Calculate month between 1 and 12
        expre = expre.concat(ponCeros(String.valueOf(rnd.nextInt(12)+1),2)+"-");

        //Calculate day between 1 and 31
        expre = expre.concat(ponCeros(String.valueOf(rnd.nextInt(31)+1),2));

        return expre;
    }//End fecNac function

    //Recover time from local machine
    public String getTime() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss.SSS");
        return formateador.format(ahora);
    }

}
