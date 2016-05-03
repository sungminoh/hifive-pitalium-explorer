package com.htmlhifive.pitalium.explorer.image;

import java.awt.Rectangle;

/**
 * Similarity unit class contains information of the similarity calculated from each method.
 */
public class SimilarityUnit {
	
	private int XSimilar;
	private int YSimilar;
	private double similarity;

	/**
	 * Constructor
	 * @param XSimilar  X-direction shift at the best match with the highest similarity
	 * @param YSimilar  Y-direction shift at the best match with the highest similarity
	 * @param similarity the highest similarity at the position of given X, Y-Similar
	 */
	public SimilarityUnit (int XSimilar, int YSimilar, double similarity) {
		this.XSimilar = XSimilar;
		this.YSimilar = YSimilar;
		this.similarity = similarity;
	}
	public SimilarityUnit(){
		this(0, 0, 0);
	}

	/**
	 * @return X-direction Similar at the best match with the highest similarity
	 */
	public int getXSimilar() {
		return XSimilar;
	}
	public void setXSimilar(int XSimilar){
		this.XSimilar = XSimilar;
	}

	/**
	 * @return Y-direction Similar at the best match with the highest similarity
	 */
	public int getYSimilar() {
		return YSimilar;
	}
	public void setYSimilar(int YSimilar){
		this.YSimilar = YSimilar;
	}

	/**
	 * @return the highest similarity at the position of given X, Y-Similar
	 */
	public double getSimilarity() {
		return similarity;
	}
	public void setSimilarity(double similarity){
		this.similarity = similarity;
	}
}