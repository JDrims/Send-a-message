import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GeoServiceImplTest {
    @Test
    void byIpTest() {
        Map<String, Location> ipLocal = new HashMap<>();
        ipLocal.put("127.0.0.1", new Location(null, null, null, 0));
        ipLocal.put("172.0.32.11", new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        ipLocal.put("96.44.183.149", new Location("New York", Country.USA, " 10th Avenue", 32));
        ipLocal.put("172.55.123.123", new Location("Moscow", Country.RUSSIA, null, 0));
        ipLocal.put("96.55.123.123", new Location("New York", Country.USA, null,  0));
        GeoService geoService = new GeoServiceImpl();
        ipLocal.forEach((k,v) -> assertEquals(geoService.byIp(k).getCountry(),v.getCountry()));
    }

    @Test
    void byCoordinatesTest() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        assertThrows(RuntimeException.class, () -> geoService.byCoordinates(55,55));
    }
}
