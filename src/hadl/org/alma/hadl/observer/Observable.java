/**
 * 
 */
package org.alma.hadl.observer;

/**
 * @author Julien
 *
 */
public interface Observable {
	public void addObserver(Observer obs);
	public void notifyObservers(Object args);
	public void notifyObserversExceptCaller(Observer caller, Object args);
	public void notifyObserver(Observer obs, Object args);
}
