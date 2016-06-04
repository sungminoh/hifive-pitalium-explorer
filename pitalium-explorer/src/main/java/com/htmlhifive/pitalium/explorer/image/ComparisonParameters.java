package com.htmlhifive.pitalium.explorer.image;

/**
 * Default parameter setting for comparison
 */
public class ComparisonParameters {

	/* default setting for comparison parameters */
	
	// difference threshold to ignore small differences
	private static double diffThreshold = 0.1;
	
	// parameters for categorization
	private static double scalingDiffCriterion = 0.3;
	private static double scalingFeatureCriterion = 0.85;
	private static double missingDiffCriterion = 0.6;
	
	// group distance for building different area
	private static int defaultGroupDistance = 10;
	private static int splitGroupDistance = 4;
	
	/**
	 * Constructor
	 */
	public ComparisonParameters() {};

	public static void setDiffThreshold(double threshold) {
		diffThreshold = threshold;
	}
	public static double getDiffThreshold() {
		return diffThreshold;
	}
	public static void setScalingDiffCriterion (double criterion) {
		scalingDiffCriterion = criterion;
	}
	public static double getScalingDiffCriterion () {
		return scalingDiffCriterion;
	}
	public static void setScalingFeatureCriterion (double criterion) {
		scalingFeatureCriterion = criterion;
	}
	public static double getScalingFeatureCriterion () {
		return scalingFeatureCriterion;
	}
	public static void setMissingDiffCriterion (double criterion) {
		missingDiffCriterion = criterion;
	}
	public static double getMissingDiffCriterion () {
		return missingDiffCriterion;
	}	
	public static void setDefaultGroupDistance(int group_distance) {
		defaultGroupDistance = group_distance;
	}
	public static int getDefaultGroupDistance() {
		return defaultGroupDistance;
	}
	public static void setSplitGroupDistance(int group_distance) {
		splitGroupDistance = group_distance;
	}
	public static int getSplitGroupDistance() {
		return splitGroupDistance;
	}
	
}