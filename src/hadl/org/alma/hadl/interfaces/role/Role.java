/**
 * 
 */
package org.alma.hadl.interfaces.role;

import java.util.ArrayList;
import java.util.List;

import org.alma.hadl.interfaces.Interface;
import org.alma.hadl.observer.Observable;
import org.alma.hadl.observer.Observer;

/**
 * @author Julien
 *
 */
public abstract class Role extends Interface implements Observable {
	protected List<Observer> observers = new ArrayList<>();

	public Role(String name) {
		super(name);
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
	public void notifyObserver(Observer obs, Object args) {
		obs.update(this, args);
	}
}
