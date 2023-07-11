# MessengerApp

You are expected to create a messaging system that supports multiple messaging services such as SMS, Email, and WhatsApp. The common behaviour is sending messages, but the implementation of sending messages varies. Implement a Java program using interfaces to model this scenario.
Create an interface called MessagingService with the following method:
sendMessage(): This method should be implemented by classes representing different messaging services.
Create three classes, SMSMessagingService, EmailMessagingService, and WhatsAppMessagingService, which implement the MessagingService interface. Implement the sendMessage() method in each class based on the specific messaging service requirements.
Write a java code to demonstrate the usage of these classes, where you create instances of each messaging service class and invoke the sendMessage() method on each instance.
