package fr.epita.quiz.datamodel;

public class Answers {
	
	private int q_id;
	private String user_ans;
	public Answers(int q_id, String user_ans) {
		this.q_id = q_id;
		this.user_ans = user_ans;
	}

	public int getQues_id() {
		return q_id;
	}

	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}

	public String getuser_ans() {
		return user_ans;
	}

	public void setuser_ans(String user_ans) {
		this.user_ans = user_ans;
	}

	public String toString() {
		return "Answer [q_id=" +q_id + " ;user_ans=" + user_ans + "]";
	}

}



