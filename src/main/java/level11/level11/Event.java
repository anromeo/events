package level11.level11;

public class Event {

	private final long id;
	private final String content;
	
	public Event(long id, String content) {
		this.id = id;
		this.content = content;
	}
	
	public long getId() {
		return id;
	}
	
	public String getContent() {
		return content;
	}
}
