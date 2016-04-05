package controllers;

import javax.inject.Inject;

import play.Logger;
import play.mvc.*;
import play.libs.ws.*;

import services.FeedbackStore;
import views.html.*;

import services.Weather;

public class HomeController extends Controller {

    @Inject WSClient ws;
    @Inject play.data.FormFactory formFactory;
    public Result index() {
        Weather weatherClient = new Weather(ws);
        FeedbackStore feedbackStore = FeedbackStore.getInstance();
        return ok(index.render(weatherClient.fetchTemperature(), feedbackStore));
    }

}
