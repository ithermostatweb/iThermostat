package services;

import java.util.ArrayList;

/**
 * Created by dinever on 4/5/16.
 */
public class FeedbackStore {

    private static FeedbackStore instance = null;
    private ArrayList<Feedback> feedbackList;

    public FeedbackStore() {
        this.feedbackList = new ArrayList<Feedback>();
    }

    public ArrayList<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(ArrayList<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    public void appendFeedback(Feedback feedback) {
        feedbackList.add(feedback);
    }

    public static FeedbackStore getInstance() {
        if (instance == null) {
            instance = new FeedbackStore();
        }
        return instance;
    }
}
