package com.csm.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csm.quizapp.QuestionWrapper;
import com.csm.quizapp.Response;
import com.csm.quizapp.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	QuizService quizService;

	//The ? in the URL is used to start the query string, 
	//which includes key-value pairs representing parameters passed to the server
	//http://localhost:8080/quiz/create?category=php&numQ=2&title=PhpQuiz
	
//	{
//	    "category": "C",
//	    "questionTitle": "#include<stdio.h>\n int main()\n {\n int n;\n for(n = 7; n!=0; n--)\n printf(\"n = %d\", n--);\n getchar();\n return 0;\n }\n",
//	    "option1": "0",
//	    "option2": "1",
//	    "option3": "2",
//	    "option4": "infinite",
//	    "rightAnswer": "infinite",
//	    "difficultylevel": "high"
//	}
	
	@PostMapping("create")
	//@RequestParam is used to bind the query parameters to the method parameters.
	public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title)
	{
		return quizService.createQuiz(category,numQ,title);
	}
	
	//http://localhost:8080/quiz/get/5
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id)
	{
		return quizService.getQuizQuestions(id);
	}
	
	//http://localhost:8080/quiz/submit/1
//	[{
//	    "id": 18,
//	    "response":"both option1 and option2"
//
//	},{
//	     "id": 3,
//	    "response":"s"
//
//	}]
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses )
	{
		return quizService.calculateResult(id,responses);
	}
}
