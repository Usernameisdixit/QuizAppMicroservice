package com.csm.quizapp.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.csm.quizapp.Question;



@Repository
public interface QuestionDao extends JpaRepository< Question, Integer> {


	List<Question> findByCategory(String category);

	// below query is valid if we are using postgre sql as it supports RANDOM()
	//SELECT * FROM question q WHERE q.category=? ORDER BY RANDOM() LIMIT ?;

	// my sql supports RAND() function
	@Query(value="select * from question q where q.category=:category ORDER BY RAND() LIMIT :numQ",nativeQuery=true)
	List<Question> findRandomQuestionsByCategory(String category, int numQ);
	

	
}
