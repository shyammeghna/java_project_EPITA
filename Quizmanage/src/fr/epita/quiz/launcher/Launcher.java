package fr.epita.quiz.launcher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import fr.epita.quiz.datamodel.Answers;
import fr.epita.quiz.datamodel.MCQChoices;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.datamodel.Results;
import fr.epita.quiz.services.QuestionJDBCDAO;


public class Launcher {
	
	private QuestionJDBCDAO jdo;

	public Launcher() {
		jdo = new QuestionJDBCDAO();
	
	}
	public static void main(String[] args) {
		
			
			System.out.println("Welcome to the quiz");
			
			

				
					Launcher launcher = new Launcher();
					launcher.showQuestions();
				}
	
@SuppressWarnings("resource")
					private void showQuestions() {
					List<Question> questions = jdo.getQuestions();
					Collections.shuffle(questions, new Random());

					for (Question quest : questions) {

						System.out.println(quest.getQuestion());
						checkAndFetchMCQs(quest);

						Scanner scanner = new Scanner(System.in);
						String ans = scanner.nextLine();
						Answers answer = new Answers(quest.getId(), ans);
						jdo.addAns(answer);
					}

					verifyAnswers();
				}

					
				private void verifyAnswers() {
					List<Results> results = jdo.getAnswers();
					int score = 0;

					for (Results result : results) {

						if (result.getUser_ans() != null
								&& result. getCrt_ans().trim().equalsIgnoreCase(result.getUser_ans().trim())) {
							score += 1;
						}
					}

					System.out.println("Your Score is: " + score);

				}

				private void checkAndFetchMCQs(Question quest) {
					List<MCQChoices> mcqChoices = new ArrayList<>();

					if (quest.isq_mcq()) {
						mcqChoices = jdo.getMCQs(quest);
						

						for (MCQChoices mcqChoice : mcqChoices) {
							System.out.println(mcqChoice.getChoice());
						}
					}
				}}
				
