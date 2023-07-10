package Menu;

public class TitleCollection {
	private String name;
	private Title[] titleCollection;
	private int count;

	public TitleCollection(String name, int count) {
		this.name = name;
		titleCollection = new Title[count];
		count = 0;
	}

	public void addTitleIntoCollection(Title title) {
		titleCollection[count++] = title;
	}

	public Title[] getTitleCollection() {
		return titleCollection;
	}

	public void setTitleCollection(Title[] titleCollection) {
		this.titleCollection = titleCollection;
	}
	
	public String getTitleInfo() {
		String info = "";
		for(int i = 0; i<count; i++) {
			info += titleCollection[i].getTitle();
		}
		return info;
	}

}
