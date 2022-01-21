package elements;

import enums.Fonts;

public class Text extends ElementImpl implements Element {
    private Fonts font;
    private String text;

    public Text(String id,Fonts font,String text) {
        super.id = id;
        this.font = font;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public Fonts getFont() {
        return font;
    }

    public void setFont(Fonts font) {
        this.font = font;
    }

    @Override
    public String toString() {
        return String.format("<div id=\"%s\">%s%s%s</div>", this.getId(), this.font.getText(), this.getText(), this.font.getText2());
    }
}

