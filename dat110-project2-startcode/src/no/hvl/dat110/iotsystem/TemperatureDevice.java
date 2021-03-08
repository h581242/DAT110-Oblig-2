package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		// TODO - start
		System.out.println("Temperature device starting...");

		// create a client object and use it to
		// - connect to the broker
		// - publish the temperature(s)
		// - disconnect from the broker
		
		Client client = new Client("SM", Common.BROKERHOST, Common.BROKERPORT);
		client.connect();
		
		if(client.connect()) {
			for(int i = 0; i < COUNT; i++) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				client.publish(Common.TEMPTOPIC, Integer.toString(sn.read()));
			}
			
			client.disconnect();
		}
		
		

		// TODO - end

		System.out.println("Temperature device stopping ... ");

		throw new UnsupportedOperationException(TODO.method());

	}
}
