package elements;

public class Header extends ElementImpl implements Element {
    private int size;
    private String title;

    public Header(String id,int size, String title) {
        super.id = id;
        this.size = size;
        this.title = title;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("<h%d id=\"%s\">%s</h%d>",this.getSize(),this.getId(),this.getTitle(), this.getSize());
    }
}
