package fr.epita.quiz.datamodel;

public class MCQChoices {
	 private int MCQ_ID;
	   private String choice;

	public MCQChoices(int mcq_id, String choice) {
		this.MCQ_ID = mcq_id;
		this.choice = choice;
	}
	public int getMCQ_ID() {
		return MCQ_ID;
	}
	public void setMCQ_ID(int mCQ_ID) {
		this.MCQ_ID = mCQ_ID;
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public String toString() {
		return "MCQChoice [ mcq_id=" + MCQ_ID+ " choice=" + choice + "]";
	}


	}


