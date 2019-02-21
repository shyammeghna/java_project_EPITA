package fr.epita.quiz.datamodel;

public class Results {
	private String crt_ans;
	private String user_ans;
	public Results(String crt_ans, String user_ans) {
		this.crt_ans = crt_ans;
		this.user_ans = user_ans;
	}
	public String getCrt_ans() {
		return crt_ans;
	}
	public void setCrt_ans(String crt_ans) {
		this.crt_ans = crt_ans;
	}
	public String getUser_ans() {
		return user_ans;
	}
	public void setUser_ans(String user_ans) {
		this.user_ans = user_ans;
	}
	
}
