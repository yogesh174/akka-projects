package actor;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import msg.Request;

public class NotificationActor extends AbstractBehavior<Request> {

    public NotificationActor(ActorContext<Request> context) {
        super(context);
    }

    @Override
    public Receive<Request> createReceive() {
        return newReceiveBuilder()
                .onMessage(Request.class, this::sendMsg)
                .build();
    }

    private Behavior<Request> sendMsg(Request message) {
        System.out.println("Sent template message to " + message.getNumber());
        return this;
    }

    public static Behavior<Request> behavior() {
        return Behaviors.setup(NotificationActor::new);
    }

}
