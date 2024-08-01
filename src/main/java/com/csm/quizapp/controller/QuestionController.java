package com.csm.quizapp.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csm.quizapp.model.Question;
import com.csm.quizapp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	//http://localhost:8080/question/allQuestions
	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions()
	{
		return questionService.getAllQuestions();
	}
	
	//http://localhost:8585/question/category/java
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category)
	{
		return questionService.getQuestionsByCategory(category);
	}
	
	//http://localhost:8080/question/add
	
//	{
//	    "category": "sql",
//	    "questionTitle": "Which of the following are types of Unicode character string types in SQL?",
//	    "option1": "nchar",
//	    "option2": "ntext",
//	    "option3": "both option1 and option2",
//	    "option4": "none",
//	    "rightAnswer": "both option1 and option2",
//	    "difficultylevel": "medium"
//	}
	
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question)
	{
		return questionService.addQuestion(question);
	}
	
	

}
