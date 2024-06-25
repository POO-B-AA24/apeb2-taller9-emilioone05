package ejercicio3;

public class MessageSystem {

    // Método principal para ejecutar el sistema
    public static void main(String[] args) {
        // Crear instancias de SMS y MMS
        SMS sms = new SMS("Pedrito", "Juan Pablo", "0981205444", "Que fue JayPi!! Como andas??");
        MMS mms = new MMS("Jeank", "Ryckysimo", "0922552608", "FotoDelDeber.jpg");

        // Crear instancia del sistema de mensajería
        MessageSystem messageSystem = new MessageSystem();

        // Enviar y ver mensajes
        messageSystem.sendMessage(sms);
        messageSystem.sendMessage(mms);

        messageSystem.viewMessage(sms);
        messageSystem.viewMessage(mms);
    }

    // Constructor de la clase MessageSystem
    public MessageSystem() {
    }

    // Método para enviar un mensaje
    public void sendMessage(Messages mess) {
        System.out.println("Enviando mensaje de " + mess.sender + " a " + mess.addressee);
        // Aquí se implementaría la lógica para enviar el mensaje
    }

    // Método para ver un mensaje
    public void viewMessage(Messages mess) {
        System.out.println("Viendo mensaje:");
        System.out.println(mess);
    }

}

// Clase base para representar un mensaje
class Messages {

    String sender;
    String addressee;
    String numMovil;
    String name;

    // Constructor
    public Messages(String sender, String addressee, String numMovil, String name) {
        this.sender = sender;
        this.addressee = addressee;
        this.numMovil = numMovil;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Messages{"
                + "sender='" + sender + '\''
                + ", addressee='" + addressee + '\''
                + ", numMovil='" + numMovil + '\''
                + ", name='" + name + '\''
                + '}';
    }
}

// Clase para representar un mensaje SMS
class SMS extends Messages {

    String MessCharacters;

    // Constructor
    public SMS(String sender, String addressee, String numMovil, String MessCharacters) {
        super(sender, addressee, numMovil, MessCharacters);
        this.MessCharacters = MessCharacters;
    }

    @Override
    public String toString() {
        return "SMS{"
                + "sender='" + sender + '\''
                + ", addressee='" + addressee + '\''
                + ", numMovil='" + numMovil + '\''
                + ", MessCharacters='" + MessCharacters + '\''
                + '}';
    }
}

// Clase para representar un mensaje MMS
class MMS extends Messages {

    String FileName;

    // Constructor
    public MMS(String sender, String addressee, String numMovil, String FileName) {
        super(sender, addressee, numMovil, FileName);
        this.FileName = FileName;
    }

    @Override
    public String toString() {
        return "MMS{"
                + "sender='" + sender + '\''
                + ", addressee='" + addressee + '\''
                + ", numMovil='" + numMovil + '\''
                + ", FileName='" + FileName + '\''
                + '}';
    }
}
