/**
 * 
 */
package com.demo.boot.h2.db.model;

/**
 * @author MGupta
 *
 */
public class Student {

	private Long id;
    private String name;
    private String passport;
    
    public Student() {
    	//Default
    }
    
	/**
	 * @param id
	 * @param name
	 * @param passport
	 */
	public Student(Long id, String name, String passport) {
		super();
		this.id = id;
		this.name = name;
		this.passport = passport;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the passport
	 */
	public String getPassport() {
		return passport;
	}
	/**
	 * @param passport the passport to set
	 */
	public void setPassport(String passport) {
		this.passport = passport;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", passport=" + passport + "]";
	}
}
