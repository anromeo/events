package level11.level11.eventbrite;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventBriteResponse {

	private Pagination pagination;
	private List<EventBriteEvent> events;
	
	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public List<EventBriteEvent> getEvents() {
		return events;
	}

	public void setEvents(List<EventBriteEvent> events) {
		this.events = events;
	}

}
