package my.problems;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;
import java.net.URL;

@Singleton
public class ThrowsAnErrorService {

    private final PayloadBean bean;


    @Inject
    public ThrowsAnErrorService(PayloadBean bean) {
        this.bean = bean;

        try {
            URL noresourcehere = this.getClass().getResource("Noresourcehere");
            noresourcehere.openStream();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
