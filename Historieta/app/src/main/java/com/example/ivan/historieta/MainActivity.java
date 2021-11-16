package com.example.ivan.historieta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int opcionUsuarioInt = 0;
        setContentView(R.layout.activity_main);
        TextView mainText = findViewById(R.id.textoHistoria);
        mainText.setText("Despiertas en la cama de una pequeña habitación que solamente tiene una puerta pequeña de madera al fondo,\nal lado de la cama tiene una trampilla y vislumbras una luz tenue de una vela en el suelo \nNo recuerdas nada, ni siquiera tu nombre. Tienes un fuerte dolor de cabeza y no sabes qué haces en esa habitación ni donde está situada");
        RadioButton optionSelection1 = findViewById(R.id.opcion1);
        RadioButton optionSelection2 = findViewById(R.id.opcion2);
        RadioButton optionSelection3 = findViewById(R.id.opcion3);
        Button continueBtn = findViewById(R.id.continuar);
        new JuegoOpciones();

    }

}
class JuegoOpciones {

    static int numeroVecesJugadas = 1; //numero de veces que has vivido la historia
    static int opcionUsuario;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Despiertas en la cama de una pequeña habitación que solamente tiene una puerta pequeña de madera al fondo,\nal lado de la cama tiene una trampilla y vislumbras una luz tenue de una vela en el suelo");
        System.out.println("No recuerdas nada, ni siquiera tu nombre. Tienes un fuerte dolor de cabeza y no sabes qué haces en esa habitación\nni donde está situada");

