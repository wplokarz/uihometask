package interfaces;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;


@Sources("classpath:browserData.properties")
public interface BrowserData extends Config {

    String browser();
    String width();
    String height();
}
