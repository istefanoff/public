package enums;

public enum Fonts {
    NORMAL("", ""),
    ITALICS("<i>", "</i>"),
    BOLD("<b>", "</b>");

    String text;
    String text2;

    Fonts(String text, String text2) {
        this.text = text;
        this.text2 = text2;
    }

    public String getText2() {
        return text2;
    }

    public String getText() {
        return text;
    }
}