        do {


            System.out.println("¿Qué quieres hacer?\n\t1) Investigar la trampilla\n\t2) Abrir la puerta y salir\n\t3) Volverte a dormir (ya que parece una pesadilla)");
            opcionUsuario = pedirNumeroInt(scan);
            switch (opcionUsuario) {
                case 1:

                    trampilla(scan);
                    break;
                case 2:
                    puerta(scan);
                    break;
                case 3:

                    dormirse(scan);
                    break;
                default:
                    System.out.println("Intentas levantarte y pierdes el conocimiento");

            }
            numeroVecesJugadas++;
        } while (opcionUsuario > 3 || opcionUsuario < 1);

    }
    public static int pedirNumeroInt(Scanner scan) {
        /*
         * pediremos un numero y comprobamos que la entrada por teclado es numérica
         */
        boolean control = true;
        do {
            try {

                System.out.print("Introduzca una opción: -> ");

                int valor = scan.nextInt();
                scan.nextLine();
                control = false;
                return valor;
            } catch (InputMismatchException e) {
                scan.next();
                System.out.println("El valor introducido no es numérico o contiene decimales");
                continue;
            }
        } while (control);
        return 0;
    }


    static void puerta(Scanner scan){

        boolean tenedor = false;
        boolean cuchara = false;
        boolean cuchillo = false;


        System.out.println("\nTe dispones a abrir la puerta, pero te parece que hay algo al otro lado, se te erizan los pelos solo de imaginar que podr�a haber, te cargas de\n valor y abres la puesta de golpe.\nSolo ves oscuridad...\nTe dispones a coger la vela para ver algo, pero al darte la vuelta, la puerta a desaparecido, dejando una pared lisa con lo que parece que es cuadro colgado,\npero ni rastro de una puerta o rastro de ella.");
        System.out.println("Desesperado te llevas las manos a la cabeza y de rabia de no saber que est� pasando tiras lo que parece que es un cuadro de la pared, rompiendose contra el suelo.");
        System.out.println("Sin ver nada, palpas la pared buscando algo con lo que iluminarte, y encuentras �Un escritorio? si, ser� eso. Y con suerte encuentras algo parecido a un candil.\nLo enciendes accionando el mecanismo, y vislumbras una sombra atravesando otra puerta al final del cuarto. Asustado y dudando de tu vista buscas algo con lo que\ndefenderte de un posible agresor, encuentras un tenedor y una cuchara.");

        int locura = 0;

        comprobadorLocuraPuerta(locura);

        System.out.println("Tu locura aumente, no puedes creer lo que acabas de ver");
        System.out.println("\n�C�al vas a escoger?");
        System.out.println("Opci�n 1: tenedor\nOpci�n 2: cuchara\nOpcion 3: cuchillo");

        opcionUsuario = pedirNumeroInt(scan);
        switch (opcionUsuario) {
            case 1:
                tenedor = true;
                System.out.println("Coges el tenedor pensando que al menos es un objeto minimamente punzante.");
                break;
            case 2:
                cuchara = true;
                System.out.println("Escoges la cuchara ya que parece brillante y extra�a.");
                break;
            case 3:
                cuchillo = true;
                opcionUsuario = 2;
                System.out.println("Descubres un caj�n secreto debajo del escritorio, en ella hay un cuchillo de la misma cuberteria que la cuchara y el tenedor, te lo llevas contigo.");
                break;
            default:
                System.out.println("Decides no coger nada, ya que no parece tener ning�n uso futuro.");

        }

        System.out.println("Te adentras en la habitaci�n, candil en mano, es un gran sal�n lleno de muebles viejos sin cubir y lleno de polvo, es tan grande que no ves al final del gran cuarto.");
        System.out.println("Escuchas unos crujidos en debajo de tus pies, como si algo se moviera en el piso inferior.");
        System.out.println("La situaci�n te pone m�s nervioso al fijarte que todos los cuadros de la sala tienen las caras tachadas de forma muy macabra, subiendo tu nivel de locura.");

        comprobadorLocuraPuerta(locura);

        System.out.println("De la nada te empieza a doler el tobillo, te lo miras y observas una especie de mordedura, como de roedor, no puedes aguantar el dolor y te agachas, no puedes con el dolor.");
        System.out.println("Te salta un rata gigante sobre ti, te asustas y usas el utensilio que escogiste anteriormente");

        if (cuchara ==  true) {
            System.out.println("La rata ve lo brillante que es la cuchara, te la roba y sale corriendo");
            cuchara = false;
        }

        if (tenedor == true) {
            System.out.println("Rapidamente coges el tenedor y le pinchas un ojo a la rata lo que la mata instant�neamente");
            comprobadorLocuraPuerta(locura);
        }

        if (cuchillo == true) {
            System.out.println("Clavas el cuchillo de forma certera en el torso del animal, dejandolo agonizando en el suelo de la sala.");
            System.out.println("La rata agoniza, pero te da un hambre feroz, como si tu instinto te estuviera pidiendo que te la comieras.");
            System.out.println("Opci�n 1: Matas a la rata\nOpci�n 2: Te la comes");

            opcionUsuario = pedirNumeroInt(scan);
            switch (opcionUsuario) {
                case 1:
                    System.out.println("Terminas con el sufrimiento de la rata");
                    comprobadorLocuraPuerta(locura);
                    opcionUsuario = 2;
                    break;
                case 2:
                    System.out.println("Empiezas a deborar al sucio roedor de una forma grotesca, cosa que no te quita el hambre, si no que te da m�s.");
                    locura+=6;
                    comprobadorLocuraPuerta(locura);

                    break;
                default:
                    System.out.println("La rata desaparece de repente");
                    opcionUsuario = 2;
            }
        }

        else {
            System.out.println("La rata te arranca un ojo por el cual se mete en tu cabeza y mueres");
            opcionUsuario = 15;
        }
        if(locura<5) {
            System.out.println("Ves un mantel viejo, lo sacudes y te tapas la herida supurante del tobillo, cojeando vas al final de la habitaci�n hay una puerta que parece que da al exterior, pero tiene una gran cerradura que se encuentra cerrada. Cerca de la puerta hay un espejo tapado, que desentona con el resto del sal�n, siendo este el �nico mueble cubierto del polvo");
            System.out.println("Te decides a destaparlo, al hacerlo empiezas a toser y lees en el clistal, escrito con sangre,\n\n\"Es solo una ilusi�n\"\n\n");
            System.out.println("En ese momento observas tu rostro en el espejo, y te das cuenta de que tiene pagado en la frente una llave, la cual pruebas con la cerradura de la puerta");
            System.out.println("Abres la puerta");
            System.out.println("Detr�s de esa hay otra puerta, y de esa, otra, y de esa, otra, hasta que llegas a una que indica, que si te tragas la llave, volveras y no habr� pasado nada, pero si abres la puerta, no sobras lo que te vas a encontrar");
            System.out.println("�Qu� quieres hacer?");
            System.out.println("\nOpci�n 1: te tragas la llave\nOpci�n 2: abres la puerta y sales corriendo");

            opcionUsuario = pedirNumeroInt(scan);
            switch (opcionUsuario) {
                case 1:
                    System.out.println("Te duermes una vez m�s, tras tragarte la llave...");
                    opcionUsuario = 15;
                    break;
                case 2:
                    System.out.println("Enhorabuena, has salido, pero no sabes que te deparar� el futuro...");
                    opcionUsuario = 2;
                    break;
                default:
                    System.out.println("Una sombra se acerca a ti de forma vertiginosa...");
                    opcionUsuario = 15;
            }
        }
    }

    public static void comprobadorLocuraPuerta(int locura) {

        if (locura >= 5) {
            System.out.println("Sientes que tu no eres tu, te miras en un reflejo, y ves que tu cara se ha vuelto borrosa y no tienes boca, lo que provoca que salgas corriendo hacia una pared con el cuchillo en el pecho, muriendo en el acto.");
            System.out.println("\n\nSe acab�, has muerto");
            opcionUsuario = 15;
        }

    }

    static void trampilla(Scanner scan) {
        int locura = 0;
        String decisionSiNo = "";
        System.out.println("\nTe situas encima de la carcomida trampilla y te arrodillas para tocar su superficie en busca de un pomo.");
        System.out.println("Comienzas a notar unos crujidos bajo tus rodillas, intentas levantarte rápidamente. Ya es tarde, para cuando consigues levantarte escuchas un fuerte chasquido que indica que la trampilla se ha roto bajo tus pies y te precipitas al vacío");
        System.out.println("\nTras un golpe sordo te levantas aturdido, sientes un sabor metálico en la boca pero parece que no te has hecho daño. Notas un bulto en la pierna que se te clava a través del pantalón, acercas tu mano al bolsillo y encuentras una pequeña caja de cerillas.");
        System.out.println("\nSe escucha un lejano gruñido en la oscura habitación, ¿qué haces?:\n\t1) Enciendes una cerilla para tratar de buscar el origen de ese ruido\n\t2) Te mantienes lo más silencioso posible a la espera de que el ruido se aleje\n");
        opcionUsuario = pedirNumeroInt(scan);
        if (opcionUsuario == 1) {
            System.out.println("\nPresa del miedo enciendes rápidamente una cerilla para iluminar la habitación.");
            System.out.println("Una siniestra voz te susurra al oído: *no deberías haber bajado aquí...*");
            System.out.println("Notas como el aire se hace cada vez más denso y comienzas a sufir alucinaciones, cuanto más tiempo pasa, más te cuesta respirar. Tu mente empieza a nublarse mientras caes desplomado al suelo.\nLa siniestra voz te habla por última vez: *...ahora formarás parte del a historia de este lugar...*");
            System.out.println("Tu respiración se va apagando lentamente... \n\n\t\tHAS MUERTO");
        }
        else {
            System.out.println("\nPresa del miedo decides agacharte y hacer el menor ruido posible.");
            System.out.println("El gruñido se aleja junto con el sonido como de chapotear en un charco. Agazapado en esa habitación te parece ver, de forma fugaz, la imagen de un escritorio de roble con un oxidado candil encima");
            System.out.println("\nEl ambiente se queda en completo silencio, los chapoteos se han disipado en la lejanía, decides encender una cerilla ahora que sabes que estás a salvo");
            System.out.println("Encuentras a tu alrededor una enorme cocina en la que parece que hace tiempo que no se utiliza, tienes hambre y puedes vislumbrar en la penumbra una olla\n\t1) Te acercas a inspeccionar la olla\n\t2) Buscas en la cocina a ver si encuentras comida fresca");
            opcionUsuario = pedirNumeroInt(scan);
            if (opcionUsuario == 1) {
                System.out.println("Abres la tapa de la olla y encuentras un caldo en el que flota una cosa blanca, metes un cucharon para comprobar que es y sacas un pequeño cráneo");
                System.out.println("Retrocedes de la olla gritando y muerto de miedo lanzas con fuerza la pequeña calavera. (tus niveles de locura aumentan significativamente)");
                locura+=4;
                comprobadorLocura(locura);
            }
            System.out.println("Te pones a mirar con la cerilla aún encendida por la habitación y encuentras una pequeña caja con un 7 y un cuchillo dibujado, ¿quieres abrirla (si/no)?");
            decisionSiNo = scan.nextLine();
            if (decisionSiNo.equalsIgnoreCase("si")){
                System.out.println("\nAl abrir la caja encuentras una misteriosa tableta de chocolate en perfecto estado, decides comértela pero te sientes extrañado por el estado del chocolate (tu nivel de locura se disminuye)");
                locura-=1;
            }
            System.out.println("\nContinuas registrando la habitación y encuentras una puerta de madera que está abierta, avanzas lentamente y te encuentras con una enorme galería iluminada que tiene en el medio una larga mesa para muchos comensales");
            System.out.println("Todo parece muy lujoso salvo por el hecho de que los cubiertos son de madera y están roídos");
            System.out.println("La habitación luce abandonada desde hace años, así lo muestran las enormes telarañas que se extienden por las columnas. \nDe un golpe se abre una pequeña ventana del techo y escuchas una voz un tanto siniestra que te dice: *...debes correr muy lejos de aquí...* (tus niveles de locura aumentan significativamente)");
            locura+=4;
            comprobadorLocura(locura);
            System.out.println("\nTras recobrarte del susto intentas centrarte, no sabes donde estás ni como has llegado a este lugar, la ventana está demasiado alta como para poder escalar a mirar el exterior. En la derecha de la habitación, casi oculto tras unas cortinas ves un cartel que dice: \n\t1) Escaleras superiores\n\t2) Escaleras inferiores\n¿Por dónde quieres ir?");
            opcionUsuario = pedirNumeroInt(scan);
            switch (opcionUsuario) {
                case 1:
                    System.out.println("\nSubes por las escaleras y desembocas ante una puerta de metal, está un poco oxidada aunque seguramente seas capaz de abrirla sin problema.\nComienzas a escuchar los gruñidos de antes cada vez más cerca, ¿qué haces?\n\t1) Abrir la puerta y huir\n\t2) Apagar la cerilla y mantenerte en silencio");
                    opcionUsuario = pedirNumeroInt(scan);
                    if (opcionUsuario == 1) {
                        System.out.println("\nTras unos fuertes golpes en la puerta consigues abrirla y sales a un enorme patio interior, observas la silueta de una estatua en la mitad del patio\n\tademás puedes ver una hilera de almenaras que bordean el patio como si de una fortaleza se tratase");
                        System.out.println("El sonido del chapoteo te hace recordar rápidamente que algo te persigue y aunque muerto de miedo, consigues cerrar la puerta. (tu nivel de locura aumenta de forma crítica)");
                        locura+=7;
                        comprobadorLocura(locura);
                        System.out.println("Te acercas a la estatua del ángel dónde encuentras una inscripción: \n\t\"He sobrevivido "+ numeroVecesJugadas +" veces\"");
                        System.out.println("De repente un golpe seco te hace caer al suelo, desmayado...\n");
                        opcionUsuario = 15; //continuar juego en bucle
                    }
                    else {
                        System.out.println("\nApagas rápidamente tu cerilla preso del miedo y tratas de hacer el menor ruido posible, hasta que deja de oírse el chapoteo");
                        System.out.println("Enciendes otra cerilla y encuentras delante de tí una aberración de la naturaleza de color verdoso que con voz dulce te dice:\n\t*...te dije que debías correr muy lejos de aquí...*");
                        System.out.println("\n\tSu voz se torna más grave y los ojos de la criatura se inyectan en sangre: \n\t*...AHORA DEBES MORIR...*");
                        locura+=20; //personaje muere si o sí
                        comprobadorLocura(locura);
                    }

                    break;

                case 2:
                    System.out.println("\nCoges las escaleras que bajan a un sótano, cada vez sientes más y más frío...\nEl ambiente está muy húmedo, notas bajo tus pies descalzos pequeños charcos un poco viscosos. Cuidadosamente enciendes tu cerilla y comienzas a mirar a tu alrededor.\nUna extraña bombilla parpadea con una luz muy tenue al final del enorme pasillo que compone el sótano.\nObservas que un reguero rojo y viscoso avanza por el suelo hasta una puerta al final de la sala ¿qué haces?\n\t1) Seguirlo\n\t2) Tratar de obtener más información de ese fluído");
                    opcionUsuario = pedirNumeroInt(scan);
                    if (opcionUsuario == 1) {
                        System.out.println("Sigues el reguero sin hacer caso a tu instinto que te dice que deberías huir de allí.\nA medida que va aumentando el caudal el olor empieza a ser insoportable, sientes un fuerte olor como a carne podrida.\nSin que te des cuenta la aberración que encontraste en la cocina aparece rompiendo la puerta dispuesta a matarte a golpes, ¿qué haces?\n\t1) Te enfrentas a ella\n\t2) Te preparas para parar el golpe");
                        opcionUsuario = pedirNumeroInt(scan);
                        if (opcionUsuario == 1) {
                            System.out.println("Tratas de darle un golpe cuando la tienes casi encima pero descubres que no es un ser corpóreo, comienzas a notar como tu cuerpo se deshace poco a poco y gritas de dolor mientras agonizas en el suelo...\n\n\n\tHAS MUERTO\n\n\n");
                            break;
                        }
                        else {
                            System.out.println("Para tu suerte recibes un impacto no demasiado fuerte que te deja en el suelo inconsciente...\nCon un primer momento de lucidez eres capaz de ver como algo te está arrastrando por un enorme pasillo de piedra, antes de caer inconsciente de nuevo crees pasar por delante de una habitación con un pequeño escritorio de roble\n");
                            opcionUsuario = 15; //continuar juego en bucle
                            numeroVecesJugadas++;
                        }
                    }
                    else {
                        System.out.println("Tratas de averiguar qué es el extraño fluído que tienes bajo tus pies, acercas la cerilla pero a penas eres capaz de ver algo que no sea el color rojo, parece sangre pero no estás seguro de dónde puede proceder, comienzas a avanzar lentamente siguiendo el rastro y te cortas con un pequeño trozo de metal en la pierna. A medida que te acercas a las puerta, sientes como el suelo vibra bajo tus pies, como si algo muy pesado estuviera corriendo. Crees que estás volviéndote loco y lo ignoras.\nAbres la enorme puerta y al otro lado encuentras un espejo con una mancha de sangre que dice:\n\t*Nunca podremos salir de aquí*\n\nDebido a tus heridas caes al suelo desorientado.\n");
                        opcionUsuario = 15; //continuar juego en bucle
                        numeroVecesJugadas++;

                    }

                    break;
                default:
                    System.out.println("Comienzas a sentir los gruñidos de antes detrás de tí y decides subir las escaleras esperando llegar a una salida.\nPreso del pánico subes corriendo y encuentras una puerta. Embistes la puerta y sales al exterior\nobservas la silueta de una estatua en la mitad del patio\\n\\tademás puedes ver una hilera de almenaras que bordean el patio como si de una fortaleza se tratase El sonido del chapoteo te hace recordar rápidamente que algo te persigue y aunque muerto de miedo, consigues cerrar la puerta. (tu nivel de locura aumenta de forma crítica)\n");
                    locura+=7;
                    comprobadorLocura(locura);
                    break;
            }

        }
    }

    public static void dormirse(Scanner scan) {

        int locura = 0;

        for (int i = 0; i < 6; i++) {
            delay(500);
            System.out.println(".");
        }

        System.out.println("Despiertas en una l�gubre habitaci�n. Una tenue luz de una vela a punto de apagarse flagra en una mesita al lado de la cama.\nConmocionado, sigues sin saber nada, excepto que ya no estas en la misma habitaci�n, todo hab�a pasado, lo de antes solo fue un mal sue�o, pero� No era as�.");
        System.out.println("\nDistingues la silueta de un hombre dado la espalda. Parece que no sabe que te has despertado.");
        System.out.println("\n�Qu� decides hacer?\n\n\t1) Preguntas quien es y donde estas.\n\n\t2) Te quedas en silencio.\n");

        opcionUsuario = pedirNumeroInt(scan);


        if (opcionUsuario == 1) {

            System.out.println("\nSe gira malhumorado y se acerca a ti con rapidez, seg�n se va acercando a la luz vas distingui�ndole cada vez m�s.\nTe das cuenta de que no es una persona, es algo mucho peor, un ser proveniente del inframundo.\nVestido con lo que parece un uniforme de m�dico, te mira con unos ojos negros como el carb�n que se clavan en tu alma.\nAbre su boca dispuesto a comerte, revela unos dientes afilados, sabes que tu hora hab�a llegado.");
            System.out.println("\nUn gran estruendo inunda la habitaci�n interrumpiendo al ser que iba a comerte, el sonido parec�a de un suelo de madera que se hab�a roto, \nparec�a estar a pocos metros de donde te encuentras.");
            System.out.println("\nEl monstruo parece alertarse bastante, decide pegarte un pu�etazo en la cara y se va por una puerta de la habitaci�n en busca de la causa de ese sonido.");
            System.out.println("\n\nTu nivel de locura aumenta");
            locura = 5;
        } else if (opcionUsuario == 2) {
            delay(2000);
            System.out.println("\nUn gran estruendo inunda la habitaci�n, el sonido parec�a de un suelo de madera que se hab�a roto, parec�a estar a pocos metros de donde te encuentras. \nEl hombre parece alertarse bastante y se va por una puerta de la habitaci�n en busca de la causa de ese sonido.");
        } else {
            System.out.println("\nNo se que intentas hacer, pero parece que has llamado la atenccion del hombre.");
            System.out.println("\nSe gira malhumorado y se acerca a ti con rapidez, seg�n se va acercando a la luz vas distingui�ndole cada vez m�s.\nTe das cuenta de que no es una persona, es algo mucho peor, un ser proveniente del inframundo.\nVestido con lo que parece un uniforme de m�dico, te mira con unos ojos negros como el carb�n que se clavan en tu alma.\nAbre su boca dispuesto a comerte, revela unos dientes afilados, sabes que tu hora hab�a llegado.");
            System.out.println("\nUn gran estruendo inunda la habitaci�n interrumpiendo al ser que iba a comerte, el sonido parec�a de un suelo de madera que se hab�a roto, \nparec�a estar a pocos metros de donde te encuentras.");
            System.out.println("\nEl monstruo parece alertarse bastante, decide pegarte un pu�etazo en la cara y se va por una puerta de la habitaci�n en busca de la causa de ese sonido.");
            System.out.println("\n\nTu nivel de locura aumenta");
            locura = 5;
        }


        System.out.println();
        System.out.println("Sales de la habitaci�n lo antes posible antes de que vuelva eso. Avanzas por un pasillo apagado y mugriento,\nlas telara�as abundan en el z�calo del techo, mientras caminas suena el rechinar del suelo.\nAvanzando por una alfombra roja muy lustrosa llegas a una especie de vest�bulo principal.");
        System.out.println("\nVes una gran puerta de madera que parece ser la puerta principal de donde te hayas.\nComo no, la puerta est� cerrada a cal y canto.");
        System.out.println("Observando el vest�bulo, ves una gran escalera que sube al piso superior y otro pasillo que no sabes d�nde ir�.");
        System.out.println("A la lejan�a escuchas pasos, parecen venir de la habitaci�n donde te encontrabas, tenias que salir de all� antes de que supiera que estas aqu�.");

        System.out.println("\n�Qu� decides hacer?\n\n\t1) Subes por la escalera.\n\n\t2) Avanzas por el pasillo.\n");
        opcionUsuario = pedirNumeroInt(scan);

        if (opcionUsuario == 1) {

            System.out.println("Subes r�pido pero con cuidado de no hacer ruido por la escalera, y llegas a un pasillo.");
            System.out.println("\nTienes dos caminos, ir por la izquierda o por la derecha\n�Por cual decides ir?\n\n\t1) Izquierda.\n\n\t2) Derecha\n");
            opcionUsuario = pedirNumeroInt(scan);
            if (opcionUsuario == 1) {

                System.out.println("\nCaminas r�pido por un pasillo angosto, los pasos detr�s de ti cada vez suenan m�s fuerte y m�s cercanos, tu coraz�n palpita cada vez mas r�pido.");
                System.out.println("No ves nada mas que una puerta al final, un fuerte grito dirigido a ti suena a tus espaldas a escasos metros.");
                System.out.println("Empiezas a correr, pero los pasos detr�s de ti se agilizan y cada vez est�n mas cerca.");
                System.out.println("Llegas al final del pasillo, abres la puerta r�pidamente, y entras, al cerrar la puerta ves aquello que te persegu�a y estaba ah� justamente,\ntu coraz�n palpita a punto de explotar, pero le cierras la puerta con fuerza.");
                System.out.println("No puedes m�s, tu coraz�n palpita tan fuerte que te agarras el pecho y�");
                System.out.println("PUM���\n");
                delay(30000);
                System.out.println("Te relajas, parece que todo ha pasado.");
                delay(3000);
                System.out.println("\nUn silencio inunda tu cuerpo.");
                System.out.println("Escuchas una armonia celestial y...");
                delay(3000);
                System.out.println("Caes de golpe contra el suelo.\n\n");
                delay(3000);
                main(null);

            } else if (opcionUsuario == 2) {

                System.out.println("\nAvanzas por la derecha, te das cuenta de que el pasillo no tiene escapatoria, solo un ventanal al final del pasillo. Decides volver pero al darte la vuelta hay una pared.\n");
                System.out.println("Se escucha un fuerte mecanismo de engranajes y la pared comienza a desplazarse hacia tu posici�n. Intentas pararla sin conseguir nada, la pared cada vez va m�s r�pido.");
                System.out.println("Poco a poco te vas acercando al ventanal, del miedo, la �nica reacci�n que toma tu cuerpo es correr hacia el ventanal y saltas hacia �l.");
                System.out.println("El ventanal daba a un patio interior, con la mala suerte de caer encima de una valla, clav�ndote la punta de flecha en el est�mago.\n");
                System.out.println("Te desangras lentamente hasta morir.\n\n");
                main(null);

            } else {

                System.out.println("De los nervios, no decides con certeza y eliges el camino de la izquierda.");
                System.out.println("\nCaminas r�pido por un pasillo angosto, los pasos detr�s de ti cada vez suenan m�s fuerte y m�s cercanos, tu coraz�n palpita cada vez mas r�pido.");
                System.out.println("No ves nada mas que una puerta al final, un fuerte grito dirigido a ti suena a tus espaldas a escasos metros.");
                System.out.println("Empiezas a correr, pero los pasos detr�s de ti se agilizan y cada vez est�n mas cerca.");
                System.out.println("Llegas al final del pasillo, abres la puerta r�pidamente, y entras, al cerrar la puerta ves aquello que te persegu�a y estaba ah� justamente,\ntu coraz�n palpita a punto de explotar, pero le cierras la puerta con fuerza.");
                System.out.println("No puedes m�s, tu coraz�n palpita tan fuerte que te agarras el pecho y�");
                System.out.println("PUM���\n");
                delay(30000);
                System.out.println("Te relajas, parece que todo ha pasado.");
                delay(3000);
                System.out.println("\nUn silencio inunda tu cuerpo.");
                System.out.println("Escuchas una armonia celestial y...");
                delay(3000);
                System.out.println("Caes de golpe contra el suelo.\n\n");
                delay(3000);
                main(null);

            }

        } else if (opcionUsuario == 2) {

            System.out.println("Continuas con prisa por el pasillo, avanzando por el ves dos puertas entreabiertas, tienes que elegir una de ellas para esconderte.");
            System.out.println("\nTienes dos caminos, la puerta de la izquierda o la puerta de la derecha\n�Por cual decides ir?\n\n\t1) Puerta izquierda.\n\n\t2) Puerta derecha\n");
            opcionUsuario = pedirNumeroInt(scan);

            if (opcionUsuario == 1) {

                System.out.println("Abres la puerta de la izquierda y entras, cierras la puerta y esperas en silencio.");
                System.out.println("Escuchas unos pasos que se acercan cada vez m�s, y se paran justo al otro lado de la puerta.");
                delay(3000);
                System.out.println("\nLos pasos se vuelven a o�r alej�ndose cada vez m�s, parece que el peligro ha pasado. Mejor ser� no salir.");

                System.out.println("Estas en una habitaci�n completamente a oscuras, notas un escal�n, parece que hay unas escaleras hacia abajo, pero no es muy buena idea bajar a oscuras,");
                System.out.println("notas un olor extra�o y una brisa roza tu cara. Encima de ti, notas una cuerda que acciona un interruptor.");
                System.out.println("\nPuedes accionar el interrupto para encender la luz o bajar las escaleras a oscuras\n�Que decides hacer?\n\n\t1) Bajas a tientas las escaleras\n\n\t2) Enciendes la luz\n");
                opcionUsuario = pedirNumeroInt(scan);

                if (opcionUsuario == 1) {

                    System.out.println("\nTe dispones a bajar las escaleras con cuidado, escal�n a escal�n el olor cada vez es mas fuerte.");
                    System.out.println("Un escal�n mal colocado te hace tropezar haciendo que vayas de cabeza contra el vac�o.\n");
                    System.out.println("Caes contra un escal�n, que te da en la cabeza y quedas inconsciente, las escaleras se pierden en el vac�o.");
                    System.out.println("Tu cuerpo sigue cayendo sin fin a un vac�o oscuro y frio, donde se perder� para siempre.\n\n");
                    main(null);

                } else if (opcionUsuario == 2) {

                    System.out.println("Alzas la mano para encender el interruptor. La luz parpadea, apagas y vuelves a encender, delante de ti se encuentra ese ser que se dispon�a a matarte.");
                    System.out.println("Es� horroroso�");
                    System.out.println("Te deja sin palabras");
                    System.out.println("Sin consciencia propia");
                    System.out.println("Tu mano agarrotada en la cuerda del interruptor, del miedo, accionas el interruptor, apagando la luz.");
                    locura = locura + 15;
                    comprobadorLocura(locura);
                    System.out.println("\n\n");
                    main(null);

                } else {

                    System.out.println("Te mareas y no mantienes el control, hace que vayas de cabeza contra el vac�o.");
                    System.out.println("Caes contra un escal�n, que te da en la cabeza y quedas inconsciente, las escaleras se pierden en el vac�o.");
                    System.out.println("Tu cuerpo sigue cayendo sin fin a un vac�o oscuro y frio, donde se perder� para siempre.");
                    main(null);

                }


            } else if (opcionUsuario == 2) {

                System.out.println("Abres la puerta de la derecha y entras, cierras la puerta y esperas en silencio.");
                System.out.println("Escuchas unos pasos que se acercan cada vez m�s, y se paran justo al otro lado de la puerta.");
                delay(3000);
                System.out.println("\nLos pasos se vuelven a o�r alej�ndose cada vez m�s, parece que el peligro ha pasado. Mejor ser� no salir.");
                System.out.println("En cuanto te tranquilizas, notas un olor pestilente, al girarte ves que te encuentras en un establo muy descuidado, esta todo completamente vac�o y destrozado.\n");
                System.out.println("Al final del establo ves un port�n abierto que da al exterior, avanzas hacia �l. ");
                System.out.println("Al lado del port�n, en una escuadra medio decente escuchas unos ruidos, al acercarte ves un roc�n que se levanta y se acerca cari�osamente.");

                do {

                    System.out.println("\nTienes que salir de aqu�\n�Que decides hacer?\n\n\t1) Dejar el caballo y salir a pie al exterior.\n\n\t2) Montarte en el caballo y salir con �l al exterior.\n");
                    opcionUsuario = pedirNumeroInt(scan);

                    if (opcionUsuario == 1) {

                        System.out.println("Sales por el port�n corriendo, sin mirar atr�s para no perder tiempo. Corres sin parar, pero no sabes a d�nde vas, este todo oscuro.");
                        System.out.println("Escuchas un fuerte sonido de una cuerda destensarse a la lejan�a.");
                        System.out.println("Un silbido suena cada vez m�s cerca.");
                        System.out.println("Y de repente�\n\n");
                        delay(10000);
                        System.out.println("Un gran arp�n te ensarta el coraz�n por las espalada.\n");
                        System.out.println("Caes al instante apaciguado, a los pocos segundos, tu cuerpo yace sin vida en el suelo.\n");
                        System.out.println("Y poco a poco te van arrastrando devuelta a ese lugar maldito.\n\n\n\n");
                        main(null);

                    } else if (opcionUsuario == 2) {

                        System.out.println("Te subes a lomos del caballo, y cabalgas r�pido hacia el horizonte oscuro.");
                        System.out.println("Escuchas un fuerte sonido de una cuerda destensarse a la lejan�a.");
                        System.out.println("Un silbido suena cada vez m�s cerca.");
                        System.out.println("Un arp�n cae a pocos metros de ti, parece que te has librado.");
                        System.out.println("Todo parece sombr�o y frio, parece que has escapado de ese maldito lugar.");
                        System.out.println("No ves absolutamente nada, la oscuridad te va comiendo cada vez m�s, no consigues ver ni el suelo.");
                        System.out.println("Poco a poco la oscuridad va encerr�ndote m�s, en pocos segundos el caballo desaparece de tu vista.");
                        System.out.println("Caes a un vac�o que te consume, sientes mas frio y que tu alama se separa de tu cuerpo, cierras los ojos y notas una paz eterna�\n\n");
                        delay(15000);
                        main(null);

                    } else {

                        System.out.println("Tienes que escoger una opcion.");

                    }

                } while (true);

            } else {

                System.out.println("No sabes que decision tomar. Te quedas paralizado\n");
                System.out.println("Los pasos por detras suenan cada vez mas cerca, derrepente recibes un fuerte golpe en la cabeza que te deja incosciente al instante.");
                System.out.println("Notas como te arrastran y te llevan a una habitaci�n.");
                main(null);
            }

        } else {

            System.out.println("No sabes que decision tomar. Te quedas paralizado\n");
            System.out.println("Los pasos por detras suenan cada vez mas cerca, derrepente recibes un fuerte golpe en la cabeza que te deja incosciente al instante.");
            System.out.println("Notas como te arrastran y te llevan a una habitaci�n.");
            main(null);

        }


    }


    static void comprobadorLocura(int locura) {

        if (locura < 5) {
            System.out.println("\n\n...Sientes unas voces en tu cabeza que te hablan en un idioma que desconoces...\n\n");
        }
        else if (locura >5 && locura < 10) {
            System.out.println("\n\n...Escuchas unas voces en tu cabeza que no comprendes, solo eres capaz de entender la palabra: final...\n\n");
            locura++;
        }
        else if (locura > 10 && locura < 18) {
            System.out.println("\n\n...Crees entender las voces de tu cabeza que te dicen este es el final de tu historia...\n\n");
            locura++;
        }
        else if (locura > 18) {

            System.out.println("\n\n...Comienzas a ver bichos subiendo por tu piel y tratas de arranc�rtela, lo que provoca tu muerte...\n\n\n\n\t\tHAS MUERTO");

        }
    }

    public static void delay(long milis) {

        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}