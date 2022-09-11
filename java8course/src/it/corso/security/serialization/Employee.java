package it.corso.security.serialization;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Employee implements Serializable {
	private String name;
	private String ssn;
	private int age;

	// Constructors/getters/setters

	private Employee() {
	}

	private static Map<String, Employee> pool = new ConcurrentHashMap<>();

	/**
	 * We introduce a pool of object to give an example of using pre/post
	 * serialization methods so that we ensure that the reference of the object
	 * comes from the in-memory object and not from the deserialized one
	 * 
	 * @param name
	 * @return
	 */
	public synchronized static Employee getEmployee(String name) {
		if (pool.get(name) == null) {
			Employee e = new Employee();
			e.name = name;
			pool.put(name, e);
		}
		return pool.get(name);
	}

	/**
	 * You can use serialPersistentFields to name fields to persist explictly
	 * instead of marking them out with transient
	 */
	private static final ObjectStreamField[] serialPersistentFields = { new ObjectStreamField("name", String.class),
			new ObjectStreamField("ssn", String.class) };

	private static String encrypt(String input) {
		// Implementation omitted
		return "";
	}

	private static String decrypt(String input) {
		// Implementation omitted
		return "";
	}

	private void writeObject(ObjectOutputStream s) throws Exception {
		ObjectOutputStream.PutField fields = s.putFields();
		fields.put("name", name);
		fields.put("ssn", encrypt(ssn));
		s.writeFields();
	}

	private void readObject(ObjectInputStream s) throws Exception {
		ObjectInputStream.GetField fields = s.readFields();
		this.name = (String) fields.get("name", null);
		this.ssn = decrypt((String) fields.get("ssn", null));
	}

	/**
	 * This is executed after deser
	 * 
	 * @return
	 * @throws ObjectStreamException
	 */
	public synchronized Object readResolve() throws ObjectStreamException {
		Employee existingEmployee = pool.get(name);
		if (pool.get(name) == null) {
			// New employee not in memory
			pool.put(name, this);
			return this;
		} else {
			// Existing user already in memory
			existingEmployee.name = this.name;
			existingEmployee.ssn = this.ssn;
			return existingEmployee;
		}
	}

	/**
	 * This is executed before serialization
	 * 
	 * @return
	 * @throws ObjectStreamException
	 */
	public Object writeReplace() throws ObjectStreamException {
		Employee e = pool.get(name);
		return e != null ? e : this;
	}
}