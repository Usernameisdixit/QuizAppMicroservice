package com.csm.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csm.quizapp.model.Quiz;



public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
