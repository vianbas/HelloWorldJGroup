import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;

public class HelloWorld 
{
    public static void main(String[] args) throws Exception 
    {
        JChannel channel = new JChannel();
        channel.setReceiver(new ReceiverAdapter() {
            @Override
            public void receive(Message msg) 
            {
                System.out.println("[Pesan Dari " + msg.getSrc() + "] :\t" + msg.getObject());
            }
        });
        channel.connect("MyHello");
        channel.send(new Message(null, "hello world semua"));
    }
}
