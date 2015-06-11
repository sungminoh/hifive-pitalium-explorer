package com.htmlhifive.testexplorer.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenshotRepository extends JpaRepository<Screenshot, Integer> {

	public List<Screenshot> findByTestExecutionIdAndTestMethodContainingAndTestScreenContaining(
			Integer testExecutionId,
			String testMethod,
			String testScreen);

}
