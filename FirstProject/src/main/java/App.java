import actor.NotificationActor;
import akka.actor.ActorRef;
import akka.actor.typed.ActorSystem;
import msg.Request;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello there!");
        ActorSystem<Request> myActor =
                ActorSystem.create(NotificationActor.behavior(), "myActor");
        myActor.tell(new Request("7330893359"));
    }
}
