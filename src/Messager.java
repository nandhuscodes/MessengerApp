import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface MessagingService{
    void sendMessage(String message);
}
class SMSSendingService implements MessagingService{
    String phoneNumber = null;
    boolean isValidNumber(String phoneNumber){
        Pattern pattern = Pattern.compile("^((\\+[1-9]?[0-9])|0)?[7-9][0-9]{9}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        this.phoneNumber = phoneNumber;
        return (matcher.find() && matcher.group().equals(phoneNumber));
    }
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS to "+phoneNumber+"...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(message);
        System.out.println("SMS sent successfully!!!");
    }
}
class WhatsappMessagingService implements MessagingService{
    String phoneNumber = null;
    boolean isValidNumber(String phoneNumber){
        Pattern pattern = Pattern.compile("^((\\+[1-9]?[0-9])|0)?[7-9][0-9]{9}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        this.phoneNumber = phoneNumber;
        return (matcher.find() && matcher.group().equals(phoneNumber));
    }
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending Whatsapp message to "+phoneNumber+"...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print(message);
        System.out.println("\nWhatsapp sent successfully!!!");
    }
}
class EmailMessagingService implements MessagingService{
    String email = null;
    boolean isValidEmail(String email){
        Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        Matcher matcher = pattern.matcher(email);
        this.email = email;
        return (matcher.find() && matcher.group().equals(email));
    }
    @Override
    public void sendMessage(String message) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print(message);
    }
}
public class Messager {
    public static void main(String[] args) {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        while(choice!=4){
            System.out.print("\n\tChoose the options to send message\n1.)SMS\n2.)Whatsapp\n3.)Email\n4.)Exit\nEnter your option: ");
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    SMSSendingService sendingService = new SMSSendingService();
                    System.out.print("Enter mobile number of receiver: ");
                    scanner.nextLine();
                    String phoneNumber = scanner.nextLine();
                    while(!sendingService.isValidNumber(phoneNumber)){
                        System.out.println("Invalid mobile number");
                        System.out.print("Enter mobile number of receiver: ");
                        phoneNumber = scanner.nextLine();
                    }
                    if(sendingService.isValidNumber(phoneNumber)){
                        System.out.println("Number verified!!!");
                        System.out.print("Type your message here...  ");
                        String message = scanner.nextLine();
                        sendingService.sendMessage(message);
                    }
                    break;
                case 2:
                    WhatsappMessagingService whatsappMessagingService = new WhatsappMessagingService();
                    char ch = 'n';
                    System.out.print("Do recipient already in Whatsapp? (y/n): ");
                    ch = scanner.next().charAt(0);
                    if(ch == 'y'){
                        System.out.print("Enter whatsapp number of receiver: ");
                        scanner.nextLine();
                        String whatsappNumber = scanner.nextLine();
                        while(!whatsappMessagingService.isValidNumber(whatsappNumber)){
                            System.out.println("Invalid mobile number");
                            System.out.print("Enter whatsapp number of receiver: ");
                            whatsappNumber = scanner.nextLine();
                        }
                        if(whatsappMessagingService.isValidNumber(whatsappNumber)){
                            System.out.println("Number verified!!!");
                            System.out.print("Type your message here...  ");
                            String message = scanner.nextLine();
                            whatsappMessagingService.sendMessage(message);
                        }
                    }else{
                        System.out.println("If recipient not in whatsapp then you can try SMS or email services!!!");
                    }
                    break;
                case 3:
                    EmailMessagingService emailMessagingService = new EmailMessagingService();
                    System.out.print("Enter recipient mail: ");
                    scanner.nextLine();
                    String email = scanner.nextLine();
                    while(!emailMessagingService.isValidEmail(email)){
                        System.out.println("Invalid email ID");
                        System.out.print("Enter email of receiver: ");
                        email = scanner.nextLine();
                    }
                    if(emailMessagingService.isValidEmail(email)){
                        System.out.println("Email verified!!!");
                        HashMap<String, String> mail = new HashMap<>();
                        System.out.print("Write your Mail...\nSubject: ");
                        mail.put("Subject", scanner.nextLine());
                        System.out.print("Body of the mail: ");
                        mail.put("Body", scanner.nextLine());
                        System.out.print("Sending Message to "+email+"...\nSubject: ");
                        emailMessagingService.sendMessage(mail.get("Subject"));
                        System.out.print("\nDear Recipient,\n\t\t");
                        emailMessagingService.sendMessage(mail.get("Body"));
                        System.out.println("\nBest Regards,\n"+email);
                        System.out.println("email sent successfully!!!");
                    }
                    break;
            }
        }
    }
}
