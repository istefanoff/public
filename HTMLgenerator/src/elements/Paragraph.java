package elements;

public class Paragraph extends ElementImpl implements Element {
    private String text;

    public Paragraph(String id,String text) {
        super.id = id;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("<p id =\"%s\">%s</p>",this.getId(), this.getText());

    }
}
