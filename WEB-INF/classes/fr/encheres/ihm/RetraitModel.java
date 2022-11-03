package fr.encheres.ihm;

import java.util.List;

import fr.encheres.bo.Retrait;

public class RetraitModel {
	private Retrait retrait;
	private List<Retrait> listeretrait;

	/**
	 * 
	 */
	public RetraitModel() {
		super();
	}

	/**
	 * @param retrait
	 */
	public RetraitModel(Retrait retrait) {
		super();
		this.retrait = retrait;
	}
	
	/**
	 * @param listeretrait
	 */
	public RetraitModel(List<Retrait> listeretrait) {
		super();
		this.listeretrait = listeretrait;
	}
	
	/**
	 * @param retrait
	 * @param listeretrait
	 */
	public RetraitModel(Retrait retrait, List<Retrait> listeretrait) {
		super();
		this.retrait = retrait;
		this.listeretrait = listeretrait;
	}

	/**
	 * @return the retrait
	 */
	public Retrait getRetrait() {
		return retrait;
	}

	/**
	 * @param retrait the retrait to set
	 */
	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}
	
	/**
	 * @return the listeretrait
	 */
	public List<Retrait> getListeretrait() {
		return listeretrait;
	}

	/**
	 * @param listeretrait the listeretrait to set
	 */
	public void setListeretrait(List<Retrait> listeretrait) {
		this.listeretrait = listeretrait;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RetraitModel [retrait=" + retrait + ", listeretrait=" + listeretrait + "]";
	}
}