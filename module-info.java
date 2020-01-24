module CollegeApplication {
	exports com.college.app.controller;
	exports com.college.app.service;
	exports com.college.app;
	exports com.college.app.dao;
	exports com.college.app.model;
	exports com.college.app.web;
	exports com.college.app.dao.impl;
	exports com.college.app.config;
	exports com.college.app.service.impl;

	requires hibernate.jpa;
	requires hibernate.core;
	requires javax.transaction.api;
	requires slf4j.api;
	requires spring.beans;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires spring.core;
	requires spring.web;
	requires spring.webmvc;
	requires thymeleaf;
	requires thymeleaf.spring4;
	requires tomcat.embed.core;
}