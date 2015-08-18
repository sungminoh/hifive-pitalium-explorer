/*
 * Copyright (C) 2015 NS Solutions Corporation, All Rights Reserved.
 */
package com.htmlhifive.pitalium.explorer.api;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.htmlhifive.pitalium.explorer.cache.BackgroundImageDispatcher;
import com.htmlhifive.pitalium.explorer.cache.CacheTaskQueue;
import com.htmlhifive.pitalium.explorer.service.ExplorerService;

@Controller
@RequestMapping("/image")
public class ImageController {
	@Autowired
	private ExplorerService service;

	private CacheTaskQueue cacheTaskQueue;
	private BackgroundImageDispatcher backgroundImageDispatcher;

	/**
	 * This method is called by spring after auto wiring. Do initialization here.
	 */
	@PostConstruct
	public void init() {
		if (service.getApplicationConfig().isDiffImageCacheOn()) {
			this.cacheTaskQueue = new CacheTaskQueue();
			this.backgroundImageDispatcher = new BackgroundImageDispatcher(service.getRepositories(), cacheTaskQueue);
			/* start background worker */
			this.backgroundImageDispatcher.start();
		}
	}

	/**
	 * This method is called when the application is about to die. Cleanup things.
	 * 
	 * @throws InterruptedException
	 */
	@PreDestroy
	public void destory() throws InterruptedException {
		if (service.getApplicationConfig().isDiffImageCacheOn()) {
			this.backgroundImageDispatcher.requestStop();
			this.cacheTaskQueue.interruptAndJoin();
			this.backgroundImageDispatcher.join();
		}
	}

	/**
	 * Get the image from id.
	 *
	 * @param screenshotId screenshot id
	 * @param targetId id of the target area to be used for image comparison
	 * @param response HttpServletResponse
	 */
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public void getImage(@RequestParam(value = "screenshotId") Integer screenshotId, 
			@RequestParam(value = "targetId") Integer targetId,
			HttpServletResponse response) {
		service.getImage(screenshotId, targetId, response);
	}

	/**
	 * Get edge detection result of an image.
	 *
	 * @param screenshotId id of screenshot to be processed by edge detector.
	 * @param targetId id of the target area to be used for image comparison
	 * @param colorIndex edge color index
	 * @param response HttpServletResponse
	 */
	public void getEdgeImage(Integer screenshotId, Integer targetId, int colorIndex,
			HttpServletResponse response) {
		service.getEdgeImage(screenshotId, targetId, colorIndex, response);
	}

	/**
	 * Get processed image.
	 * 
	 * @param screenshotId id of an image to be processed
	 * @param targetId id of the target area to be used for image comparison
	 * @param algorithm currently only "edge" is supported
	 * @param colorIndex edge color index
	 * @param response HttpServletResponse
	 */
	@RequestMapping(value = "/getProcessed", method = RequestMethod.GET)
	public void getProcessed(@RequestParam(value = "screenshotId") Integer screenshotId, 
			@RequestParam(value = "targetId") Integer targetId,
			@RequestParam(value = "algorithm") String algorithm, 
			@RequestParam(value = "colorIndex") int colorIndex, 
			HttpServletResponse response) {
		service.getProcessed(screenshotId, targetId, algorithm, colorIndex, response);
	}

	/**
	 * Get the diff image with a marker of comparison result. If there is no difference, return normal image.
	 *
	 * @param sourceSceenshotId comparison source image id
	 * @param targetScreenshotId comparison target image id
	 * @param targetId id of the target area to be used for image comparison
	 * @param response HttpServletResponse
	 */
	@RequestMapping(value = "/getDiff", method = RequestMethod.GET)
	public void getDiffImage(@RequestParam(value = "sourceSceenshotId") Integer sourceSceenshotId, 
			@RequestParam(value = "targetScreenshotId") Integer targetScreenshotId,
			@RequestParam(value = "targetId") Integer targetId, 
			HttpServletResponse response) {
		service.getDiffImage(sourceSceenshotId, targetScreenshotId, targetId, response);
	}
}
