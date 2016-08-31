package level11.level11;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
	
	private static final String template = "Hello, %s!";
	private static final AtomicLong counter = new AtomicLong();
	
    @RequestMapping("/events")
    public Event listEvents(@RequestParam(value="zipcode", defaultValue="World") String zipcode) {
        return new Event(counter.incrementAndGet(),
                            String.format(template, zipcode));
    }

}
