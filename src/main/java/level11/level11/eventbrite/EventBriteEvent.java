package level11.level11.eventbrite;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventBriteEvent {

//	private long id;
	private Name name;
	private String url;
	private Description description;
//	private String start;
//	private String end;
	
	public Name getName() {
		return name;
	}


	public void setName(Name name) {
		this.name = name;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}
	
	public Description getDescription() {
		return this.description;
	}
	
	public void setDescription(Description description) {
		this.description = description;
	}
//
//
//	public String getDescription() {
//		return description;
//	}
//
//
//	public void setDescription(String description) {
//		this.description = description;
//	}


//	public String getStart() {
//		return start;
//	}
//
//
//	public void setStart(String start) {
//		this.start = start;
//	}
//
//
//	public String getEnd() {
//		return end;
//	}
//
//
//	public void setEnd(String end) {
//		this.end = end;
//	}


	@Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'';
    }
}
