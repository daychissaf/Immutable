package codinggame.codinggame;

import java.util.Date;

public final class Planet {

	// PRIVATE

	/**
	 * Final primitive data is always immutable.
	 */
	private final double mass;

	/**
	 * An immutable object field. (String objects never change state.)
	 */
	private final String name;

	/**
	 * A mutable object field. In this case, the state of this mutable field is to
	 * be changed only by this class. (In other cases, it makes perfect sense to
	 * allow the state of a field to be changed outside the native class; this is
	 * the case when a field acts as a "pointer" to an object created elsewhere.)
	 */
	private final Date discoveryDate;

	public Planet(double mass, String name, Date discoveryDate) {
		this.mass = mass;
		this.name = name;
		// make a private copy of aDateOfDiscovery
		// this is the only way to keep the fDateOfDiscovery
		// field private, and shields this class from any changes that
		// the caller may make to the original aDateOfDiscovery object
		this.discoveryDate = new Date(discoveryDate.getTime());
	}

	/**
	 * Returns a primitive value.
	 *
	 * The caller can do whatever they want with the return value, without affecting
	 * the internals of this class. Why? Because this is a primitive value. The
	 * caller sees its "own" double that simply has the same value as fMass.
	 */
	public double getMass() {
		return mass;
	}

	/**
	 * Returns an immutable object.
	 *
	 * The caller gets a direct reference to the internal field. But this is not
	 * dangerous, since String is immutable and cannot be changed.
	 */
	public String getName() {
		return name;
	}

	// /**
	// * Returns a mutable object - likely bad style.
	// *
	// * The caller gets a direct reference to the internal field. This is usually
	// dangerous,
	// * since the Date object state can be changed both by this class and its
	// caller.
	// * That is, this class is no longer in complete control of fDate.
	// */
	// public Date getDateOfDiscovery() {
	// return fDateOfDiscovery;
	// }

	/**
	 * Returns a mutable object - good style.
	 * 
	 * Returns a defensive copy of the field. The caller of this method can do
	 * anything they want with the returned Date object, without affecting the
	 * internals of this class in any way. Why? Because they do not have a reference
	 * to fDate. Rather, they are playing with a second Date that initially has the
	 * same data as fDate.
	 */
	public Date getDiscoveryDate() {
		return new Date(discoveryDate.getTime());
	}

	/**
	 * if we want increase the mass for exemple we should not change current objects
	 * we create new Planet
	 */
	public Planet gincreaseMassBy(double delta) {
		return new Planet(mass + delta, name, discoveryDate);
	}

}