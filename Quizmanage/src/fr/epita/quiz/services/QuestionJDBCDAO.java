package fr.epita.quiz.services;


	
import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.datamodel.Results;
import fr.epita.quiz.datamodel.Answers;
import fr.epita.quiz.datamodel.MCQChoices;
import fr.epita.quiz.datamodel.Results;


	public class QuestionJDBCDAO {
		
		public static final String ss= "SELECT * FROM QUESTION";
		public static final String ans= "SELECT CRT_ANS, USER_ANS FROM ANSWERS";
		public static final String update= "UPDATE ANSWERS SET USER_ANS = ? WHERE Q_ID = ?";
		public static final String sel = "SELECT * FROM MCQCHOICES2 WHERE Q_ID = ?";


	   public List<Question> getQuestions() {
			List<Question> resultList = new ArrayList<Question>();

			try (Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(ss);) {

				ResultSet results = preparedStatement.executeQuery();
				while (results.next()) {
					
					int difficulty = results.getInt("DIFFICULTY");
					boolean mcq = results.getBoolean("Q_MCQ");
					String topics = results.getString("TOPICS");
					 
					String questt = results.getString("QUESTIONS");
					Question currentQuestion = new Question(questt,topics,difficulty,mcq);
					resultList.add(currentQuestion);
				}
				results.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return resultList;

		}

		
	   public List<Results> getAnswers() {
			List<Results> resultsList = new ArrayList<>();

			try (Connection connection = getConnection()) {
				PreparedStatement statement = connection.prepareStatement(ans);

				ResultSet results = statement.executeQuery();
				while (results.next()) {
					String actual_ans = results.getString("CRT_ANS");
					String user_ans = results.getString("USER_ANS");

					Results result = new Results(actual_ans, user_ans);
					resultsList.add(result);
				}
				results.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return resultsList;
		}


	   
	   
	   		
		public void addAns(Answers answer) {

			try (Connection connection = getConnection()) {
				PreparedStatement statement = connection.prepareStatement(ans);
				//statement.setString(5, answer.getuser_ans());
				//statement.setInt(2, answer.getQues_id());
				statement.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

				public List<MCQChoices> getMCQs(Question question) {
			List<MCQChoices> mcqChoicesList = new ArrayList<>();

			try (Connection connection = getConnection()) {
				PreparedStatement statement = connection.prepareStatement(sel);

				statement.setInt(1, question.getId());
				ResultSet results = statement.executeQuery();

				while (results.next()) {
					int mcq_id = results.getInt("MCQ_ID");
					String choice = results.getString("CHOICE");

					MCQChoices mcqChoices = new MCQChoices(mcq_id, choice); 
					mcqChoicesList.add(mcqChoices);
				}
				results.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return mcqChoicesList;

		}

		private Connection getConnection() throws SQLException {
			Configuration conf = Configuration.getInstance();
			String jdbcUrl = conf.getConfigurationValue("jdbc.url");
			String user = conf.getConfigurationValue("jdbc.user");
			String password = conf.getConfigurationValue("jdbc.password");
			Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
			return connection;
		}
	}
