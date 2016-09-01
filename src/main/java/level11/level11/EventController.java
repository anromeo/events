package level11.level11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import level11.level11.eventbrite.EventBriteEvent;
import level11.level11.eventbrite.EventBriteResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EventController {

	private static final String defaultQuery = "---";
	private static final AtomicLong counter = new AtomicLong();
	// This would not be in the code if this was not a prototype
	private static final String eventsBriteToken = "UD6B6BENRKC2BX27DB7D";
	private static final Logger log = LoggerFactory.getLogger(EventController.class);

	
//	@RequestMapping("/")
//	public String index(Model model) {
//		return "index";
//	}
	
    @RequestMapping("/events2")
    public String listEvents2(
    		@RequestParam(value="zipcode", defaultValue="Seattle") String zipcode,
    		@RequestParam(value="query", defaultValue=defaultQuery) String query) {
    	// List<Event> events = getEventbriteEvents(zipcode, query);
        return getEventbriteEvents2(zipcode, query);
    }

    private String getEventbriteEvents2(String zipcode, String query) {
    	List<EventBriteEvent> events = new ArrayList<EventBriteEvent>();
    	StringBuilder endpoint = new StringBuilder("https://www.eventbriteapi.com/v3/events/search/?sort_by=distance&token=" + eventsBriteToken +"&location.address=" + zipcode + "&location.within=10mi");
    	if (!query.equals(defaultQuery)) {
    		endpoint.append("q=" + query);
    	}
    	RestTemplate restTemplate = new RestTemplate();
    	EventBriteResponse response = restTemplate.getForObject(endpoint.toString(), EventBriteResponse.class);
    	return response.getPagination().getPage_count();
    }
    
    
    @RequestMapping("/events")
    public List<Event> listEvents(
    		@RequestParam(value="zipcode", defaultValue="Seattle") String zipcode,
    		@RequestParam(value="query", defaultValue=defaultQuery) String query) {
    	List<Event> events = getEventbriteEvents(zipcode, query);
        return events;
    }

    private List<Event> getEventbriteEvents(String zipcode, String query) {
    	List<Event> events = new ArrayList<Event>();
    	StringBuilder endpoint = new StringBuilder("https://www.eventbriteapi.com/v3/events/search/?sort_by=distance&token=" + eventsBriteToken +"&location.address=" + zipcode + "&location.within=10mi");
    	if (!query.equals(defaultQuery)) {
    		endpoint.append("q=" + query);
    	}
    	RestTemplate restTemplate = new RestTemplate();
    	EventBriteResponse response = restTemplate.getForObject(endpoint.toString(), EventBriteResponse.class);
    	for (EventBriteEvent eventBriteEvent : response.getEvents()) {
    		events.add(new Event(eventBriteEvent));
    	}
    	return events;
    }
}
