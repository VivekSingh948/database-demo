package com.in28minutes.database.databasedemo;

import java.util.Date;

//import java.util.Date;

//import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;

//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner{
	
	@Autowired
	PersonJdbcDao dao;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(1000);
		logger.info("all person -> {}",dao.findAll());
		logger.info("person 10001 -> {}",dao.findById(10001));
		logger.info("deleting 10002  -> No of row deleted - {}",dao.deleteById(10002));
		logger.info("inserting person 10004 -> {}",dao.insert(new Person(10004,"Tara","Berlin",new Date())));
		logger.info("upadting person 10003 -> {}",dao.update(new Person(10003,"Pieter","Utrecht",new Date())));
	}

}
