import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalizationServiceImplTest {
    @Test
    void localeTest() {
        Map<Country, String> local = new HashMap<>();
        local.put(Country.RUSSIA, "Добро пожаловать");
        local.put(Country.USA, "Welcome");
        LocalizationService localizationService = new LocalizationServiceImpl();
        local.forEach((k,v) -> assertEquals(localizationService.locale(k),v));
    }
}
