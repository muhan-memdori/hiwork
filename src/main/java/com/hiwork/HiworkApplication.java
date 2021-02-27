package com.hiwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;

@SpringBootApplication
public class HiworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(HiworkApplication.class, args);

		Queue<Integer> sq = new LinkedList<>();
		sq.offset();
	}

}
