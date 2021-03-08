package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.common.TODO;

public class DisplayDevice {
	
	private static final int COUNT = 10;
		
	public static void main (String[] args) {
		
		
		// TODO - START
		System.out.println("Display starting ...");
		// create a client object and use it to
		Client client = new Client("disp", Common.BROKERHOST, Common.BROKERPORT);
		// - connect to the broker
		if(client.connect()) {
			
			// - create the temperature topic on the broker
			client.createTopic(Common.TEMPTOPIC);
			// - subscribe to the topic
			client.subscribe(Common.TEMPTOPIC);
			for(int i = 0; i<COUNT; i++) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			// - receive messages on the topic
			PublishMsg m  =(PublishMsg) client.receive();
			System.out.println(m.toString());
			// - unsubscribe from the topic
			}
			client.unsubscribe(Common.TEMPTOPIC);
			// - disconnect from the broker		
			client.disconnect();
		}
		// TODO - END
		
		System.out.println("Display stopping ... ");
		
	}
}
