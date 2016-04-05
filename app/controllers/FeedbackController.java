package controllers;

import java.util.*;

import com.google.inject.Inject;
import play.mvc.*;
import play.data.Form;

import services.Feedback;
import services.FeedbackStore;

public class FeedbackController extends Controller {

    public Result postFeedback() {
        Form<Feedback> feedbackForm = Form.form(Feedback.class);
        Feedback feedback = feedbackForm.bindFromRequest().get();
        feedback.setCreatedAt(new Date());

        FeedbackStore feedbackStore = FeedbackStore.getInstance();
        feedbackStore.appendFeedback(feedback);
        return redirect("/");
    }

}
