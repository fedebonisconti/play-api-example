import play.Application;
import play.GlobalSettings;
import spring.SpringApplicationContext;

import static play.Logger.info;

public class Global extends GlobalSettings {
    @Override
    public void onStart(Application application) {
        super.onStart(application);

        info("Starting up the application...");

        SpringApplicationContext.initialize();
    }
}
