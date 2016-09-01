package level11.level11;

import java.util.HashSet;
import java.util.Set;

import level11.level11.eventbrite.EventBriteEvent;

public class Event {
	
	private final String title;
	private final String url;
	private final String description;
	
	
//	private final String description;

	public Event(EventBriteEvent event) {
		this.title = event.getName().getText();
		this.url = event.getUrl();
		this.description = event.getDescription().getText();
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
}
