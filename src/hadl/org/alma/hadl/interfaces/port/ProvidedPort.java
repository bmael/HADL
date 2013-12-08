/**
 * 
 */
package org.alma.hadl.interfaces.port;

import java.util.ArrayList;
import java.util.List;

import org.alma.hadl.component.ComponentAssembly;
import org.alma.hadl.observer.Observable;
import org.alma.hadl.observer.Observer;

/**
 * @author Julien
 *
 */
public abstract class ProvidedPort extends Port implements Observable {
	protected List<Observer> observers = new ArrayList<>();
	
	public ProvidedPort(ComponentAssembly owner, String name) {
		super(owner, name);
	}

	@Override
	public void addObserver(Observer obs) {
		this.observers.add(obs);
	}

	@Override
	public void notifyObservers(Object args) {
		for (Observer observer : observers) {
			observer.update(this, args);
		}
	}
	
	@Override
	public void notifyObserversExceptCaller(Observer caller, Object args) {
		for (Observer observer : observers) {
			if ( !(observer.equals(caller)) )
				observer.update(this, args);
		}
	}
	
	@Override
	public void notifyObserver(Observer obs, Object args) {
		obs.update(this, args);
	}
}
