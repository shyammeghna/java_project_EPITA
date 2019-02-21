package fr.epita.quiz.datamodel;


	//import java.util.List;

	public class Question {

		private int q_id;
		
		private String question; 
		private String topics;	 
		private Integer difficulty;
		private boolean q_mcq;
		
		public Question() {
		}
		
		public Question(String question, String topics, Integer difficulty,boolean q_mcq) {
			this.question = question;
			this.topics = topics;
			this.difficulty = difficulty;
			this.q_mcq=q_mcq;
		}
		
		public String toString() {
			return "Question [id=" + q_id + ", question=" + question + ", topics=" + topics + ", difficulty="
					+ difficulty + "]";
		}
		public String getQuestion() {
			return question;
		}
		public void setQuestion(String question) {
			this.question = question;
		}
		public String getTopics() {
			return topics;
		}
		public void setTopics(String topics) {
			this.topics = topics;
		}
		public Integer getDifficulty() {
			return difficulty;
		}
		public void setDifficulty(Integer difficulty) {
			this.difficulty = difficulty;
		}
		public boolean isq_mcq() {
			return q_mcq;
		}
		public void setq_mcq(boolean q_mcq) {
			this.q_mcq = q_mcq;
		}
		
		public int getId() {
			return q_id;
		}

		public void setId(int q_id) {
			this.q_id = q_id;
		}
	}



