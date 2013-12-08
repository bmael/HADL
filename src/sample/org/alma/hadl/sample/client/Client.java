/**
 * 
 */
package org.alma.hadl.sample.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.alma.hadl.component.Component;
import org.alma.hadl.observer.Observable;
import org.alma.hadl.sample.client.port.SendRequestPort;
import org.alma.hadl.sample.client.service.SendRequestService;

/**
 * @author Julien
 *
 */
public class Client extends Component {
	public Client() {
		super("Client");
		
		this.addProvidedPort(new SendRequestPort(this, "SendRequestPort"));
		this.addProvidedService(new SendRequestService(this, "SendRequestService"));
	}

	public void doAction() {
		System.out.println("In Client");

		List<String> args;
		int i = 0;

		Scanner sc = new Scanner(System.in);
		String arg;

		do {
			args = new ArrayList<>();

			System.out.println("=====================================");
			System.out.println("\t\tCLient");
			System.out.println("=====================================");
			System.out.println("Enter What you want to do :");
			System.out.println("[1] - Add User in database");
			System.out.println("[2] - Remove User from databse");
			System.out.println("[3] - Show database content");
			System.out.println("[0] - Quit");
			System.out.println("=====================================");

			i = sc.nextInt();
			sc.nextLine();

			switch (i) {
			
			case 1:
				args.add("addUser");

				System.out.println("Enter User First Name :");
				arg = sc.nextLine();
				args.add(arg);

				System.out.println("Enter User Last Name");
				arg = sc.nextLine();
				args.add(arg);
				
				((SendRequestService) this.getProvidedServiceByType(SendRequestService.class)).send(this, args);
				
				break;

			case 2:
				args.add("removeUser");

				System.out.println("Enter User First Name :");
				arg = sc.nextLine();
				args.add(arg);

				System.out.println("Enter User Last Name :");
				arg = sc.nextLine();
				args.add(arg);
				
				((SendRequestService) this.getProvidedServiceByType(SendRequestService.class)).send(this, args);
				
				break;
				
			case 3:
				args.add("selectAllUsers");
				
				((SendRequestService) this.getProvidedServiceByType(SendRequestService.class)).send(this, args);
				
				break;

			case 0:
				System.out.println("Shutting down client");
				break;
				
			default :
				System.err.println("Unknown command");
				break;
			}

		} while ( i != 0 );
		
		sc.close();

	}	// doAction

	@Override
	public void update(Observable obs, Object args) {
		if ( obs instanceof SendRequestPort )
			System.out.println("Back in Client");
			System.out.println(args);
	}
}
